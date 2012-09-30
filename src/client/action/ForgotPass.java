/*
 * huythang38
 */

package client.action;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Client;
import client.event.MessageDisconnect;
import client.gui.LoadingImage;

public class ForgotPass extends Thread {
	public LoadingImage loadingImage = new LoadingImage("lib/images/executeL.gif");
	public static boolean complete;
	public String email;
	public Thread threadLoading;
	
	public ForgotPass(String values){
		email = values;
		threadLoading = new Thread(loadingImage);
		threadLoading.setName("LOadingImage");
		threadLoading.start();
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		
		try {
			if (!Client.conn.forgotPassWord(email)) {
				threadLoading.stop();
				loadingImage.disposeDialog();
				JOptionPane
						.showMessageDialog(new JFrame(),
								"Email fail! Please re-enter!");
				complete= false;
			} else {
				threadLoading.stop();
				loadingImage.disposeDialog();
				JOptionPane
						.showMessageDialog(new JFrame(),
								"Your request has been processed. Please check your email!");
				complete = true;
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new MessageDisconnect();
			if (!Client.checkConnect) {
				complete = true;
			}
		}
	}
}

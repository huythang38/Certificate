/*
 * huythang38
 */
package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.actionDatabase.IDatabase;

public class Client {
	public IDatabase conn;
	
	//
	public Client() {	}

	// connect to server
	public boolean connectServer(String path, int port){
		boolean check = false;
		try {
			conn = (IDatabase) Naming.lookup("rmi://" + path + ":" + port
					+ "/Certificate");
			check = true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			check = false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			check = false;
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public void disConnectServer(){
		conn = null;
	}
	
	//checkAccount
	@SuppressWarnings("rawtypes")
	public Vector checkAccount(String username, String password){
		Vector data = null;
		try {
			data = conn.checkAccount(username, password);
		} catch (RemoteException e) {
			int check = JOptionPane.showConfirmDialog(new JFrame(), "Disconnected! Would you like to reconnect?"
					, "Error", JOptionPane.YES_NO_OPTION);
			
			//reconnect
			if (check == 0){
				RUN.disconnect();
				RUN runPro = new RUN(true);
				runPro.showLoadConnect();
				runPro.Connect();		
			}else{
				System.exit(0);
			}
		}
		return data;
	}
	
}

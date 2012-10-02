package client.event.admin;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.AccountResetPassword;

public class ResetPassEvent {
	public void resetPass(final int id) {
		AccountResetPassword.lblWaitting.setVisible(true);

		Thread t = new Thread() {
			public void run() {
				try {
					if (Client.conn.resetPass(id)) {
						AccountResetPassword.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"successfully reset!");
					} else {
						AccountResetPassword.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't reset password!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					new DisconnectToExit();
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
}

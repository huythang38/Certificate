package client.action;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Client;
import client.RUN;

public class Login {
	// checkAccount
	@SuppressWarnings("rawtypes")
	public Vector checkAccount(String username, String password) {
		Vector data = null;
		try {
			data = Client.conn.checkAccount(username, password);
		} catch (RemoteException e) {
			int check = JOptionPane.showConfirmDialog(new JFrame(),
					"Disconnected! Would you like to reconnect?", "Error",
					JOptionPane.YES_NO_OPTION);

			// reconnect
			if (check == 0) {
				RUN.disconnect();
				RUN runPro = new RUN(true);
				runPro.showLoadConnect();
				runPro.Connect();
			} else {
				System.exit(0);
			}
		}
		return data;
	}
}

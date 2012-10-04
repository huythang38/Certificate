package client.action.account;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.MessageDisconnect;

public class Login {
	// checkAccount
	@SuppressWarnings("rawtypes")
	public Vector checkAccount(String username, String password) {
		Vector data = null;
		try {
			data = Client.conn.checkAccount(username, password);
		} catch (RemoteException e) {
			new MessageDisconnect();
		}
		return data;
	}
}

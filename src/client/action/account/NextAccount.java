package client.action.account;

import java.rmi.RemoteException;

import client.Client;

public class NextAccount {
	public static int nextAccount(){
		int _return = 0;
		try {
			_return = Client.conn.getAccountsLastID() + 1;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _return;
	}
}

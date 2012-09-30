package client.action.account;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;

public class UserAndStatus {
	public static Vector<?> data = new Vector<>();
	
	public UserAndStatus(int id){
		try {
			data = Client.conn.getAccount(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getUser(){
		return (String) data.get(0);
	}
	
	public static int getStatus(){
		return (Integer) data.get(1);
	}
}

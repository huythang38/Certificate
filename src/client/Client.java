/*
 * huythang38
 */
package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

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
	//checkAccount
	@SuppressWarnings("rawtypes")
	public Vector checkAccount(String username, String password){
		Vector data = null;
		try {
			data = conn.checkAccount(username, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
//	@SuppressWarnings("rawtypes")
//	public static void main(String[] args) {
//		Client client = new Client("196.168.62.88", 7777);
//		Vector data = client.checkAccount("thang", "thang");
//		
//		if (data.isEmpty()){
//			System.out.println("tai khoan sai");
//		}
//		else if (data.get(1).equals(1)){
//			System.out.println("dang nhap thanh cong");
//		}
//	}
}

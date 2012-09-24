/*
 * huythang38
 */
package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.actionDatabase.IDatabase;

public class Client {
	public static IDatabase conn;
	
	//
	public Client() {	}

	// connect to server
	public boolean connectServer(String path, int port){
		boolean check = false;
		try {
			conn = (IDatabase) Naming.lookup("rmi://" + path + ":" + port
					+ "/certificate");
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
	
}

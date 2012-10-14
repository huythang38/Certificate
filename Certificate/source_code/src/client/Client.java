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
	public static boolean checkConnect;
	//
	public Client() {	}

	// connect to server
	public boolean connectServer(String path, int port){
		checkConnect = false;
		try {
			conn = (IDatabase) Naming.lookup("rmi://" + path + ":" + port
					+ "/certificate");
			checkConnect = true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			checkConnect = false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			checkConnect = false;
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			checkConnect = false;
		}
		return checkConnect;
	}
	
	public void disConnectServer(){
		conn = null;
	}
	
}

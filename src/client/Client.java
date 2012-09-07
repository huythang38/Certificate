package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.management.remote.rmi.RMIServerImpl;

import server.actionDatabase.IDatabase;

public class Client {
	public IDatabase conn;

	public Client(String path, int port) {
		try {
			conn = (IDatabase) Naming.lookup("rmi://" + path + ":" + port
					+ "/Certificate");

			System.out.println("connect thanh cong");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client("localhost", 4749);
	}
}

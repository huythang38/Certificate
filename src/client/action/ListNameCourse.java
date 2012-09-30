package client.action;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;

public class ListNameCourse {
	public ListNameCourse(){
		new Client().connectServer("localhost", 7777);
	}
	
	public Vector<String> getListNameCourse(){
		Vector<String> data = null;
		try {
			data = Client.conn.getListNameCourse();
			data.add(0, "Choice Course...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
}

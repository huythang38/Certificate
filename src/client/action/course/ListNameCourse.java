package client.action.course;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ListNameCourse {
	public ListNameCourse(){}
	
	public Vector<String> getListNameCourse(){
		Vector<String> data = null;
		try {
			data = Client.conn.getListNameCourse();
			data.add(0, "Choice Course...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		
		return data;
	}
}

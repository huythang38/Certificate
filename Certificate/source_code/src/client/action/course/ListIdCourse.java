package client.action.course;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ListIdCourse {
	public ListIdCourse() {
	}

	public static Vector<Integer> getListIdCourse() {
		Vector<Integer> data = null;
		try {
			data = Client.conn.getListIdCourse();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

		return data;
	}
}

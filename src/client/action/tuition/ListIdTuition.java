package client.action.tuition;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ListIdTuition {
	public ListIdTuition() {
	}

	public static Vector<Integer> getListIdCourse() {
		Vector<Integer> data = null;
		try {
			data = Client.conn.getListIdTuition();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

		return data;
	}
}

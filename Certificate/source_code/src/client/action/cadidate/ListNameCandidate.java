package client.action.cadidate;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ListNameCandidate {
	public static Vector<String> getListNameCandidate() {
		Vector<String> data = null;
		try {
			data = Client.conn.getListNameCandidate();
//			data.add(0, "Choice Candidate...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

		return data;
	}
}

package client.action.student;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ModeltoTable {
	@SuppressWarnings("rawtypes")
	public static Vector data;

	public ModeltoTable() {
	}

	@SuppressWarnings({ "rawtypes"})
	public static Vector getModel(int class_id) {
		try {
			if (data != null) {
				data.removeAllElements();
			}
			data = Client.conn.getModelStudent(class_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		return data;
	}
}

package client.action.Class;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ModelClass {
	@SuppressWarnings("rawtypes")
	public static Vector data = null;

	public ModelClass() {
	}

	@SuppressWarnings({ "rawtypes" })
	public static Vector getModel() {
		try {
			if (data != null) {
				data.removeAllElements();
			}
			data = Client.conn.getModelClass();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		return data;
	}
}

package client.action.subject;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ModelSubject {
	@SuppressWarnings("rawtypes")
	public static Vector data = null;

	public ModelSubject() {
	}

	@SuppressWarnings({ "rawtypes" })
	public static Vector getModelSubject() {
		try {
			if (data != null) {
				data.removeAllElements();
			}
			data = Client.conn.getModelSubject();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		return data;
	}
}

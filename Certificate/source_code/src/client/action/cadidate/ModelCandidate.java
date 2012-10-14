package client.action.cadidate;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ModelCandidate {
	@SuppressWarnings("rawtypes")
	public static Vector data = null;

	public ModelCandidate() {
	}

	@SuppressWarnings({ "rawtypes" })
	public static Vector getModelCandidate() {
		try {
			if (data != null) {
				data.removeAllElements();
			}
			data = Client.conn.getModelCandidate();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		return data;
	}
}

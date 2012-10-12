package client.action.record;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ModelInputMark {
	@SuppressWarnings("rawtypes")
	public static Vector data = new Vector();

	public ModelInputMark() {
	}

	@SuppressWarnings({ "rawtypes" })
	public static Vector getModel(int class_id, int subjects_id) {
		try {
			if (data != null) {
				data.removeAllElements();
			}
			data = Client.conn.getModelInputMark(class_id, subjects_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		return data;
	}
}

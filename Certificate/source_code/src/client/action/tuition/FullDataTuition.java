package client.action.tuition;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class FullDataTuition {
	@SuppressWarnings("rawtypes")
	public static Vector data = null;

	public FullDataTuition() {
	}

	@SuppressWarnings({ "rawtypes" })
	public static Vector getModelDataCourse() {
		try {
			if (data != null) {
				data.removeAllElements();
			}
			data = Client.conn.getFullTuition();// get list name course
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		return data;
	}
}

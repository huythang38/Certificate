package client.action.course;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class FullDataCourse {
	@SuppressWarnings("rawtypes")
	public static Vector data = null;

	public FullDataCourse() {
	}

	@SuppressWarnings({ "rawtypes" })
	public static Vector getModelDataCourse() {
		try {
			if (data != null) {
				data.removeAllElements();
			}
			data = Client.conn.getFullCourse();// get list name course
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		return data;
	}
}

package client.action.subject;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ListNameAndIDSubject {
	@SuppressWarnings("rawtypes")
	public Vector data = new Vector<>();
	public ListNameAndIDSubject(int index){
		try {
			data = Client.conn.getListNameAndIDSubject(index);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector<String> getListName() {
		Vector<String> dataListName = new Vector<>();
		dataListName = (Vector) data.get(1);
		dataListName.add(0, "Choice Subject...");
		return dataListName;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector<Integer> getListID() {
		Vector<Integer> dataListID = new Vector<>();
		dataListID = (Vector) data.get(0);
		return dataListID;
	}
}

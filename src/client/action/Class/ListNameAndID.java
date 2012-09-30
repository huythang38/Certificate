package client.action.Class;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;

public class ListNameAndID {
	@SuppressWarnings("rawtypes")
	public Vector data = new Vector<>();
	public ListNameAndID(int index){
		try {
			data = Client.conn.getListNameAndIDClass(index);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector<String> getListNameClass() {
		Vector<String> dataListName = new Vector<>();
		dataListName = (Vector) data.get(1);
		dataListName.add(0, "---");
		return dataListName;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector<Integer> getListIDClass() {
		Vector<Integer> dataListID = new Vector<>();
		dataListID = (Vector) data.get(0);
		return dataListID;
	}
}

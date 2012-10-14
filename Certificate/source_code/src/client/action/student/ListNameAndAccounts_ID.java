package client.action.student;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ListNameAndAccounts_ID {
	/**
	 * @uml.property  name="data"
	 */
	public Vector<?> data = new Vector<>();

	public ListNameAndAccounts_ID(int index) {
		try {
			data = Client.conn.getListNameAndAccount_idStudent(index);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public Vector<String> getListName() {
		Vector<String> dataListNameStudent = null;
		dataListNameStudent = (Vector<String>) data.get(1);
		dataListNameStudent.add(0, "Choice Student...");
		return dataListNameStudent;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector<Integer> getListID() {
		Vector<Integer> dataListID = new Vector<>();
		dataListID = (Vector) data.get(0);
		return dataListID;
	}
}

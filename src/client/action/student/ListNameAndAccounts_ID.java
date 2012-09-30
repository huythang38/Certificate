package client.action.student;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;

public class ListNameAndAccounts_ID {
	public Vector data = new Vector<>();

	public ListNameAndAccounts_ID(int index) {
		try {
			data = Client.conn.getListNameAndAccount_idStudent(index);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vector<String> getListName() {
		Vector<String> dataListNameStudent = null;
		dataListNameStudent = (Vector) data.get(1);
		dataListNameStudent.add(0, "---");
		return dataListNameStudent;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector<Integer> getListID() {
		Vector<Integer> dataListID = new Vector<>();
		dataListID = (Vector) data.get(0);
		return dataListID;
	}
}

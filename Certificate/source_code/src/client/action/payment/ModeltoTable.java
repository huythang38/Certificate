package client.action.payment;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ModeltoTable {
	@SuppressWarnings("rawtypes")
	public static Vector data;

	public ModeltoTable() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector getModel(int class_id) {
		Vector model = new Vector<>();
		try {
			if (data != null) {
				data.removeAllElements();
			}
			data = Client.conn.getModelEnterPaymentTable(class_id);
			for (int x = 0; x < data.size(); x++) {
				Vector deleteId = new Vector<>();
				deleteId.addAll((Vector) data.get(x));
				deleteId.set(2, deleteId.get(1));
				deleteId.set(1, deleteId.get(3));
				deleteId.remove(3);
				model.add(deleteId);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		return model;
	}
}

package client.event.admin.searchPanel;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.action.student.ModeltoTable;

public class SearchPanelGenerationCertificate extends SearchPanelEvent {
	@SuppressWarnings("rawtypes")
	public static Vector data;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector ModelfoTable(int classId) {
		int index = super.listNameAndIDClass.getListIDClass().get(classId - 1);
		data = new Vector<>();
		data = ModeltoTable.getModel(index);
		Vector _return = new Vector<>();
		for (int x = 0; x < data.size(); x++) {
			Vector dataChild = new Vector<>();
			dataChild = (Vector) data.get(x);
			Vector dataChild1 = new Vector<>();
			dataChild1.add(x + 1);
			dataChild1.add(dataChild.get(1));

			try {
				if (Client.conn.isCertificate(Integer.parseInt(dataChild.get(0)
						.toString()))) {

					dataChild1.add("yes");
				} else {
					dataChild1.add("no");
				}
			} catch (NumberFormatException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			_return.add(dataChild1);
		}
		return _return;
	}
}

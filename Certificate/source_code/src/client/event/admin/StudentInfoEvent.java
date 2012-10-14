package client.event.admin;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.admin.searchPanel.SearchPanelStudentInfoEvent;
import client.gui.admin.nav_panel.ViewStudent;

public class StudentInfoEvent {
	@SuppressWarnings("rawtypes")
	public void viewInfo(int index) {
		Vector data = new Vector();
		Vector account = new Vector();

		data = (Vector) SearchPanelStudentInfoEvent.data.get(index);

		try {
			int student_id = Integer.parseInt(data.get(0).toString());
			int account_id = Client.conn.getAccounts_id(student_id);
			account = Client.conn.getAccount(account_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		{
			String status = null;
			if (account.get(1).toString().equals("1")) {
				status = "Account is unlocked";
			} else {
				status = "Account is locked";
			}
			ViewStudent.setContentToPanel(account.get(0).toString(), status,
					data.get(1).toString(), data.get(2).toString(), data.get(3)
							.toString(), data.get(4).toString(), data.get(5)
							.toString(), data.get(6).toString(), data.get(7)
							.toString(), data.get(8).toString(), data.get(9)
							.toString());
		}
	}
}

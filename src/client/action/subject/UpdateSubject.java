package client.action.subject;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageSubject;

public class UpdateSubject extends Thread {
	public String name;
	public String courses_name;
	public int id;

	public UpdateSubject(int _id, String _name, String _courses_name) {
		this.name = _name;
		this.id = _id;
		this.courses_name = _courses_name;
	}

	public void run() {
		ManageSubject.lblWaitting.setVisible(true);

		try {
			if (Client.conn.updateSubject(id, name, courses_name)) {
				ManageSubject.lblWaitting.setVisible(false);
				ManageSubject.tableModel = new DefaultTableModel(
						ModelSubject.getModelSubject(),
						ManageSubject.headTable);
				ManageSubject.table.setModel(ManageSubject.tableModel);

				JOptionPane.showMessageDialog(new JFrame(), "Updated!");
				ManageSubject.setEnableConpoment(false, true, true, false,
						true, true, true);
			} else {
				ManageSubject.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't update!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

	}
}

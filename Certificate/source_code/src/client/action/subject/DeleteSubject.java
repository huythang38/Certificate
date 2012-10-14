package client.action.subject;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageSubject;

public class DeleteSubject extends Thread {
	/**
	 * @uml.property  name="id"
	 */
	public int id;

	public DeleteSubject(int _id) {
		this.id = _id;
	}

	public void run() {
		ManageSubject.lblWaitting.setVisible(true);
		try {
			if (Client.conn.deleteSubject(id)) {
				ManageSubject.lblWaitting.setVisible(false);
				ManageSubject.tableModel = new DefaultTableModel(
						ModelSubject.getModelSubject(),
						ManageSubject.headTable);
				ManageSubject.table.setModel(ManageSubject.tableModel);

				JOptionPane.showMessageDialog(new JFrame(), "Deleted!");
				ManageSubject.setEnableConpoment(false, false, false, true, false,
						false, true);
				ManageSubject.txtId.setText("");
				ManageSubject.txtName.setText("");
			} else {
				ManageSubject.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't delete!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}
}

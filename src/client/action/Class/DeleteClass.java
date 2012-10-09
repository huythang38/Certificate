package client.action.Class;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageClass;

public class DeleteClass extends Thread {
	public int id;

	public DeleteClass(int _id) {
		this.id = _id;
	}

	public void run() {
		ManageClass.lblWaitting.setVisible(true);
		try {
			if (Client.conn.deleteClass(id)) {
				ManageClass.lblWaitting.setVisible(false);
				ManageClass.tableModel = new DefaultTableModel(
						ModelClass.getModel(), ManageClass.headTable);
				ManageClass.table.setModel(ManageClass.tableModel);

				JOptionPane.showMessageDialog(new JFrame(), "Deleted!");
				ManageClass.setEnableConpoment(false, false, false, false,
						false, true, false, false, true);
				ManageClass.txtId.setText("");
				ManageClass.txtName.setText("");
			} else {
				ManageClass.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't delete!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}
}

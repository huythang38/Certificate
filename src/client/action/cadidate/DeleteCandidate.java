package client.action.cadidate;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageCandidate;

public class DeleteCandidate extends Thread {
	public int id;

	public DeleteCandidate(int _id) {
		this.id = _id;
	}

	public void run() {
		ManageCandidate.lblWaitting.setVisible(true);
		try {
			if (Client.conn.deleteCandidate(id)) {
				ManageCandidate.lblWaitting.setVisible(false);
				ManageCandidate.tableModel = new DefaultTableModel(
						ModelCandidate.getModelCandidate(),
						ManageCandidate.headTable);
				ManageCandidate.table.setModel(ManageCandidate.tableModel);

				JOptionPane.showMessageDialog(new JFrame(), "Deleted!");
				ManageCandidate.setEnableConpoment(false, false, false, true, false,
						false, true);
				ManageCandidate.txtId.setText("");
				ManageCandidate.txtName.setText("");
			} else {
				ManageCandidate.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't delete!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}
}

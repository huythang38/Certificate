package client.action.cadidate;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageCandidate;

public class UpdateCandidate extends Thread {
	public String name;
	public Float payment;
	public int id;

	public UpdateCandidate(int _id, String _name, Float _payment) {
		this.name = _name;
		this.id = _id;
		this.payment = _payment;
	}

	public void run() {
		ManageCandidate.lblWaitting.setVisible(true);

		try {
			if (Client.conn.updateCandidate(id, name, payment)) {
				ManageCandidate.lblWaitting.setVisible(false);
				ManageCandidate.tableModel = new DefaultTableModel(
						ModelCandidate.getModelCandidate(),
						ManageCandidate.headTable);
				ManageCandidate.table.setModel(ManageCandidate.tableModel);

				JOptionPane.showMessageDialog(new JFrame(), "Updated!");
				ManageCandidate.setEnableConpoment(true, true, true, false,
						true, true, true);
			} else {
				ManageCandidate.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't update!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

	}
}

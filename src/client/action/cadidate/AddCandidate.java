package client.action.cadidate;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageCandidate;

public class AddCandidate extends Thread {
	public String name;
	public Float payment;

	public AddCandidate(String _name, Float _payment) {
		this.name = _name;
		this.payment = _payment;
	}

	public void run() {
		ManageCandidate.lblWaitting.setVisible(true);

		try {
			if (Client.conn.isNameCandidate(name) == false) {
				
				try {
					if (Client.conn.newCandidate(name, payment)) {
						ManageCandidate.lblWaitting.setVisible(false);
						ManageCandidate.tableModel = new DefaultTableModel(
								ModelCandidate.getModelCandidate(),
								ManageCandidate.headTable);
						ManageCandidate.table.setModel(ManageCandidate.tableModel);

						JOptionPane.showMessageDialog(new JFrame(), "Added!");
						ManageCandidate.setEnableConpoment(false, false, false, true,
								false, false, true);
						ManageCandidate.txtId.setText("");
						ManageCandidate.txtName.setText("");
						ManageCandidate.btnNew.setVisible(true);
						ManageCandidate.btnOk.setVisible(false);
					} else {
						ManageCandidate.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't add!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					new DisconnectToExit();
					e.printStackTrace();
				}

			} else {
				ManageCandidate.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(),
						"Candidate already exists! Please check!");
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

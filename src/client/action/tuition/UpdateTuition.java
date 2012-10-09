package client.action.tuition;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageTuition;

public class UpdateTuition extends Thread{
	public Float payment;
	public int id;

	public UpdateTuition(int _id, Float _payment) {
		this.payment = _payment;
		this.id = _id;
	}

	public void run() {
		ManageTuition.lblWaitting.setVisible(true);

		try {
			if (Client.conn.isPaymentTuition(payment) == false) {

				try {
					if (Client.conn.updateTuition(id, payment)) {
						ManageTuition.lblWaitting.setVisible(false);
						ManageTuition.tableModel = new DefaultTableModel(
								FullDataTuition.getModelDataCourse(),
								ManageTuition.headTable);
						ManageTuition.table.setModel(ManageTuition.tableModel);

						JOptionPane.showMessageDialog(new JFrame(), "Updated!");
						ManageTuition.setEnableConpoment(false, true, false,
								true, true, true);
					} else {
						ManageTuition.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't update!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					new DisconnectToExit();
					e.printStackTrace();
				}

			} else {
				ManageTuition.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(),
						"Tuition already exists! Please check!");
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

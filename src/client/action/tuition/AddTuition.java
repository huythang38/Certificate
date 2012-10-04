package client.action.tuition;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageCourse;
import client.gui.admin.nav_panel.ManageTuition;

public class AddTuition extends Thread {
	public Float payment;

	public AddTuition(Float _payment) {
		this.payment = _payment;
	}

	public void run() {
		ManageCourse.lblWaitting.setVisible(true);

		try {
			if (Client.conn.isPaymentTuition(payment) == false) {
				
				try {
					if (Client.conn.newTuition(payment)) {
						ManageTuition.lblWaitting.setVisible(false);
						ManageTuition.tableModel = new DefaultTableModel(
								FullDataTuition.getModelDataCourse(),
								ManageTuition.headTable);
						ManageTuition.table.setModel(ManageTuition.tableModel);

						JOptionPane.showMessageDialog(new JFrame(), "Added!");
						ManageTuition.setEnableConpoment(false, false, true,
								false, false, true);
						ManageTuition.txtId.setText("");
						ManageTuition.txtPayment.setText("");
						ManageTuition.btnNew.setVisible(true);
						ManageTuition.btnOk.setVisible(false);
					} else {
						ManageTuition.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't add!");
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

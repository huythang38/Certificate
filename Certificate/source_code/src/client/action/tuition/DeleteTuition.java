package client.action.tuition;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageTuition;

public class DeleteTuition extends Thread {
	/**
	 * @uml.property  name="id"
	 */
	public int id;

	public DeleteTuition(int _id) {
		this.id = _id;
	}

	public void run() {
		ManageTuition.lblWaitting.setVisible(true);
		try {
			if (Client.conn.deleteTuition(id)) {
				ManageTuition.lblWaitting.setVisible(false);
				ManageTuition.tableModel = new DefaultTableModel(
						FullDataTuition.getModelDataCourse(),
						ManageTuition.headTable);
				ManageTuition.table.setModel(ManageTuition.tableModel);

				JOptionPane.showMessageDialog(new JFrame(), "Deleted!");
				ManageTuition.setEnableConpoment(false, false, true, false,
						false, true);
				ManageTuition.txtId.setText("");
				ManageTuition.txtPayment.setText("");
			} else {
				ManageTuition.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't delete!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}
}

package client.action.course;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageCourse;

public class DeleteCourse extends Thread {
	public int id;

	public DeleteCourse(int _id) {
		this.id = _id;
	}

	public void run() {
		ManageCourse.lblWaitting.setVisible(true);
		try {
			if (Client.conn.deleteCourse(id)) {
				ManageCourse.lblWaitting.setVisible(false);
				ManageCourse.tableModel = new DefaultTableModel(
						FullDataCourse.getModelDataCourse(),
						ManageCourse.headTable);
				ManageCourse.table.setModel(ManageCourse.tableModel);

				JOptionPane.showMessageDialog(new JFrame(), "Deleted!");
				ManageCourse.setEnableConpoment(false, false, true, false,
						false, true);
				ManageCourse.txtId.setText("");
				ManageCourse.txtName.setText("");
			} else {
				ManageCourse.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't delete!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}
}

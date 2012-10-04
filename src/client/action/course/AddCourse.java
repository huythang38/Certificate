package client.action.course;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageCourse;

public class AddCourse extends Thread {
	public String name;

	public AddCourse(String _name) {
		this.name = _name;
	}

	public void run() {
		ManageCourse.lblWaitting.setVisible(true);

		try {
			if (Client.conn.isNameCourse(name) == false) {
				
				try {
					if (Client.conn.newCourse(name)) {
						ManageCourse.lblWaitting.setVisible(false);
						ManageCourse.tableModel = new DefaultTableModel(
								FullDataCourse.getModelDataCourse(),
								ManageCourse.headTable);
						ManageCourse.table.setModel(ManageCourse.tableModel);

						JOptionPane.showMessageDialog(new JFrame(), "Added!");
						ManageCourse.setEnableConpoment(false, false, true,
								false, false, true);
						ManageCourse.txtId.setText("");
						ManageCourse.txtName.setText("");
						ManageCourse.btnNew.setVisible(true);
						ManageCourse.btnOk.setVisible(false);
					} else {
						ManageCourse.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't add!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					new DisconnectToExit();
					e.printStackTrace();
				}

			} else {
				ManageCourse.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(),
						"Course already exists! Please check!");
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

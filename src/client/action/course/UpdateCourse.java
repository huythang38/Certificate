package client.action.course;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageCourse;

public class UpdateCourse extends Thread{
	public String name;
	public int id;

	public UpdateCourse(int _id, String _name) {
		this.name = _name;
		this.id = _id;
	}

	public void run() {
		ManageCourse.lblWaitting.setVisible(true);

		try {
			if (Client.conn.isNameCourse(name) == false) {

				try {
					if (Client.conn.updateCourse(id, name)) {
						ManageCourse.lblWaitting.setVisible(false);
						ManageCourse.tableModel = new DefaultTableModel(
								FullDataCourse.getModelDataCourse(),
								ManageCourse.headTable);
						ManageCourse.table.setModel(ManageCourse.tableModel);

						JOptionPane.showMessageDialog(new JFrame(), "Updated!");
						ManageCourse.setEnableConpoment(true, true, false,
								true, true, true);
					} else {
						ManageCourse.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't update!");
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

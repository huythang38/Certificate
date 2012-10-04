package client.event.admin;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.action.course.AddCourse;
import client.action.course.FullDataCourse;
import client.action.course.UpdateCourse;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageCourse;

public class ManageCoursesEvent {

	public ManageCoursesEvent() {
	}

	public void newCourse(final String name) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			AddCourse addCourse = new AddCourse(name);
			addCourse.start();
		}
	}

	public void deleteCourse(final int id) {

		ManageCourse.lblWaitting.setVisible(true);

		Thread t = new Thread() {
			public void run() {
				try {
					if (Client.conn.deleteCourse(id)) {
						ManageCourse.lblWaitting.setVisible(false);
						ManageCourse.tableModel = new DefaultTableModel(
								FullDataCourse.getModelDataCourse(),
								ManageCourse.headTable);
						ManageCourse.table.setModel(ManageCourse.tableModel);

						JOptionPane.showMessageDialog(new JFrame(), "Deleted!");
						ManageCourse.setEnableConpoment(false, false, true,
								false, false, true);
						ManageCourse.txtId.setText("");
						ManageCourse.txtName.setText("");
					} else {
						ManageCourse.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't delete!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					new DisconnectToExit();
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	public void updateCourse(final int id, String name) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			UpdateCourse updateCourse = new UpdateCourse(id, name);
			updateCourse.start();
		}

	}

}

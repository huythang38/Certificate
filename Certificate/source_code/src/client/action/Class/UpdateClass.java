package client.action.Class;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageClass;

public class UpdateClass extends Thread {
	/**
	 * @uml.property  name="name"
	 */
	public String name;
	/**
	 * @uml.property  name="courses_name"
	 */
	public String courses_name;
	/**
	 * @uml.property  name="id"
	 */
	public int id;
	/**
	 * @uml.property  name="size"
	 */
	public int size;
	/**
	 * @uml.property  name="year"
	 */
	public int year;

	public UpdateClass(int _id, String _name, String _courses_name, int _size,
			int _year) {
		this.name = _name;
		this.id = _id;
		this.courses_name = _courses_name;
		this.size = _size;
		this.year = _year;
	}

	public void run() {
		ManageClass.lblWaitting.setVisible(true);

		try {
			if (Client.conn.updateClass(id, name, courses_name, size, year)) {
				ManageClass.lblWaitting.setVisible(false);
				ManageClass.tableModel = new DefaultTableModel(
						ModelClass.getModel(), ManageClass.headTable);
				ManageClass.table.setModel(ManageClass.tableModel);

				JOptionPane.showMessageDialog(new JFrame(), "Updated!");
				ManageClass.setEnableConpoment(false, true, true, true, true,
						false, true, true, true);
			} else {
				ManageClass.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't update!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

	}
}

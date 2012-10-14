package client.action.Class;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageClass;

public class AddClass extends Thread {
	/**
	 * @uml.property  name="name"
	 */
	public String name;
	/**
	 * @uml.property  name="courses_name"
	 */
	public String courses_name;
	/**
	 * @uml.property  name="size"
	 */
	public int size;
	/**
	 * @uml.property  name="year"
	 */
	public int year;

	public AddClass(String _name, String _courses_name, int _size, int _year) {
		this.name = _name;
		this.courses_name = _courses_name;
		this.size = _size;
		this.year = _year;
	}

	public void run() {
		ManageClass.lblWaitting.setVisible(true);

		try {
			if (Client.conn.isClass(name, courses_name) == false) {

				try {
					if (Client.conn.newClass(name, courses_name, size, year)) {
						ManageClass.lblWaitting.setVisible(false);
						ManageClass.tableModel = new DefaultTableModel(
								ModelClass.getModel(), ManageClass.headTable);
						ManageClass.table.setModel(ManageClass.tableModel);

						JOptionPane.showMessageDialog(new JFrame(), "Added!");
						ManageClass.setEnableConpoment(false, false, false,
								false, false, true, false, false, true);
						ManageClass.txtId.setText("");
						ManageClass.txtName.setText("");
						ManageClass.btnNew.setVisible(true);
						ManageClass.btnOk.setVisible(false);
					} else {
						ManageClass.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't add!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					new DisconnectToExit();
					e.printStackTrace();
				}

			} else {
				ManageClass.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(),
						"Class already exists! Please check!");
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

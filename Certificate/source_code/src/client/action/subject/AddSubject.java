package client.action.subject;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.ManageSubject;

public class AddSubject extends Thread {
	/**
	 * @uml.property  name="name"
	 */
	public String name;
	/**
	 * @uml.property  name="courses_name"
	 */
	public String courses_name;

	public AddSubject(String _name, String _courses_name) {
		this.name = _name;
		this.courses_name = _courses_name;
	}

	public void run() {
		ManageSubject.lblWaitting.setVisible(true);

		try {
			if (Client.conn.isSubject(name, courses_name) == false) {
				
				try {
					if (Client.conn.newSubject(name, courses_name)) {
						ManageSubject.lblWaitting.setVisible(false);
						ManageSubject.tableModel = new DefaultTableModel(
								ModelSubject.getModelSubject(),
								ManageSubject.headTable);
						ManageSubject.table.setModel(ManageSubject.tableModel);

						JOptionPane.showMessageDialog(new JFrame(), "Added!");
						ManageSubject.setEnableConpoment(false, false, false, true,
								false, false, true);
						ManageSubject.txtId.setText("");
						ManageSubject.txtName.setText("");
						ManageSubject.btnNew.setVisible(true);
						ManageSubject.btnOk.setVisible(false);
					} else {
						ManageSubject.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't add!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					new DisconnectToExit();
					e.printStackTrace();
				}

			} else {
				ManageSubject.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(),
						"Subject already exists! Please check!");
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

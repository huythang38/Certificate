package client.action.student;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.UpdateStudent;

public class UpdateStudents extends Thread {
	/**
	 * @uml.property  name="name"
	 */
	public String name;
	/**
	 * @uml.property  name="address"
	 */
	public String address;
	/**
	 * @uml.property  name="birthday"
	 */
	public String birthday;
	/**
	 * @uml.property  name="email"
	 */
	public String email;
	/**
	 * @uml.property  name="candidate"
	 */
	public String candidate;
	/**
	 * @uml.property  name="class"
	 */
	public String Class;
	/**
	 * @uml.property  name="id"
	 */
	public int id;
	/**
	 * @uml.property  name="gender"
	 */
	public int gender;
	/**
	 * @uml.property  name="phone"
	 */
	public int phone;
	/**
	 * @uml.property  name="class_id"
	 */
	public int class_id;

	public UpdateStudents(int _id, String _name, String _address, int _gender,
			String _birthday, String _email, int _phone, String _candidate,
			String _class, int _class_id) {

		this.id = _id;
		this.name = _name;
		this.address = _address;
		this.gender = _gender;
		this.birthday = _birthday;
		this.email = _email;
		this.phone = _phone;
		this.candidate = _candidate;
		this.Class = _class;
		this.class_id = _class_id;
	}

	public void run() {
		UpdateStudent.lblWaitting.setVisible(true);
		//
		try {
			if (Client.conn.updateStudent(id, name, address, gender, birthday,
					email, phone, candidate, Class)) {
				UpdateStudent.lblWaitting.setVisible(false);
				UpdateStudent.model = new DefaultTableModel(
						UpdateStudent.searchPanelEvent.ModelfoTable(class_id),
						UpdateStudent.headTable);
				UpdateStudent.table.setModel(UpdateStudent.model);

				JOptionPane.showMessageDialog(new JFrame(), "Updated!");
				UpdateStudent.setEnableConpoment(false);
			} else {
				UpdateStudent.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't update!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

	}
}

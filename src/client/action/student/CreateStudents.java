package client.action.student;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.action.account.NextAccount;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.CreateStudent;

public class CreateStudents extends Thread {
	public String name;
	public String address;
	public String birthday;
	public String email;
	public String candidate;
	public String Class;
	public int id;
	public int gender;
	public int phone;
	public int class_id;

	public CreateStudents(String _name, String _address, int _gender,
			String _birthday, String _email, int _phone, String _candidate,
			String _class) {

		this.name = _name;
		this.address = _address;
		this.gender = _gender;
		this.birthday = _birthday;
		this.email = _email;
		this.phone = _phone;
		this.candidate = _candidate;
		this.Class = _class;
	}

	public boolean createAccount() throws RemoteException {
		return Client.conn.createAccount();
	}

	public boolean createPayment(int students_id) throws RemoteException {
		return Client.conn.createPayment(students_id);
	}

	public int getIDClass(String class_name) throws RemoteException {
		return Client.conn.getClassID(class_name);
	}

	public void run() {
		CreateStudent.lblWaitting.setVisible(true);
		//
		try {
			if (createAccount()) {
				if (Client.conn.createStudent(name, address, gender, birthday,
						email, phone, candidate, Class,
						(NextAccount.nextAccount() - 1))) {
					if (createPayment(Client.conn.getStudentsLastID())) {
						CreateStudent.lblWaitting.setVisible(false);

						CreateStudent.model = new DefaultTableModel(
								ModeltoTable.getModel(getIDClass(Class)),
								CreateStudent.headTable);
						CreateStudent.table.setModel(CreateStudent.model);
						CreateStudent.txtUsername.setText("Student"
								+ NextAccount.nextAccount());
						JOptionPane.showMessageDialog(new JFrame(), "Created!");
					}
				} else {
					CreateStudent.lblWaitting.setVisible(false);
					JOptionPane
							.showMessageDialog(new JFrame(), "Don't create!");
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

	}
}

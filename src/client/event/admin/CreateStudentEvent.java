package client.event.admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.action.student.CreateStudents;
import extend_lib.ValidateEmail;

public class CreateStudentEvent {
	public void createStudent(String name, String address, int gender,
			String birthday, String email, int phone, String candidate,
			String _class) {

		CreateStudents createStudents = new CreateStudents(name, address,
				gender, birthday, email, phone, candidate, _class);
		createStudents.start();

	}

	public void create(String name, String address, boolean male,
			boolean female, String birthday, String email, String phone,
			String candidate, String _class, int Class, int course) {

		if (name.equals("") || address.equals("") || birthday.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Not leave * field empty!");

		} else if ((male == false) && (female == false)) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Not select an item in the gender!");

		} else if ((!email.equals("")) && (!ValidateEmail.isEmail(email))) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Validate email fail! Please check again!");

		} else if (!birthday.matches("^\\d\\d\\d\\d-\\d\\d-\\d\\d$")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Validate birthday fail! Please check again!");

		} else if (course == 0) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Not select an item in the course!");

		} else if (Class == 0) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Not select an item in the class!");

		} else {
			int _phone;
			if (phone.equals("")) {
				_phone = 0;
			} else {
				_phone = Integer.parseInt(phone);
			}

			if (male == true) {
				createStudent(name, address, 1, birthday, email, _phone,
						candidate, _class);
			} else if (female == true) {
				createStudent(name, address, 0, birthday, email, _phone,
						candidate, _class);
			}

		}
	}
}

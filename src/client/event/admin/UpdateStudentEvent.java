package client.event.admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.action.student.UpdateStudents;
import extend_lib.ValidateEmail;

public class UpdateStudentEvent {
	public void updateStudent(final int id, String name, String address,
			int gender, String birthday, String email, int phone,
			String candidate, String _class, int class_id) {

		UpdateStudents updateStudents = new UpdateStudents(id, name, address,
				gender, birthday, email, phone, candidate, _class, class_id);
		updateStudents.start();

	}

	public void update(final String id, String name, String address, boolean male,
			boolean female, String birthday, String email, String phone,
			String candidate, String _class, int class_id, int Class) {

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

		} else if (Class == 0) {
			_class = null;

		} else {
			if (male == true) {
				updateStudent(Integer.parseInt(id), name, address, 1, birthday, email,
						Integer.parseInt(phone), candidate, _class, class_id);
			} else if (female == true) {
				updateStudent(Integer.parseInt(id), name, address, 0, birthday, email,
						Integer.parseInt(phone), candidate, _class, class_id);
			}

		}
	}
}

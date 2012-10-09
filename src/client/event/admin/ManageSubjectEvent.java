package client.event.admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.action.subject.AddSubject;
import client.action.subject.DeleteSubject;
import client.action.subject.UpdateSubject;

public class ManageSubjectEvent {

	public ManageSubjectEvent() {
	}

	public void newSubject(final String name, String courses_name) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			AddSubject add = new AddSubject(name, courses_name);
			add.start();
		}
	}

	public void updateSubject(final int id, String name, String courses_name) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			UpdateSubject update = new UpdateSubject(id, name, courses_name);
			update.start();
		}

	}

	public void delete(final int id) {
		int bol = JOptionPane.showConfirmDialog(new JFrame(),
				"Delete Subject can delete records in other tables!",
				"Message", JOptionPane.OK_OPTION);

		if (bol == 0) {
			DeleteSubject delete = new DeleteSubject(id);
			delete.start();
		}
	}

}

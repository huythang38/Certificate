package client.event.admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.action.Class.AddClass;
import client.action.Class.DeleteClass;
import client.action.Class.UpdateClass;

public class ManageClassEvent {

	public ManageClassEvent() {
	}

	public void newClass(final String name, String courses_name, int size,
			int year) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			AddClass add = new AddClass(name, courses_name, size, year);
			add.start();
		}
	}

	public void updateClass(final int id, String name, String courses_name,
			int size, int year) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			UpdateClass update = new UpdateClass(id, name, courses_name, size,
					year);
			update.start();
		}

	}

	public void deleteClass(final int id) {
		int bol = JOptionPane.showConfirmDialog(new JFrame(),
				"Delete Class can delete records in other tables!",
				"Message", JOptionPane.OK_OPTION);

		if (bol == 0) {
			DeleteClass delete = new DeleteClass(id);
			delete.start();
		}
	}

}

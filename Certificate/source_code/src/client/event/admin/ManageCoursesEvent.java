package client.event.admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.action.course.AddCourse;
import client.action.course.DeleteCourse;
import client.action.course.UpdateCourse;

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
		int bol = JOptionPane.showConfirmDialog(new JFrame(), "Delete course can delete records in other tables!",
				"Message", JOptionPane.OK_OPTION);

		if (bol == 0) {
			DeleteCourse deleteCourse = new DeleteCourse(id);
			deleteCourse.start();
		}
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

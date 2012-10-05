package client.event.admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.action.cadidate.AddCandidate;
import client.action.cadidate.DeleteCandidate;
import client.action.cadidate.UpdateCandidate;

public class ManageCandidateEvent {
	public void newCandidate(final String name, Float payment) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			AddCandidate addCandidate = new AddCandidate(name, payment);
			addCandidate.start();
		}
	}

	public void deleteCandidate(final int id) {
		int bol = JOptionPane.showConfirmDialog(new JFrame(),
				"Delete candidate can delete records in other tables!", "Message",
				JOptionPane.OK_OPTION);

		if (bol == 0) {
			DeleteCandidate deleteCourse = new DeleteCandidate(id);
			deleteCourse.start();
		}
	}

	public void updateCandidate(final int id, String name, Float payment) {
		if (name.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			UpdateCandidate updateCandidate = new UpdateCandidate(id, name, payment);
			updateCandidate.start();
		}

	}
}

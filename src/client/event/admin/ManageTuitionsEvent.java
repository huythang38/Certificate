package client.event.admin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.action.tuition.AddTuition;
import client.action.tuition.DeleteTuition;
import client.action.tuition.UpdateTuition;

public class ManageTuitionsEvent {
	public ManageTuitionsEvent() {
	}

	public void newTuition(final Float payment) {
			AddTuition addTuition = new AddTuition(payment);
			addTuition.start();
	}

	public void deleteTuition(final int id) {
		int bol = JOptionPane.showConfirmDialog(new JFrame(),
				"Delete tuition can delete records in other tables!", "Message",
				JOptionPane.OK_OPTION);

		if (bol == 0) {
			DeleteTuition deleteTuition = new DeleteTuition(id);
			deleteTuition.start();
		}
	}

	public void updateTuition(final int id, Float payment) {
			UpdateTuition updateTuition = new UpdateTuition(id, payment);
			updateTuition.start();
	}
}

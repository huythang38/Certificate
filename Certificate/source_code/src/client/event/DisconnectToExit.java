package client.event;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DisconnectToExit {

	public DisconnectToExit() {
		JOptionPane.showMessageDialog(new JFrame(),
				"Disconnected! Program will exit!");
		System.exit(0);
	}
}

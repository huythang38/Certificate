package client.event;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.RUN;

public class MessageDisconnect {

	/**
	 * @uml.property  name="check"
	 */
	public int check;
	
	public MessageDisconnect() {
		check = JOptionPane.showConfirmDialog(new JFrame(),
				"Disconnected! Would you like to reconnect?", "Error",
				JOptionPane.YES_NO_OPTION);

		// reconnect
		if (check == 0) {
			RUN.disconnect();
			RUN runPro = new RUN(true);
			runPro.showLoadConnect("lib/images/connect.gif");
			runPro.Connect();
		} else {
			System.exit(0);
		}
	}

}

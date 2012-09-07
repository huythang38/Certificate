package client.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginConfigEvent {

	public boolean configAction(String path, int port) {
		boolean check;
		if (path.equals("")) {
			check = false;
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			check = true;
		}
		if ((port <= 1024) || (port > 65650)) {
			check = false;
			JOptionPane.showMessageDialog(new JFrame(),
					"in the range from 1025 to 65651!");
		}
		return check;
	}

	public boolean checkLogin(String userName, String passWord) {

		return false;
	}
}

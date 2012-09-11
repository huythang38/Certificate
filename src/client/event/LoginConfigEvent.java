/*
 * huythang38
 */

package client.event;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Client;
import client.RUN;
import client.config.Config;
import client.gui.NavFrame;

public class LoginConfigEvent {
	public Client client;
	public Config config;

	public LoginConfigEvent(Client values) {
		config = new Config();
		client = values;
	}

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

		if (check) {
			config.updateConfigFile(path, port);
		}
		return check;
	}

	public boolean checkLogin(String userName, String passWord) {
		boolean check = false;
		if (userName.equals("") || passWord.equals("")) {
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			@SuppressWarnings("rawtypes")
			Vector dataLogin = RUN.connectServer.client.checkAccount(userName,
					passWord);

			// login failed
			if (dataLogin.isEmpty()) {
				JOptionPane.showMessageDialog(new JFrame(),
						"account or password is incorrect!");
				check = false;
			}
			// successful login
			else if (dataLogin.get(1).equals(1)) {
				check = true;
				// call Navigator Frame
				NavFrame navFrame = new NavFrame();
				navFrame.setUserName(dataLogin.get(0).toString());
				navFrame.setPermission(Integer.parseInt(dataLogin.get(2).toString()));
			}
			// account has been locked
			else {
				JOptionPane
						.showMessageDialog(new JFrame(),
								"Your account has been locked. \nPlease contact the school for more details.");
				check = false;
			}
		}

		return check;
	}
}

/*
 * huythang38
 */

package client.event;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.action.ForgotPass;
import extend_lib.ValidateEmail;

public class FogotPassEvent {

	public void generateEmail(String value) {

		if (ValidateEmail.isEmail(value)) {
			
			ForgotPass forgotPass = new ForgotPass(value);
			forgotPass.setName("sendMail");
			forgotPass.start();

		} else {
			JOptionPane.showMessageDialog(new JFrame(),
					"Validate email fail! Please check again!");
		}
	}

}

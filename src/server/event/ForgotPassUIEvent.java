/*
 * huythang38
 */
package server.event;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.config.Config;

import extend_lib.ValidateEmail;

public class ForgotPassUIEvent {
	public boolean check = false;
	
	public void updateForm(String smtp, int port, String username, String password){

		if (smtp.equals("")|| port == 0 || username.equals("") || password.equals(""))
		{
			JOptionPane.showMessageDialog(new JFrame(), "not leave any field empty!");
		}else if (!ValidateEmail.isEmail(username)){
			JOptionPane.showMessageDialog(new JFrame(), "Username fail! Please re-enter!");
		}else{
			Config config = new Config();
			config.updateConfigSMTP(smtp, port, username, password);
			check = true;
		}	
	}
	
	public boolean isUpdateForm(){
		return check;
	}
}

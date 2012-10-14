/*
 * huythang38
 */

package server.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Config {
	/**
	 * @uml.property  name="config"
	 */
	public Properties config;
	/**
	 * @uml.property  name="user"
	 */
	public String user;
	/**
	 * @uml.property  name="pass"
	 */
	public String pass;
	/**
	 * @uml.property  name="smtp"
	 */
	public String smtp;
	/**
	 * @uml.property  name="port_smtp"
	 */
	public int port_smtp;
	/**
	 * @uml.property  name="user_smtp"
	 */
	public String user_smtp;
	/**
	 * @uml.property  name="pass_smtp"
	 */
	public String pass_smtp;
	/**
	 * @uml.property  name="port"
	 */
	public int port;

	public Config() {
		readConfigFile();
	}

	// read key from file configConnect.properties
	public void readConfigFile() {
		config = new Properties();
		try {
			FileInputStream path = new FileInputStream("lib/config.properties");
			try {
				config.load(path);
				user = config.getProperty("USER").trim();
				pass = config.getProperty("PASS").trim();
				port = Integer.parseInt(config.getProperty("PORT").trim());
				
				smtp = config.getProperty("SMTP").trim();
				port_smtp = Integer.parseInt(config.getProperty("PORT_SMTP").trim());
				user_smtp = config.getProperty("USER_SMTP").trim();
				pass_smtp = config.getProperty("PASS_SMTP").trim();
				
				path.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(new JFrame(),
						"don't read file config!");
				System.exit(0);
			}
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(new JFrame(),
					"could not find file config.properties");
			System.exit(0);
		}
	}

	// update key to file
	public void updateConfigDATA(String userNew, String passNew, int portNew) {
		config.setProperty("USER", userNew);
		config.setProperty("PASS", passNew);
		config.setProperty("PORT", Integer.toString(portNew));
		// write to file
		try {
			FileOutputStream writeFile = new FileOutputStream(
					"lib/config.properties");
			config.store(writeFile, null);
			writeFile.close();
			JOptionPane.showMessageDialog(new JFrame(),
					"Update succeed! Restart Program to apply!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// update key to file
		public void updateConfigSMTP(String smtpNew, int portNew, String userNew, String passNew) {
			config.setProperty("SMTP", smtpNew);
			config.setProperty("PORT_SMTP", Integer.toString(portNew));
			config.setProperty("USER_SMTP", userNew);
			config.setProperty("PASS_SMTP", passNew);
			
			// write to file
			try {
				FileOutputStream writeFile = new FileOutputStream(
						"lib/config.properties");
				config.store(writeFile, null);
				writeFile.close();
				JOptionPane.showMessageDialog(new JFrame(),
						"Update succeed!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	// get config
	/**
	 * @return
	 * @uml.property  name="user"
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return
	 * @uml.property  name="pass"
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @return
	 * @uml.property  name="port"
	 */
	public int getPort() {
		return port;
	}
	
	//
	/**
	 * @return
	 * @uml.property  name="smtp"
	 */
	public String getSmtp() {
		return smtp;
	}

	/**
	 * @return
	 * @uml.property  name="port_smtp"
	 */
	public int getPort_smtp() {
		return port_smtp;
	}
	
	/**
	 * @return
	 * @uml.property  name="user_smtp"
	 */
	public String getUser_smtp() {
		return user_smtp;
	}

	/**
	 * @return
	 * @uml.property  name="pass_smtp"
	 */
	public String getPass_smtp() {
		return pass_smtp;
	}

}

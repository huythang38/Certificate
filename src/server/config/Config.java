package server.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Config {
	public Properties config;
	public String user, pass;
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
	public void updateConfigFile(String userNew, String passNew, int portNew) {
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
					"update succeed! Restart Program to apply!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get config
	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public int getPort() {
		return port;
	}
}

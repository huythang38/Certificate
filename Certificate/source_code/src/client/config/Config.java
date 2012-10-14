/*
 * huythang38
 */

package client.config;

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
	 * @uml.property  name="path"
	 */
	public String path;
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
			FileInputStream file = new FileInputStream(
					"lib/configConnectServer.properties");
			try {
				config.load(file);
				path = config.getProperty("PATH").trim();
				port = Integer.parseInt(config.getProperty("PORT").trim());
				file.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(new JFrame(),
						"don't read file config!");
				System.exit(0);
			}
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(new JFrame(),
					"could not find file configConnectServer.properties");
			System.exit(0);
		}
	}

	// update key to file
	public void updateConfigFile(String pathNew, int portNew) {
		config.setProperty("PATH", pathNew);
		config.setProperty("PORT", Integer.toString(portNew));
		// write to file
		try {
			FileOutputStream writeFile = new FileOutputStream(
					"lib/configConnectServer.properties");
			config.store(writeFile, null);
			writeFile.close();
			JOptionPane.showMessageDialog(new JFrame(),
					"update config succeeded! \nAnd test connect to Server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "don't update config!");
			e.printStackTrace();
		}
	}

	// get config
	/**
	 * @return
	 * @uml.property  name="path"
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @return
	 * @uml.property  name="port"
	 */
	public int getPort() {
		return port;
	}
}

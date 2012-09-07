package client.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Config {
	public Properties config;
	public String path;
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
					"update config succeeded!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "don't update config!");
			e.printStackTrace();
		}
	}

	// get config
	public String getPath() {
		return path;
	}

	public int getPort() {
		return port;
	}
}

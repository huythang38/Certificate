/*
 * huythang38
 */

package client;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import client.config.Config;
import client.event.LoginConfigEvent;
import client.gui.LoginConfig;
import client.gui.SplashScreen;
import client.threads.ConnectServer;

public class RUN {
	public static Config config;
	public LoginConfigEvent events;
	public SplashScreen sScreen;
	public LoginConfig loginConfig;
	public Timer timerCheckConnect;
	public static ConnectServer connectServer;

	public boolean isSpScreen;
	
	// Main
	public static void main(String[] args) {
		RUN runPro = new RUN();
		runPro.LAF();
		runPro.showSpashScreen();
		runPro.Connect();
	}

	// Look and Feel
	public void LAF() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		} catch (UnsupportedLookAndFeelException ex) {
		}
	}

	// RUN
	public RUN() {}

	public void showSpashScreen() {
		// call Splash Screen
		sScreen = new SplashScreen();
		sScreen.setVisible(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isSpScreen = true;
	}

	public void Connect() {
		// Connect to server (run Thread)
		connectServer = new ConnectServer();

		// Timer used to refesh status when check Connect to Server
		timerCheckConnect = new Timer();
		timerCheckConnect.schedule(new RemindTaskCheckConnect(), 1000);
	}
	
	public void disconnect(){
		connectServer.stopConnect();
	}
	class RemindTaskCheckConnect extends TimerTask {
		public void run() {
			// true show frame LoginConfig with login panel
			if (connectServer.isConnect()) {
				if (isSpScreen){
					sScreen.removeNotify();
					isSpScreen = false;
				}
				loginConfig = new LoginConfig();
				loginConfig.cl.show(loginConfig.panel, "login");
				loginConfig.setVisible(true);

				// true show frame LoginConfig with config panel when connect
				// fail
			} else if (connectServer.isConnect() == false
					& connectServer.isNext() == true) {
				if (isSpScreen){
					sScreen.removeNotify();
					isSpScreen = false;
				}
				loginConfig = new LoginConfig();
				loginConfig.cl.show(loginConfig.panel, "config");
				loginConfig.setVisible(true);
				JOptionPane
						.showMessageDialog(
								new JFrame(),
								"Connection failed!Please check the internet connection \nor install connection settings!");

				// waiting for connection
			} else {
				timerCheckConnect.schedule(new RemindTaskCheckConnect(), 1000);
			}
		}
	}
}

/*
 * huythang38
 */

package client;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import client.config.Config;
import client.event.LoginConfigEvent;
import client.gui.LoadingImage;
import client.gui.LoginConfig;
import client.gui.SplashScreen;
import client.threads.ConnectServer;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
//import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
;

public class RUN {
	public static Config config;
	public LoginConfigEvent events;
	public SplashScreen sScreen;
	public LoadingImage loadingImage;
	public static LoginConfig loginConfig;
	public Timer timerCheckConnect;
	public static ConnectServer connectServer;

	public boolean isLastConnect;
	public boolean isSpScreen;

	// Main
	public static void main(String[] args) {
		RUN runPro = new RUN(false);
		runPro.LAF();
		runPro.showSpashScreen();
		runPro.Connect();
	}

	// Look and Feel
	public void LAF() {
//		 try {
//		 for (UIManager.LookAndFeelInfo info : UIManager
//		 .getInstalledLookAndFeels()) {
//		 if ("Nimbus".equals(info.getName())) {
//		 UIManager.setLookAndFeel(info.getClassName());
//		 break;
//		 }
//		 }
//		 } catch (ClassNotFoundException ex) {
//		 } catch (InstantiationException ex) {
//		 } catch (IllegalAccessException ex) {
//		 } catch (UnsupportedLookAndFeelException ex) {
//		 }
//
		try 
	    {
//	      UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
	      UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }

	}

	// RUN
	public RUN(boolean values) {
		isLastConnect = values;
	}

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

	@SuppressWarnings("deprecation")
	public void showLoadConnect(){
		loadingImage = new LoadingImage();
		loginConfig.disable();
	}
	
	public void Connect() {
		// Connect to server (run Thread)
		connectServer = new ConnectServer();

		// Timer used to refesh status when check Connect to Server
		timerCheckConnect = new Timer();
		timerCheckConnect.schedule(new RemindTaskCheckConnect(), 1000);
	}

	public static void disconnect() {
		connectServer.stopConnect();
	}

	class RemindTaskCheckConnect extends TimerTask {
		@SuppressWarnings("deprecation")
		public void run() {
			// true show frame LoginConfig with login panel
			if (connectServer.isConnect()) {
				
				if (isSpScreen) {
					sScreen.removeNotify();
					isSpScreen = false;
					
					loginConfig = new LoginConfig();
					loginConfig.cl.show(loginConfig.panel, "login");
					loginConfig.setVisible(true);
				}else{
					loadingImage.removeNotify();
					
					if (isLastConnect){
						JOptionPane.showMessageDialog(new JFrame(),
								"successful connection");
					}
					loginConfig.setTitle("Login");
					loginConfig.cl.show(loginConfig.panel, "login");
					loginConfig.enable();
				}
					
				// true show frame LoginConfig with config panel when connect
				// fail
			} else if (connectServer.isConnect() == false
					& connectServer.isNext() == true) {
				if (isSpScreen) {
					sScreen.removeNotify();
					isSpScreen = false;
					
					loginConfig = new LoginConfig();
					loginConfig.setTitle("Config Conect");
					loginConfig.cl.show(loginConfig.panel, "config");
					loginConfig.btnBackToLogin.setEnabled(false);
					loginConfig.setVisible(true);
					JOptionPane
							.showMessageDialog(
									new JFrame(),
									"Connection failed!Please check the internet connection \n" +
									"or install connection settings!");
					
				}else{
					loadingImage.removeNotify();
			
					loginConfig.setTitle("Config Conect");
					loginConfig.cl.show(loginConfig.panel, "config");
					loginConfig.btnBackToLogin.setEnabled(false);
					JOptionPane
							.showMessageDialog(
									new JFrame(),
									"Connection failed!Please check the internet connection \n" +
									"or install connection settings!");
				}
				loginConfig.enable();
				
				// waiting for connection
			} else {
				timerCheckConnect.schedule(new RemindTaskCheckConnect(), 1000);
			}
		}
	}
}

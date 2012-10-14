/*
 * huythang38
 */

package client;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.config.Config;
import client.event.LoginConfigEvent;
import client.gui.LoadingImage;
import client.gui.LoginConfig;
import client.gui.SplashScreen;
import client.threads.ConnectServer;

public class RUN {
	public static Config config;
	/**
	 * @uml.property  name="events"
	 * @uml.associationEnd  readOnly="true"
	 */
	public LoginConfigEvent events;
	/**
	 * @uml.property  name="sScreen"
	 * @uml.associationEnd  
	 */
	public SplashScreen sScreen;
	/**
	 * @uml.property  name="loadingImage"
	 * @uml.associationEnd  
	 */
	public LoadingImage loadingImage;
	public static LoginConfig loginConfig;
	/**
	 * @uml.property  name="timerCheckConnect"
	 */
	public Timer timerCheckConnect;
	public static ConnectServer connectServer;
	/**
	 * @uml.property  name="threadLoading"
	 */
	public Thread threadLoading;

	/**
	 * @uml.property  name="isLastConnect"
	 */
	public boolean isLastConnect;
	/**
	 * @uml.property  name="isSpScreen"
	 */
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
		try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
            {
                if ("Windows".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }else if("GTK+".equals(installedLookAndFeels[idx].getName())){
                	javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }else{
                	javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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

	public void showLoadConnect(String urlImg) {
		loadingImage = new LoadingImage(urlImg);
		threadLoading = new Thread(loadingImage);
		threadLoading.setName("LOadingImage");
		threadLoading.start();
	}

	public void Connect() {
		// Connect to server (run Thread)
		connectServer = new ConnectServer();

		// Timer used to refesh status when check Connect to Server
		timerCheckConnect = new Timer();
		timerCheckConnect.schedule(new RemindTaskCheckConnect(), 1000);
//		try{
//			cconnectServer.stop();
//		} catch (Exception ex) {
//			
//		}
		
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
				} else {
					threadLoading.stop();
					loadingImage.disposeDialog();

					if (isLastConnect) {
						JOptionPane.showMessageDialog(new JFrame(),
								"successful connection");
					}
					loginConfig.setTitle("Login");
					loginConfig.cl.show(loginConfig.panel, "login");
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
					JOptionPane.showMessageDialog(new JFrame(),
							"Connection failed!Please check the internet connection \n"
									+ "or install connection settings!");

				} else {
					threadLoading.stop();
					loadingImage.disposeDialog();

					loginConfig.setTitle("Config Conect");
					loginConfig.cl.show(loginConfig.panel, "config");
					loginConfig.btnBackToLogin.setEnabled(false);
					JOptionPane.showMessageDialog(new JFrame(),
							"Connection failed!Please check the internet connection \n"
									+ "or install connection settings!");
				}

				// waiting for connection
			} else {
				timerCheckConnect.schedule(new RemindTaskCheckConnect(), 1000);
			}
		}
	}
}

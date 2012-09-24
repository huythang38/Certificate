/*
 * huythang38
 */
package client.threads;

import client.Client;
import client.config.Config;
import client.event.LoginConfigEvent;

public class ConnectServer implements Runnable {
	public Client client;
	public Config config;
	public boolean checkConnect;
	public boolean nextAction;
	public static boolean stopConnect = true;
	public LoginConfigEvent events;

	public ConnectServer(){
		Thread tConnectServer = new Thread(this);
		tConnectServer.setName("ConnectServer");
		tConnectServer.start();
	}
	
	public void run() {
		config = new Config();
		client = new Client();
		checkConnect = client.connectServer(config.getPath(), config.getPort());
		nextAction = true;
		
		//stop connect when not find server
		if (checkConnect == false && nextAction == true){
			stopConnect();
		}
		// successful connection, keep the threading
		while (stopConnect){
			//
		}
	}
	
	//status connect
	public boolean isConnect() {
		return checkConnect;
	}
	
	//true: then continue, false: waiting for connection	
	public boolean isNext() {
		return nextAction;
	}
	
	//stop Connect to Server
	public void stopConnect(){
		client.disConnectServer();
		stopConnect = false;
	}
}
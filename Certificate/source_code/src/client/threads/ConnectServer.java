/*
 * huythang38
 */
package client.threads;

import client.Client;
import client.config.Config;
import client.event.LoginConfigEvent;

public class ConnectServer implements Runnable {
	/**
	 * @uml.property  name="client"
	 * @uml.associationEnd  
	 */
	public Client client;
	/**
	 * @uml.property  name="config"
	 * @uml.associationEnd  
	 */
	public Config config;
	/**
	 * @uml.property  name="checkConnect"
	 */
	public boolean checkConnect;
	/**
	 * @uml.property  name="nextAction"
	 */
	public boolean nextAction;
	public static boolean stopConnect = true;
	/**
	 * @uml.property  name="events"
	 * @uml.associationEnd  readOnly="true"
	 */
	public LoginConfigEvent events;

	public ConnectServer(){
		Thread tConnectServer = new Thread(this);
		tConnectServer.setName("ConnectServer");
		tConnectServer.setPriority(2);
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
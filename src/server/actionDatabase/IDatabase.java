package server.actionDatabase;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDatabase extends Remote {
	// read file configConnect.propreties for config Connect to Database
	public void readConfigDatabase() throws RemoteException;

	// create connection to Database
	public void connectDatabase() throws RemoteException;

	// disConnect
	public void disConnect() throws RemoteException;
}

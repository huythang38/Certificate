/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import server.Server;

@SuppressWarnings("serial")
public class Excutable extends UnicastRemoteObject implements IDatabase {
	public Server server;

	public Excutable() throws RemoteException {
		server = new Server();
	}

	@Override
	public Vector<?> checkAccount(String username, String password)
			throws RemoteException {
		return server.checkAccount(username, password);
	}

	@Override
	public boolean statusConnect() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
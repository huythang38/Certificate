/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface IDatabase extends Remote {
	
	//check Account
	public Vector<?> checkAccount(String username, String password) throws RemoteException;
}

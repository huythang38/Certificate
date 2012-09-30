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
	
	//forgot Password
	public boolean forgotPassWord(String email) throws RemoteException;
	
	//return list name course in table courses
	public Vector<String> getListNameCourse() throws RemoteException;
	
	//return list name class and id in table class
	@SuppressWarnings("rawtypes")
	public Vector getListNameAndIDClass(int index) throws RemoteException;
	
	//return list name and Accounts_id in table student
	@SuppressWarnings("rawtypes")
	public Vector getListNameAndAccount_idStudent(int index) throws RemoteException;
	
	//
}

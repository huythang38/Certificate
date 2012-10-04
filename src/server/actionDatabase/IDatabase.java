/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface IDatabase extends Remote {

	// check Account
	public Vector<?> checkAccount(String username, String password)
			throws RemoteException;

	// forgot Password
	public boolean forgotPassWord(String email) throws RemoteException;

	// check name in table courses
	public boolean isNameCourse(String name) throws RemoteException;

	// return full data in table courses
	@SuppressWarnings("rawtypes")
	public Vector getFullCourse() throws RemoteException;

	// return list name course in table courses
	public Vector<String> getListNameCourse() throws RemoteException;

	// return list id course in table courses
	public Vector<Integer> getListIdCourse() throws RemoteException;

	// return list name class and id in table class
	@SuppressWarnings("rawtypes")
	public Vector getListNameAndIDClass(int index) throws RemoteException;

	// return list name and Accounts_id in table student
	@SuppressWarnings("rawtypes")
	public Vector getListNameAndAccount_idStudent(int index)
			throws RemoteException;

	// return username and status of account
	@SuppressWarnings("rawtypes")
	public Vector getAccount(int id) throws RemoteException;

	// change status account
	public boolean changeStatus(int id, int status) throws RemoteException;

	// reset password
	public boolean resetPass(int id) throws RemoteException;

	// update course
	public boolean updateCourse(int id, String name) throws RemoteException;

	// delete course
	public boolean deleteCourse(int id) throws RemoteException;

	// new course
	public boolean newCourse(String name) throws RemoteException;

}

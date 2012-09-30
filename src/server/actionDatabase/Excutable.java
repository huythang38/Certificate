/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import server.event.ForgotPass;
import server.event.Login;
import server.event.read_data.ClassTable;
import server.event.read_data.CoursesTable;
import server.event.read_data.StudentsTable;

@SuppressWarnings("serial")
public class Excutable extends UnicastRemoteObject implements IDatabase {
	public Login login = new Login();
	public CoursesTable coursesTable;
	public ClassTable classTable;
	public StudentsTable studentTable;

	public Excutable() throws RemoteException {}

	@Override
	public Vector<?> checkAccount(String username, String password)
			throws RemoteException {
		return login.checkAccount(username, password);
	}

	@Override
	public boolean forgotPassWord(String email) throws RemoteException {
		// TODO Auto-generated method stub
		ForgotPass forgotPass = new ForgotPass();
		if (forgotPass.checkEmail(email)) {
			forgotPass.sendPassToMail(email);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Vector<String> getListNameCourse() throws RemoteException {
		// TODO Auto-generated method stub
		coursesTable = new CoursesTable();
		return coursesTable.getNameCollection();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getListNameAndIDClass(int index) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector<>();
		classTable = new ClassTable();
		data.add(classTable.getIDCollection(index));
		data.add(classTable.getNameCollection(index));
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getListNameAndAccount_idStudent(int index) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		studentTable = new StudentsTable();
		data.add(studentTable.getAccounts_idCollection(index));
		data.add(studentTable.getNameCollection(index));
		return data;
	}

}

/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import server.Server;
import server.event.ForgotPass;
import server.event.Login;

@SuppressWarnings("serial")
public class Excutable extends UnicastRemoteObject implements IDatabase {
	public Login login = new Login();

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

	@SuppressWarnings("rawtypes")
	public Vector getFullCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.getFullCollection();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getListNameAndIDClass(int index) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector<>();
		data.add(Server.classTable.getIDCollection(index));
		data.add(Server.classTable.getNameCollection(index));
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getListNameAndAccount_idStudent(int index) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		data.add(Server.studentsTable.getAccounts_idCollection(index));
		data.add(Server.studentsTable.getNameCollection(index));
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getAccount(int id) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		data.add(Server.accountsTable.getUsername(id));
		data.add(Server.accountsTable.getStatus(id));
		return data;
	}

	@Override
	public boolean changeStatus(int id, int status) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.accountsTable.updateStatus(id, status);
	}

	@Override
	public boolean resetPass(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.accountsTable.resetPass(id);
	}

	@Override
	public boolean updateCourse(int id, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.updateCourse(id, name);
	}

	@Override
	public boolean deleteCourse(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.deleteCourse(id);
	}

	@Override
	public boolean newCourse(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.addCourse(name);
	}

	@Override
	public Vector<String> getListNameCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.getNameCollection();
	}

	@Override
	public Vector<Integer> getListIdCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.getIdCollection();
	}

	@Override
	public boolean isNameCourse(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.isNameCourse(name);
	}

	
	
	@Override
	public boolean isPaymentTuition(Float payment) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.isPaymentTuition(payment);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Vector getFullTuition() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.getFullCollection();
	}

	@Override
	public Vector<Float> getListPaymentTuition() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.getPaymentCollection();
	}

	@Override
	public Vector<Integer> getListIdTuition() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.getIdCollection();
	}

	@Override
	public boolean updateTuition(int id, Float payment) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.updateTuiton(id, payment);
	}

	@Override
	public boolean deleteTuition(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.deleteTuition(id);
	}

	@Override
	public boolean newTuition(Float payment) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.addTuition(payment);
	}

	
	
	
}

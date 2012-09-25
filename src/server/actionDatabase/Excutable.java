/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import server.event.ForgotPass;
import server.event.Login;

@SuppressWarnings("serial")
public class Excutable extends UnicastRemoteObject implements IDatabase {
	public Login login = new Login();

	public Excutable() throws RemoteException {
	}

	@Override
	public Vector<?> checkAccount(String username, String password)
			throws RemoteException {
		return login.checkAccount(username, password);
	}

	@Override
	public boolean statusConnect() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
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

}

/*
 * huythang38
 */
package server.event;

import java.util.Vector;

import server.Server;

public class Login {
	// Action
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector<?> checkAccount(String username, String password) {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		if (Server.accountsTable.getUsername(username) != null){
			if (Server.accountsTable.getPassword(password) != null){
				int id = Server.accountsTable.getId(username);
				data.addElement(id);
				data.addElement(username);
				data.addElement(Server.accountsTable.getStatus(id));
				data.addElement(Server.accountsTable.getRole(id));
			}
		}
		return data;
	}
}

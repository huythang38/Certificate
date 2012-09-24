package server.event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		try {
			Statement stmt = Server.conn.createStatement();
			String sql = "select * from accounts where username = '" + username
					+ "' and password = '" + password + "'";
			ResultSet rst = stmt.executeQuery(sql);
			rst.next();
			data.addElement(rst.getInt("id"));
			data.addElement(rst.getString("username"));
			data.addElement(rst.getInt("status"));
			data.addElement(rst.getInt("role"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return data;
	}
}

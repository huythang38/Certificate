/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.config.Config;

@SuppressWarnings("serial")
public class Excutable extends UnicastRemoteObject implements IDatabase {
	private String userData;
	private String passData;
	private int port;
	public Connection conn;

	public Excutable() throws RemoteException {
		readConfigDatabase();
	}

	public void readConfigDatabase() {
		Config config = new Config();
		userData = config.getUser();
		passData = config.getPass();
		port = config.getPort();
	}

	public void connectDatabase() {
		// TODO Auto-generated method stub
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(new JFrame(),
					"lib jdbc not found!");
		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Certificate", userData,
					passData);
			System.out.println("Connect Database succeeded!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(new JFrame(),
					"error Connect Database!");

		}
	}

	public void disConnect(){

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getPort() {
		return port;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Vector<?> checkAccount(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from Accounts where AC_User = '"+username+"' and AC_Pass = '"+password+"'";
			ResultSet rst = stmt.executeQuery(sql);
			rst.next();
			data.addElement(rst.getString("AC_User"));
			data.addElement(rst.getInt("AC_Status"));
			data.addElement(rst.getInt("AC_Permission"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return data;
	}
}

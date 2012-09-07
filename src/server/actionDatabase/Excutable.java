package server.actionDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

	@Override
	public void readConfigDatabase() throws RemoteException {
		Config config = new Config();
		userData = config.getUser();
		passData = config.getPass();
		port = config.getPort();
	}

	@Override
	public void connectDatabase() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException ex) {

			} catch (IllegalAccessException ex) {

			}
		} catch (ClassNotFoundException ex) {

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

	@Override
	public void disConnect() throws RemoteException {

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
}

/*
 * huythang38
 */

package server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.actionDatabase.Excutable;
import server.config.Config;

public class Server {
	private static Excutable run;
	private InetAddress dc;
	private int port;
	private String userData;
	private String passData;
	public static Connection conn;

	public boolean startServer() {
		try {
			dc = InetAddress.getLocalHost();
			run = new Excutable();
			port = (new Config()).getPort();
			System.out.println(port);
			try {
				LocateRegistry.createRegistry(port);
			} catch (RemoteException e1) {
			}

			Naming.rebind("rmi://" + dc.getHostAddress() + ":" + port
					+ "/Certificate", run);
			JOptionPane.showMessageDialog(new JFrame(),
					"start server successfully!");

			// start connect to DataBase
			readConfigDatabase();
			connectDatabase();
			return true;
		} catch (MalformedURLException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "not start Server");
			return false;
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(new JFrame(), "not get IP Local");
			return false;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void closeServer() throws RemoteException {
		try {
			Naming.unbind("rmi://localhost:" + port + "/Certificate");
			UnicastRemoteObject.unexportObject(run, true);
			 disConnectDatabase();
			JOptionPane.showMessageDialog(new JFrame(),
					"Close server successfully!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// run.disConnect();
		// System.exit(0);
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
			JOptionPane.showMessageDialog(new JFrame(), "lib jdbc not found!");
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

	public void disConnectDatabase() {
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

//Action
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector<?> checkAccount(String username, String password) {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from Accounts where AC_User = '" + username
					+ "' and AC_Pass = '" + password + "'";
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

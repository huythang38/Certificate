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
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.actionDatabase.Excutable;
import server.config.Config;
import server.event.read_data.AccountsTable;
import server.event.read_data.CandidatesTable;
import server.event.read_data.ClassTable;
import server.event.read_data.CoursesTable;
import server.event.read_data.PaymentsTable;
import server.event.read_data.StudentsTable;
import server.event.read_data.SubjectsTable;
import server.event.read_data.TuitionsTable;

public class Server {
	private static Excutable run;
	private InetAddress dc;
	private int port;
	private String userData;
	private String passData;
	public static Connection conn;
	public static AccountsTable accountsTable;
	public static StudentsTable studentsTable;
	public static CoursesTable coursesTable;
	public static ClassTable classTable;
	public static TuitionsTable tuitionsTable;
	public static CandidatesTable candidatesTable;
	public static PaymentsTable paymentsTable;
	public static SubjectsTable subjectsTable;

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
					+ "/certificate", run);
			JOptionPane.showMessageDialog(new JFrame(),
					"start server successfully!");

			// start connect to DataBase
			readConfigDatabase();
			connectDatabase();
			callData();
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
			Naming.unbind("rmi://localhost:" + port + "/certificate");
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
					"jdbc:mysql://localhost:3306/certificate", userData,
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

	public void callData(){
		accountsTable = new AccountsTable();
		studentsTable = new StudentsTable();
		coursesTable = new CoursesTable();
		classTable = new ClassTable();
		tuitionsTable = new TuitionsTable();
		candidatesTable = new CandidatesTable();
		paymentsTable = new PaymentsTable();
		subjectsTable = new SubjectsTable();
	}
}

/*
 * huythang38
 */

package server.gui;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.actionDatabase.Excutable;
import server.config.Config;

public class Server {
	private Excutable run;
	private InetAddress dc;
	private int port;

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
			run.connectDatabase();
			return true;
		} catch (MalformedURLException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "not start Server");
			return false;
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(new JFrame(), "not get IP Local");
			return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public void closeServer() throws RemoteException {
		try {
			Naming.unbind("rmi://localhost:" + port + "/Certificate");
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

}

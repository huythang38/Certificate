package client.event.admin;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.ExecuteLoading;
import client.gui.admin.nav_panel.AccountChangeStatusPanel;

public class ChangeStatusEvent {
	public static ExecuteLoading lblWaitting;
	public static Thread threadExecuteLoading;

	public ChangeStatusEvent() {
	}

	public void changeStatus(final int id, final int index) {
		AccountChangeStatusPanel.lblWaitting.setVisible(true);

		Thread t = new Thread() {
			public void run() {
				try {
					if (Client.conn.changeStatus(id, index)) {
						AccountChangeStatusPanel.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Changed Status!");
					}else{
						AccountChangeStatusPanel.lblWaitting.setVisible(false);
						JOptionPane.showMessageDialog(new JFrame(),
								"Don't change Status!");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					new DisconnectToExit();
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
}

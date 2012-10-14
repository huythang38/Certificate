package client.action.certificate;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.Certificate;

public class CreateCertificate extends Thread {
	/**
	 * @uml.property  name="score"
	 */
	public int score;
	/**
	 * @uml.property  name="classified"
	 */
	public String classified;
	/**
	 * @uml.property  name="students_id"
	 */
	public int students_id;

	public CreateCertificate(int _score, String _classified, int _students_id) {
		this.score = _score;
		this.classified = _classified;
		this.students_id = _students_id;
	}

	public void run() {
		Certificate.lblWaitting.setVisible(true);
		try {
			if (Client.conn.createCertificate(score, classified, students_id)) {
				Certificate.lblWaitting.setVisible(false);

				int index = Certificate.searchPanel.cbbxClass.getSelectedIndex();
				if (index != 0) {
					Certificate.model = new DefaultTableModel(
							Certificate.searchPanelEvent.ModelfoTable(index), Certificate.headTable);
					Certificate.table.setModel(Certificate.model);

				}

				JOptionPane.showMessageDialog(new JFrame(), "Succeed!");
				Certificate.btnGeneration.setEnabled(false);
				Certificate.btnExportCertificate.setEnabled(true);
			} else {
				Certificate.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't Succeed!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}
}

package client.action.record;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Client;
import client.event.DisconnectToExit;
import client.event.admin.searchPanel.SearchPanelInputMarkEvent;
import client.gui.admin.nav_panel.InputMark;

public class InputMarks extends Thread {
	public String name;
	public int subjects_id;
	public int mark;

	public InputMarks(String students_name, int _subjects_id, String _mark) {
		this.name = students_name;
		this.subjects_id = _subjects_id;
		this.mark = Integer.parseInt(_mark);
	}

	@SuppressWarnings("static-access")
	public void run() {
		InputMark.lblWaitting.setVisible(true);
		try {
			if (Client.conn.inputMark(name, subjects_id, mark)) {
				InputMark.lblWaitting.setVisible(false);

				SearchPanelInputMarkEvent.showRecord(
						InputMark.searchPanel.cbbxClass.getSelectedIndex(),
						InputMark.searchPanel.cbbxSubject.getSelectedIndex());

				JOptionPane.showMessageDialog(new JFrame(), "Succeed!");
			} else {
				InputMark.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Not succeed!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
	}
}

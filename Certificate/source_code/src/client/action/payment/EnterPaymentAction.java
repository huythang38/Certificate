package client.action.payment;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import client.Client;
import client.action.course.FullDataCourse;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.EnterPayment;

@SuppressWarnings("unused")
public class EnterPaymentAction extends Thread {
	/**
	 * @uml.property  name="students_id"
	 */
	public int students_id;
	/**
	 * @uml.property  name="payment"
	 */
	public Float payment;

	public EnterPaymentAction(int _students_id, Float _payment) {
		this.students_id = _students_id;
		this.payment = _payment;
	}

	public void run() {
		EnterPayment.lblWaitting.setVisible(true);

		try {
			if (Client.conn.enterPayment(students_id, payment)) {
				EnterPayment.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Succeed!");
				int index = EnterPayment.searchPanel.cbbxClass.getSelectedIndex();
				if (index != 0) {
					EnterPayment.model = new DefaultTableModel(EnterPayment.searchPanelEvent
							.ModelfoTable(index), EnterPayment.headTable);
					EnterPayment.table.setModel(EnterPayment.model);
					EnterPayment.btnOk.setEnabled(false);
				}
			} else {
				EnterPayment.lblWaitting.setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Don't enter new Payment!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}

	}
}

package client.event.admin;

import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Client;
import client.action.payment.EnterPaymentAction;
import client.action.payment.ModeltoTable;
import client.event.DisconnectToExit;
import client.gui.admin.nav_panel.EnterPayment;

@SuppressWarnings("unused")
public class EnterPaymentEvent {

	public EnterPaymentEvent() {
	}

	@SuppressWarnings("rawtypes")
	public void enterPayment(int row, Float payment) {
		Vector data = (Vector) ModeltoTable.data.get(row);
		int students_id = Integer.parseInt(data.get(2).toString());
		Float tuition = (Float) EnterPayment.table.getValueAt(row, 2);
		Float paid = (Float) EnterPayment.table.getValueAt(row, 1);

		if (tuition < (paid + payment)) {
			JOptionPane.showMessageDialog(new JFrame(), "ok!");
		} else {
			EnterPaymentAction enterPayment = new EnterPaymentAction(
					students_id, (paid + payment));
			 enterPayment.start();
		}

		//
	}
}

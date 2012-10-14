package client.event.admin;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.admin.searchPanel.SearchPanelGenerationCertificate;
import client.gui.admin.nav_panel.Certificate;

public class GenerationCertificateEvent {
	@SuppressWarnings("rawtypes")
	public static Vector data = new Vector();
	/**
	 * @uml.property  name="account"
	 */
	@SuppressWarnings("rawtypes")
	Vector account = new Vector();
	/**
	 * @uml.property  name="status"
	 */
	String status = null;
	/**
	 * @uml.property  name="tableSeclect"
	 */
	int tableSeclect;

	public void viewInfo(int _tableSeclect) {
		this.tableSeclect = _tableSeclect;
		String paymentStatus = null;
		String subjectStatus = null;
		String score = null;
		String grade = null;

		getAccount();

		if (getPaymentStatus()) {
			paymentStatus = "Complete";
		} else {
			paymentStatus = "Not Complete";
		}

		if (getSubjectStatus()) {
			subjectStatus = "Complete";
			int iScore = score();
			score = Integer.toString(iScore);
			try {
				grade = grade(iScore);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			subjectStatus = "Not Complete";
		}

		Certificate.setContentToPanel(account.get(0).toString(), status, data
				.get(1).toString(), data.get(4).toString(), data.get(8)
				.toString(), data.get(9).toString(), paymentStatus,
				subjectStatus, score, grade);
	}

	@SuppressWarnings("rawtypes")
	public void getAccount() {
		data = (Vector) SearchPanelGenerationCertificate.data.get(tableSeclect);

		try {
			int student_id = Integer.parseInt(data.get(0).toString());
			int account_id = Client.conn.getAccounts_id(student_id);
			account = Client.conn.getAccount(account_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (account.get(1).toString().equals("1")) {
			status = "Account is unlocked";
		} else {
			status = "Account is locked";
		}
	}

	public boolean getPaymentStatus() {
		boolean _return = false;
		int students_id = Integer.parseInt(data.get(0).toString());
		String candidates_name = data.get(7).toString();
		try {
			Float paid = Client.conn.getPaid(students_id);
			Float payment = Client.conn.getPayment(candidates_name);

			if ((payment - paid) == 0) {
				_return = true;
			} else {
				_return = false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			_return = false;
		}

		return _return;
	}

	public int score() {
		int _return = 0;
		int students_id = Integer.parseInt(data.get(0).toString());
		String courses_name = data.get(9).toString();

		try {
			_return = Client.conn.getScore(students_id, courses_name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _return;
	}

	public boolean getSubjectStatus() {
		boolean _return = false;
		int students_id = Integer.parseInt(data.get(0).toString());
		String courses_name = data.get(9).toString();

		try {
			if (Client.conn.isCompleteSubject(students_id, courses_name)) {
				_return = true;
			} else {
				_return = false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return _return;
	}

	public String grade(int score) throws RemoteException {
		String _return = null;
		int students_id = Integer.parseInt(data.get(0).toString());

		if (score >= 75) {
			_return = "Distinction";
			if (Client.conn.isCertificate(students_id)) {
				Certificate.btnGeneration.setEnabled(false);
				Certificate.btnExportCertificate.setEnabled(true);
			} else {
				Certificate.btnGeneration.setEnabled(true);
				Certificate.btnExportCertificate.setEnabled(false);
			}

		} else if ((score >= 60) && (score < 75)) {
			_return = "A";
			if (Client.conn.isCertificate(students_id)) {
				Certificate.btnGeneration.setEnabled(false);
				Certificate.btnExportCertificate.setEnabled(true);
			} else {
				Certificate.btnGeneration.setEnabled(true);
				Certificate.btnExportCertificate.setEnabled(false);
			}

		} else if ((score >= 50) && (score < 59)) {
			if (Client.conn.isCertificate(students_id)) {
				Certificate.btnGeneration.setEnabled(false);
				Certificate.btnExportCertificate.setEnabled(true);
			} else {
				Certificate.btnGeneration.setEnabled(true);
				Certificate.btnExportCertificate.setEnabled(false);
			}
			_return = "B";

		} else if ((score >= 40) && (score < 49)) {
			_return = "C";

		}
		return _return;
	}
}

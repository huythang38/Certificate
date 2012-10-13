/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import server.Server;
import server.event.ForgotPass;
import server.event.Login;

@SuppressWarnings("serial")
public class Excutable extends UnicastRemoteObject implements IDatabase {
	public Login login = new Login();

	public Excutable() throws RemoteException {
	}

	@Override
	public Vector<?> checkAccount(String username, String password)
			throws RemoteException {
		return login.checkAccount(username, password);
	}

	@Override
	public boolean forgotPassWord(String email) throws RemoteException {
		// TODO Auto-generated method stub
		ForgotPass forgotPass = new ForgotPass();
		if (forgotPass.checkEmail(email)) {
			forgotPass.sendPassToMail(email);
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public Vector getFullCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.getFullCollection();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getListNameAndIDClass(int index) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector<>();
		data.add(Server.classTable.getIDCollection(index));
		data.add(Server.classTable.getNameCollection(index));
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getListNameAndAccount_idStudent(int index)
			throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		data.add(Server.studentsTable.getAccounts_idCollection(index));
		data.add(Server.studentsTable.getNameCollection(index));
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getAccount(int id) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		data.add(Server.accountsTable.getUsername(id));
		data.add(Server.accountsTable.getStatus(id));
		return data;
	}

	@Override
	public boolean changeStatus(int id, int status) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.accountsTable.updateStatus(id, status);
	}

	@Override
	public boolean resetPass(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.accountsTable.resetPass(id);
	}

	@Override
	public boolean updateCourse(int id, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.updateCourse(id, name);
	}

	@Override
	public boolean deleteCourse(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.deleteCourse(id);
	}

	@Override
	public boolean newCourse(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.addCourse(name);
	}

	@Override
	public Vector<String> getListNameCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.getNameCollection();
	}

	@Override
	public Vector<Integer> getListIdCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.getIdCollection();
	}

	@Override
	public boolean isNameCourse(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.coursesTable.isNameCourse(name);
	}

	@Override
	public boolean isPaymentTuition(Float payment) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.isPaymentTuition(payment);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Vector getFullTuition() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.getFullCollection();
	}

	@Override
	public Vector<Float> getListPaymentTuition() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.getPaymentCollection();
	}

	@Override
	public Vector<Integer> getListIdTuition() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.getIdCollection();
	}

	@Override
	public boolean updateTuition(int id, Float payment) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.updateTuiton(id, payment);
	}

	@Override
	public boolean deleteTuition(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.deleteTuition(id);
	}

	@Override
	public boolean newTuition(Float payment) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.tuitionsTable.addTuition(payment);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getModelCandidate() throws RemoteException {
		// TODO Auto-generated method stub
		Vector dataCandidate = Server.candidatesTable.getFullCollection();
		Vector _return = new Vector();
		for (int x = 0; x < dataCandidate.size(); x++) {
			Vector dataChild = new Vector();
			dataChild = (Vector) dataCandidate.get(x);
			Float payment = Server.tuitionsTable.getPayment((int) dataChild
					.get(2));
			dataChild.set(2, payment);

			_return.add(dataChild);
		}
		return _return;
	}

	@Override
	public boolean deleteCandidate(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.candidatesTable.deleteCandidate(id);
	}

	@Override
	public boolean newCandidate(String name, Float payment)
			throws RemoteException {
		// TODO Auto-generated method stub
		int tuitions_id = Server.tuitionsTable.getId(payment);
		return Server.candidatesTable.addCandidate(name, tuitions_id);
	}

	@Override
	public boolean updateCandidate(int id, String name, Float payment)
			throws RemoteException {
		// TODO Auto-generated method stub
		int tuitions_id = Server.tuitionsTable.getId(payment);
		return Server.candidatesTable.updateCandidate(id, name, tuitions_id);
	}

	@Override
	public boolean isNameCandidate(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.candidatesTable.isNameCandidate(name);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getModelEnterPaymentTable(int class_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		Vector _return = new Vector();
		Vector data = Server.studentsTable
				.getName_ID_CandidateId_Collection(class_id);
		for (int x = 0; x < data.size(); x++) {
			Vector dataChild = (Vector) data.get(x);

			{
				int students_id = Integer.parseInt(dataChild.get(2).toString());
				Float paid = Server.paymentsTable.getPaid(students_id);
				dataChild.add(paid);
			}
			{
				int candidates_id = Integer.parseInt(dataChild.get(1)
						.toString());
				Float payment = Server.tuitionsTable.getPayment(candidates_id);
				dataChild.set(1, payment);
			}

			_return.add(dataChild);
		}
		return _return;
	}

	@Override
	public boolean enterPayment(int students_id, Float newPaid)
			throws RemoteException {
		// TODO Auto-generated method stub
		return Server.paymentsTable.enterPayment(students_id, newPaid);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getModelSubject() throws RemoteException {
		// TODO Auto-generated method stub
		Vector dataSubject = Server.subjectsTable.getFullCollection();
		Vector _return = new Vector();
		for (int x = 0; x < dataSubject.size(); x++) {
			Vector dataChild = new Vector();
			dataChild = ((Vector) dataSubject.get(x));
			int courses_id = (int) dataChild.get(2);
			String courseName = Server.coursesTable.getName(courses_id);
			dataChild.set(2, courseName);
			_return.add(dataChild);
		}
		return _return;
	}

	@Override
	public boolean deleteSubject(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.subjectsTable.deleteSubject(id);
	}

	@Override
	public boolean newSubject(String name, String courses_name)
			throws RemoteException {
		// TODO Auto-generated method stub
		int courses_id = Server.coursesTable.getId(courses_name);
		return Server.subjectsTable.addSubject(name, courses_id);
	}

	@Override
	public boolean updateSubject(int id, String name, String courses_name)
			throws RemoteException {
		// TODO Auto-generated method stub
		int courses_id = Server.coursesTable.getId(courses_name);
		return Server.subjectsTable.updateSubject(id, name, courses_id);
	}

	@Override
	public boolean isSubject(String name, String courses_name)
			throws RemoteException {
		// TODO Auto-generated method stub
		int courses_id = Server.coursesTable.getId(courses_name);
		return Server.subjectsTable.isSubject(name, courses_id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getModelClass() throws RemoteException {
		// TODO Auto-generated method stub
		Vector dataClass = Server.classTable.getFullCollection();
		Vector _return = new Vector();
		for (int x = 0; x < dataClass.size(); x++) {
			Vector dataChild = new Vector();
			dataChild = ((Vector) dataClass.get(x));
			int courses_id = (int) dataChild.get(2);
			String courseName = Server.coursesTable.getName(courses_id);
			dataChild.set(2, courseName);
			_return.add(dataChild);
		}
		return _return;
	}

	@Override
	public boolean deleteClass(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.classTable.deleteClass(id);
	}

	@Override
	public boolean newClass(String name, String courses_name, int size, int year)
			throws RemoteException {
		// TODO Auto-generated method stub
		int courses_id = Server.coursesTable.getId(courses_name);
		return Server.classTable.addClass(name, courses_id, size, year);
	}

	@Override
	public boolean updateClass(int id, String name, String courses_name,
			int size, int year) throws RemoteException {
		// TODO Auto-generated method stub
		int courses_id = Server.coursesTable.getId(courses_name);
		return Server.classTable.updateClass(id, name, courses_id, size, year);
	}

	@Override
	public boolean isClass(String name, String courses_name)
			throws RemoteException {
		// TODO Auto-generated method stub
		int courses_id = Server.coursesTable.getId(courses_name);
		return Server.classTable.isClass(name, courses_id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getModelStudent(int class_id) throws RemoteException {
		// TODO Auto-generated method stub
		Vector _return = new Vector();
		Vector data = Server.studentsTable.getFullData(class_id);

		for (int x = 0; x < data.size(); x++) {
			Vector dataChild = (Vector) data.get(x);

			{
				int gender = Integer.parseInt(dataChild.get(3).toString());
				if (gender == 1) {
					dataChild.set(3, "Male");
				} else {
					dataChild.set(3, "Female");
				}
			}
			{
				int candidates_id = Integer.parseInt(dataChild.get(7)
						.toString());
				String candidates_name = Server.candidatesTable
						.getName(candidates_id);
				dataChild.set(7, candidates_name);
			}
			{
				String class_name = Server.classTable.getName(class_id);
				dataChild.set(8, class_name);
			}
			{
				int courses_id = Server.classTable.getCourses_id(class_id);
				String courses_name = Server.coursesTable.getName(courses_id);
				dataChild.set(9, courses_name);
			}
			_return.add(dataChild);
		}

		return _return;
	}

	@Override
	public Vector<String> getListNameCandidate() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.candidatesTable.getNameCollection();
	}

	@Override
	public boolean updateStudent(int id, String name, String address,
			int gender, String birthday, String email, int phone,
			String candidate, String _class) throws RemoteException {
		// TODO Auto-generated method stub

		int candidates_id = Server.candidatesTable.getId(candidate);
		int class_id = Server.classTable.getId(_class);
		boolean isUpdate = Server.studentsTable.updateStudent(id, name,
				address, gender, birthday, email, phone, candidates_id,
				class_id);
		return isUpdate;
	}

	@Override
	public int getAccounts_id(int idStudent) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.studentsTable.getAccounts_id(idStudent);
	}

	@Override
	public int getAccountsLastID() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.accountsTable.getIdLast();
	}

	@Override
	public boolean createAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.accountsTable.addAccount();
	}

	@Override
	public boolean createPayment(int students_id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.paymentsTable.addPayment(students_id);
	}

	@Override
	public boolean createStudent(String name, String address, int gender,
			String birthday, String email, int phone, String candidate,
			String _class, int accounts_id) throws RemoteException {
		// TODO Auto-generated method stub

		int candidates_id = Server.candidatesTable.getId(candidate);
		int class_id = Server.classTable.getId(_class);
		boolean isUpdate = Server.studentsTable.createStudent(name, address,
				gender, birthday, email, phone, candidates_id, class_id,
				accounts_id);
		return isUpdate;
	}

	@Override
	public int getStudentsLastID() throws RemoteException {
		// TODO Auto-generated method stub
		return Server.studentsTable.getIdLast();
	}

	@Override
	public int getClassID(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.classTable.getId(name);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getListNameAndIDSubject(int index) throws RemoteException {
		// TODO Auto-generated method stub
		Vector data = new Vector<>();
		data.add(Server.subjectsTable.getIDCollection(index));
		data.add(Server.subjectsTable.getNameCollection(index));
		return data;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Vector getModelInputMark(int class_id, int subjects_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		Vector StudentsCollection = new Vector();
		Vector _return = new Vector();
		StudentsCollection = Server.studentsTable
				.getName_ID_CandidateId_Collection(class_id);

		for (int x = 0; x < StudentsCollection.size(); x++) {
			Vector data = new Vector();
			Vector dataChild = new Vector();

			data = (Vector) StudentsCollection.get(x);
			{
				dataChild.add(data.get(0));
				int students_id = Integer.parseInt(data.get(2).toString());
				int mark = Server.recordsTable
						.getMark(students_id, subjects_id);
				dataChild.add(mark);

				_return.add(dataChild);
			}
		}

		return _return;
	}

	@Override
	public boolean inputMark(String students_name, int class_id,
			int subjects_id, int mark) throws RemoteException {
		// TODO Auto-generated method stub
		int students_id = Server.studentsTable.getId(students_name, class_id);
		return Server.recordsTable.updateRecord(students_id, subjects_id, mark);
	}

	@Override
	public boolean isCertificate(int students_id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.certificatesTable.isCertificate(students_id);
	}

	@Override
	public Float getPaid(int students_id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.paymentsTable.getPaid(students_id);
	}

	@Override
	public Float getPayment(String candidates_Name) throws RemoteException {
		// TODO Auto-generated method stub
		int tuitions_id = Server.candidatesTable
				.getTuitions_id(candidates_Name);
		return Server.tuitionsTable.getPayment(tuitions_id);
	}

	@Override
	public boolean isCompleteSubject(int students_id, String courses_name)
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean _return = false;

		int courses_id = Server.coursesTable.getId(courses_name);
		Vector<Integer> listIdSubject = new Vector<Integer>();
		listIdSubject = Server.subjectsTable.getIDCollection(courses_id);

		for (int x = 0; x < listIdSubject.size(); x++) {
			int subjects_id = listIdSubject.get(x);
			int mark = Server.recordsTable.getMark(students_id, subjects_id);
			if (mark < 40) {
				_return = false;
				break;
			} else {
				_return = true;
			}
		}

		return _return;
	}

	@Override
	public int getScore(int students_id, String courses_name)
			throws RemoteException {
		// TODO Auto-generated method stub
		int _return = 0;

		int courses_id = Server.coursesTable.getId(courses_name);
		Vector<Integer> listIdSubject = new Vector<Integer>();
		listIdSubject = Server.subjectsTable.getIDCollection(courses_id);

		for (int x = 0; x < listIdSubject.size(); x++) {
			int subjects_id = listIdSubject.get(x);
			int mark = Server.recordsTable.getMark(students_id, subjects_id);
				_return = _return + mark;
		}

		return _return / listIdSubject.size();
	}

	@Override
	public boolean createCertificate(int score, String classified,
			int students_id) throws RemoteException {
		// TODO Auto-generated method stub
		return Server.certificatesTable.createCertificate(score, classified, students_id);
	}
}

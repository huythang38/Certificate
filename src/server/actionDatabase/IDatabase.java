/*
 * huythang38
 */

package server.actionDatabase;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface IDatabase extends Remote {

	// check Account
	public Vector<?> checkAccount(String username, String password)
			throws RemoteException;

	// forgot Password
	public boolean forgotPassWord(String email) throws RemoteException;

	// return list name class and id in table class
	@SuppressWarnings("rawtypes")
	public Vector getListNameAndIDClass(int index) throws RemoteException;

	// return list name and Accounts_id in table student
	@SuppressWarnings("rawtypes")
	public Vector getListNameAndAccount_idStudent(int index)
			throws RemoteException;

	// return username and status of account
	@SuppressWarnings("rawtypes")
	public Vector getAccount(int id) throws RemoteException;

	// change status account
	public boolean changeStatus(int id, int status) throws RemoteException;

	// reset password
	public boolean resetPass(int id) throws RemoteException;

	// check name in table courses
	public boolean isNameCourse(String name) throws RemoteException;

	// return full data in table courses
	@SuppressWarnings("rawtypes")
	public Vector getFullCourse() throws RemoteException;

	// return list name course in table courses
	public Vector<String> getListNameCourse() throws RemoteException;

	// return list id course in table courses
	public Vector<Integer> getListIdCourse() throws RemoteException;

	// update course
	public boolean updateCourse(int id, String name) throws RemoteException;

	// delete course
	public boolean deleteCourse(int id) throws RemoteException;

	// new course
	public boolean newCourse(String name) throws RemoteException;

	// check payment in table tuitions
	public boolean isPaymentTuition(Float payment) throws RemoteException;

	// return full data in table tuitions
	@SuppressWarnings("rawtypes")
	public Vector getFullTuition() throws RemoteException;

	// return list payment in table tuitions
	public Vector<Float> getListPaymentTuition() throws RemoteException;

	// return list id in table tuitions
	public Vector<Integer> getListIdTuition() throws RemoteException;

	// update tuition
	public boolean updateTuition(int id, Float payment) throws RemoteException;

	// delete tuition
	public boolean deleteTuition(int id) throws RemoteException;

	// new tuition
	public boolean newTuition(Float payment) throws RemoteException;

	// get model for table candidates
	@SuppressWarnings("rawtypes")
	public Vector getModelCandidate() throws RemoteException;

	// check name in table courses
	public boolean isNameCandidate(String name) throws RemoteException;

	// delete candidate
	public boolean deleteCandidate(int id) throws RemoteException;

	// new candidate
	public boolean newCandidate(String name, Float payment)
			throws RemoteException;

	// update candidate
	public boolean updateCandidate(int id, String name, Float payment)
			throws RemoteException;

	// return model(name in student, paid in paymnents, payment in tuitions) for
	// module enter payment
	@SuppressWarnings("rawtypes")
	public Vector getModelEnterPaymentTable(int class_id)
			throws RemoteException;

	// enter new payments
	public boolean enterPayment(int students_id, Float newPaid)
			throws RemoteException;

	// return model(id in subjects, name in subjects, name in courses) for
	// module manage subjects
	@SuppressWarnings("rawtypes")
	public Vector getModelSubject() throws RemoteException;

	// delete subject
	public boolean deleteSubject(int id) throws RemoteException;

	// new candidate
	public boolean newSubject(String name, String courses_name)
			throws RemoteException;

	// update subject
	public boolean updateSubject(int id, String name, String courses_name)
			throws RemoteException;

	// check exist subject
	public boolean isSubject(String name, String courses_name)
			throws RemoteException;

}

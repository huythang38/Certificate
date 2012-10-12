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

	// new subject
	public boolean newSubject(String name, String courses_name)
			throws RemoteException;

	// update subject
	public boolean updateSubject(int id, String name, String courses_name)
			throws RemoteException;

	// check exist subject
	public boolean isSubject(String name, String courses_name)
			throws RemoteException;

	// return model(id in class, name in class, name in courses, size in class,
	// year in class) for
	// module manage class
	@SuppressWarnings("rawtypes")
	public Vector getModelClass() throws RemoteException;

	// delete class
	public boolean deleteClass(int id) throws RemoteException;

	// new class
	public boolean newClass(String name, String courses_name, int size, int year)
			throws RemoteException;

	// update class
	public boolean updateClass(int id, String name, String courses_name,
			int size, int year) throws RemoteException;

	// check exist class
	public boolean isClass(String name, String courses_name)
			throws RemoteException;

	//
	//
	//
	@SuppressWarnings("rawtypes")
	public Vector getModelStudent(int class_id) throws RemoteException;

	// return list name candidate in table candidate
	public Vector<String> getListNameCandidate() throws RemoteException;

	// update student
	public boolean updateStudent(int id, String name, String address,
			int gender, String birthday, String email, int phone,
			String candidate, String _class) throws RemoteException;

	// get Accounts_id
	public int getAccounts_id(int idStudent) throws RemoteException;

	//
	//
	//
	// getLastIdLast in Accounts
	public int getAccountsLastID() throws RemoteException;

	// getLastIdLast in Student
	public int getStudentsLastID() throws RemoteException;

	// create new Account
	public boolean createAccount() throws RemoteException;

	// create Payment
	public boolean createPayment(int students_id) throws RemoteException;

	// create Student
	public boolean createStudent(String name, String address, int gender,
			String birthday, String email, int phone, String candidate,
			String _class, int accounts_id) throws RemoteException;

	// get id in class
	public int getClassID(String name) throws RemoteException;

	//
	//
	//
	// return list name class and id in table class
	@SuppressWarnings("rawtypes")
	public Vector getListNameAndIDSubject(int index) throws RemoteException;

	//
	@SuppressWarnings("rawtypes")
	public Vector getModelInputMark(int class_id, int subjects_id)
			throws RemoteException;

	//
	public boolean inputMark(String students_name, int subjects_id, int mark)
			throws RemoteException;
}

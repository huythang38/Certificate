package client.event.admin.searchPanel;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import client.action.ListNameCourse;
import client.action.Class.ListNameAndID;
import client.action.student.ListNameAndAccounts_ID;

public class SearchPanelEvent {
	public ListNameCourse listNameCourse = new ListNameCourse();
	public ListNameAndID listNameAndIDClass;
	public ListNameAndAccounts_ID listNameAndAccount_IDStudent;
	
	public Vector<String> getListNameCourse(){
		return listNameCourse.getListNameCourse();
	}
	
	public DefaultComboBoxModel<String> getListNameClassModel(int index){
		listNameAndIDClass = new ListNameAndID(index);
		Vector<String> data = listNameAndIDClass.getListNameClass();
		return new DefaultComboBoxModel<String>(data);
	}
	
	public DefaultComboBoxModel<String> getListNameStudentModel(int inde){
		int index = listNameAndIDClass.getListIDClass().get(inde - 1);
		listNameAndAccount_IDStudent = new ListNameAndAccounts_ID(index);
		Vector<String> data = listNameAndAccount_IDStudent.getListName();
		return new DefaultComboBoxModel<String>(data);
	}
	
	public int choiceStudent(int inde){
		int index = listNameAndAccount_IDStudent.getListID().get(inde - 1);
		return index;
	}
	
}

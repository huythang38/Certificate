package client.event.admin.searchPanel;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import client.action.record.ModelInputMark;
import client.action.subject.ListNameAndIDSubject;
import client.action.Class.ListNameAndIDClass;
import client.action.course.ListIdCourse;
import client.gui.admin.nav_panel.InputMark;
import client.gui.admin.nav_panel.searchPanel.SearchPanelInputMark;

public class SearchPanelInputMarkEvent extends SearchPanelEvent {
	public static ListNameAndIDSubject listNameAndIDSubject;
	public static ListNameAndIDClass listNameAndIDC;
	
	@Override
	public DefaultComboBoxModel<String> getListNameClassModel(int inde) {
		// TODO Auto-generated method stub
		int index = ListIdCourse.getListIdCourse().get(inde - 1);
		listNameAndIDC = new ListNameAndIDClass(index);
		listNameAndIDSubject = new ListNameAndIDSubject(index);
		
		Vector<String> data = listNameAndIDSubject.getListName();
		
		SearchPanelInputMark.cbbxSubject.setModel(new DefaultComboBoxModel<>(data));
		return super.getListNameClassModel(inde);
	}
	
	//
	@SuppressWarnings("rawtypes")
	public static void showRecord(int indexClass, int indexSubject) {
		int indexC = listNameAndIDC.getListIDClass().get(indexClass - 1);
		int indexS = listNameAndIDSubject.getListID().get(indexSubject - 1);
		
		Vector model = ModelInputMark.getModel(indexC, indexS);
		
		InputMark.model = new DefaultTableModel(model, InputMark.headTable);
		InputMark.table.setModel(InputMark.model);
	}
}

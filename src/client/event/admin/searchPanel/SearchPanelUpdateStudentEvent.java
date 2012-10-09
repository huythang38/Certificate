package client.event.admin.searchPanel;

import java.util.Vector;

import client.action.student.ModeltoTable;

public class SearchPanelUpdateStudentEvent extends SearchPanelEvent {
	@SuppressWarnings({ "rawtypes" })
	public Vector ModelfoTable(int classId) {
		int index = super.listNameAndIDClass.getListIDClass().get(classId - 1);
		return ModeltoTable.getModel(index);
	}
}

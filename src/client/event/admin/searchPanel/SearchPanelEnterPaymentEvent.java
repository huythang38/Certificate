package client.event.admin.searchPanel;

import java.util.Vector;
import client.action.payment.ModeltoTable;

public class SearchPanelEnterPaymentEvent extends SearchPanelEvent{
	@SuppressWarnings({ "rawtypes" })
	public Vector ModelfoTable(int classId){
		int index = super.listNameAndIDClass.getListIDClass().get(classId - 1);
		return ModeltoTable.getModel(index);	
	}
}

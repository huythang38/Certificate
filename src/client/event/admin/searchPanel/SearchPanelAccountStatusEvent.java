package client.event.admin.searchPanel;

import client.action.account.UserAndStatus;
import client.gui.admin.nav_panel.AccountChangeStatusPanel;

public class SearchPanelAccountStatusEvent extends SearchPanelEvent {
//	@Override
	@SuppressWarnings("static-access")
	public int choiceStudent(int inde) {
		// TODO Auto-generated method stub
		int index = super.choiceStudent(inde);
		UserAndStatus userAndStatus = new UserAndStatus(index);
		AccountChangeStatusPanel.lblAccountid.setText(userAndStatus.getUser());
		AccountChangeStatusPanel.cbbxChoiceStatus.setSelectedIndex(userAndStatus.getStatus());
		return inde;
	}
}

package client.event.admin.searchPanel;

import client.action.account.UserAndStatus;
import client.gui.admin.nav_panel.AccountResetPassword;

public class SearchPanelAccountResetPasswordEvent extends SearchPanelEvent{
	@SuppressWarnings("static-access")
	@Override
	public int choiceStudent(int inde) {
		// TODO Auto-generated method stub
		int index = super.choiceStudent(inde);
		UserAndStatus userAndStatus = new UserAndStatus(index);
		AccountResetPassword.idAccount = index;
		AccountResetPassword.lblAccountid.setText(userAndStatus.getUser());
		return inde;
	}

}

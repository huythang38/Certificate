package client.event.admin.searchPanel;

import javax.swing.DefaultComboBoxModel;

import client.gui.admin.nav_panel.AccountChangeStatusPanel;

public class SearchPanelAccountStatusEvent extends SearchPanelEvent {
	@Override
	public int choiceStudent(int inde) {
		// TODO Auto-generated method stub
		int index = super.choiceStudent(inde);
		AccountChangeStatusPanel.loadContent(index);
		return 0;
	}
}

package client.gui.admin.nav_panel.searchPanel;

import client.event.admin.searchPanel.SearchPanelAccountResetPasswordEvent;

@SuppressWarnings("serial")
public class SearchPanelAccountResetPassword extends SearchPanel{
	public static SearchPanelAccountResetPasswordEvent event = new SearchPanelAccountResetPasswordEvent();
	
	public SearchPanelAccountResetPassword(){
		super(event);
	}
	
}
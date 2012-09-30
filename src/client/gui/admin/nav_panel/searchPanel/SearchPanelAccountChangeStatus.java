package client.gui.admin.nav_panel.searchPanel;

import client.event.admin.searchPanel.SearchPanelAccountStatusEvent;

@SuppressWarnings("serial")
public class SearchPanelAccountChangeStatus extends SearchPanel{
	public static SearchPanelAccountStatusEvent event = new SearchPanelAccountStatusEvent();
	
	public SearchPanelAccountChangeStatus(){
		super(event);
	}
	
}

package client.gui.student;

import java.awt.CardLayout;

import javax.swing.JPanel;

import client.gui.student.nav_panel.About;
import client.gui.student.nav_panel.ViewInfo;
import client.gui.student.nav_panel.ViewMark;
import client.gui.student.nav_panel.HomePanel;

@SuppressWarnings("serial")
public class NavContentPanel extends JPanel {
	public CardLayout cardLayout;
	
	public NavContentPanel() {
		setLayout(new CardLayout());
		// tab home
		{
			HomePanel contentHome = new HomePanel();
			add(contentHome, "home");

			About contentAbout = new About();
			add(contentAbout, "about");
		}

		// tab Feature
		{
			ViewInfo viewInfo = new ViewInfo();
			add(viewInfo, "viewInfo");

			ViewMark viewMark = new ViewMark();
			add(viewMark, "viewMark");
		}
		
		cardLayout = (CardLayout) (this.getLayout());
		showContent("home");
	}
	
	public void showContent(String index){
		cardLayout.show(this, index);
	}
}

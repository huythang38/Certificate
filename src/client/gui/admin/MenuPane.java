package client.gui.admin;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import client.gui.admin.nav_menu.AccountTab;
import client.gui.admin.nav_menu.HomeTab;
import client.gui.admin.nav_menu.OtherTab;
import client.gui.admin.nav_menu.ReportTab;
import client.gui.admin.nav_menu.StudentTab;


@SuppressWarnings("serial")
public class MenuPane extends JTabbedPane {
	public MenuPane() {
		setBackground(new Color(219, 232, 243));
		setPreferredSize(new Dimension(0, 100));
		{
			{
				HomeTab tabpeHome = new HomeTab();
				addTab("Home", new ImageIcon("lib/images/home_16.png"),
						tabpeHome, null);
			}
			
			{
				StudentTab tabpeStudent = new StudentTab();
				addTab("Student", new ImageIcon(
						"lib/images/student_16.png"), tabpeStudent, null);
				
			}

			{
				AccountTab tabpeAccount = new AccountTab();
				addTab("Account", new ImageIcon(
						"lib/images/user_16.png"), tabpeAccount, null);
			}

			{
				OtherTab tabpeOther = new OtherTab();
				addTab("Other...", new ImageIcon(
						"lib/images/other_16.png"), tabpeOther, null);
			}

			{
				ReportTab tabpeReport = new ReportTab();
				addTab("Reports", new ImageIcon(
						"lib/images/report_16.png"), tabpeReport, null);
			}
		}
	}//end MenuPane method
}

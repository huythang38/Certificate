package client.gui.student;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import client.gui.student.nav_menu.FeatureTab;
import client.gui.student.nav_menu.HomeTab;

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
				FeatureTab tabpeAccount = new FeatureTab();
				addTab("Feature", new ImageIcon("lib/images/gear_16.png"),
						tabpeAccount, null);
			}
		}
	}// end MenuPane method
}

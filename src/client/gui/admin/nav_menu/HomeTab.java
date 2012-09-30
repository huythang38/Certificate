package client.gui.admin.nav_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import client.gui.NavGUI_Admin;
import extend_lib.Button;

@SuppressWarnings("serial")
public class HomeTab extends JPanel {

	public HomeTab() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		
		Button btHome = new Button("lib/images/home.png", "Home");
		add(btHome);
		btHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("home");
			}
		});
		btHome.setPreferredSize(new Dimension(90, 80));

		JPanel panelHelp = new JPanel();
		panelHelp.setOpaque(false);
		add(panelHelp);
		panelHelp.setPreferredSize(new Dimension(215, 90));
		panelHelp.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Help", TitledBorder.LEFT, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelHelp.setLayout(null);
		{
			Button btHelp = new Button("lib/images/help.png", "CSG Help!");
			btHelp.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					NavGUI_Admin.navPanel.showContent("help");
				}
			});
			btHelp.setBounds(11, 13, 87, 70);
			panelHelp.add(btHelp);

			Button btAbout = new Button("lib/images/about.png", "About CSG!");
			btAbout.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					NavGUI_Admin.navPanel.showContent("about");
				}
			});
			btAbout.setBounds(105, 13, 100, 70);
			panelHelp.add(btAbout);
		}
		
				Button btLogout = new Button("lib/images/logout.png", "Logout");
				add(btLogout);
				btLogout.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {

					}
				});
				btLogout.setPreferredSize(new Dimension(90, 80));
				
						Button btExit = new Button("lib/images/exit.png", "Exit");
						add(btExit);
						btExit.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent arg0) {
								System.exit(0);
							}
						});
						btExit.setPreferredSize(new Dimension(90, 80));
	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/bak3.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}
}

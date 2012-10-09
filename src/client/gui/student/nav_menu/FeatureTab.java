package client.gui.student.nav_menu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import client.gui.NavGUI_Student;
import extend_lib.Button;

@SuppressWarnings("serial")
public class FeatureTab extends JPanel {

	public FeatureTab() {
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));

		Button btViewInfo = new Button("lib/images/user_status.png",
				"View Info");
		btViewInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Student.navPanel.showContent("viewInfo");
			}
		});
		btViewInfo.setPreferredSize(new Dimension(120, 80));
		add(btViewInfo);

		Button btViewMark = new Button("lib/images/user_pass.png", "View Mark");
		btViewMark.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Student.navPanel.showContent("viewMark");
			}
		});
		btViewMark.setPreferredSize(new Dimension(120, 80));
		add(btViewMark);

		Button btChangePass = new Button("lib/images/user_role.png",
				"Change password");
		btChangePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
//				NavGUI_Student.navPanel.showContent("changeRole");
			}
		});
		btChangePass.setPreferredSize(new Dimension(110, 80));
		add(btChangePass);
		
		Button btUpdateInfo = new Button("lib/images/user_role.png",
				"Update Info");
		btUpdateInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
//				NavGUI_Student.navPanel.showContent("changeRole");
			}
		});
		btUpdateInfo.setPreferredSize(new Dimension(110, 80));
		add(btUpdateInfo);
	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/tabPanel.png").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}
}

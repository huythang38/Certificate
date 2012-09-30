package client.gui.admin.nav_menu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import client.gui.NavGUI_Admin;
import extend_lib.Button;

@SuppressWarnings("serial")
public class AccountTab extends JPanel{

	public AccountTab(){
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setLayout(new FlowLayout(FlowLayout.LEADING, 10,
				5));

		Button btChangeStatus = new Button(
				"lib/images/user_status.png", "Change Status");
		btChangeStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("changeStatus");
			}
		});
		btChangeStatus.setPreferredSize(new Dimension(120, 80));
		add(btChangeStatus);

//		Button btChangeRole = new Button("lib/images/user_role.png",
//				"Change Role");
//		btChangeRole.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				NavGUI_Admin.navPanel.showContent("changeRole");
//			}
//		});
//		btChangeRole.setPreferredSize(new Dimension(110, 80));
//		add(btChangeRole);

		Button btResetPass = new Button("lib/images/user_pass.png",
				"Reset Password");
		btResetPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("resetPass");
			}
		});
		btResetPass.setPreferredSize(new Dimension(120, 80));
		add(btResetPass);
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/bak4.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}
}

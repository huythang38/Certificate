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
public class ReportTab extends JPanel {

	public ReportTab() {
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));

		Button btGenerateCertificate = new Button("lib/images/certificateicon.png",
				"Generate Certificate");
		btGenerateCertificate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("generateCertificate");
			}
		});
		btGenerateCertificate.setPreferredSize(new Dimension(125, 80));
		add(btGenerateCertificate);
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/tabPanel.png").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}
}

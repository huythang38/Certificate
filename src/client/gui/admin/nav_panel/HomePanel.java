package client.gui.admin.nav_panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	
	public HomePanel() {
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);

	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/bak3.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);		
	}
}

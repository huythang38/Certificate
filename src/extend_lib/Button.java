/*
 * huythang38
 */

package extend_lib;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Button extends JPanel {

	public Button(String urlIcon, String nameButton) {
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setSize(100, 105);
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JLabel lblIcon = new JLabel(new javax.swing.ImageIcon(urlIcon));
		{
			lblIcon.setOpaque(false);
			GridBagConstraints gbc_lblIcon = new GridBagConstraints();
			gbc_lblIcon.anchor = GridBagConstraints.CENTER;
			gbc_lblIcon.gridx = 0;
			gbc_lblIcon.gridy = 0;
			add(lblIcon, gbc_lblIcon);
		}

		JLabel label = new JLabel(nameButton);
		{
			label.setFont(new Font("SansSerif", Font.BOLD, 12));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_edit = new GridBagConstraints();
			gbc_edit.fill = GridBagConstraints.BOTH;
			gbc_edit.gridx = 0;
			gbc_edit.gridy = 1;
			add(label, gbc_edit);
		}

		addMouseListener(new changeMouseAdapter(this));
		addMouseMotionListener(new changeMouseMotionAdapter(this));
	}

	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}

	class changeMouseAdapter extends MouseAdapter {
		public JPanel panel;

		public changeMouseAdapter(JPanel values) {
			panel = values;
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			panel.setBorder(null);
			panel.setBackground(new Color(0, 0, 0, 0));
			panel.repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBorder(new LineBorder(new Color(126, 180, 234), 1));
			panel.setBackground(new Color(228, 240, 252, 150));
			panel.repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBorder(new LineBorder(new Color(126, 180, 234), 1));
			panel.setBackground(new Color(206, 229, 252, 200));
			panel.repaint();
		}
	}

	class changeMouseMotionAdapter extends MouseMotionAdapter {
		public JPanel panel;

		public changeMouseMotionAdapter(JPanel values) {
			panel = values;
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			panel.setBorder(new LineBorder(new Color(126, 180, 234), 1));
			panel.setBackground(new Color(228, 240, 252, 150));
			panel.repaint();
		}
	}
}

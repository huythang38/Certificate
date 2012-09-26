/*
 * huythang38
 */

package extend_lib;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Button extends JPanel{
	
	public Button(String urlIcon, String nameButton) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setSize(100, 105);
		GridBagLayout gridBagLayout = new GridBagLayout();

		setLayout(gridBagLayout);

		JLabel lblIcon = new JLabel(new javax.swing.ImageIcon(urlIcon));
		{
			lblIcon.setOpaque(true);
			GridBagConstraints gbc_lblIcon = new GridBagConstraints();
			gbc_lblIcon.anchor = GridBagConstraints.CENTER;
			gbc_lblIcon.gridx = 0;
			gbc_lblIcon.gridy = 0;
			add(lblIcon, gbc_lblIcon);
		}

		JTextPane edit = new JTextPane();
		{
			edit.setFocusable(false);
			edit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			edit.addMouseListener(new changeMouseAdapter(this));
			edit.addMouseMotionListener(new changeMouseMotionAdapter(this));
			edit.setBackground(null);
			edit.setContentType("text/html");
			edit.setEditable(false);
			edit.setText("<html><body><div text-align: center; padding:0;>"
					+ nameButton);
			GridBagConstraints gbc_edit = new GridBagConstraints();
			gbc_edit.fill = GridBagConstraints.BOTH;
			gbc_edit.gridx = 0;
			gbc_edit.gridy = 1;
			add(edit, gbc_edit);
		}
		
		addMouseListener(new changeMouseAdapter(this));
		addMouseMotionListener(new changeMouseMotionAdapter(this));
	}

	class changeMouseAdapter extends MouseAdapter {
		public JPanel panel;

		public changeMouseAdapter(JPanel values) {
			panel = values;
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			panel.setBorder(null);
			panel.setBackground(null);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBorder(new LineBorder(new Color(126, 180, 234), 1));
			panel.setBackground(new Color(228, 240, 252));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBorder(new LineBorder(new Color(126, 180, 234), 1));
			panel.setBackground(new Color(206, 229, 252));
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
			panel.setBackground(new Color(228, 240, 252));
		}
	}
}

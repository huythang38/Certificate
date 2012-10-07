package client.gui.admin.nav_menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import client.gui.NavGUI_Admin;
import extend_lib.Button;

@SuppressWarnings("serial")
public class OtherTab extends JPanel {
	
	public OtherTab() {
		setLayout(new FlowLayout());

		Button btManageClass = new Button("lib/images/class.png",
				"Manage Class");
		btManageClass.setPreferredSize(new Dimension(100, 80));
		btManageClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("manageClass");
			}
		});
		add(btManageClass);


		Button btManageCourse = new Button("lib/images/course.png",
				"Manage Course");
		btManageCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("manageCourse");
			}
		});
		btManageCourse.setPreferredSize(new Dimension(110, 80));
		add(btManageCourse);

		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(1, 50));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				SystemColor.textHighlight, null));
		add(separator_1);

		Button btManageTuition = new Button("lib/images/tuition.png",
				"Manage Tuition");
		btManageTuition.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("manageTuition");
			}
		});
		btManageTuition.setPreferredSize(new Dimension(110, 80));
		add(btManageTuition);

		Button btManageCandidate = new Button("lib/images/student_48.png",
				"Manage Candidate");
		btManageCandidate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("manageCandidate");
			}
		});
		btManageCandidate.setPreferredSize(new Dimension(120, 80));
		add(btManageCandidate);

		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(1, 50));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				SystemColor.textHighlight, null));
		add(separator_2);

		Button btManageSubject = new Button("lib/images/subject.png",
				"Manage Subject");
		btManageSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("manageSubject");
			}
		});
		btManageSubject.setPreferredSize(new Dimension(120, 80));
		add(btManageSubject);
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/tabPanel.png").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}
}

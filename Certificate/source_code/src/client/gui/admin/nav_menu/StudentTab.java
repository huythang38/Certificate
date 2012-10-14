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
public class StudentTab extends JPanel {

	public StudentTab() {
		setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
		setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		Button btViewInfoStudent = new Button("lib/images/student_48.png",
				"View Infor Students");
		btViewInfoStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("viewInfoStudent");
			}
		});
		btViewInfoStudent.setPreferredSize(new Dimension(150, 80));
		add(btViewInfoStudent);

		Button btCreateStudent = new Button("lib/images/student_add.png",
				"Create Student");
		btCreateStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createStudent");
			}
		});
		btCreateStudent.setPreferredSize(new Dimension(120, 80));
		add(btCreateStudent);

		Button btUpdateStudent = new Button("lib/images/student_update.png",
				"Update Student");
		btUpdateStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("updateStudent");
			}
		});
		btUpdateStudent.setPreferredSize(new Dimension(125, 80));
		add(btUpdateStudent);

		Button btInputMarks = new Button("lib/images/input_mark.png",
				"Input Marks");
		btInputMarks.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("inputMark");
			}
		});
		btInputMarks.setPreferredSize(new Dimension(110, 80));
		add(btInputMarks);

		Button btEnterPayment = new Button("lib/images/enter_money.png",
				"Enter Payment");
		btEnterPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("enterPayment");
			}
		});
		btEnterPayment.setPreferredSize(new Dimension(120, 80));
		add(btEnterPayment);
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/tabPanel.png").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}
}

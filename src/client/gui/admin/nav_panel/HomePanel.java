package client.gui.admin.nav_panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import client.gui.NavGUI_Admin;

import extend_lib.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	
	public HomePanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setPreferredSize(new Dimension(763, 407));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblIconstudent = new JLabel("");
		lblIconstudent.setIcon(new ImageIcon("lib/images/student.png"));
		lblIconstudent.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblIconstudent.setBounds(23, 48, 120, 120);
		panel.add(lblIconstudent);
		
		JLabel iconAccount = new JLabel("");
		iconAccount.setIcon(new ImageIcon("lib/images/user_group.png"));
		iconAccount.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		iconAccount.setBounds(23, 229, 120, 120);
		panel.add(iconAccount);
		
		JLabel iconOther = new JLabel("");
		iconOther.setIcon(new ImageIcon("lib/images/glossy_3d_blue_hourglass.png"));
		iconOther.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		iconOther.setBounds(398, 229, 120, 120);
		panel.add(iconOther);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("lib/images/logo2.png"));
		lblLogo.setBounds(398, 30, 340, 130);
		panel.add(lblLogo);
		
		Button btnCreateStudent = new Button(null, "Create Student");
		btnCreateStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createStudent");
			}
		});
		btnCreateStudent.setBounds(153, 48, 129, 25);
		panel.add(btnCreateStudent);
		
		Button btnInputMark = new Button(null, "Input Marks");
		btnInputMark.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("inputMark");
			}
		});
		btnInputMark.setBounds(153, 79, 129, 25);
		panel.add(btnInputMark);
		
		Button btnEnterPayment = new Button(null, "Enter Payment");
		btnEnterPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("enterPayment");
			}
		});
		btnEnterPayment.setBounds(153, 112, 129, 25);
		panel.add(btnEnterPayment);
		
		Button btnInfoStudent = new Button(null, "Info Student");
		btnInfoStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("viewInfoStudent");
			}
		});
		btnInfoStudent.setBounds(153, 143, 129, 25);
		panel.add(btnInfoStudent);
		
		Button btnChangeStatus = new Button((String) null, "Change Status");
		btnChangeStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("changeStatus");
			}
		});
		btnChangeStatus.setBounds(153, 229, 129, 25);
		panel.add(btnChangeStatus);
		
		Button btnResetPass = new Button((String) null, "Reset Password");
		btnResetPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("resetPass");
			}
		});
		btnResetPass.setBounds(153, 260, 129, 25);
		panel.add(btnResetPass);
		
		Button btnManageCourse = new Button((String) null, "Manage Course");
		btnManageCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("manageCourse");
			}
		});
		btnManageCourse.setBounds(528, 229, 129, 25);
		panel.add(btnManageCourse);
		
		Button btnCreateClass = new Button((String) null, "Create Class");
		btnCreateClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createClass");
			}
		});
		btnCreateClass.setBounds(528, 260, 129, 25);
		panel.add(btnCreateClass);
		
		Button btnCreateSubject = new Button((String) null, "Create Subject");
		btnCreateSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createSubject");
			}
		});
		btnCreateSubject.setBounds(528, 293, 129, 25);
		panel.add(btnCreateSubject);
		
		Button btnCreateTuition = new Button((String) null, "Create Tuition");
		btnCreateTuition.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createTuition");
			}
		});
		btnCreateTuition.setBounds(528, 324, 129, 25);
		panel.add(btnCreateTuition);
		

	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/Background.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);		
	}
}

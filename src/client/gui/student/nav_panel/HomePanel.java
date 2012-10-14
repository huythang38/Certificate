package client.gui.student.nav_panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import client.gui.NavGUI_Student;

import extend_lib.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;


@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	public JLabel lblUsername;
	public JLabel lblName_1;
	public JLabel lblClass_1;
	public JLabel lblCourse_1;
	public HomePanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setPreferredSize(new Dimension(763, 407));
		add(panel);
		panel.setLayout(null);
		
		JLabel iconStudent = new JLabel("");
		iconStudent.setIcon(new ImageIcon("lib/images/student.png"));
		iconStudent.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		iconStudent.setBounds(23, 229, 120, 120);
		panel.add(iconStudent);
		
		JLabel iconFeature = new JLabel("");
		iconFeature.setIcon(new ImageIcon("lib/images/gear.png"));
		iconFeature.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		iconFeature.setBounds(398, 229, 120, 120);
		panel.add(iconFeature);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("lib/images/logo2.png"));
		lblLogo.setBounds(398, 30, 340, 130);
		panel.add(lblLogo);
		
		Button btnViewInfo = new Button(null, "View Info");
		btnViewInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Student.navPanel.showContent("viewInfo");
			}
		});
		btnViewInfo.setBounds(153, 229, 129, 25);
		panel.add(btnViewInfo);
		
		Button btnViewMark = new Button(null, "View Mark");
		btnViewMark.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Student.navPanel.showContent("resetPass");
			}
		});
		btnViewMark.setBounds(153, 260, 129, 25);
		panel.add(btnViewMark);
		
		Button btnChangePass = new Button((String) null, "Change Password");
		btnChangePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
//				NavGUI_Student.navPanel.showContent("manageCourse");
			}
		});
		btnChangePass.setBounds(528, 229, 129, 25);
		panel.add(btnChangePass);
		
		Button btnUpdateInfo = new Button((String) null, "Update Info");
		btnUpdateInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
//				NavGUI_Student.navPanel.showContent("manageClass");
			}
		});
		btnUpdateInfo.setBounds(528, 260, 129, 25);
		panel.add(btnUpdateInfo);
		
		
		JLabel lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
		lblWelcome.setBounds(23, 22, 103, 32);
		panel.add(lblWelcome);
		
		lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Serif", Font.ITALIC, 20));
		lblUsername.setBounds(140, 26, 235, 27);
		panel.add(lblUsername);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		lblName.setBounds(53, 65, 48, 22);
		panel.add(lblName);
		
		JLabel lblClass = new JLabel("Class: ");
		lblClass.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		lblClass.setBounds(53, 94, 45, 22);
		panel.add(lblClass);
		
		JLabel lblCourse = new JLabel("Course: ");
		lblCourse.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		lblCourse.setBounds(53, 124, 56, 22);
		panel.add(lblCourse);
		
		lblName_1 = new JLabel("name");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName_1.setBounds(140, 64, 235, 25);
		panel.add(lblName_1);
		
		lblClass_1 = new JLabel("class");
		lblClass_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClass_1.setBounds(140, 93, 235, 25);
		panel.add(lblClass_1);
		
		lblCourse_1 = new JLabel("course");
		lblCourse_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse_1.setBounds(140, 123, 235, 25);
		panel.add(lblCourse_1);
		
		setWelcome();
	}
	
	public void setWelcome(){
		lblUsername.setText(NavGUI_Student.username);
		lblName_1.setText("Le Huy Thang");
		lblClass_1.setText("Batch 1");
		lblCourse_1.setText("ACCP i10");
	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/Background.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);		
	}
}

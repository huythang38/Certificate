package client.gui.admin.nav_panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class About extends JPanel{
	public About(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(500, 420));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCertificareGenerationSystem = new JLabel("Certificate Generation System");
		lblCertificareGenerationSystem.setForeground(SystemColor.window);
		lblCertificareGenerationSystem.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 30));
		lblCertificareGenerationSystem.setVerifyInputWhenFocusTarget(false);
		lblCertificareGenerationSystem.setBounds(33, 11, 423, 47);
		panel.add(lblCertificareGenerationSystem);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("lib/images/Education-128.png"));
		lblNewLabel.setBounds(179, 56, 136, 118);
		panel.add(lblNewLabel);
		
		JLabel lblActhor = new JLabel("Deverloper:");
		lblActhor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActhor.setBounds(33, 221, 111, 14);
		panel.add(lblActhor);
		
		JLabel lblLeHuyThang = new JLabel("Le Huy Thang");
		lblLeHuyThang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeHuyThang.setBounds(70, 246, 103, 14);
		panel.add(lblLeHuyThang);
		
		JLabel lblPhanCongHuu = new JLabel("Phan Cong Huu");
		lblPhanCongHuu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhanCongHuu.setBounds(70, 271, 87, 14);
		panel.add(lblPhanCongHuu);
		
		JLabel lblCenter = new JLabel("Company:");
		lblCenter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCenter.setBounds(310, 221, 136, 14);
		panel.add(lblCenter);
		
		JLabel lblAptechdanang = new JLabel("International Programming Training Center");
		lblAptechdanang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAptechdanang.setBounds(223, 244, 245, 14);
		panel.add(lblAptechdanang);
		
		JLabel lblSoftechAptech = new JLabel("SOFTECH \u2013 APTECH DANANG");
		lblSoftechAptech.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSoftechAptech.setBounds(252, 271, 154, 14);
		panel.add(lblSoftechAptech);
		
		JLabel lblQuangTrung = new JLabel("14 Quang Trung - Da Nang - Viet Nam");
		lblQuangTrung.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuangTrung.setBounds(233, 296, 207, 14);
		panel.add(lblQuangTrung);
		
		JLabel lblV = new JLabel("v 1.0");
		lblV.setForeground(SystemColor.window);
		lblV.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblV.setBounds(223, 185, 46, 25);
		panel.add(lblV);
		
		JLabel lblTeachersInstructions = new JLabel("Teachers instructions:");
		lblTeachersInstructions.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTeachersInstructions.setBounds(33, 321, 125, 14);
		panel.add(lblTeachersInstructions);
		
		JLabel lblHoangNhacTrung = new JLabel("Hoang Nhac Trung");
		lblHoangNhacTrung.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHoangNhacTrung.setBounds(70, 346, 102, 14);
		panel.add(lblHoangNhacTrung);
		
		JLabel lblEprojectSem = new JLabel("eProject Sem 2 - ACCP i10");
		lblEprojectSem.setForeground(SystemColor.window);
		lblEprojectSem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEprojectSem.setBounds(164, 49, 172, 25);
		panel.add(lblEprojectSem);
		
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/backgroundHome.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);		
	}
}

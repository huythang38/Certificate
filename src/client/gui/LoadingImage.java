package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import client.config.ContainerCenterLocationUI;

import java.awt.Font;
import java.awt.Color;

public class LoadingImage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingImage frame = new LoadingImage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoadingImage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 220, 220);
		new ContainerCenterLocationUI(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImageconnect = new JLabel(new ImageIcon("lib/images/loading1.gif"));
		lblImageconnect.setBounds(62, 27, 90, 90);
		contentPane.add(lblImageconnect);
		
		JLabel lblConnecting = new JLabel("Connecting...");
		lblConnecting.setForeground(Color.WHITE);
		lblConnecting.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		lblConnecting.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnecting.setBounds(45, 135, 128, 29);
		contentPane.add(lblConnecting);
		
		setVisible(true);
	}
}

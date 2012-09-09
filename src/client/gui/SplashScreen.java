/*
 * huythang38
 */

package client.gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import client.config.ContainerCenterLocationUI;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
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
	public SplashScreen(){
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		new ContainerCenterLocationUI(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
	//connect to server icon	
		JLabel lblProgress = new JLabel(new ImageIcon("lib/images/loading.gif"));
		lblProgress.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgress.setBounds(0, 280, 220, 15);
		contentPane.add(lblProgress);
		
	//background	
		JLabel lblBackground = new JLabel(new ImageIcon("lib/images/splashscreen.jpg"));
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setBounds(0, 0, 450, 300);
		contentPane.add(lblBackground);		
		
//		setVisible(true);
	}
}

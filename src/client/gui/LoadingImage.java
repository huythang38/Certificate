package client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import extend_lib.ContainerCenterLocationUI;

@SuppressWarnings("serial")
public class LoadingImage extends JDialog {

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
		setForeground(Color.BLACK);
		setTitle("Loading...");
		setBounds(0, 0, 220, 220);
		new ContainerCenterLocationUI(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImageconnect = new JLabel(new ImageIcon("lib/images/loading1.gif"));
		lblImageconnect.setBounds(62, 27, 90, 90);
		contentPane.add(lblImageconnect);
		
		JLabel lblConnecting = new JLabel(new ImageIcon("lib/images/loading2.gif"));
		lblConnecting.setForeground(Color.BLACK);
		lblConnecting.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		lblConnecting.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnecting.setBounds(45, 135, 128, 29);
		contentPane.add(lblConnecting);
		setVisible(true);
		setResizable(false);
	}
}

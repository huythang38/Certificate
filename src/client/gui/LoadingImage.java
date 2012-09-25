/*
 * huythang38
 */

package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import extend_lib.ContainerCenterLocationUI;

@SuppressWarnings("serial")
public class LoadingImage extends JDialog implements Runnable{
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public LoadingImage() {
		setResizable(false);	
	}
	
	public void disposeDialog(){	
		dispose();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setBackground(SystemColor.activeCaptionText);
		setAlwaysOnTop(true);
		
		// TODO Auto-generated method stub
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setForeground(Color.BLACK);
		setTitle("Loading...");
		setBounds(0, 0, 220, 220);
		 new ContainerCenterLocationUI(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblImageconnect = new JLabel(new ImageIcon(
				"lib/images/loading1.gif"));
		lblImageconnect.setBounds(62, 27, 90, 90);
		contentPane.add(lblImageconnect);

		JLabel lblConnecting = new JLabel(new ImageIcon(
				"lib/images/loading2.gif"));
		lblConnecting.setForeground(Color.BLACK);
		lblConnecting.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		lblConnecting.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnecting.setBounds(45, 135, 128, 29);
		contentPane.add(lblConnecting);
		
		setModal(true);
		setVisible(true);
		setResizable(false);
	}
}

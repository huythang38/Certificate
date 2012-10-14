/*
 * huythang38
 */

package client.gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import extend_lib.ContainerCenterLocationUI;

@SuppressWarnings("serial")
public class LoadingImage extends JDialog implements Runnable {
	/**
	 * @uml.property  name="contentPane"
	 * @uml.associationEnd  
	 */
	private JPanel contentPane;
	/**
	 * @uml.property  name="img"
	 */
	public String img;

	/**
	 * Create the frame.
	 */
	public LoadingImage(String urlImage) {
		img = urlImage;
	}

	public void disposeDialog() {
		dispose();
	}

	@Override
	public void run() {
		setUndecorated(true);
		setBackground(new Color(255, 255, 255, 100));
		setAlwaysOnTop(true);

		// TODO Auto-generated method stub

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setForeground(Color.BLACK);
		setTitle("Loading...");
		setBounds(0, 0, 200, 200);
		new ContainerCenterLocationUI(this);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Image image = new ImageIcon(img).getImage();
		int loctionX = (getWidth() - image.getWidth(null)) / 2;
		int loctionY = (getHeight() - image.getHeight(null)) / 2;

		JLabel lblImageconnect = new JLabel(new ImageIcon(img));
		lblImageconnect.setBounds(loctionX, loctionY, image.getWidth(null), image.getHeight(null));
		contentPane.add(lblImageconnect);

		setModal(true);
		setVisible(true);
		setResizable(false);

	}
}

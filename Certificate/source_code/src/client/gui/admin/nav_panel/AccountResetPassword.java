package client.gui.admin.nav_panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import client.event.admin.ResetPassEvent;
import client.event.admin.searchPanel.SearchPanelAccountResetPasswordEvent;
import client.gui.ExecuteLoading;
import client.gui.admin.nav_panel.searchPanel.SearchPanel;

@SuppressWarnings("serial")
public class AccountResetPassword extends JPanel {
	/**
	 * @uml.property  name="contentPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JPanel contentPanel;
	public static ExecuteLoading lblWaitting;
	public static JLabel lblAccountid;
	public static int idAccount;
	
	/**
	 * @uml.property  name="event"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ResetPassEvent event = new ResetPassEvent();
	
	/**
	 * Create the panel.
	 */
	public AccountResetPassword() {
		setLayout(new BorderLayout(0, 0));
		SearchPanelAccountResetPasswordEvent searchPanelEvent = new SearchPanelAccountResetPasswordEvent();
		SearchPanel searchPanel = new SearchPanel(searchPanelEvent);
		add(searchPanel, BorderLayout.NORTH);
		
		contentPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPanel.getLayout();
		flowLayout.setVgap(60);
		contentPanel.setOpaque(false);
		add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.textHighlight, null));
		panel.setPreferredSize(new Dimension(350, 230));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblResetPasswordFor = new JLabel("Reset Password for Account:");
		lblResetPasswordFor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResetPasswordFor.setBounds(35, 29, 263, 46);
		panel.add(lblResetPasswordFor);
		
		lblAccountid = new JLabel("Username!");
		lblAccountid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountid.setBounds(86, 97, 168, 20);
		panel.add(lblAccountid);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				event.resetPass(idAccount);
			}
		});
		btnOk.setBounds(99, 156, 149, 46);
		panel.add(btnOk);
		
		
		lblWaitting = new ExecuteLoading();
		lblWaitting.setBounds(10, 150, 89, 54);
		panel.add(lblWaitting);

	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/Background.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);		
	}
}

package client.gui;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import client.Client;
import client.gui.admin.MenuPane;
import client.gui.admin.NavContentPanel;
import extend_lib.ContainerCenterLocationUI;
import extend_lib.LogoContainer;

@SuppressWarnings("serial")
public class NavGUI_Admin extends JFrame {
	public static NavContentPanel navPanel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Client().connectServer("localhost", 7777);
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NavGUI_Admin frame = new NavGUI_Admin();
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
	public NavGUI_Admin() {
		setTitle("Certificate Generation System - Admin");
		new LogoContainer(this);
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		new ContainerCenterLocationUI(this);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		{
			gbl_contentPane.columnWidths = new int[] { 0, 0 };
			gbl_contentPane.rowHeights = new int[] { 130, 0 };
			gbl_contentPane.columnWeights = new double[] { 1, Double.MIN_VALUE };
			gbl_contentPane.rowWeights = new double[] { 0.0, 1.0 };
			contentPane.setLayout(gbl_contentPane);
		}

		//add Nav Menu
		MenuPane tabbedPane_NavMenu = new MenuPane();
		{
			tabbedPane_NavMenu
					.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			GridBagConstraints gbc_tabbedPane_NavMenu = new GridBagConstraints();
			gbc_tabbedPane_NavMenu.fill = GridBagConstraints.BOTH;
			gbc_tabbedPane_NavMenu.insets = new Insets(5, 2, 5, 2);
			gbc_tabbedPane_NavMenu.gridx = 0;
			gbc_tabbedPane_NavMenu.gridy = 0;
			contentPane.add(tabbedPane_NavMenu, gbc_tabbedPane_NavMenu);	
		}
		
		//add Nav Panel Content
		navPanel = new NavContentPanel();
		{		
			navPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null));
			GridBagConstraints gbc_navPanel = new GridBagConstraints();
			gbc_navPanel.insets = new Insets(2, 2, 5, 2);
			gbc_navPanel.fill = GridBagConstraints.BOTH;
			gbc_navPanel.gridx = 0;
			gbc_navPanel.gridy = 1;
			contentPane.add(navPanel, gbc_navPanel);
		}
	}//end NavGUI_Admin method
	
}//end NavGUI_Admin method

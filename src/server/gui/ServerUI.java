/*
 * huythang38
 */

package server.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import server.Server;
import server.config.Config;
import server.event.UIEvent;
import extend_lib.ContainerCenterLocationUI;
import extend_lib.LogoContainer;

@SuppressWarnings("serial")
public class ServerUI extends JFrame {
	public JTextField txtUser;
	public JPasswordField pwdPass;
	public JFormattedTextField frmtdtxtfldPort;
	public JButton btnUpdateConfig;
	public JButton btnConfig;
	public JButton btnStart;
	public JButton btnClose;
	public JMenuItem mntmMailServer;

	public UIEvent events;
	public Config config;
	public Server server;
	public static ServerUI frame;

	/**
	 * Launch the application.
	 * 
	 * @throws ParseException
	 * @throws UnsupportedLookAndFeelException
	 */
	public static void main(String[] args) {
		// LookAndFeel
		try {
			javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager
					.getInstalledLookAndFeels();
			for (int idx = 0; idx < installedLookAndFeels.length; idx++) {
				if ("Windows".equals(installedLookAndFeels[idx].getName())) {
					javax.swing.UIManager
							.setLookAndFeel(installedLookAndFeels[idx]
									.getClassName());
					break;
				} else if ("GTK+".equals(installedLookAndFeels[idx].getName())) {
					javax.swing.UIManager
							.setLookAndFeel(installedLookAndFeels[idx]
									.getClassName());
					break;
				} else {
					javax.swing.UIManager
							.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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
					frame = new ServerUI();
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
	public ServerUI() {
		events = new UIEvent();
		config = new Config();
		server = new Server();
		String user = config.getUser();
		String pass = config.getPass();
		int port = config.getPort();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				events.windowClosing();
			}
		});
		setTitle("Server");
		new LogoContainer(this);
//		setBounds(0, 0, 355, 500);
		setSize(355, 460);
		setResizable(false);
		new ContainerCenterLocationUI(this);
		getContentPane().setLayout(new BorderLayout(0, 0));

		//
		JLabel lblImage = new JLabel(new ImageIcon("lib/images/logo.png"));
		lblImage.setPreferredSize(new Dimension(0, 100));
		lblImage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		getContentPane().add(lblImage, BorderLayout.NORTH);

		// draw panel control server
		JPanel panelControl = new JPanel();
		panelControl.setPreferredSize(new Dimension(0, 80));
		panelControl.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelControl.setBorder(new TitledBorder(null, "Server",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelControl, BorderLayout.SOUTH);
		panelControl.setLayout(null);

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = false;
				check = server.startServer();
				if (check) {
					btnStart.setEnabled(false);
					btnClose.setEnabled(true);
				}
			}
		});
		btnStart.setBounds(20, 29, 130, 27);
		panelControl.add(btnStart);

		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					server.closeServer();
					btnStart.setEnabled(true);
					btnClose.setEnabled(false);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnClose.setEnabled(false);
		btnClose.setBounds(200, 29, 130, 27);
		panelControl.add(btnClose);
		// end draw panel control server
		
		// draw panel config server
		JPanel panelConfig = new JPanel();
		getContentPane().add(panelConfig, BorderLayout.CENTER);
		panelConfig.setPreferredSize(new Dimension(0, 100));
		panelConfig.setLayout(null);

		txtUser = new JTextField(user);
		txtUser.setBounds(140, 35, 160, 30);
		panelConfig.add(txtUser);
		txtUser.setEnabled(false);
		txtUser.setColumns(10);

		pwdPass = new JPasswordField(pass);
		pwdPass.setBounds(140, 80, 160, 30);
		panelConfig.add(pwdPass);
		pwdPass.setEnabled(false);

		frmtdtxtfldPort = new JFormattedTextField(port);
		frmtdtxtfldPort.setBounds(140, 125, 50, 30);
		panelConfig.add(frmtdtxtfldPort);
		frmtdtxtfldPort.setFormatterFactory(new DefaultFormatterFactory(
				new NumberFormatter(new DecimalFormat("#0"))));
		frmtdtxtfldPort.setEnabled(false);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(50, 35, 90, 30);
		panelConfig.add(lblUser);

		JLabel lblPass = new JLabel("Pass");
		lblPass.setBounds(50, 80, 90, 30);
		panelConfig.add(lblPass);

		JLabel lblPort = new JLabel("Port Server");
		lblPort.setBounds(50, 125, 90, 30);
		panelConfig.add(lblPort);

		btnConfig = new JButton("Config");
		btnConfig.setBounds(60, 180, 110, 30);
		panelConfig.add(btnConfig);

		btnUpdateConfig = new JButton("Update Config");
		btnUpdateConfig.setBounds(190, 180, 110, 30);
		panelConfig.add(btnUpdateConfig);
		btnUpdateConfig.setEnabled(false);
		btnUpdateConfig.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(frmtdtxtfldPort.getText());
				boolean check = events.btnUpdateConfigAction(txtUser.getText(),
						pwdPass.getText(), port);
				if (check) {
					config.updateConfigDATA(txtUser.getText(),
							pwdPass.getText(), port);
					try {

						Runtime.getRuntime().exec("java server.gui.ServerUI");

						System.exit(0);

					} catch (IOException ex) {

					}
					// System.exit(0);
				}
			}
		});
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setEnabled(true);
				pwdPass.setEnabled(true);
				frmtdtxtfldPort.setEnabled(true);
				btnUpdateConfig.setEnabled(true);
				btnConfig.setEnabled(false);
			}
		});

		// end draw panel config server

		// draw Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				events.mntmExitAction();
			}
		});

		JMenuItem mntmShowIpServer = new JMenuItem("show IP server");
		mntmShowIpServer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InetAddress dc;
				try {
					dc = InetAddress.getLocalHost();
					String hostAddress = dc.getHostAddress();
					int port = new Config().getPort();
					JOptionPane.showMessageDialog(new JFrame(), "IP:\n"
							+ hostAddress + ":" + port);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println();

			}
		});
		mnFile.add(mntmShowIpServer);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		mnFile.add(mntmExit);

		JMenu mnSetting = new JMenu("Settings");
		menuBar.add(mnSetting);

		mntmMailServer = new JMenuItem("Mail Server...");
		mntmMailServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConfigMailServer();
			}
		});
		mnSetting.add(mntmMailServer);
		// end draw menu
	}

	public static void showFrame() {
		frame.setVisible(true);
	}
}

package server.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import server.config.Config;
import server.config.ContainerCenterLocationUI;

@SuppressWarnings("serial")
public class ServerUI extends JFrame {
	private JTextField txtUser;
	private JPasswordField pwdPass;
	private JFormattedTextField frmtdtxtfldPort;
	private JButton btnUpdateConfig;
	private JButton btnConfig;
	private JButton btnStart;
	private JButton btnClose;

	public UIEvent events;
	//
	public Config config;
	public Server server;
	public static ServerUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// LookAndFeel
		try {
			for (UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		} catch (UnsupportedLookAndFeelException ex) {
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

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				events.windowClosing();
			}
		});
		setTitle("Server");
		setBounds(100, 100, 350, 500);
		setResizable(false);
		new ContainerCenterLocationUI(this);
		getContentPane().setLayout(null);

		//
		JLabel lblImage = new JLabel("image");
		lblImage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(6, 6, 334, 116);
		getContentPane().add(lblImage);

		txtUser = new JTextField(config.getUser());
		txtUser.setEnabled(false);
		txtUser.setBounds(140, 166, 164, 27);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);

		pwdPass = new JPasswordField(config.getPass());
		pwdPass.setEnabled(false);
		pwdPass.setBounds(140, 205, 164, 27);
		getContentPane().add(pwdPass);

		frmtdtxtfldPort = new JFormattedTextField(config.getPort());
		frmtdtxtfldPort.setFormatterFactory(new DefaultFormatterFactory(
				new NumberFormatter(new DecimalFormat("#0"))));
		frmtdtxtfldPort.setEnabled(false);
		frmtdtxtfldPort.setBounds(140, 244, 60, 27);
		getContentPane().add(frmtdtxtfldPort);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(47, 172, 60, 15);
		getContentPane().add(lblUser);

		JLabel lblPass = new JLabel("Pass");
		lblPass.setBounds(47, 211, 60, 15);
		getContentPane().add(lblPass);

		JLabel lblPort = new JLabel("Port Server");
		lblPort.setBounds(47, 250, 81, 15);
		getContentPane().add(lblPort);

		btnConfig = new JButton("Config");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setEnabled(true);
				pwdPass.setEnabled(true);
				frmtdtxtfldPort.setEnabled(true);
				btnUpdateConfig.setEnabled(true);
				btnConfig.setEnabled(false);
			}
		});
		btnConfig.setBounds(47, 297, 100, 27);
		getContentPane().add(btnConfig);

		btnUpdateConfig = new JButton("Update Config");
		btnUpdateConfig.setEnabled(false);
		btnUpdateConfig.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(frmtdtxtfldPort.getText());
				boolean check = events.btnUpdateConfigAction(txtUser.getText(),
						pwdPass.getText(), port);
				if (check) {
					config.updateConfigFile(txtUser.getText(),
							pwdPass.getText(), port);

				}
			}
		});
		btnUpdateConfig.setBounds(186, 297, 118, 27);
		getContentPane().add(btnUpdateConfig);

		// draw panel control server
		JPanel panelControl = new JPanel();
		panelControl.setBorder(new TitledBorder(null, "Server",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelControl.setBounds(10, 345, 330, 83);
		getContentPane().add(panelControl);
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
		btnStart.setBounds(19, 29, 130, 27);
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
		btnClose.setBounds(182, 29, 130, 27);
		panelControl.add(btnClose);

		// end draw panel control server

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
		// end draw menu
	}

	public static void showFrame() {
		frame.setVisible(true);
	}
}

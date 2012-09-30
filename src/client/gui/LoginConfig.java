/*
 * huythang38
 */

package client.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import client.RUN;
import client.config.Config;
import client.event.LoginConfigEvent;
import extend_lib.ContainerCenterLocationUI;
import extend_lib.LogoContainer;
import java.awt.BorderLayout;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class LoginConfig extends JFrame {

	public JPanel contentPane;
	public JPanel panel;
	public JPanel panelLogin;
	public JPanel panelConfig;

	public CardLayout cl;
	public JTextField txtUsername;
	public JPasswordField pwdPassword;
	public JTextField txtPath;
	public JFormattedTextField frmtdtxtfldPort;

	public JButton btnLogin;
	public JButton btnConfigConnect;
	public JButton btnBackToLogin;
	public JButton btnConfig;

	JLabel lblForgotPass;

	public LoginConfigEvent events;
	public Config config;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Look and Feel
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
					LoginConfig frame = new LoginConfig();
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
	public LoginConfig() {
		setTitle("Login");
		new LogoContainer(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(357, 410);
		new ContainerCenterLocationUI(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		events = new LoginConfigEvent();
		config = new Config();
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblImage = new JLabel("image");
		lblImage.setPreferredSize(new Dimension(0, 105));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(lblImage, BorderLayout.NORTH);

		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 260));
		panel.setBounds(13, 109, 324, 260);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new CardLayout(0, 0));

		panelLogin = new JPanel();
		panelLogin.setPreferredSize(new Dimension(0, 100));
		panel.add(panelLogin, "login");
		panelLogin.setBorder(new TitledBorder(new TitledBorder(null, "Login",
				TitledBorder.LEADING, TitledBorder.TOP, null, null), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelLogin.setLayout(null);

		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(44, 48, 101, 25);
		panelLogin.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(44, 120, 101, 25);
		panelLogin.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(138, 46, 170, 30);
		txtUsername.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					boolean check = events.checkLogin(txtUsername.getText(),
							pwdPassword.getText());
					if (check) {
						// delete form LoginConfig
						removeNotify();
					}
				}
			}
		});
		panelLogin.add(txtUsername);

		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(138, 118, 170, 30);
		pwdPassword.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					boolean check = events.checkLogin(txtUsername.getText(),
							pwdPassword.getText());
					if (check) {
						// delete form LoginConfig
						removeNotify();
					}
				}
			}
		});
		panelLogin.add(pwdPassword);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				boolean check = events.checkLogin(txtUsername.getText(),
						pwdPassword.getText());
				if (check) {
					// delete form LoginConfig
					removeNotify();
				}
			}
		});
		btnLogin.setBounds(26, 209, 142, 35);
		panelLogin.add(btnLogin);

		cl = (CardLayout) (panel.getLayout());

		btnConfigConnect = new JButton("Config Connect!");
		btnConfigConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackToLogin.setEnabled(true);
				setTitle("Config Conect");
				cl.show(panel, "config");

			}
		});
		btnConfigConnect.setBounds(180, 209, 142, 35);
		panelLogin.add(btnConfigConnect);

		lblForgotPass = new JLabel("Forgot password?");
		lblForgotPass.setFont(new Font("Dialog", Font.BOLD, 12));
		lblForgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblForgotPass.setFont(new Font("Dialog", Font.BOLD, 12));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new ForgotPassDialog();
			}
		});
		lblForgotPass.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblForgotPass.setFont(new Font("Dialog", Font.ITALIC, 12));
			}
		});

		lblForgotPass.setBounds(138, 160, 147, 15);
		panelLogin.add(lblForgotPass);

		panelConfig = new JPanel();
		panel.add(panelConfig, "config");
		panelConfig.setLayout(null);
		panelConfig.setBorder(new TitledBorder(new TitledBorder(null, "Login",
				TitledBorder.LEADING, TitledBorder.TOP, null, null),
				"Config Connect", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));

		JLabel lblURL = new JLabel("Path");
		lblURL.setBounds(44, 49, 101, 25);
		panelConfig.add(lblURL);

		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(44, 121, 101, 25);
		panelConfig.add(lblPort);

		txtPath = new JTextField(config.getPath());
		txtPath.setColumns(10);
		txtPath.setBounds(138, 47, 170, 30);
		panelConfig.add(txtPath);

		frmtdtxtfldPort = new JFormattedTextField(config.getPort());
		frmtdtxtfldPort.setFormatterFactory(new DefaultFormatterFactory(
				new NumberFormatter(new DecimalFormat("#0"))));
		frmtdtxtfldPort.setBounds(138, 119, 70, 30);
		panelConfig.add(frmtdtxtfldPort);

		btnBackToLogin = new JButton("Back to Login");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Login");
				cl.show(panel, "login");
			}
		});
		btnBackToLogin.setBounds(26, 210, 142, 35);
		panelConfig.add(btnBackToLogin);

		btnConfig = new JButton("Config");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(frmtdtxtfldPort.getText());
				boolean check = events.configAction(txtPath.getText(), port);
				// back to Login panel
				if (check) {
					// remove LoginConfig Frame
					// removeNotify();
					// disconnect anh test new connect
					RUN.disconnect();
					RUN runPro = new RUN(true);
					runPro.showLoadConnect();
					runPro.Connect();
				}
			}
		});
		btnConfig.setBounds(180, 210, 142, 35);
		panelConfig.add(btnConfig);

	}
}

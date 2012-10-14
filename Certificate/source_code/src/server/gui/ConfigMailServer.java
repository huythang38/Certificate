/*
 * huythang38
 */
package server.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import server.config.Config;
import server.event.ForgotPassUIEvent;

import extend_lib.ContainerCenterLocationUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ConfigMailServer extends JDialog {

	/**
	 * @uml.property  name="contentPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public final JPanel contentPanel = new JPanel();
	/**
	 * @uml.property  name="txtSmtp"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JTextField txtSmtp;
	/**
	 * @uml.property  name="txtUsername"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JTextField txtUsername;
	/**
	 * @uml.property  name="pwdPassword"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JPasswordField pwdPassword;
	/**
	 * @uml.property  name="frmtdtxtfldPort"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JFormattedTextField frmtdtxtfldPort;
	/**
	 * @uml.property  name="event"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ForgotPassUIEvent event;
	
	/**
	 * @uml.property  name="config"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public Config config = new Config();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigMailServer dialog = new ConfigMailServer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigMailServer() {
		event = new ForgotPassUIEvent();
		
		setResizable(false);
		setTitle("Configure Mail Server");
		setBounds(100, 100, 390, 277);
		new ContainerCenterLocationUI(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblSmtp = new JLabel("SMTP:");
		lblSmtp.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSmtp.setBounds(23, 24, 97, 17);
		contentPanel.add(lblSmtp);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPort.setBounds(23, 78, 97, 17);
		contentPanel.add(lblPort);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsername.setBounds(23, 117, 97, 17);
		contentPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setBounds(23, 171, 97, 17);
		contentPanel.add(lblPassword);
		
		txtSmtp = new JTextField();
		txtSmtp.setText(config.getSmtp());
		txtSmtp.setBounds(165, 22, 197, 25);
		contentPanel.add(txtSmtp);
		txtSmtp.setColumns(10);
		
		frmtdtxtfldPort = new JFormattedTextField(config.getPort_smtp());
		frmtdtxtfldPort.setHorizontalAlignment(SwingConstants.RIGHT);
		frmtdtxtfldPort.setFormatterFactory(new DefaultFormatterFactory(
				new NumberFormatter(new DecimalFormat("#0"))));
		frmtdtxtfldPort.setBounds(165, 73, 72, 25);
		contentPanel.add(frmtdtxtfldPort);
		
		txtUsername = new JTextField();
		txtUsername.setText(config.getUser_smtp());
		txtUsername.setBounds(165, 112, 197, 25);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText(config.getPass_smtp());
		pwdPassword.setBounds(165, 168, 197, 25);
		contentPanel.add(pwdPassword);
		
		JLabel lblNewLabel = new JLabel("Ex: smtp.gmail.com");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(165, 47, 197, 17);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ex: abc@gmail.com");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(165, 140, 197, 17);
		contentPanel.add(lblNewLabel_1);
		
		{
			JPanel buttonPane = new JPanel();
			FlowLayout flowLayout = (FlowLayout) buttonPane.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			
			JButton btnApply = new JButton("Apply");
			btnApply.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					event.updateForm(
							txtSmtp.getText(), Integer.parseInt(frmtdtxtfldPort.getText().toString()),
							txtUsername.getText(), pwdPassword.getText());
					
					if (event.isUpdateForm()){
						dispose();
					}
				}
			});
			buttonPane.add(btnApply);
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		setModal(true);
		setVisible(true);
	}
}

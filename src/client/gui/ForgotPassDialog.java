/*
 * huythang38
 */

package client.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client.action.ForgotPass;
import client.event.FogotPassEvent;

import extend_lib.ContainerCenterLocationUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class ForgotPassDialog extends JDialog {
	JTextField txtEmail;
	FogotPassEvent event;
	public Timer timer;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ForgotPassDialog dialog = new ForgotPassDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ForgotPassDialog() {
		setResizable(false);
		{
			event = new FogotPassEvent();

		}

		{
			setTitle("Forgot Password!");
			setBounds(100, 100, 350, 179);
			new ContainerCenterLocationUI(this);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			setModal(true);
		}

		JLabel lblNewLabel = new JLabel("Please input your email.");
		{
			lblNewLabel
					.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			lblNewLabel.setBounds(12, 23, 291, 15);
			contentPanel.add(lblNewLabel);
		}

		txtEmail = new JTextField();
		{
			txtEmail.setBounds(32, 50, 271, 21);
			contentPanel.add(txtEmail);
		}

		JLabel lblNewLabel_1 = new JLabel("Ex: example@gmail.com");
		lblNewLabel_1.setBounds(42, 84, 237, 17);
		contentPanel.add(lblNewLabel_1);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						event.generateEmail(txtEmail.getText().trim());
						
						timer = new Timer();
						timer.schedule(new RemindTask(), 1000);
						
					}
				});
			
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

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

		setVisible(true);
	}
	
	
	class RemindTask extends TimerTask {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (ForgotPass.complete) {
				dispose();
				ForgotPass.complete = false;
			} else {
				timer.schedule(new RemindTask(), 500);
			}
		}
	}
}

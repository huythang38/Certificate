package client.gui.admin.nav_panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import client.event.admin.ChangeStatusEvent;
import client.gui.ExecuteLoading;
import client.gui.admin.nav_panel.searchPanel.SearchPanelAccountChangeStatus;

@SuppressWarnings("serial")
public class AccountChangeStatusPanel extends JPanel {
	public static JTable tableShow;
	public static JComboBox<String> cbbxChoiceStatus;
	public static JLabel lblAccountid;
	public static int idAccount;
	public static JButton btnOk;
	public static JButton btnCancel;
	public static ExecuteLoading lblWaitting;
	public static Thread threadExecuteLoading;
	public static JPanel contentPanel;
	public static JPanel panelChangeStatus;
	
	public ChangeStatusEvent event = new ChangeStatusEvent();

	/**
	 * Create the panel.
	 */
	public AccountChangeStatusPanel() {
		setLayout(new BorderLayout(0, 0));
		
		SearchPanelAccountChangeStatus searchPanel = new SearchPanelAccountChangeStatus();
		add(searchPanel, BorderLayout.NORTH);
		
		contentPanel = new JPanel();
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(SystemColor.scrollbar);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 60));
		
		panelChangeStatus = new JPanel();
		panelChangeStatus.setPreferredSize(new Dimension(350, 230));
		panelChangeStatus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 153, 255), SystemColor.textInactiveText));
		contentPanel.add(panelChangeStatus);
		panelChangeStatus.setLayout(null);
		
		cbbxChoiceStatus = new JComboBox<String>();
		cbbxChoiceStatus.setEnabled(false);
		cbbxChoiceStatus.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cbbxChoiceStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"disable", "enable"}));
		cbbxChoiceStatus.setBounds(58, 105, 229, 20);
		panelChangeStatus.add(cbbxChoiceStatus);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				event.changeStatus(idAccount, cbbxChoiceStatus.getSelectedIndex());
			}
		});
		btnOk.setEnabled(false);
		btnOk.setBounds(127, 165, 89, 39);
		panelChangeStatus.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancel.setEnabled(false);
				btnOk.setEnabled(false);
				cbbxChoiceStatus.setEnabled(false);
			}
		});
		btnCancel.setEnabled(false);
		btnCancel.setBounds(226, 165, 89, 39);
		panelChangeStatus.add(btnCancel);
		
		JLabel lblChangeAccountStatus = new JLabel("Change Account Status of Student:");
		lblChangeAccountStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblChangeAccountStatus.setBounds(24, 30, 302, 31);
		panelChangeStatus.add(lblChangeAccountStatus);
		
		lblAccountid = new JLabel("");
		lblAccountid.setBounds(48, 72, 190, 14);
		panelChangeStatus.add(lblAccountid);
		
		
		lblWaitting = new ExecuteLoading();
		lblWaitting.setBounds(10, 165, 89, 54);
		panelChangeStatus.add(lblWaitting);
		
	}
}

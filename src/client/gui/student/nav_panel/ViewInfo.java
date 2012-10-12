package client.gui.student.nav_panel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import client.event.admin.ChangeStatusEvent;
import client.gui.ExecuteLoading;

@SuppressWarnings("serial")
public class ViewInfo extends JPanel {
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
	public ViewInfo() {
//		setLayout(new BorderLayout(0, 0));
//		SearchPanelAccountStatusEvent searchPanelEvent = new SearchPanelAccountStatusEvent();
//		SearchPanel searchPanel = new SearchPanel(searchPanelEvent);
//		add(searchPanel, BorderLayout.NORTH);
//		
//		contentPanel = new JPanel();
//		contentPanel.setOpaque(false);
//		add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setBackground(SystemColor.scrollbar);
//		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 60));
//		
//		panelChangeStatus = new JPanel();
//		panelChangeStatus.setPreferredSize(new Dimension(350, 230));
//		panelChangeStatus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 153, 255), SystemColor.textInactiveText));
//		contentPanel.add(panelChangeStatus);
//		panelChangeStatus.setLayout(null);
//		
//		cbbxChoiceStatus = new JComboBox<String>();
//		cbbxChoiceStatus.setEnabled(false);
//		cbbxChoiceStatus.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//		cbbxChoiceStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"disable", "enable"}));
//		cbbxChoiceStatus.setBounds(58, 105, 229, 20);
//		panelChangeStatus.add(cbbxChoiceStatus);
//		
//		btnOk = new JButton("Ok");
//		btnOk.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				event.changeStatus(idAccount, cbbxChoiceStatus.getSelectedIndex());
//			}
//		});
//		btnOk.setEnabled(false);
//		btnOk.setBounds(127, 165, 89, 39);
//		panelChangeStatus.add(btnOk);
//		
//		btnCancel = new JButton("Cancel");
//		btnCancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				btnCancel.setEnabled(false);
//				btnOk.setEnabled(false);
//				cbbxChoiceStatus.setEnabled(false);
//			}
//		});
//		btnCancel.setEnabled(false);
//		btnCancel.setBounds(226, 165, 89, 39);
//		panelChangeStatus.add(btnCancel);
//		
//		JLabel lblChangeAccountStatus = new JLabel("Change Account Status of Account:");
//		lblChangeAccountStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
//		lblChangeAccountStatus.setBounds(24, 30, 302, 31);
//		panelChangeStatus.add(lblChangeAccountStatus);
//		
//		lblAccountid = new JLabel("");
//		lblAccountid.setBounds(48, 72, 190, 14);
//		panelChangeStatus.add(lblAccountid);
//		
//		
//		lblWaitting = new ExecuteLoading();
//		lblWaitting.setBounds(10, 165, 89, 54);
//		panelChangeStatus.add(lblWaitting);
		
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/Background.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);		
	}
}

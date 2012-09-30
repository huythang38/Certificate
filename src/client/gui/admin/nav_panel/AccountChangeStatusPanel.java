package client.gui.admin.nav_panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import client.gui.admin.nav_panel.searchPanel.SearchPanelAccountChangeStatus;

import java.awt.ComponentOrientation;

@SuppressWarnings("serial")
public class AccountChangeStatusPanel extends JPanel {
	private JTable tableShow;
	public static JLabel lblAccountid;

	/**
	 * Create the panel.
	 */
	public AccountChangeStatusPanel() {
		setLayout(new BorderLayout(0, 0));
		
		SearchPanelAccountChangeStatus searchPanel = new SearchPanelAccountChangeStatus();
		add(searchPanel, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		splitPane.setLeftComponent(contentPanel);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		
		JPanel panelChangeStatus = new JPanel();
		panelChangeStatus.setPreferredSize(new Dimension(350, 215));
		panelChangeStatus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.add(panelChangeStatus);
		panelChangeStatus.setLayout(null);
		
		JComboBox cbbxChoiceStatus = new JComboBox();
		cbbxChoiceStatus.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cbbxChoiceStatus.setModel(new DefaultComboBoxModel(new String[] {"enable", "disable"}));
		cbbxChoiceStatus.setBounds(58, 105, 229, 20);
		panelChangeStatus.add(cbbxChoiceStatus);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(127, 165, 89, 39);
		panelChangeStatus.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(226, 165, 89, 39);
		panelChangeStatus.add(btnCancel);
		
		JLabel lblChangeAccountStatus = new JLabel("Change Account Status of Student:");
		lblChangeAccountStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblChangeAccountStatus.setBounds(24, 30, 302, 31);
		panelChangeStatus.add(lblChangeAccountStatus);
		
		lblAccountid = new JLabel("");
		lblAccountid.setBounds(48, 72, 190, 14);
		panelChangeStatus.add(lblAccountid);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBorder(new TitledBorder(null, "test", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(tablePanel);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneTable = new JScrollPane();
		tablePanel.add(scrollPaneTable, BorderLayout.CENTER);
		
		tableShow = new JTable();
		tableShow.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPaneTable.setViewportView(tableShow);
		splitPane.setDividerLocation(250);

	}
	
	public static void loadContent(int index){
		System.out.println("ok");
	}
	
}

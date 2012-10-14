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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import client.event.admin.EnterPaymentEvent;
import client.event.admin.searchPanel.SearchPanelEnterPaymentEvent;
import client.gui.ExecuteLoading;
import client.gui.admin.nav_panel.searchPanel.SearchPanel;

@SuppressWarnings("serial")
public class EnterPayment extends JPanel {
	public static JTable table;
	public static Vector<String> headTable;
	public static DefaultTableModel model;
	/**
	 * @uml.property  name="txtEnterpayment"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JTextField txtEnterpayment;
	/**
	 * @uml.property  name="lblName_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JLabel lblName_1;
	/**
	 * @uml.property  name="lblTuition_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JLabel lblTuition_1;
	/**
	 * @uml.property  name="lblPaid_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JLabel lblPaid_1;
	/**
	 * @uml.property  name="lblUnpaid_1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JLabel lblUnpaid_1;
	public static JButton btnOk;
	public static SearchPanel searchPanel;
	public static SearchPanelEnterPaymentEvent searchPanelEvent;
	public static ExecuteLoading lblWaitting;
	
	/**
	 * @uml.property  name="event"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public EnterPaymentEvent event = new EnterPaymentEvent();

	public EnterPayment() {
		setLayout(new BorderLayout(0, 0));
		searchPanelEvent = new SearchPanelEnterPaymentEvent();
		{
			searchPanel = new SearchPanel(searchPanelEvent);
			searchPanel.cbbxStudent.setVisible(false);
			searchPanel.cbbxClass.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int index = searchPanel.cbbxClass.getSelectedIndex();
					if (index != 0) {
						model = new DefaultTableModel(searchPanelEvent
								.ModelfoTable(index), headTable);
						table.setModel(model);
					}

				}
			});
			add(searchPanel, BorderLayout.NORTH);
		}

		//
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setOpaque(false);
		splitPane.setDividerSize(3);
		add(splitPane, BorderLayout.CENTER);

		JPanel contentPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPanel.getLayout();
		flowLayout.setVgap(60);
		contentPanel.setOpaque(false);
		splitPane.setLeftComponent(contentPanel);

		JPanel panel = new JPanel();
		{
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
					SystemColor.textHighlight, null));
			panel.setBackground(SystemColor.window);
			panel.setPreferredSize(new Dimension(380, 280));
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblEnterPayment = new JLabel("Enter Payment:");
			lblEnterPayment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
					15));
			lblEnterPayment.setBounds(34, 23, 194, 25);
			panel.add(lblEnterPayment);

			JLabel lblName = new JLabel("Student:");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblName.setBounds(70, 75, 48, 14);
			panel.add(lblName);

			JLabel lblTuition = new JLabel("Tuition:");
			lblTuition.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTuition.setBounds(100, 100, 42, 14);
			panel.add(lblTuition);

			JLabel lblPaid = new JLabel("Paid:");
			lblPaid.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblPaid.setBounds(30, 127, 27, 14);
			panel.add(lblPaid);

			JLabel lblUnpaid = new JLabel("Unpaid:");
			lblUnpaid.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblUnpaid.setBounds(210, 127, 42, 14);
			panel.add(lblUnpaid);

			lblName_1 = new JLabel("");
			lblName_1.setBounds(140, 75, 194, 14);
			panel.add(lblName_1);

			lblTuition_1 = new JLabel("");
			lblTuition_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTuition_1.setBounds(168, 100, 88, 14);
			panel.add(lblTuition_1);

			lblPaid_1 = new JLabel("");
			lblPaid_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPaid_1.setBounds(59, 127, 100, 14);
			panel.add(lblPaid_1);

			lblUnpaid_1 = new JLabel("");
			lblUnpaid_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblUnpaid_1.setBounds(252, 127, 94, 14);
			panel.add(lblUnpaid_1);

			JLabel lblNextPayment = new JLabel("Next payment");
			lblNextPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNextPayment.setBounds(145, 165, 78, 15);
			panel.add(lblNextPayment);

			txtEnterpayment = new JTextField();
			txtEnterpayment.setBounds(100, 191, 184, 25);
			panel.add(txtEnterpayment);
			txtEnterpayment.setColumns(10);

			btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						int row = table.getSelectedRow();
						Float newPayment = Float.parseFloat(txtEnterpayment.getText());
						event.enterPayment(row, newPayment);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(),"Incorrect format of the payment! Please check!");
					}
				}
			});
			btnOk.setEnabled(false);
			btnOk.setBounds(140, 230, 89, 34);
			panel.add(btnOk);
			
			
			lblWaitting = new ExecuteLoading();
			lblWaitting.setBounds(320, 215, 89, 54);
			panel.add(lblWaitting);

		}

		JPanel tablePanel = new JPanel();
		{
			tablePanel.setOpaque(false);
			splitPane.setRightComponent(tablePanel);
			tablePanel.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setOpaque(false);
			tablePanel.add(scrollPane, BorderLayout.CENTER);

			{
				headTable = new Vector<String>();
				{// head of the table
					headTable.addElement(new String("Name"));
					headTable.addElement(new String("paid"));
					headTable.addElement(new String("payment"));
				}
			}
			table = new JTable(null, headTable);
			table.setRowHeight(20);
			{// Alignment Center for Table Header
				TableCellRenderer myRenderer = table.getTableHeader()
						.getDefaultRenderer();
				JLabel label = (JLabel) myRenderer;
				label.setHorizontalAlignment(JLabel.CENTER);
			}
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					int row = table.getSelectedRow();
					Float payment = Float.parseFloat(table.getValueAt(row, 2)
							.toString());
					Float paid = Float.parseFloat(table.getValueAt(row, 1)
							.toString());
					Float unPaid = payment - paid;
					setContentToPanel(table.getValueAt(row, 0).toString(),
							table.getValueAt(row, 2).toString(), table
									.getValueAt(row, 1).toString(), unPaid
									.toString());
				}
			});

			scrollPane.setViewportView(table);
			scrollPane.getViewport().setOpaque(false);
		}

		splitPane.setDividerLocation(400);
	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/Background.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}

	public void setContentToPanel(String name, String tuition, String paid,
			String unPaid) {

		lblName_1.setText(name);
		lblTuition_1.setText(tuition);
		lblPaid_1.setText(paid);
		lblUnpaid_1.setText(unPaid);
		btnOk.setEnabled(true);
	}
}

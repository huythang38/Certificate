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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import client.action.cadidate.ModelCandidate;
import client.action.tuition.ListPaymentTuition;
import client.event.admin.ManageCandidateEvent;
import client.gui.ExecuteLoading;

@SuppressWarnings("serial")
public class ManageCandidate extends JPanel {
	public static JTextField txtId;
	public static JTextField txtName;
	public static JComboBox<Object> cbbxPayment;
	public static JButton btnNew;
	public static JButton btnOk;
	public static JButton btnUpdate;
	public static JButton btnDelete;
	public static JButton btnCancel;
	public static JTable table;
	public static ExecuteLoading lblWaitting;
	public static Vector<String> headTable;
	public static DefaultTableModel tableModel;

	/**
	 * @uml.property  name="event"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ManageCandidateEvent event = new ManageCandidateEvent();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ManageCandidate() {
		setLayout(new BorderLayout(0, 0));

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
			panel.setPreferredSize(new Dimension(400, 280));
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblCourses = new JLabel("Manage Candidate:");
			lblCourses.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			lblCourses.setBounds(34, 23, 194, 25);
			panel.add(lblCourses);

			JLabel lblId = new JLabel("ID:");
			lblId.setBounds(70, 75, 46, 14);
			panel.add(lblId);

			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(70, 127, 46, 14);
			panel.add(lblName);

			txtId = new JTextField();
			txtId.setEnabled(false);
			txtId.setText("id");
			txtId.setBounds(131, 70, 169, 25);
			panel.add(txtId);
			txtId.setColumns(10);

			txtName = new JTextField();
			txtName.setEnabled(false);
			txtName.setText("name");
			txtName.setBounds(131, 122, 169, 25);
			panel.add(txtName);
			txtName.setColumns(10);

			JLabel lblPayment = new JLabel("Payment:");
			lblPayment.setBounds(70, 175, 58, 14);
			panel.add(lblPayment);

			cbbxPayment = new JComboBox<>();
			ComboBoxModel<Object> paymentModel = new DefaultComboBoxModel(
					ListPaymentTuition.getListPaymentTuition());
			cbbxPayment.setModel(paymentModel);
			cbbxPayment.setEnabled(false);
			cbbxPayment.setBounds(131, 170, 80, 25);
			panel.add(cbbxPayment);

			btnNew = new JButton("New");
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnOk.setVisible(true);
					btnNew.setVisible(false);
					setEnableConpoment(false, true, true, true, false, false,
							true);
					txtName.setText("");
					int idNew = Integer.parseInt(table.getValueAt(
							table.getModel().getRowCount() - 1, 0).toString()) + 1;
					txtId.setText(Integer.toString(idNew));
				}
			});
			btnNew.setBounds(16, 224, 80, 29);
			panel.add(btnNew);

			btnOk = new JButton("Ok");
			btnOk.setVisible(false);
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					event.newCandidate(txtName.getText(), Float
							.parseFloat(cbbxPayment.getSelectedItem()
									.toString()));
				}
			});
			btnOk.setBounds(16, 224, 80, 29);
			panel.add(btnOk);

			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					event.updateCandidate(Integer.parseInt(txtId.getText()),
							txtName.getText(), Float.parseFloat(cbbxPayment
									.getSelectedItem().toString()));
				}
			});
			btnUpdate.setEnabled(false);
			btnUpdate.setBounds(109, 224, 80, 29);
			panel.add(btnUpdate);

			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					event.deleteCandidate(Integer.parseInt(txtId.getText()));
				}
			});
			btnDelete.setEnabled(false);
			btnDelete.setBounds(204, 224, 80, 29);
			panel.add(btnDelete);

			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setEnableConpoment(false, false, false, true, false, false,
							true);
					btnOk.setVisible(false);
					btnNew.setVisible(true);
				}
			});
			btnCancel.setBounds(300, 224, 80, 29);
			panel.add(btnCancel);

			lblWaitting = new ExecuteLoading();
			lblWaitting.setBounds(320, 83, 89, 54);
			panel.add(lblWaitting);
		}
		
		JLabel label_1 = new JLabel("$");
		label_1.setBounds(221, 175, 46, 14);
		panel.add(label_1);

		JPanel tablePanel = new JPanel();
		{
			tablePanel.setOpaque(false);
			splitPane.setRightComponent(tablePanel);
			tablePanel.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setOpaque(false);
			tablePanel.add(scrollPane, BorderLayout.CENTER);

			headTable = new Vector<String>();
			{// head of the table
				headTable.addElement(new String("id"));
				headTable.addElement(new String("name"));
				headTable.addElement(new String("payment"));
			}
			tableModel = new DefaultTableModel(
					ModelCandidate.getModelCandidate(), headTable);

			table = new JTable(tableModel);
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
					setEnableConpoment(false, true, true, false, true, true,
							true);
					btnOk.setVisible(false);
					btnNew.setVisible(true);

					int row = table.getSelectedRow();
					setContentToPanel(Integer.parseInt(table.getValueAt(row, 0)
							.toString()), table.getValueAt(row, 1).toString(),
							table.getValueAt(row, 2));
				}
			});

			scrollPane.setViewportView(table);
			scrollPane.getViewport().setOpaque(false);
		}

		splitPane.setDividerLocation(450);
	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/Background.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}

	public void setContentToPanel(int id, String name, Object payment) {
		txtId.setText(Integer.toString(id));
		txtName.setText(name);
		cbbxPayment.setSelectedItem(payment);
	}

	public static void setEnableConpoment(boolean _id, boolean _name,
			boolean _cbbxPayment, boolean _new, boolean _update,
			boolean _delete, boolean _cancel) {

		txtId.setEnabled(_id);
		txtName.setEnabled(_name);
		cbbxPayment.setEnabled(_cbbxPayment);
		btnNew.setEnabled(_new);
		btnUpdate.setEnabled(_update);
		btnDelete.setEnabled(_delete);
		btnCancel.setEnabled(_cancel);
	}
}

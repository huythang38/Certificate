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
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import client.action.Class.ModelClass;
import client.action.course.ListNameCourse;
import client.event.admin.ManageClassEvent;
import client.gui.ExecuteLoading;

@SuppressWarnings("serial")
public class ManageClass extends JPanel {
	public static JTextField txtId;
	public static JTextField txtName;
	public static JComboBox<Object> cbbxCourse;
	public static JFormattedTextField frmtdtxtfldSize;
	public static JFormattedTextField frmtdtxtfldYear;
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
	public ManageClassEvent event = new ManageClassEvent();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ManageClass() {
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setOpaque(false);
		splitPane.setDividerSize(3);
		add(splitPane, BorderLayout.CENTER);

		JPanel contentPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPanel.getLayout();
		flowLayout.setVgap(30);
		contentPanel.setOpaque(false);
		splitPane.setLeftComponent(contentPanel);

		JPanel panel = new JPanel();
		{
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
					SystemColor.textHighlight, null));
			panel.setBackground(SystemColor.window);
			panel.setPreferredSize(new Dimension(400, 350));
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblSubject = new JLabel("Manage Class:");
			lblSubject.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			lblSubject.setBounds(34, 23, 194, 25);
			panel.add(lblSubject);

			JLabel lblId = new JLabel("ID:");
			lblId.setBounds(80, 64, 46, 14);
			panel.add(lblId);

			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(80, 116, 46, 14);
			panel.add(lblName);

			txtId = new JTextField();
			txtId.setEnabled(false);
			txtId.setText("id");
			txtId.setBounds(141, 59, 169, 25);
			panel.add(txtId);
			txtId.setColumns(10);

			txtName = new JTextField();
			txtName.setEnabled(false);
			txtName.setText("name");
			txtName.setBounds(141, 111, 169, 25);
			panel.add(txtName);
			txtName.setColumns(10);

			JLabel lblCourse = new JLabel("Courses:");
			lblCourse.setBounds(80, 164, 58, 14);
			panel.add(lblCourse);

			cbbxCourse = new JComboBox<>();
			ComboBoxModel<Object> courseModel = new DefaultComboBoxModel(
					ListNameCourse.getListNameCourse());
			cbbxCourse.setModel(courseModel);
			cbbxCourse.setEnabled(false);
			cbbxCourse.setBounds(141, 159, 169, 25);
			panel.add(cbbxCourse);

			JLabel lblSize = new JLabel("Size:");
			lblSize.setBounds(80, 207, 46, 14);
			panel.add(lblSize);

			JLabel lblYear = new JLabel("Year:");
			lblYear.setBounds(80, 250, 46, 14);
			panel.add(lblYear);

			frmtdtxtfldSize = new JFormattedTextField(0);
			frmtdtxtfldSize.setText("size");
			frmtdtxtfldSize.setEnabled(false);
			frmtdtxtfldSize.setHorizontalAlignment(SwingConstants.RIGHT);
			frmtdtxtfldSize.setFormatterFactory(new DefaultFormatterFactory(
					new NumberFormatter(new DecimalFormat("#0"))));
			frmtdtxtfldSize.setBounds(141, 202, 80, 25);
			panel.add(frmtdtxtfldSize);

			frmtdtxtfldYear = new JFormattedTextField(0);
			frmtdtxtfldYear.setText("year");
			frmtdtxtfldYear.setEnabled(false);
			frmtdtxtfldYear.setHorizontalAlignment(SwingConstants.RIGHT);
			frmtdtxtfldYear.setFormatterFactory(new DefaultFormatterFactory(
					new NumberFormatter(new DecimalFormat("#0"))));
			frmtdtxtfldYear.setBounds(141, 245, 80, 25);
			panel.add(frmtdtxtfldYear);

			btnNew = new JButton("New");
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnOk.setVisible(true);
					btnNew.setVisible(false);
					setEnableConpoment(false, true, true, true, true, true,
							false, false, true);
					txtName.setText("");
					int idNew = Integer.parseInt(table.getValueAt(
							table.getModel().getRowCount() - 1, 0).toString()) + 1;
					txtId.setText(Integer.toString(idNew));
				}
			});
			btnNew.setBounds(16, 305, 80, 29);
			panel.add(btnNew);

			btnOk = new JButton("Ok");
			btnOk.setVisible(false);
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cbbxCourse.getSelectedIndex() != 0) {
						event.newClass(txtName.getText(), cbbxCourse
								.getSelectedItem().toString(), Integer
								.parseInt(frmtdtxtfldSize.getText()), Integer
								.parseInt(frmtdtxtfldYear.getText()));
					} else {
						JOptionPane.showMessageDialog(new JFrame(),
								"No items selected in Courses!");
					}
				}
			});
			btnOk.setBounds(16, 305, 80, 29);
			panel.add(btnOk);

			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cbbxCourse.getSelectedIndex() != 0) {
						event.updateClass(Integer.parseInt(txtId.getText()),
								txtName.getText(), cbbxCourse.getSelectedItem()
										.toString(), Integer
										.parseInt(frmtdtxtfldSize.getText()),
								Integer.parseInt(frmtdtxtfldYear.getText()));
					} else {
						JOptionPane.showMessageDialog(new JFrame(),
								"No items selected in Courses!");
					}
				}
			});
			btnUpdate.setEnabled(false);
			btnUpdate.setBounds(106, 305, 80, 29);
			panel.add(btnUpdate);

			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					event.deleteClass(Integer.parseInt(txtId.getText()));
				}
			});
			btnDelete.setEnabled(false);
			btnDelete.setBounds(201, 305, 80, 29);
			panel.add(btnDelete);

			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setEnableConpoment(false, false, false, false, false, true,
							false, false, true);
					btnOk.setVisible(false);
					btnNew.setVisible(true);
				}
			});
			btnCancel.setBounds(297, 305, 80, 29);
			panel.add(btnCancel);

			lblWaitting = new ExecuteLoading();
			lblWaitting.setBounds(280, 210, 89, 54);
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

			headTable = new Vector<String>();
			{// head of the table
				headTable.addElement(new String("id"));
				headTable.addElement(new String("name"));
				headTable.addElement(new String("courses"));
				headTable.addElement(new String("size"));
				headTable.addElement(new String("year"));

			}
			tableModel = new DefaultTableModel(ModelClass.getModel(), headTable);

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
					setEnableConpoment(false, true, true, true, true, false,
							true, true, true);
					btnOk.setVisible(false);
					btnNew.setVisible(true);

					int row = table.getSelectedRow();
					setContentToPanel(Integer.parseInt(table.getValueAt(row, 0)
							.toString()), table.getValueAt(row, 1).toString(),
							table.getValueAt(row, 2), table.getValueAt(row, 3),
							table.getValueAt(row, 4));
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

	public void setContentToPanel(int id, String name, Object payment,
			Object size, Object year) {
		txtId.setText(Integer.toString(id));
		txtName.setText(name);
		cbbxCourse.setSelectedItem(payment);
		frmtdtxtfldSize.setText(size.toString());
		frmtdtxtfldYear.setText(year.toString());
	}

	public static void setEnableConpoment(boolean _id, boolean _name,
			boolean _cbbxCourse, boolean _frmtdtxtfldSize,
			boolean _frmtdtxtfldYear, boolean _new, boolean _update,
			boolean _delete, boolean _cancel) {

		txtId.setEnabled(_id);
		txtName.setEnabled(_name);
		cbbxCourse.setEnabled(_cbbxCourse);
		frmtdtxtfldSize.setEnabled(_frmtdtxtfldSize);
		frmtdtxtfldYear.setEnabled(_frmtdtxtfldYear);
		btnNew.setEnabled(_new);
		btnUpdate.setEnabled(_update);
		btnDelete.setEnabled(_delete);
		btnCancel.setEnabled(_cancel);
	}
}

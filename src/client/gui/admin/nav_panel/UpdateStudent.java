package client.gui.admin.nav_panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import client.action.cadidate.ListNameCandidate;
import client.action.course.ListNameCourse;
import client.event.admin.UpdateStudentEvent;
import client.event.admin.searchPanel.SearchPanelEvent;
import client.event.admin.searchPanel.SearchPanelUpdateStudentEvent;
import client.gui.ExecuteLoading;
import client.gui.admin.nav_panel.searchPanel.SearchPanel;

@SuppressWarnings("serial")
public class UpdateStudent extends JPanel {
	public static JTable table;
	public static Vector<String> headTable;
	public static DefaultTableModel model;
	public static SearchPanel searchPanel;
	public static SearchPanelUpdateStudentEvent searchPanelEvent;

	public static JFormattedTextField frmtdtxtfldPhone;
	public static ButtonGroup rdbGroup;
	public static JRadioButton rdbtnMale;
	public static JRadioButton rdbtnFemale;
	public static JComboBox<String> cbbxCandidate;
	public static JComboBox<String> cbbxCourse;
	public static JComboBox<String> cbbxClass;
	public static JButton btnCancel;
	public static JButton btnUpdate;

	public static ExecuteLoading lblWaitting;

	public UpdateStudentEvent event = new UpdateStudentEvent();
	public static JTextField txtId;
	public static JTextField txtName;
	public static JTextField txtAddress;
	public static JTextField txtBirthday;
	public static JTextField txtEmail;

	public UpdateStudent() {
		setLayout(new BorderLayout(0, 0));
		searchPanelEvent = new SearchPanelUpdateStudentEvent();
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

		JPanel panel = new JPanel();
		{
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
					SystemColor.textHighlight, null));
			panel.setBackground(SystemColor.window);
			panel.setPreferredSize(new Dimension(380, 480));
			// contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblUpdateStudent = new JLabel("Update Student:");
			lblUpdateStudent.setFont(new Font("Tahoma",
					Font.BOLD | Font.ITALIC, 15));
			lblUpdateStudent.setBounds(34, 23, 194, 25);
			panel.add(lblUpdateStudent);

			txtId = new JTextField();
			txtId.setEnabled(false);
			txtId.setHorizontalAlignment(SwingConstants.RIGHT);
			txtId.setText("id");
			txtId.setBounds(118, 59, 86, 25);
			panel.add(txtId);
			txtId.setColumns(10);

			txtName = new JTextField();
			txtName.setEnabled(false);
			txtName.setText("name");
			txtName.setBounds(118, 95, 217, 25);
			panel.add(txtName);
			txtName.setColumns(10);

			txtAddress = new JTextField();
			txtAddress.setEnabled(false);
			txtAddress.setText("address");
			txtAddress.setBounds(118, 131, 217, 25);
			panel.add(txtAddress);
			txtAddress.setColumns(10);

			rdbGroup = new ButtonGroup();

			rdbtnMale = new JRadioButton("Male");
			rdbtnMale.setEnabled(false);
			rdbtnMale.setBounds(118, 163, 55, 23);
			rdbGroup.add(rdbtnMale);
			panel.add(rdbtnMale);

			rdbtnFemale = new JRadioButton("Female");
			rdbtnFemale.setEnabled(false);
			rdbtnFemale.setBounds(186, 163, 69, 23);
			rdbGroup.add(rdbtnFemale);
			panel.add(rdbtnFemale);

			txtBirthday = new JTextField();
			txtBirthday.setEnabled(false);
			txtBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
			txtBirthday.setText("birthday");
			txtBirthday.setBounds(118, 193, 217, 25);
			panel.add(txtBirthday);
			txtBirthday.setColumns(10);

			txtEmail = new JTextField();
			txtEmail.setEnabled(false);
			txtEmail.setText("email");
			txtEmail.setBounds(118, 229, 217, 25);
			panel.add(txtEmail);
			txtEmail.setColumns(10);

			frmtdtxtfldPhone = new JFormattedTextField();
			frmtdtxtfldPhone.setEnabled(false);
			frmtdtxtfldPhone.setHorizontalAlignment(SwingConstants.RIGHT);
			frmtdtxtfldPhone.setText("phone");
			frmtdtxtfldPhone.setBounds(118, 265, 137, 25);
			panel.add(frmtdtxtfldPhone);

			cbbxCandidate = new JComboBox<String>(
					ListNameCandidate.getListNameCandidate());
			cbbxCandidate.setEnabled(false);
			cbbxCandidate.setBounds(118, 301, 137, 25);
			panel.add(cbbxCandidate);

			cbbxCourse = new JComboBox<String>(
					ListNameCourse.getListNameCourse());
			cbbxCourse.setEnabled(false);
			cbbxCourse.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int index = cbbxCourse.getSelectedIndex();
					if (index != 0) {
						SearchPanelEvent evt = new SearchPanelEvent();
						cbbxClass.setModel(evt.getListNameClassModel(index));
					} else {
						cbbxClass.setModel(new DefaultComboBoxModel<String>());
					}

				}
			});
			cbbxCourse.setBounds(118, 337, 137, 25);
			panel.add(cbbxCourse);

			cbbxClass = new JComboBox<String>();
			cbbxClass.setEnabled(false);
			cbbxClass.setBounds(118, 373, 137, 25);
			panel.add(cbbxClass);

			JLabel lblId = new JLabel("Id (*):");
			lblId.setBounds(44, 64, 46, 14);
			panel.add(lblId);

			JLabel lblName = new JLabel("Name (*):");
			lblName.setBounds(44, 100, 48, 14);
			panel.add(lblName);

			JLabel lblAddress = new JLabel("Address (*):");
			lblAddress.setBounds(44, 136, 60, 14);
			panel.add(lblAddress);

			JLabel lblGender = new JLabel("Gender (*):");
			lblGender.setBounds(44, 167, 56, 14);
			panel.add(lblGender);

			JLabel lblBirthday = new JLabel("Birthday (*):");
			lblBirthday.setBounds(44, 198, 61, 14);
			panel.add(lblBirthday);

			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(44, 234, 46, 14);
			panel.add(lblEmail);

			JLabel lblPhone = new JLabel("Phone:");
			lblPhone.setBounds(44, 270, 46, 14);
			panel.add(lblPhone);

			JLabel lblCandidate = new JLabel("Candidate (*):");
			lblCandidate.setBounds(44, 306, 70, 14);
			panel.add(lblCandidate);

			JLabel lblCourse = new JLabel("Course:");
			lblCourse.setBounds(44, 342, 46, 14);
			panel.add(lblCourse);

			JLabel lblClass = new JLabel("Class:");
			lblClass.setBounds(44, 378, 46, 14);
			panel.add(lblClass);

			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					event.update(txtId.getText(), txtName.getText(),
							txtAddress.getText(), rdbtnMale.isSelected(),
							rdbtnFemale.isSelected(), txtBirthday.getText(),
							txtEmail.getText(), frmtdtxtfldPhone.getText(),
							cbbxCandidate.getSelectedItem().toString(),
							cbbxClass.getSelectedItem().toString(),
							searchPanel.cbbxClass.getSelectedIndex(),
							cbbxClass.getSelectedIndex());
					// (txtName.getText(),
					// txtAddress.getText(), rdbtnMale.isSelected(),
					// rdbtnFemale.isSelected(), txtBirthday.getText(),
					// txtEmail.getText(), frmtdtxtfldPhone.getText(),
					// cbbxCandidate.getSelectedIndex(),
					// cbbxClass.getSelectedIndex());

					// if (rdbtnMale.isSelected()){
					// event.updateStudent(txtId, txtName, 1, gender, birthday,
					// email, phone, candidate, _class);
					// } else if (rdbtnFemale.isSelected()){
					// event.updateStudent(txtId, txtName, 0, gender, birthday,
					// email, phone, candidate, _class);
					// }

				}
			});
			btnUpdate.setEnabled(false);
			btnUpdate.setBounds(84, 423, 100, 35);
			panel.add(btnUpdate);

			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setEnableConpoment(false);
				}
			});
			btnCancel.setEnabled(false);
			btnCancel.setBounds(209, 423, 100, 35);
			panel.add(btnCancel);

			lblWaitting = new ExecuteLoading();
			lblWaitting.setBounds(300, 345, 89, 54);
			panel.add(lblWaitting);

		}

		JScrollPane scrollPaneFrame = new JScrollPane();
		{
			JPanel panel_1 = new JPanel();
			panel_1.setOpaque(false);
			panel_1.add(panel);
			scrollPaneFrame.setViewportView(panel_1);

			scrollPaneFrame.setOpaque(false);
			splitPane.setLeftComponent(scrollPaneFrame);
			scrollPaneFrame.getViewport().setOpaque(false);
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
					headTable.addElement(new String("id"));
					headTable.addElement(new String("name"));
					headTable.addElement(new String("address"));
					headTable.addElement(new String("gender"));
					headTable.addElement(new String("birthday"));
					headTable.addElement(new String("email"));
					headTable.addElement(new String("phone"));
					headTable.addElement(new String("candidate"));
					headTable.addElement(new String("class"));
					headTable.addElement(new String("course"));
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
					setEnableConpoment(true);
					int row = table.getSelectedRow();
					setContentToPanel(table.getValueAt(row, 0).toString(),
							table.getValueAt(row, 1).toString(), table
									.getValueAt(row, 2).toString(), table
									.getValueAt(row, 3).toString(), table
									.getValueAt(row, 4).toString(), table
									.getValueAt(row, 5).toString(), table
									.getValueAt(row, 6).toString(), table
									.getValueAt(row, 7), table.getValueAt(row,
									8), table.getValueAt(row, 9));
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

	public void setContentToPanel(String id, String name, String address,
			String gender, String birthday, String email, String phone,
			Object candidate, Object _class, Object course) {

		txtId.setText(id);
		txtName.setText(name);
		txtAddress.setText(address);

		if (gender.equals("Male")) {
			rdbtnMale.setSelected(true);
		} else {
			rdbtnFemale.setSelected(true);
		}

		txtBirthday.setText(birthday);
		txtEmail.setText(email);
		frmtdtxtfldPhone.setText(phone);
		cbbxCandidate.setSelectedItem(candidate);
		cbbxCourse.setSelectedItem(course);
		cbbxClass.setSelectedItem(_class);
	}

	public static void setEnableConpoment(boolean boo) {
		txtName.setEnabled(boo);
		txtAddress.setEnabled(boo);
		rdbtnMale.setEnabled(boo);
		rdbtnFemale.setEnabled(boo);
		txtBirthday.setEnabled(boo);
		txtEmail.setEnabled(boo);
		frmtdtxtfldPhone.setEnabled(boo);
		cbbxCandidate.setEnabled(boo);
		cbbxCourse.setEnabled(boo);
		cbbxClass.setEnabled(boo);
		btnUpdate.setEnabled(boo);
		btnCancel.setEnabled(boo);
	}
}

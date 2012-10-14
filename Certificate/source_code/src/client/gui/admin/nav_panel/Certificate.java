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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import client.action.certificate.CreateCertificate;
import client.event.admin.GenerationCertificateEvent;
import client.event.admin.searchPanel.SearchPanelGenerationCertificate;
import client.gui.ExecuteLoading;
import client.gui.admin.nav_panel.searchPanel.SearchPanel;
import client.report.ExportCertificate;

@SuppressWarnings("serial")
public class Certificate extends JPanel {
	public static JTable table;
	public static Vector<String> headTable;
	public static DefaultTableModel model;
	public static SearchPanel searchPanel;
	public static SearchPanelGenerationCertificate searchPanelEvent;
	public static ButtonGroup rdbGroup;

	public static ExecuteLoading lblWaitting;

	/**
	 * @uml.property  name="event"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public GenerationCertificateEvent event = new GenerationCertificateEvent();
	/**
	 * @uml.property  name="exportCertificate"
	 * @uml.associationEnd  readOnly="true"
	 */
	public ExportCertificate exportCertificate;

	public static JTextField txtId;
	public static JLabel lblLock;
	public static JTextField txtName;
	public static JTextField txtBirthday;
	public static JTextField txtCourse;
	public static JTextField txtClass;
	public static JLabel lblPaymentstatus;
	public static JLabel lblScore;
	public static JLabel lblGrade;
	public static JButton btnGeneration;
	public static JButton btnExportCertificate;
	public static JButton btnCancel;
	public static JLabel lblStatusCompleteSubject;

	public Certificate() {
		setLayout(new BorderLayout(0, 0));
		searchPanelEvent = new SearchPanelGenerationCertificate();
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
			panel.setPreferredSize(new Dimension(380, 440));
			// contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblUpdateStudent = new JLabel("Generation Certificate:");
			lblUpdateStudent.setFont(new Font("Tahoma",
					Font.BOLD | Font.ITALIC, 15));
			lblUpdateStudent.setBounds(34, 23, 194, 25);
			panel.add(lblUpdateStudent);

			txtId = new JTextField();
			txtId.setEditable(false);
			txtId.setHorizontalAlignment(SwingConstants.RIGHT);
			txtId.setText("Account");
			txtId.setBounds(118, 59, 106, 25);
			panel.add(txtId);
			txtId.setColumns(10);

			txtName = new JTextField();
			txtName.setEditable(false);
			txtName.setText("name");
			txtName.setBounds(118, 95, 217, 25);
			panel.add(txtName);
			txtName.setColumns(10);

			rdbGroup = new ButtonGroup();

			txtBirthday = new JTextField();
			txtBirthday.setEditable(false);
			txtBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
			txtBirthday.setText("birthday");
			txtBirthday.setBounds(118, 131, 217, 25);
			panel.add(txtBirthday);
			txtBirthday.setColumns(10);

			JLabel lblId = new JLabel("Account:");
			lblId.setBounds(44, 64, 46, 14);
			panel.add(lblId);

			JLabel lblName = new JLabel("Name (*):");
			lblName.setBounds(44, 100, 48, 14);
			panel.add(lblName);

			JLabel lblBirthday = new JLabel("Birthday (*):");
			lblBirthday.setBounds(44, 136, 61, 14);
			panel.add(lblBirthday);

			JLabel lblCourse = new JLabel("Course:");
			lblCourse.setBounds(44, 172, 46, 14);
			panel.add(lblCourse);

			JLabel lblClass = new JLabel("Class:");
			lblClass.setBounds(44, 208, 46, 14);
			panel.add(lblClass);

			txtCourse = new JTextField();
			txtCourse.setEditable(false);
			txtCourse.setText("Course");
			txtCourse.setBounds(118, 167, 137, 25);
			panel.add(txtCourse);
			txtCourse.setColumns(10);

			txtClass = new JTextField();
			txtClass.setEditable(false);
			txtClass.setText("Class");
			txtClass.setBounds(118, 203, 137, 25);
			panel.add(txtClass);
			txtClass.setColumns(10);

			lblLock = new JLabel("lock");
			lblLock.setBounds(234, 64, 101, 14);
			panel.add(lblLock);

			lblPaymentstatus = new JLabel("Payment Status");
			lblPaymentstatus.setBounds(118, 239, 137, 25);
			panel.add(lblPaymentstatus);

			JLabel lblPayment = new JLabel("Payment:");
			lblPayment.setBounds(44, 244, 61, 14);
			panel.add(lblPayment);

			lblStatusCompleteSubject = new JLabel("Status Complete Subject");
			lblStatusCompleteSubject.setBounds(118, 275, 137, 25);
			panel.add(lblStatusCompleteSubject);

			JLabel lblSubject = new JLabel("Subject:");
			lblSubject.setBounds(44, 280, 61, 14);
			panel.add(lblSubject);

			lblScore = new JLabel("score");
			lblScore.setBounds(118, 311, 137, 25);
			panel.add(lblScore);

			JLabel lblScore_1 = new JLabel("Score:");
			lblScore_1.setBounds(44, 316, 46, 14);
			panel.add(lblScore_1);

			lblGrade = new JLabel("grade");
			lblGrade.setBounds(118, 345, 137, 25);
			panel.add(lblGrade);

			JLabel lblGrade_1 = new JLabel("Grade:");
			lblGrade_1.setBounds(44, 350, 61, 14);
			panel.add(lblGrade_1);

			btnGeneration = new JButton("Generation");
			btnGeneration.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int student_id = Integer
							.parseInt(GenerationCertificateEvent.data.get(0)
									.toString());
					CreateCertificate createCertificate = new CreateCertificate(
							Integer.parseInt(lblScore.getText()), lblGrade
									.getText(), student_id);
					createCertificate.start();
				}
			});
			btnGeneration.setEnabled(false);
			btnGeneration.setBounds(20, 390, 89, 30);
			panel.add(btnGeneration);

			btnExportCertificate = new JButton("Export Certificate ");
			btnExportCertificate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					exportCertificate = new ExportCertificate(
							txtName.getText(), txtBirthday.getText(), "ABC", lblGrade.getText());
				}
			});
			btnExportCertificate.setEnabled(false);
			btnExportCertificate.setBounds(125, 390, 121, 30);
			panel.add(btnExportCertificate);

			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnGeneration.setEnabled(false);
					btnExportCertificate.setEnabled(false);
				}
			});
			btnCancel.setBounds(265, 390, 89, 30);
			panel.add(btnCancel);

			lblWaitting = new ExecuteLoading();
			lblWaitting.setVisible(true);
			panel.add(lblWaitting);

		}

		JScrollPane scrollPaneFrame = new JScrollPane();
		{
			JPanel panel_1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
			flowLayout.setVgap(20);
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
					headTable.addElement(new String("no."));
					headTable.addElement(new String("name"));
					headTable.addElement(new String("status certificate"));
				}
			}
			table = new JTable(null, headTable);
			table.setRowHeight(20);
			{// Alignment Center for Table Header
				TableCellRenderer myRenderer = table.getTableHeader()
						.getDefaultRenderer();
				JLabel label = (JLabel) myRenderer;
				label.setHorizontalAlignment(JLabel.CENTER);

				TableColumn col = table.getColumnModel().getColumn(0);
				int width = 10;
				col.setPreferredWidth(width);
			}
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					int row = table.getSelectedRow();
					event.viewInfo(row);
				}
			});

			scrollPane.setViewportView(table);
			scrollPane.getViewport().setOpaque(false);
		}

		splitPane.setDividerLocation(550);

	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/Background.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}

	public static void setContentToPanel(String username, String lock,
			String name, String birthday, String _class, String course,
			String paymentStatus, String statusCompleteSubject, String score,
			String grade) {

		txtId.setText(username);
		lblLock.setText(lock);
		txtName.setText(name);
		txtBirthday.setText(birthday);
		txtCourse.setText(course);
		txtClass.setText(_class);

		lblPaymentstatus.setText(paymentStatus);
		lblStatusCompleteSubject.setText(statusCompleteSubject);
		lblScore.setText(score);
		lblGrade.setText(grade);
	}
}

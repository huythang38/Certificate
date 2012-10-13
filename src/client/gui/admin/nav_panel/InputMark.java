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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import client.event.admin.InputMarkEvent;
import client.event.admin.searchPanel.SearchPanelInputMarkEvent;
import client.gui.ExecuteLoading;
import client.gui.admin.nav_panel.searchPanel.SearchPanelInputMark;

@SuppressWarnings("serial")
public class InputMark extends JPanel {
	public static JTable table;
	public static Vector<String> headTable;
	public static DefaultTableModel model;
	public static JButton btnOk;
	public static SearchPanelInputMark searchPanel;
	public static SearchPanelInputMarkEvent searchPanelEvent;
	public static ExecuteLoading lblWaitting;
	public static JFormattedTextField frmtdtxtfldMark;
	public static JLabel lblShowSubject;
	public static JLabel lblShowName;

	public InputMarkEvent event = new InputMarkEvent();

	public InputMark() {
		setLayout(new BorderLayout(0, 0));
		searchPanelEvent = new SearchPanelInputMarkEvent();
		{
			searchPanel = new SearchPanelInputMark(searchPanelEvent);
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
			panel.setPreferredSize(new Dimension(380, 260));
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblEnterPayment = new JLabel("InputMark:");
			lblEnterPayment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
					15));
			lblEnterPayment.setBounds(34, 23, 194, 25);
			panel.add(lblEnterPayment);

			JLabel lblName = new JLabel("Student:");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblName.setBounds(91, 71, 48, 14);
			panel.add(lblName);

			JLabel lblSubject = new JLabel("Subject:");
			lblSubject.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSubject.setBounds(91, 107, 48, 14);
			panel.add(lblSubject);

			JLabel lblMark = new JLabel("Mark:");
			lblMark.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblMark.setBounds(91, 146, 46, 14);
			panel.add(lblMark);

			frmtdtxtfldMark = new JFormattedTextField();
			frmtdtxtfldMark.setEnabled(false);
			frmtdtxtfldMark.setFormatterFactory(new DefaultFormatterFactory(
					new NumberFormatter(new DecimalFormat("#0"))));
			frmtdtxtfldMark.setText("Mark");
			frmtdtxtfldMark.setBounds(164, 141, 117, 25);
			panel.add(frmtdtxtfldMark);

			lblShowName = new JLabel("name");
			lblShowName.setBounds(164, 71, 117, 14);
			panel.add(lblShowName);

			lblShowSubject = new JLabel("subject");
			lblShowSubject.setBounds(164, 107, 117, 14);
			panel.add(lblShowSubject);

			btnOk = new JButton("Ok");
			btnOk.setEnabled(false);
			btnOk.addActionListener(new ActionListener() {
				@SuppressWarnings({ "unused", "static-access" })
				public void actionPerformed(ActionEvent arg0) {
					try {
						int row = table.getSelectedRow();
						int indexSubject = searchPanelEvent.listNameAndIDSubject
								.getListID().get(
										searchPanel.cbbxSubject
												.getSelectedIndex() - 1);
						int indexClass = searchPanelEvent.listNameAndIDC
								.getListIDClass().get(
										searchPanel.cbbxClass
												.getSelectedIndex() - 1);
						
						event.inputMark(lblShowName.getText(), indexClass,
								indexSubject, frmtdtxtfldMark.getText());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Incorrect format of the Mark! Please check!");
					}
				}
			});
			btnOk.setBounds(140, 199, 89, 34);
			panel.add(btnOk);

			lblWaitting = new ExecuteLoading();
			lblWaitting.setBounds(320, 200, 89, 54);
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
					headTable.addElement(new String("name"));
					headTable.addElement(new String("mark"));
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

				@SuppressWarnings("static-access")
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					int row = table.getSelectedRow();
					setContentToPanel(table.getValueAt(row, 0).toString(),
							searchPanel.cbbxSubject.getSelectedItem()
									.toString(), table.getValueAt(row, 1)
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

	public void setContentToPanel(String name, String subject, String mark) {
		lblShowName.setText(name);
		lblShowSubject.setText(subject);
		frmtdtxtfldMark.setText(mark);
		frmtdtxtfldMark.setEnabled(true);
		btnOk.setEnabled(true);
	}
}

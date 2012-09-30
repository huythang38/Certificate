package client.gui.admin.nav_panel.searchPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import client.event.admin.searchPanel.SearchPanelEvent;
import java.awt.SystemColor;
import java.awt.Color;

@SuppressWarnings("serial")
public class SearchPanel extends JPanel {
	@SuppressWarnings("rawtypes")
	public JComboBox cbbxCourse = null;
	@SuppressWarnings("rawtypes")
	public JComboBox cbbxClass;
	@SuppressWarnings("rawtypes")
	public JComboBox cbbxStudent;
	public SearchPanelEvent event;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SearchPanel(SearchPanelEvent value) {
		setBackground(new Color(240, 255, 240));
		event = value;
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(3);
		flowLayout.setHgap(20);

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.textHighlight, null));
		setPreferredSize(new Dimension(0, 30));

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		add(lblSearch);

		cbbxCourse = new JComboBox(event.getListNameCourse());
		cbbxCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = cbbxCourse.getSelectedIndex();
				if (index != 0) {
					cbbxClass.setModel(event.getListNameClassModel(index));
				}else{
					cbbxClass.setModel(new DefaultComboBoxModel<String>());
				}
			}
		});
		cbbxCourse.setPreferredSize(new Dimension(150, 20));
		add(cbbxCourse);

		cbbxClass = new JComboBox();
		cbbxClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = cbbxClass.getSelectedIndex();
				if (index != 0) {
					cbbxStudent.setModel(event.getListNameStudentModel(index));
				}else{
					cbbxStudent.setModel(new DefaultComboBoxModel<String>());
				}
			}
		});
		cbbxClass.setPreferredSize(new Dimension(150, 20));
		add(cbbxClass);

		cbbxStudent = new JComboBox();
		cbbxStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = cbbxStudent.getSelectedIndex();
				if (index != 0) {
					event.choiceStudent(index);
				}
			}
		});
		cbbxStudent.setPreferredSize(new Dimension(150, 20));
		add(cbbxStudent);

	}
}

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

@SuppressWarnings("serial")
public class SearchPanel extends JPanel {
	@SuppressWarnings("rawtypes")
	public JComboBox cbbxCourse = null;
	@SuppressWarnings("rawtypes")
	public JComboBox cbbxClass;
	@SuppressWarnings("rawtypes")
	public JComboBox cbbxStudent;
	@SuppressWarnings("rawtypes")
	public DefaultComboBoxModel comboBoxModel;
	public SearchPanelEvent event;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SearchPanel(SearchPanelEvent value){
		event = value;
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(3);
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setPreferredSize(new Dimension(0, 30));

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		add(lblSearch);

		cbbxCourse = new JComboBox(event.getListNameCourse());
		cbbxCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = cbbxCourse.getSelectedIndex();
				cbbxClass.setModel(event.getListNameClassModel(index));
			}
		});
		cbbxCourse.setPreferredSize(new Dimension(150, 20));
		add(cbbxCourse);

		cbbxClass = new JComboBox();
		cbbxClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = cbbxClass.getSelectedIndex();
				cbbxStudent.setModel(event.getListNameStudentModel(index));
			}
		});
		cbbxClass.setPreferredSize(new Dimension(150, 20));
		add(cbbxClass);

		cbbxStudent = new JComboBox();
		cbbxStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = cbbxClass.getSelectedIndex();
				event.choiceStudent(index);
			}
		});
		cbbxStudent.setPreferredSize(new Dimension(150, 20));
		add(cbbxStudent);

	}
}

package client.gui.admin.nav_panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class SearchPanel extends JPanel{
	public SearchPanel() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(3);
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		
				setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setPreferredSize(new Dimension(0, 30));

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		add(lblSearch);

		JComboBox cbbxCourse = new JComboBox();
		cbbxCourse.setPreferredSize(new Dimension(150, 20));
		add(cbbxCourse);

		JComboBox cbbxClass = new JComboBox();
		cbbxClass.setPreferredSize(new Dimension(150, 20));
		add(cbbxClass);

		JComboBox cbbxStudent = new JComboBox();
		cbbxStudent.setPreferredSize(new Dimension(150, 20));
		add(cbbxStudent);
	}
}

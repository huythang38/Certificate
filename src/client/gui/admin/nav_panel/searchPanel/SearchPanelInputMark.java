package client.gui.admin.nav_panel.searchPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.event.admin.searchPanel.SearchPanelEvent;
import client.event.admin.searchPanel.SearchPanelInputMarkEvent;

@SuppressWarnings("serial")
public class SearchPanelInputMark extends SearchPanel {

	public static SearchPanelInputMarkEvent searchPanelEvent = new SearchPanelInputMarkEvent();
	public static JComboBox<String> cbbxSubject;

	public SearchPanelInputMark(SearchPanelEvent value) {
		super(value);
		// TODO Auto-generated constructor stub
		cbbxStudent.setVisible(false);

		cbbxSubject = new JComboBox<String>();
		cbbxSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indexSubject = cbbxSubject.getSelectedIndex();
				int indexClass = cbbxClass.getSelectedIndex();
				if (indexClass != 0) {
					if (indexSubject != 0) {
						//
						searchPanelEvent.showRecord(indexClass, indexSubject);
						//
					} else {
						JOptionPane
								.showMessageDialog(new JFrame(),
										"Not select an item in the Subject! Please check!");
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
							"Not select an item in the Class! Please check!");
				}
			}
		});
		cbbxSubject.setPreferredSize(new Dimension(150, 20));
		add(cbbxSubject);
	}
}

package client.gui.admin.nav_menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import client.gui.NavGUI_Admin;
import extend_lib.Button;

@SuppressWarnings("serial")
public class OtherTab extends JPanel {
	public JScrollPane scrollPane;
	public JPanel panel;
	
	@SuppressWarnings("unused")
	public OtherTab() {
		setLayout(new BorderLayout());
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel = new JPanel();
		panel.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();

		Button btCreateClass = new Button("lib/images/class_add.png",
				"Create Class");
		btCreateClass.setMinimumSize(new Dimension(100, 105));
		btCreateClass.setPreferredSize(new Dimension(100, 80));
		btCreateClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createClass");
			}
		});
		panel.add(btCreateClass);

		Button btChangeClass = new Button("lib/images/class_change.png",
				"Change Class");
		btChangeClass.setMinimumSize(new Dimension(100, 105));
		btChangeClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("changeClass");
			}
		});
		btChangeClass.setPreferredSize(new Dimension(110, 80));
		panel.add(btChangeClass);

		JSeparator separator = new JSeparator();
		separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				SystemColor.textHighlight, null));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setPreferredSize(new Dimension(1, 50));
		panel.add(separator);

		Button btCreateCourse = new Button("lib/images/course_add.png",
				"Create Course");
		btCreateCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createCourse");
			}
		});
		btCreateCourse.setPreferredSize(new Dimension(110, 80));
		panel.add(btCreateCourse);

		Button btChangeCourse = new Button("lib/images/course_change.png",
				"Change Course");
		btChangeCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("changeCourse");
			}
		});
		btChangeCourse.setPreferredSize(new Dimension(120, 80));
		panel.add(btChangeCourse);

		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(1, 50));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				SystemColor.textHighlight, null));
		panel.add(separator_1);

		Button btCreateTuition = new Button("lib/images/tuition_add.png",
				"Create Tuition");
		btCreateTuition.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createTuition");
			}
		});
		btCreateTuition.setPreferredSize(new Dimension(110, 80));
		panel.add(btCreateTuition);

		Button btChangeTuition = new Button("lib/images/tuition_change.png",
				"Change Tuition");
		btChangeTuition.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("changeTuition");
			}
		});
		btChangeTuition.setPreferredSize(new Dimension(120, 80));
		panel.add(btChangeTuition);

		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(1, 50));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED,
				SystemColor.textHighlight, null));
		panel.add(separator_2);

		Button btCreateSubject = new Button("lib/images/subject_add.png",
				"Create Subject");
		btCreateSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("createSubject");
			}
		});
		btCreateSubject.setPreferredSize(new Dimension(120, 80));
		panel.add(btCreateSubject);

		Button btChangeSubject = new Button("lib/images/subject_change.png",
				"Change Subject");
		btChangeSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				NavGUI_Admin.navPanel.showContent("changeSubject");
			}
		});
		btChangeSubject.setPreferredSize(new Dimension(120, 80));
		panel.add(btChangeSubject);
		
//		scrollPane.
		scrollPane.setViewportView(panel);
		scrollPane.getViewport().setOpaque(false);
		
		
		add(scrollPane, BorderLayout.CENTER);
		
		final JSlider slider = new JSlider();
		slider.setOpaque(false);
		slider.setBackground(new Color(228, 240, 252));
		slider.setBorder(null);
		slider.setValue(scrollPane.getHorizontalScrollBar().getValue());
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				scrollPane.getHorizontalScrollBar().setValue(slider.getValue()*3);
			}
		});

		slider.setPreferredSize(new Dimension(20, 0));
		slider.setMinimumSize(new Dimension(25, 26));
		slider.setOrientation(SwingConstants.VERTICAL);
		add(slider, BorderLayout.EAST);
		
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("lib/images/bak4.jpg").getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}
}

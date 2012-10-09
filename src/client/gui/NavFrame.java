/*
 * huythang38
 */

package client.gui;

import java.awt.EventQueue;

public class NavFrame {
	public static NavGUI_Admin navGUI_Admin;
	public static NavGUI_Student navGUI_Student;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new NavFrame(0, null, 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NavFrame(int id, String userName, int role) {
		if (role == 1){
			navGUI_Admin = new NavGUI_Admin();
			navGUI_Admin.setVisible(true);
		}else{
			navGUI_Student = new NavGUI_Student();
			navGUI_Student.setVisible(true);
		}
	}
}

/*
 * huythang38
 */

package client.gui;

import java.awt.EventQueue;

public class NavFrame {
	
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
			new NavGUI_Admin().setVisible(true);
		}else{
			
		}
	}
}

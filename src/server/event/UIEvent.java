/*
 * huythang38
 */

package server.event;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.gui.ServerUI;

public class UIEvent {
	private SystemTray tray;
	private TrayIcon trayIcon;

	public UIEvent() {
		trayIcon = new TrayIcon((new ImageIcon("lib/images/logoTray.png")).getImage());
		PopupMenu popupMenu = new PopupMenu();

		// item show server
		MenuItem show = new MenuItem("Show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAction();
			}
		});
		popupMenu.add(show);

		// Separator
		popupMenu.addSeparator();

		// item exit program
		MenuItem exit = new MenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mntmExitAction();
			}
		});
		popupMenu.add(exit);

		// add to program
		tray = SystemTray.getSystemTray();
		trayIcon.setPopupMenu(popupMenu);
		trayIcon.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					showAction();
			}
		});
	}

	// show
	public void showAction() {
		tray.remove(trayIcon);
		ServerUI.showFrame();
	}

	// event window
	public void mntmExitAction() {
		System.exit(0);
	}

	// event close button window
	public void windowClosing() {
		systemTray();
	}

	// System Tray
	public void systemTray() {
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
			return;
		}
	}

	// config
	@SuppressWarnings({ "unused", "resource" })
	public boolean btnUpdateConfigAction(String user, String pass, int port) {
		boolean check;
		if (user.equals("") | pass.equals("")) {
			check = false;
			JOptionPane.showMessageDialog(new JFrame(),
					"not leave any field empty!");
		} else {
			check = true;
		}
		if ((port <= 1024) || (port > 65650)) {
			check = false;
			JOptionPane.showMessageDialog(new JFrame(),
					"in the range from 1025 to 65651!");
		} else {
			try {
				ServerSocket server = new ServerSocket(port);
			} catch (IOException e) {
				check = false;
				JOptionPane.showMessageDialog(new JFrame(),
						"existing port! Choice other port!");
			}
		}
		return check;
	}

}

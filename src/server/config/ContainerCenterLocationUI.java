package server.config;

import java.awt.Toolkit;
import javax.swing.*;

public class ContainerCenterLocationUI {
	public ContainerCenterLocationUI(JWindow comp) {
		// can giua man hinh
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int screenX = (toolkit.getScreenSize().width - comp.getSize().width) / 2;
		int screenY = (toolkit.getScreenSize().height - comp.getSize().height) / 2;
		comp.setLocation(screenX, screenY);
	}

	public ContainerCenterLocationUI(JFrame comp) {
		// can giua man hinh
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int screenX = (toolkit.getScreenSize().width - comp.getSize().width) / 2;
		int screenY = (toolkit.getScreenSize().height - comp.getSize().height) / 2;
		comp.setLocation(screenX, screenY);
	}
}

package extend_lib;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class LogoContainer {
	public LogoContainer(JFrame frame){
		frame.setIconImage(new ImageIcon("lib/images/logo.png").getImage());
	}
}

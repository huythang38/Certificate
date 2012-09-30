package extend_lib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public class TransparentBackgroundFrame extends JComponent
implements ComponentListener, WindowFocusListener, Runnable {

// constants ---------------------------------------------------------------
// instance ----------------------------------------------------------------
private JDialog _dialog;
private BufferedImage _background;
private long _lastUpdate = 0;
private boolean _refreshRequested = true;
private Robot _robot;
private Rectangle _screenRect;
private ConvolveOp _blurOp;

// constructor -------------------------------------------------------------

public TransparentBackgroundFrame(JDialog dialog) {
_dialog = dialog;
try {
	_robot = new Robot();
} catch (AWTException e) {
	e.printStackTrace();
	return;
}

Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
_screenRect = new Rectangle(dim.width, dim.height);

float[] my_kernel = {
		0.10f, 0.10f, 0.10f,
		0.10f, 0.20f, 0.10f,
		0.10f, 0.10f, 0.10f};
_blurOp = new ConvolveOp(new Kernel(3, 3, my_kernel));

updateBackground();
_dialog.addComponentListener(this);
_dialog.addWindowFocusListener(this);
new Thread(this).start();
}

// protected ---------------------------------------------------------------

protected void updateBackground() {
_background = _robot.createScreenCapture(_screenRect);
}



protected void refresh() {
if (_dialog.isVisible() && this.isVisible()) {
	repaint();
	_refreshRequested = true;
	_lastUpdate = System.currentTimeMillis();
}
}


// JComponent --------------------------------------------------------------

protected void paintComponent(Graphics g) {
Graphics2D g2 = (Graphics2D) g;
Point pos = this.getLocationOnScreen();
BufferedImage buf = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
buf.getGraphics().drawImage(_background, -pos.x, -pos.y, null);

Image img = _blurOp.filter(buf, null);
g2.drawImage(img, 0, 0, null);
g2.setColor(new Color(255, 255, 255, 192));
g2.fillRect(0, 0, getWidth(), getHeight());
}

// ComponentListener -------------------------------------------------------
public void componentHidden(ComponentEvent e) {
}

public void componentMoved(ComponentEvent e) {
repaint();
}

public void componentResized(ComponentEvent e) {
repaint();

}

public void componentShown(ComponentEvent e) {
repaint();
}

// WindowFocusListener -----------------------------------------------------
public void windowGainedFocus(WindowEvent e) {
refresh();
}

public void windowLostFocus(WindowEvent e) {
refresh();
}

// Runnable ----------------------------------------------------------------
public void run() {
try {
	while (true) {
		Thread.sleep(100);
		long now = System.currentTimeMillis();
		if (_refreshRequested && ((now - _lastUpdate) > 1000)) {
			if (_dialog.isVisible()) {
				Point location = _dialog.getLocation();
				_dialog.setLocation(-_dialog.getWidth(), -_dialog.getHeight());
				updateBackground();
				_dialog.setLocation(location);
				refresh();
			}
			_lastUpdate = now;
			_refreshRequested = false;
		}
	}
} catch (InterruptedException e) {
	e.printStackTrace();
}
}
}
/*
 * huythang38
 */

package client.event;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FogotPassEvent {
	public void generateEmail(String value){
		if (value.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"+
                   "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
		{
			
			
			System.out.println("ok");
		}else{
			JOptionPane.showMessageDialog(new JFrame(), "Validate email fail !");
		}
	}
	
}

package client.action.tuition;

import java.rmi.RemoteException;
import java.util.Vector;

import client.Client;
import client.event.DisconnectToExit;

public class ListPaymentTuition {
	public ListPaymentTuition(){}
	
	public static Vector<Float> getListPaymentTuition(){
		Vector<Float> data = null;
		try {
			data = Client.conn.getListPaymentTuition();
//			data.add(0, "Choice Tuition...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new DisconnectToExit();
			e.printStackTrace();
		}
		
		return data;
	}
}

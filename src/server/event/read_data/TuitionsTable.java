package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;

import server.Server;

import com.sun.rowset.JdbcRowSetImpl;

public class TuitionsTable {
	public Statement stmt;
	public ResultSet rst;
	public JdbcRowSet jrst;

	public TuitionsTable() {
		try {
			stmt = Server.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from tuitions";
			rst = stmt.executeQuery(sql);
			jrst = new JdbcRowSetImpl(rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public boolean isPaymentTuition(float payment){
		boolean check = false;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getFloat("payment") == payment) {
					check = true;
					break;
				}else{
					check = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getFullCollection() {
		Vector FullCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				Vector data = new Vector();
				data.add(jrst.getInt("id"));
				data.add(jrst.getFloat("payment"));
				FullCollection.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return FullCollection;
	}

	public Vector<Integer> getIdCollection() {
		Vector<Integer> nameCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				nameCollection.add(jrst.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nameCollection;
	}

	public Vector<Float> getPaymentCollection() {
		Vector<Float> paymentCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				paymentCollection.add(jrst.getFloat("payment"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paymentCollection;
	}

	public boolean deleteTuition(int id) {
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("id") == id) {
					jrst.deleteRow();
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addTuition(Float payment){
		
		try {
			jrst.moveToInsertRow();
			jrst.updateFloat("payment", payment);
			jrst.insertRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateTuiton(int id, Float payment) {
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("id") == id) {
					jrst.updateFloat("payment", payment);
					jrst.updateRow();
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

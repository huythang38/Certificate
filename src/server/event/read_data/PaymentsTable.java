package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;

import server.Server;

import com.sun.rowset.JdbcRowSetImpl;

public class PaymentsTable {
	public Statement stmt;
	public ResultSet rst;
	public JdbcRowSet jrst;

	public PaymentsTable() {
		try {
			stmt = Server.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from payments";
			rst = stmt.executeQuery(sql);
			jrst = new JdbcRowSetImpl(rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public Float getPaid(int students_id) {
		Float _return = null;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("students_id") == students_id) {
					_return = jrst.getFloat("paid");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			_return = 0f;
		}
		return _return;
	}
	
	public boolean enterPayment(int students_id, Float newPaid) {
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("students_id") == students_id) {
					jrst.updateFloat("paid", newPaid);
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

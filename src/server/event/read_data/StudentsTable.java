package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

import server.Server;

public class StudentsTable {
	public Statement stmt;
	public ResultSet rst;
	public JdbcRowSet jrst;

	public StudentsTable() {
		try {
			stmt = Server.conn.createStatement();
			String sql = "select * from students";
			rst = stmt.executeQuery(sql);
			jrst = new JdbcRowSetImpl(rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public Vector<Integer> getAccounts_idCollection(int index) {
		Vector<Integer> accounts_idCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if (jrst.getInt("class_id") == index){
					accounts_idCollection.add(jrst.getInt("accounts_id"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts_idCollection;
	}

	public Vector<String> getNameCollection(int index) {
		Vector<String> nameCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if (jrst.getInt("class_id") == index){
					nameCollection.add(jrst.getString("name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nameCollection;
	}
	
	public String getEmail(String email) {
		String returnValue = null;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if ((jrst.getString("email")).equals(email)){
					returnValue = jrst.getString("email");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public int getAccounts_id(String email) {
		int returnValue = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if ((jrst.getString("email")).equals(email)){
					returnValue = jrst.getInt("accounts_id");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public String getName(String email) {
		String returnValue = null;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if ((jrst.getString("email")).equals(email)){
					returnValue = jrst.getString("name");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
}

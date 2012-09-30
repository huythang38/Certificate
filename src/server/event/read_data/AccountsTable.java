package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

import server.Server;

public class AccountsTable {
	public Statement stmt;
	public ResultSet rst;
	public JdbcRowSet jrst;
	
	public AccountsTable() {
		try {
			stmt = Server.conn.createStatement();
			String sql = "select * from accounts";
			rst = stmt.executeQuery(sql);
			jrst = new JdbcRowSetImpl(rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public int getId(String username) {
		int returnValue = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if ((jrst.getString("username")).equals(username)){
					returnValue = jrst.getInt("id");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public String getUsername(int id) {
		String returnValue = null;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if (jrst.getInt("id") == id){
					returnValue = jrst.getString("username");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public String getUsername(String username) {
		String returnValue = null;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if ((jrst.getString("username")).equals(username)){
					returnValue = jrst.getString("username");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public String getPassword(int id) {
		String returnValue = null;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if (jrst.getInt("id") == id){
					returnValue = jrst.getString("password");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public String getPassword(String pass) {
		String returnValue = null;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if ((jrst.getString("password")).equals(pass)){
					returnValue = jrst.getString("password");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public int getStatus(int id) {
		int returnValue = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if (jrst.getInt("id") == id){
					returnValue = jrst.getInt("status");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public int getRole(int id) {
		int returnValue = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if (jrst.getInt("id") == id){
					returnValue = jrst.getInt("role");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public void updateStatus(int value){
		try {
			jrst.next();
			jrst.updateInt("status", value);
			jrst.updateRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
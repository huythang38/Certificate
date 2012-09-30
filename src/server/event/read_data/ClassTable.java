package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

import server.Server;

public class ClassTable {
	public Statement stmt;
	public ResultSet rst;
	public JdbcRowSet jrst;
	public Vector<Integer> idCollection = new Vector<>();
	public Vector<String> nameCollection = new Vector<>();
	
	public ClassTable() {
		try {
			stmt = Server.conn.createStatement();
			String sql = "select * from class";
			rst = stmt.executeQuery(sql);
			jrst = new JdbcRowSetImpl(rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public Vector<Integer> getIDCollection(int index) {
		Vector<Integer> idCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if (jrst.getInt("courses_id") == index){
					idCollection.add(jrst.getInt("id"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idCollection;
	}
	
	public Vector<String> getNameCollection(int index) {
		Vector<String> nameCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()){
				if (jrst.getInt("courses_id") == index){
					nameCollection.add(jrst.getString("name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nameCollection;
	}
}

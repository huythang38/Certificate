package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;

import server.Server;

import com.sun.rowset.JdbcRowSetImpl;

public class CoursesTable {
	public Statement stmt;
	public ResultSet rst;
	public JdbcRowSet jrst;

	public CoursesTable() {
		try {
			stmt = Server.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from courses";
			rst = stmt.executeQuery(sql);
			jrst = new JdbcRowSetImpl(rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public boolean isNameCourse(String name){
		boolean check = false;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getString("name").equals(name)) {
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
				data.add(jrst.getString("name"));
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

	public Vector<String> getNameCollection() {
		Vector<String> nameCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				nameCollection.add(jrst.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nameCollection;
	}

	public boolean deleteCourse(int id) {
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
	
	public boolean addCourse(String name){
		
		try {
			jrst.moveToInsertRow();
			jrst.updateString("name", name);
			jrst.insertRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateCourse(int id, String name) {
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("id") == id) {
					jrst.updateString("name", name);
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

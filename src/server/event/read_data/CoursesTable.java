package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

import server.Server;

public class CoursesTable {
	public Statement stmt;
	public ResultSet rst;
	public JdbcRowSet jrst;

	public CoursesTable() {
		try {
			stmt = Server.conn.createStatement(
			           ResultSet.TYPE_SCROLL_SENSITIVE,
			           ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from courses";
			rst = stmt.executeQuery(sql);
			jrst = new JdbcRowSetImpl(rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public Vector<String> getNameCollection() {
		Vector<String> course_idCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				course_idCollection.add(jrst.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return course_idCollection;
	}
}

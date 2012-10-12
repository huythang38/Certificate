package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;

import server.Server;

import com.sun.rowset.JdbcRowSetImpl;

public class RecordsTable {
	public Statement stmt;
	public ResultSet rst;
	public JdbcRowSet jrst;

	public RecordsTable() {
		try {
			stmt = Server.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from records";
			rst = stmt.executeQuery(sql);
			jrst = new JdbcRowSetImpl(rst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public boolean newRecord(int students_id, int subjects_id) {
		try {
			jrst.moveToInsertRow();
			jrst.updateInt("students_id", students_id);
			jrst.updateInt("subjects_id", subjects_id);
			jrst.updateInt("mark", 0);
			jrst.insertRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateRecord(int students_id, int subjects_id, int mark) {
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("students_id") == students_id) {
					if (jrst.getInt("subjects_id") == subjects_id) {
						jrst.updateInt("students_id", students_id);
						jrst.updateInt("subjects_id", subjects_id);
						jrst.updateInt("mark", mark);
						jrst.updateRow();
						return true;
					}
				}
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public int getMark(int students_id, int subjects_id) {
		int mark = 0;
		boolean check = false;

		try {
			jrst.beforeFirst();
			if (!jrst.next()) {
				newRecord(students_id, subjects_id);
			} else {
				jrst.beforeFirst();
				while (jrst.next()) {
					if (jrst.getInt("students_id") == students_id) {
						if (jrst.getInt("subjects_id") == subjects_id) {
							mark = jrst.getInt("mark");
							check = true;
							break;
						} else {
							check = false;
						}
					} else {
						check = false;
					}
				}
				if (!check) {
					newRecord(students_id, subjects_id);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mark;
	}
}
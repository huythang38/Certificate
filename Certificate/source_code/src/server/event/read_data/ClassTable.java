package server.event.read_data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

import server.Server;

public class ClassTable {
	/**
	 * @uml.property  name="stmt"
	 */
	public Statement stmt;
	/**
	 * @uml.property  name="rst"
	 */
	public ResultSet rst;
	/**
	 * @uml.property  name="jrst"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public JdbcRowSet jrst;
	/**
	 * @uml.property  name="idCollection"
	 */
	public Vector<Integer> idCollection = new Vector<>();
	/**
	 * @uml.property  name="nameCollection"
	 */
	public Vector<String> nameCollection = new Vector<>();

	public ClassTable() {
		try {
			stmt = Server.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
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
			while (jrst.next()) {
				if (jrst.getInt("courses_id") == index) {
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
			while (jrst.next()) {
				if (jrst.getInt("courses_id") == index) {
					nameCollection.add(jrst.getString("name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nameCollection;
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
				data.add(jrst.getInt("courses_id"));
				data.add(jrst.getInt("size"));
				data.add(jrst.getInt("year"));
				FullCollection.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return FullCollection;
	}

	public boolean deleteClass(int id) {
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

	public boolean addClass(String name, int courses_id, int size, int year) {

		try {
			jrst.moveToInsertRow();
			jrst.updateString("name", name);
			jrst.updateInt("courses_id", courses_id);
			jrst.updateInt("size", size);
			jrst.updateInt("year", year);
			jrst.insertRow();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateClass(int id, String name, int courses_id, int size,
			int year) {
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("id") == id) {
					jrst.updateString("name", name);
					jrst.updateInt("courses_id", courses_id);
					jrst.updateInt("size", size);
					jrst.updateInt("year", year);
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

	public boolean isClass(String name, int courses_id) {
		boolean check = false;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getString("name").equals(name)) {
					if (jrst.getInt("courses_id") == courses_id) {
						check = true;
						break;
					} else {
						check = false;
					}
				} else {
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
	
	public String getName(int id) {
		String _return = null;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("id") == id) {
					_return = jrst.getString("name");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _return;
	}
	
	public int getCourses_id(int id) {
		int _return = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("id") == id) {
					_return = jrst.getInt("courses_id");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _return;
	}
	
	public int getId(String name) {
		int _return = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getString("name").equals(name)) {
					_return = jrst.getInt("id");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _return;
	}
}

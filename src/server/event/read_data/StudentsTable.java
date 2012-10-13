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
			stmt = Server.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
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
			while (jrst.next()) {
				if (jrst.getInt("class_id") == index) {
					accounts_idCollection.add(jrst.getInt("accounts_id"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accounts_idCollection;
	}

	public Vector<String> getNameCollection(int class_id) {
		Vector<String> nameCollection = new Vector<>();
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("class_id") == class_id) {
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
			while (jrst.next()) {
				if ((jrst.getString("email")).equals(email)) {
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
			while (jrst.next()) {
				if ((jrst.getString("email")).equals(email)) {
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
			while (jrst.next()) {
				if ((jrst.getString("email")).equals(email)) {
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getName_ID_CandidateId_Collection(int class_id) {
		Vector collection = new Vector();
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("class_id") == class_id) {
					Vector collection1 = new Vector<>();
					collection1.add(jrst.getString("name"));
					collection1.add(jrst.getInt("candidates_id"));
					collection1.add(jrst.getInt("id"));

					collection.add(collection1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return collection;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getFullData(int class_id) {
		Vector collection = new Vector();
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("class_id") == class_id) {
					Vector collection1 = new Vector<>();

					collection1.add(jrst.getInt("id"));
					collection1.add(jrst.getString("name"));
					collection1.add(jrst.getString("address"));
					collection1.add(jrst.getInt("gender"));
					collection1.add(jrst.getDate("birthday"));
					collection1.add(jrst.getString("email"));
					collection1.add(jrst.getInt("phone_number"));
					collection1.add(jrst.getInt("candidates_id"));
					collection1.add(jrst.getInt("class_id"));
					collection1.add(jrst.getInt("accounts_id"));

					collection.add(collection1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return collection;
	}

	public boolean updateStudent(int id, String name, String address,
			int gender, String birthday, String email, int phone,
			int candidates_id, int class_id) {
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if (jrst.getInt("id") == id) {
					jrst.updateString("name", name);
					jrst.updateString("address", address);
					jrst.updateInt("gender", gender);
					jrst.updateString("birthday", birthday);
					jrst.updateString("email", email);
					jrst.updateInt("phone_number", phone);
					jrst.updateInt("candidates_id", candidates_id);
					if (class_id == 0) {
						jrst.updateNull("class_id");
					} else {
						jrst.updateInt("class_id", class_id);
					}
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

	public int getAccounts_id(int id) {
		int returnValue = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if ((jrst.getInt("id")) == id) {
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

	public boolean createStudent(String name, String address, int gender,
			String birthday, String email, int phone, int candidates_id,
			int class_id, int accounts_id) {
		try {
			jrst.moveToInsertRow();
			jrst.updateString("name", name);
			jrst.updateString("address", address);
			jrst.updateInt("gender", gender);
			jrst.updateString("birthday", birthday);
			jrst.updateString("email", email);
			jrst.updateInt("phone_number", phone);
			jrst.updateInt("accounts_id", accounts_id);
			jrst.updateInt("candidates_id", candidates_id);
			if (class_id == 0) {
				jrst.updateNull("class_id");
			} else {
				jrst.updateInt("class_id", class_id);
			}
			jrst.insertRow();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int getIdLast() {
		int returnValue = 0;
		try {
			jrst.afterLast();
			jrst.last();
			returnValue = jrst.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	public int getId(String name) {
		int returnValue = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if ((jrst.getString("name")).equals(name)) {
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
	
	public int getId(String name, int class_id) {
		int returnValue = 0;
		try {
			jrst.beforeFirst();
			while (jrst.next()) {
				if ((jrst.getString("name").equals(name)) && (jrst.getInt("class_id") == class_id)) {
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
}

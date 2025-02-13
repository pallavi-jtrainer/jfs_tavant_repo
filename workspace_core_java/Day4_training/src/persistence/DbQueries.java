package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Users;

/**
 * class for Db queries for users table
 * @author Pallavi
 */
public class DbQueries {
	
	/**
	 * private method to retrieve the last row from the table
	 * @return Users object
	 */
	private static Users getLastRow() {
		String sql = "SELECT * FROM USERS ORDER BY USERID DESC LIMIT 1";
		Users user = new Users();
		
		Connection connection = DbConnection.getDbConnection();
		if(connection != null) {
			try {
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					user.setUserId(rs.getLong("USERID"));
					user.setFirstName(rs.getString("FIRSTNAME"));
					user.setLastName(rs.getString("LASTNAME"));
				}
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage() + ": " + e.getErrorCode());
			}
			
		}
		return user;
	}

	/**
	 * method to insert a new user
	 * @param user Users object
	 * @return integer
	 */
	public static int addUser(Users user) {
		String sql = "INSERT INTO USERS (USERID, FIRSTNAME, LASTNAME)"
				+ " VALUES (?,?,?)";
		
		int res = 0;
		long id = 0;
		
		Connection con = DbConnection.getDbConnection();
		PreparedStatement ps = null;
		if(con != null) {
			try {
				ps = con.prepareStatement(sql);
				Users u = getLastRow();
				if(u.getUserId() == 0)
					id = 101;
				else
					id = u.getUserId() + 1;
				
				user.setUserId(id);
				
				ps.setLong(1, id);
				ps.setString(2, user.getFirstName());
				ps.setString(3, user.getLastName());
				
				res = ps.executeUpdate(); //dml statement
				
//				ps.close();
//				con.close();
				
			} catch (SQLException e) {
				System.out.println(e.getErrorCode() +" " + e.getMessage());
			} finally {
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		return res;
	}
	
	public static List<Users> listAllUsers() {
		List<Users> users = new ArrayList<Users>();
		
		String sql = "SELECT * FROM USERS";
		
		Connection con = DbConnection.getDbConnection();
		Statement stmt = null;
		ResultSet rs = null;
		if(con != null) {
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Users user = new Users();
					user.setUserId(rs.getLong("USERID"));
					user.setFirstName(rs.getString("FIRSTNAME"));
					user.setLastName(rs.getString("LASTNAME"));
					
					users.add(user);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					rs.close();
					stmt.close();
					con.close();
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
			
		}
		return users;
	}
	
	public static Users getUserById(long id) {
		String sql = "SELECT * FROM USERS WHERE USERID = ?";
		Users user = new Users();
		
		Connection con = DbConnection.getDbConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					user.setUserId(rs.getLong("USERID"));
					user.setFirstName(rs.getString("FIRSTNAME"));
					user.setLastName(rs.getString("LASTNAME"));
					
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					rs.close();
					ps.close();
					con.close();
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
			
		}
		return user;
	}
	
	public static int updateUser(long id, String lname) {
		String sql = "UPDATE USERS SET LASTNAME = ? WHERE USERID = ?";
		
		Connection con = DbConnection.getDbConnection();
		PreparedStatement ps = null;

		int res = 0;
		
		if(con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, lname);
				ps.setLong(2, id);
				
				res = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					ps.close();
					con.close();
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
			
		}
		return res;
	}
	
	public static int deleteUser(long id) {
		String sql = "DELETE FROM USERS WHERE USERID = ?";
		
		Connection con = DbConnection.getDbConnection();
		PreparedStatement ps = null;

		int res = 0;
		
		if(con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				
				res = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					ps.close();
					con.close();
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
			
		}
		return res;
	}
}

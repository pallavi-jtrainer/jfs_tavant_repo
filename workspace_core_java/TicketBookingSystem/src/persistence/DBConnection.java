package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/ticketbookingdb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Pass1234";
	
	public static Connection getDbConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
}

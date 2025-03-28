package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection con = null;
	
	public static Connection getDbConnection() {
//		Connection con = null;
		
		final String URL = "jdbc:mysql://localhost:3306/usersdb";
		final String USERNAME = "root";
		final String PASSWORD = "Pass1234";
		
		try {
			//register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return con;
	}
}

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	private static String url = "jdbc:mysql://localhost:3306/bsm?serverTimezone=UTC";
	private static String user = "root";
	private static String password = "";
	
	private static Statement connect() {
		
		Connection connect;
		
		try {
			
			connect = DriverManager.getConnection(url, user, password);
			return connect.createStatement();
			
		} catch (SQLException e) {
			
			System.out.println("Connection Error!");
			e.printStackTrace();
			System.exit(0);
			return null;
		}
		
	}
	
	private static void closeConnection(Statement st) {
		try {
			
			st.close();
			
		} catch (SQLException e) {
			
			System.out.println("Closing Connection Error!");
			System.exit(0);
		}
	}
	
	public static ResultSet selectUsers() {
		
		Statement st = connect();
		ResultSet result = null;
		
		try {
			result = st.executeQuery("SELECT * FROM user");
			
		} catch (SQLException e) {
			System.out.println("Query Error!");
		}
		
		//closeConnection(st);
		
		return result;
	}

}

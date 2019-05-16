package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;

import bsm.User;

public class DataBase {
	
	private static String url = "jdbc:mysql://localhost:3306/bsm?serverTimezone=UTC";
	private static String user = "root";
	private static String password = "";
	
	/**
	 *	Connection Methods 
	 * 
	 */	
	public static Statement connect() {
		
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
	
	public static void closeConnection(Statement st) {
		try {
			
			st.close();
			
		} catch (SQLException e) {
			
			System.out.println("Closing Connection Error!");
			System.exit(0);
		}
	}
	
	/**
	 *	SELECT Methods 
	 * 
	 */	
	public static ResultSet selectUsers(Statement st) {
		
		ResultSet result = null;
		
		try {
			result = st.executeQuery("SELECT * FROM user INNER JOIN login ON user.email = login.email");
			
		} catch (SQLException e) {
			System.out.println("Query -SelectUsers- Error!");
		}
		
		return result;
	}
	
	public static ResultSet selectRooms(Statement st) {
		
		ResultSet result = null;
		
		try {
			result = st.executeQuery("SELECT * FROM room");
			
		} catch (SQLException e) {
			System.out.println("Query -SelectRooms- Error!");
		}
		
		return result;
	}
	
	public static ResultSet selectPermissionsByID(Statement st, String idUser) {
		
		ResultSet result = null;
		
		try {
			result = st.executeQuery("SELECT room.ID FROM room INNER JOIN permission ON room.ID = permission.IDRoom WHERE permission.IDUser = " + idUser);
			
		} catch (SQLException e) {
			System.out.println("Query -SelectPermission- Error!");
		}
		
		return result;
	}
	
	/**
	 *	INSERT Methods 
	 * 
	 */	
	public static boolean insertNewUser(Statement st, User u) {
		
		return true;
	}
	
	public static boolean insertNewRoom(Statement st, User u) {
		
		return true;
	}
	
	public static boolean insertPermissions(Statement st, ArrayList<String> permissionList) {
		
		return true;
	}
	
	/**
	 * DELETE Method
	 */
	public static boolean deleteUser(Statement st, String id) {
		
		int result = 0;
		
		try {
			result = st.executeUpdate("DELETE FROM user WHERE ID = " + id);
		} catch (SQLException e) {
			System.out.println("Query -DeleteUser- Error!");
		}
		
		return (result > 0);
	}
	
	public static boolean deleteRoom(Statement st, String id) {
		
		int result = 0;
		
		try {
			result = st.executeUpdate("DELETE FROM room WHERE ID = " + id);
		} catch (SQLException e) {
			System.out.println("Query -DeleteRoom- Error!");
		}
		
		return (result > 0);
	}
	
	public static boolean deletePermission(Statement st, String idUser, String idRoom) {
		
		int result = 0;
		
		try {
			result = st.executeUpdate("DELETE FROM permission WHERE IDUser = " + idUser + " AND IDRoom = " + idRoom);
		} catch (SQLException e) {
			System.out.println("Query -DeletePermission- Error!");
		}
		
		return (result > 0);
	}

}

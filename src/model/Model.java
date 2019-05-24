package model;

import java.sql.Statement;

import bsm.User;

public class Model {
	
	private Model() {}
	
	public static boolean insertNewUser(User newUser, String password) {
		
		Statement st = DataBase.connect();
		
		boolean result = DataBase.insertNewUser(st, newUser, password);
		
		DataBase.closeConnection(st);
		
		return result;
		
	}
	

}

package bsm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DataBase;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//hi
		System.out.println("ciao");
		System.out.println("ciao tutti");
		
		
		Statement st = DataBase.connect();
		ResultSet rs = DataBase.selectUsers(st);
		
		while(rs.next())
			System.out.println(rs.getString("firstName"));
		DataBase.closeConnection(st);
 	
	}	

}

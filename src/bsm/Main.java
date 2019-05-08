package bsm;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DataBase;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//hi
		System.out.println("ciao");
		System.out.println("ciao tutti");
		ResultSet rs = DataBase.selectUsers();
		rs.next();
		System.out.println(rs.getString("firstName"));
 	
	}

}

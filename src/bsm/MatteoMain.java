package bsm;

import java.sql.ResultSet;
import java.sql.Statement;

import model.DataBase;

public class MatteoMain {

	public static void main(String[] args) {
		Statement st = DataBase.connect();
		boolean rs = DataBase.deleteUser(st, "5");		
		System.out.println(rs);
		DataBase.closeConnection(st);

	}

}

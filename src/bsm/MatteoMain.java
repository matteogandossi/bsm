package bsm;

import java.sql.ResultSet;
import java.sql.Statement;

import model.DataBase;

public class MatteoMain {

	public static void main(String[] args) {
		Statement st = DataBase.connect();
		boolean rs = DataBase.deletePermission(st, "3","2");		
		System.out.println(rs);
		DataBase.closeConnection(st);

	}

}

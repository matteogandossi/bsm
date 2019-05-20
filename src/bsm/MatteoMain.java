package bsm;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import model.DataBase;

public class MatteoMain {

	public static void main(String[] args) {
		Statement st = DataBase.connect();
		/*Room r = new Room();
		r.setMaxSize(5);
		r.setName("newroom");*/
		User u = new User();
		u.setFirstName("Aldo");
		u.setLastName("Sem");
		u.setBirthPlace("Here");
		u.setDepartment("Officeee");
		u.setDesignation("Street");
		u.setEmailId("h@h");
		u.setMobileNumber("123156");
		u.setPetName("Ciao");
		u.setDateOfBirth("2000-11-21");
		boolean rs = DataBase.insertNewUser(st, u, "ciao");
		System.out.println(rs);
		DataBase.closeConnection(st);

	}

}

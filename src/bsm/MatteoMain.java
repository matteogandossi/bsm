package bsm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import controller.Server;
import controller.Status;
import model.DataBase;

public class MatteoMain {

	public static void main(String[] args) throws SQLException, UserNotFoundException {
		Statement st = DataBase.connect();
		/*Room r = new Room();
		r.setMaxSize(5);
		r.setName("newroom");*/
		/*User u = new User();
		u.setFirstName("Aldo");
		u.setLastName("Sem");
		u.setBirthPlace("Here");
		u.setDepartment("Officeee");
		u.setDesignation("Street");
		u.setEmailId("h@h");
		u.setMobileNumber("123156");
		u.setPetName("Ciao");
		u.setDateOfBirth("2000-11-21");
		boolean rs = DataBase.insertNewUser(st, u, "ciao");*/
		
		
		//Server server = new Server();
		//server.print();
		
		
		

	}

}

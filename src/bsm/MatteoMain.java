package bsm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
		
		ResultSet rs = DataBase.selectUsers(st);
		
		Status status = new Status();
		
		while(rs.next()) {
			
			User u = new User();
			
			u.setId(rs.getString("ID"));
			u.setFirstName(rs.getString("firstName"));
			u.setLastName(rs.getString("secondName"));
			u.setEmailId(rs.getString("email"));
			u.setDesignation(rs.getString("designation"));
			u.setDepartment(rs.getString("department"));
			u.setMobileNumber(rs.getString("mobileNumber"));
			u.setDateOfBirth(rs.getString("doB"));
			System.out.println(u.getId());
			status.addNewUser(u);
		}
		
		DataBase.closeConnection(st);
		
		Room r = new Room();
		r.setRoomName("hall");
		
		status.getUserStatus("2").login();
		status.getUserStatus("2").enterRoom(r);
		
		status.print();
		
		
		

	}

}

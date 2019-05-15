package bsm;

import java.sql.*;
import java.util.Scanner;
import java.math.BigDecimal;
public class Login{  
	
	
	
public static void main(String args[]){  
try{  
	int answer;
	String loginNameTemp = "";
	String passwordTemp = "";
	String rs1 = "";
	String rs2 = "";
	String temp1 = "";
	String temp2 = "";
	String temp3 = "";
	String tm1 = "";
	String tm2 = "";
	String tm3 = "";
	String passtemp = "";
	//Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bsm","root","");  
	Statement stmt=con.createStatement();  


	Scanner scanner = new Scanner(System.in);
	System.out.println("Do you want to 1.Login 2.Recovery");
	answer = scanner.nextInt();
	scanner.nextLine();

	if(answer == 1) {
		System.out.println("Please enter Email id ");
		loginNameTemp = scanner.nextLine();
		System.out.println("Please enter password ");
		passwordTemp = scanner.nextLine();
		ResultSet rs=stmt.executeQuery("select * from login WHERE email = '" + loginNameTemp + "'");
		while(rs.next()) {
			rs1 = rs.getString(1);
		    rs2 = rs.getString(2);}
		    if(rs1.equals(loginNameTemp) && rs2.equals(passwordTemp))
		{
		System.out.println("Access Granted! Welcome!");
		}
		else
		System.out.println("User name or password is wrong!");

	//ResultSet rs=stmt.executeQuery("select * from user");  
	//while(rs.next())
	//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)); 
	}
	else {
		System.out.println("Enter the Emailid");
 	    temp1 = scanner.nextLine();
 	    System.out.println("Please enter your first pet Name");
        temp2 = scanner.nextLine();
        System.out.println("Please enter your birth place");
        temp3 = scanner.nextLine();
        ResultSet rs=stmt.executeQuery("select * from login WHERE email = '" + temp1 + "'");
        while(rs.next()) {
			tm1 = rs.getString(1);
		    tm2 = rs.getString(3);
		    tm3 = rs.getString(4);}
        
		    if(tm1.equals(temp1) && tm2.equals(temp2) && tm3.equals(temp3))
		{
		System.out.println("Please enter new password!");
		passtemp = scanner.nextLine();
		int rsa=stmt.executeUpdate("update login set password = '" + passtemp + "' where email = '" + tm1 + "'");
		System.out.println("Password changed successfully!");
		}
		else
		System.out.println("User name or security questions are wrong!");
	}
	con.close();  
	}catch(Exception e){ System.out.println(e);}  

}  
}  






	
		
		

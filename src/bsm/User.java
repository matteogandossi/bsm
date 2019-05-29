/* package bsm;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class User { 
	private String firstName;
    private String lastName;
    private String id;
    private List<String> rooms;
    private String logIn;
    private String emailId;
    private String password;
    private String designation;
    private String department;
    private String mobileNumber;
    private String dateOfBirth;
    private String petName;
    private String birthPlace;
    //private String securityQuestion1;
    //private String securityQuestion2;
    
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getName() { return firstName + " " +  lastName; }
    
    public void setId(String id) { this.id = id; }
    public String getId() { return id; }

    public void setRooms(List<String> rooms) { this.rooms = rooms; }
    public List<String> getRooms() { return rooms; }

    public void setLogIn(String logIn) { this.logIn = logIn; }
    public String getLogIn() { return logIn; }
    
    public void setEmailId(String emailId) { this.emailId = emailId; }
    public String getEmailId() { return emailId; }
    
    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }
    
    public void setDepartment(String department) { this.department = department; }
    public String getDepartment() { return department; }
    
    public void setDesignation(String designation) { this.designation = designation; }
    public String getDesignation() { return designation; }
    
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public String getMobileNumber() { return mobileNumber; }
    
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getDateOfBirth() { return dateOfBirth; }
    
    public void setPetName(String petName) { this.petName = petName; }
    public String getPetName() { return petName; }
    
    public void setBirthPlace(String birthPlace) { this.birthPlace = birthPlace; }
    public String getBirthPlace() { return birthPlace; } 
    
   public void setSecurityQuestion1(String securityQuestion1) { this.securityQuestion1 = securityQuestion1; }
    public String getSecurityQuestion1() { return securityQuestion1; }
    
    public void setSecurityQuestion2(String securityQuestion2) { this.securityQuestion2 = securityQuestion2; }
    public String getSecurityQuestion2() { return securityQuestion2; }
    
    private void addRooms()
    {
    	Scanner scanner = new Scanner(System.in);
        List<String> rooms = new LinkedList<>();
        setRooms(rooms);

        String answer;
        int nextRooms;

        System.out.println("Do you want to add any Rooms? yes or no");
        answer = scanner.nextLine();
        while (!answer.toLowerCase().equals("no"))
        {
            if (answer.toLowerCase().equals("yes"))
            {
                System.out.println("Which rooms would you like to add now? Please choose from the following selection. " +
                        "Choose the number for the rooms");
                System.out.println("1. Room 101");
                System.out.println("2. Room 102");
                System.out.println("3. Room 103");
                System.out.println("4. Room 104");
                System.out.println("5. Room 105");

                if (scanner.hasNextInt())
                {
                    nextRooms = scanner.nextInt();
                    scanner.nextLine();
                    chooseRooms(rooms, nextRooms);

                } else {
                    System.out.println("You put in the wrong input: Enter a number 1 - 5 for each class");
                    scanner.nextLine();
                }

            } else {
                System.out.println("You put in the wrong input: Enter either yes or no next time");
            }

            System.out.println("Do you want to add any more rooms?");
            answer = scanner.nextLine();
        }
        
    }
    
    private void chooseRooms(List<String> rooms, int roomNumber)
    {
        switch (roomNumber)
        {
            case 1:
                if (checkDups(rooms, "Room 101"))
                	rooms.add("Room 101");
                break;
            case 2:
                if (checkDups(rooms, "Room 102"))
                	rooms.add("Room 102");
                break;
            case 3:
                if (checkDups(rooms, "Room 103"))
                	rooms.add("Room 103");
                break;
            case 4:
                if (checkDups(rooms, "Room 104"))
                	rooms.add("Room 104");
                break;
            case 5:
                if (checkDups(rooms, "Room 105"))
                	rooms.add("CRoom 105");
                break;
            default:
                System.out.println("You gave the wrong input");
                break;
        }
    }
    
    
    private boolean checkDups(List<String> list, String word)
    {
        for (String temp : list)
        {
            if (word.equals(temp))
            {
                System.out.println("You are already assigned that Room");
                return false;
            }
        }
        return true;
    }


    
    
    private void displayInfo() {
    	//System.out.println("User Name is " + user.getName());
    	
    }


public static void main(String[] args) {
    try {
    	
    	User user = new User();
        String firstName = "";
        String lastName = "";
        Scanner scanner = new Scanner(System.in);
        
    	System.out.println("Please enter your first name for user ");
        firstName = scanner.nextLine();
        user.setFirstName(firstName);
        
        System.out.println("Please enter your last name");
        lastName = scanner.nextLine();
        user.setLastName(lastName);
        
        user.addRooms();
        //user.displayInfo();
        System.out.println("User Name is " + user.getName());
        if (user.getRooms().size() > 0) {
            System.out.println("User's Current Rooms:" + user.getRooms());
        } else {
            System.out.println("User's Current Rooms: The User isn't assinged any Rooms");
        }
        
        
    	} 
    	catch (NegativeArraySizeException e) {
    		System.out.println("You can't use a negative number for size");
    	}

  }
} */



package bsm;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.DataBase;


public class User {
	private String firstName;
    private String lastName;
    private String id;
    private String[] rooms;
    private String logIn;
    private String emailId;
    private String password;
    private String designation;
    private String department;
    private String mobileNumber;
    private String dateOfBirth;
    private String securityQuestion1;
    private String securityQuestion2;

  //  private String roomName;
  //  private int maxSize;
   // private String roomPassword;
	Scanner scanner = new Scanner(System.in);
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getName() { return firstName + " " +  lastName; }
    
    public void setId(String id) { this.id = id; }
    public String getId() { return id; }

    public void setRooms(String[] rooms) { this.rooms = rooms; }
    public String[] getRooms() { return rooms; }

    public void setLogIn(String logIn) { this.logIn = logIn; }
    public String getLogIn() { return logIn; }
    
    public void setEmailId(String emailId) { this.emailId = emailId; }
    public String getEmailId() { return emailId; }
    
    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }
    
    public void setDepartment(String department) { this.department = department; }
    public String getDepartment() { return department; }
    
    public void setDesignation(String designation) { this.designation = designation; }
    public String getDesignation() { return designation; }
    
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public String getMobileNumber() { return mobileNumber; }
    
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getDateOfBirth() { return dateOfBirth; }
    
    public void setSecurityQuestion1(String securityQuestion1) { this.securityQuestion1 = securityQuestion1; }
    public String getSecurityQuestion1() { return securityQuestion1; }
    
    public void setSecurityQuestion2(String securityQuestion2) { this.securityQuestion2 = securityQuestion2; }
    public String getSecurityQuestion2() { return securityQuestion2; }
    
   /* public void setRoomName(String roomName) { this.roomName = roomName; }
    public String getRoomtName() { return roomName; }
    
    public void setMaxSize(int maxSize) { this.maxSize = maxSize; }
    public int getMaxSize() { return maxSize; }
    
    public void setRoomPassword(String roomPassword) { this.password = roomPassword; }
    public String getRoomPassword() { return roomPassword; } */
    
    

public void insertNewUser() { 
	
	User user = new User();
	System.out.println("Please enter your first name for user ");
    firstName = scanner.nextLine();
    user.setFirstName(firstName);
    
    System.out.println("Please enter your last name");
    lastName = scanner.nextLine();
    user.setLastName(lastName);
    
	System.out.println("Please enter user's Email-id");
	emailId = scanner.nextLine();
	user.setEmailId(emailId);
	
	System.out.println("Please enter user's Designation");
	designation = scanner.nextLine();
	user.setDesignation(designation);
	
	System.out.println("Please enter user's Department");
	department = scanner.nextLine();
	user.setDepartment(department);
	
	System.out.println("Please enter user's Mobile Number");
	mobileNumber = scanner.nextLine();
	user.setMobileNumber(mobileNumber);
	
	System.out.println("Please enter user's DateOfBirth");
	dateOfBirth = scanner.nextLine();
	user.setDateOfBirth(dateOfBirth);
	
	System.out.println("Please enter user's Password");
	password = scanner.nextLine();
	user.setPassword(password);
	
	System.out.println("Please enter user's First Pet Name");
	securityQuestion1 = scanner.nextLine();
	user.setSecurityQuestion1(securityQuestion1);
	
	System.out.println("Please enter user's Birth Place");
	securityQuestion2 = scanner.nextLine();
	user.setSecurityQuestion2(securityQuestion2);

    Statement st = DataBase.connect();
	DataBase.insertNewUser(st,user,user.password) ;

}

public void deleteUser() throws SQLException { 
	
	User user = new User();
	String answer;
	Statement st = DataBase.connect();
	ResultSet rs = DataBase.showUsers(st);
	while(rs.next())
    System.out.println(rs.getString("ID") + ".  " + rs.getString("firstName") + " " + rs.getString("SecondName")+ " " + rs.getString("email")); 
	System.out.println("Please enter your user id delete user profile ");
    answer = scanner.nextLine();
    ResultSet rs1 = DataBase.userExist(st,answer);
	if(rs1.next())
	{
	String tempEmail = rs1.getString("email");
    DataBase.deleteUser(st,answer);
    DataBase.deleteUserPermission(st,answer);
    DataBase.deleteLogin(st,tempEmail);
    System.out.println("Deleted the profile succesfully ");
	}
	else { System.out.println("User Id is doesn't exist");}
}

/*public void insertNewRoom() { 
	User user = new User();
	System.out.println("Please enter Room Name ");
    roomName = scanner.nextLine();
    user.setRoomName(roomName);
    
    System.out.println("Please enter Room's Maximum Size ");
    maxSize = scanner.nextInt();
    user.setMaxSize(maxSize);
    
    System.out.println("Please enter Room Password");
	roomPassword = scanner.nextLine();
	user.setRoomPassword(roomPassword);
	
	Statement st = DataBase.connect();
	DataBase.insertNewRoom(st,user,user.roomPassword) ;
    
}

public boolean checkRoomPassword(String input) { 

    if (input.equals(roomPassword)) {
        return true;
    } 
    return false;
} */



public void addremovePermission() throws SQLException { 
	User user = new User();
	String permissionAnswer;
	String permissionUserId;
	String choosenRoom;

    System.out.println("Do you want to add or remove permission");
    permissionAnswer = scanner.nextLine();
        if (permissionAnswer.toLowerCase().equals("add"))
        {
            System.out.println("Please enter user-id of User to add permission");
            permissionUserId = scanner.nextLine();
            Statement st = DataBase.connect();
            ResultSet rs = DataBase.userExist(st,permissionUserId);
        	if(rs.next())
        	{
        		Statement st1 = DataBase.connect();
        		ResultSet rs1 = DataBase.selectRooms(st1);
        		while(rs1.next())
        	    System.out.println(rs1.getString("ID") + ".  " + rs1.getString("name")); 
        		System.out.println("Choose the number for the rooms to add permission");
        		choosenRoom = scanner.nextLine();
        		ResultSet rs2 = DataBase.duplicatePermission(st1,permissionUserId,choosenRoom);
        		if(rs2.next())
            	{
        			System.out.println("User already has permission to this room");
            	}
        		else
        		{
        			DataBase.insertPermissions(st1,permissionUserId,choosenRoom) ;
        			System.out.println("Added permission succesfully");
        		}
        		}
        	else { System.out.println("User Id is doesn't exist");}
            
        }
        else
        {
        	System.out.println("Please enter user-id of User to remove permission");
            permissionUserId = scanner.nextLine();
            Statement st = DataBase.connect();
            ResultSet rs = DataBase.userExist(st,permissionUserId);
        	if(rs.next())
        	{
        		Statement st1 = DataBase.connect();
        		ResultSet rs1 = DataBase.selectRooms(st1);
        		while(rs1.next())
        	    System.out.println(rs1.getString("ID") + ".  " + rs1.getString("name")); 
        		System.out.println("Choose the number for the rooms to remove permission");
        		choosenRoom = scanner.nextLine();
        		ResultSet rs2 = DataBase.duplicatePermission(st1,permissionUserId,choosenRoom);
        		if(rs2.next())
            	{
        			DataBase.deletePermission(st1,permissionUserId,choosenRoom);
        			System.out.println("Removed permission succesfully");
            	}
        		else
        		{
        			System.out.println("Invalid room number");
            	}
        	}
        	else{System.out.println("User Id is doesn't exist");}
        }
}


public void allStatus() { 

}



public void userLogedIn() { 

}


public void possionOfUsers() { 

}

public static void main(String[] args) throws SQLException {
	
	User user = new User();
	Room room= new Room();
	Scanner scanner = new Scanner(System.in);
	//user.insertNewUser();
	//user.addremovePermission();
	//user.deleteUser();
	int choosedOption;
	System.out.println("Please enter opration number wish to perform");
	System.out.println("1. Insert New User");
    System.out.println("2. Delete User");
    System.out.println("3. Insert New Room");
    System.out.println("4. Delete Room");
    System.out.println("5. Update Room Password");
    System.out.println("6. Add/Remove permission");
    choosedOption = scanner.nextInt();
    switch (choosedOption)
    {
        case 1:
        	user.insertNewUser();
            break;
        case 2:
            user.deleteUser();
            break;
        case 3:
            room.insertNewRoom();
            break;
        case 4:
            room.deleteRoom();
            break;
        case 5:
        	room.updateRoomPassword();
            break;
        case 6:
        	user.addremovePermission();
            break;
        default:
            System.out.println("You gave the wrong input");
            break;
    }
}

}


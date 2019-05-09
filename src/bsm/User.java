package bsm;
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
    private String department;
    private String mobileNumber;
    private String dateOfBirth;
    
    private void setFirstName(String firstName) { this.firstName = firstName; }
    private void setLastName(String lastName) { this.lastName = lastName; }
    private String getName() { return firstName + " " +  lastName; }
    
    private void setId(String id) { this.id = id; }
    private String getId() { return id; }

    private void setRooms(List<String> rooms) { this.rooms = rooms; }
    private List<String> getRooms() { return rooms; }

    private void setLogIn(String logIn) { this.logIn = logIn; }
    private String getLogIN() { return logIn; }
    
    private void setEmailId(String emailId) { this.emailId = emailId; }
    private String getEmailId() { return emailId; }
    
    private void setPassword(String passwor) { this.password = password; }
    private String getPassword() { return password; }
    
    private void setDepartment(String department) { this.department = department; }
    private String getDepartment() { return department; }
    
    private void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    private String getMobileNumber() { return mobileNumber; }
    
    private void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    private String getDateOfBirth() { return dateOfBirth; }
    
    
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
}
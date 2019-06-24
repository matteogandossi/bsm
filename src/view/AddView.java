package view;

import bsm.Room;
import bsm.User;

public class AddView extends BasicView {
	
	private AddView() {}
	
	public static User newUser() {
		
		User newUser = new User();
		
		System.out.println("Add new user.");
		System.out.print("Please enter the user's first name: ");
	    newUser.setFirstName(scanner.nextLine());
	    
	    System.out.print("Please enter the user's last name: ");
	    newUser.setLastName(scanner.nextLine());
	    
		System.out.print("Please enter the user's e-mail: ");
		newUser.setEmailId(scanner.nextLine());
		
		System.out.print("Please enter the user's designation: ");
		newUser.setDesignation(scanner.nextLine());
		
		System.out.print("Please enter the user's department: ");
		newUser.setDepartment(scanner.nextLine());
		
		System.out.print("Please enter the user's mobile number: ");
		newUser.setMobileNumber(scanner.nextLine());
		
		System.out.print("Please enter the user's date of birth (YYYY-MM-DD): ");
		newUser.setDateOfBirth(scanner.nextLine());
		
		System.out.print("Please enter the user's password: ");
		newUser.setPassword(scanner.nextLine());
		
		System.out.print("Please enter the user's first pet's name: ");
		newUser.setSecurityQuestion1(scanner.nextLine());
		
		System.out.print("Please enter the user's birth place: ");
		newUser.setSecurityQuestion2(scanner.nextLine());
		
		return newUser;
		
	}
	
	public static Room newRoom() {
		
		Room newRoom = new Room();
		
		System.out.println("Add new room.");
		System.out.print("Please enter the room's name: ");
		newRoom.setRoomName(scanner.nextLine());
		
		System.out.print("Please enter the room's capacity: ");
		newRoom.setMaxSize(scanner.nextInt());
		
		System.out.println("Do you want to set a password on this room? ");
		System.out.println("1) Yes\n0) No");
		int choiche = BasicView.askForChoice();
		
		if(choiche == 1) {
			System.out.print("Insert room's password: ");
			newRoom.setRoomPassword(scanner.nextLine());
		}
		
		return newRoom;	
		
		
	}
	

}

package view;

import bsm.Room;
import bsm.User;
import controller.Status;

public class AdminView{
	
	private AdminView() {}
		
	public static int mainMenu() {
		System.out.println("Select the operation... ");
		System.out.println("1) See Status of the building");
		System.out.println("2) Add new User/Room/Permission");
		System.out.println("3) Remove User/Room/Permission");
		System.out.println("4) Show User/Room");
		BasicView.backOrQuit("Quit");
		return BasicView.askForChoice();
	}
	
	public static void addMenu(Status status) {
		
		int choice;
		boolean outcome;
		
		System.out.println("Select what entity do you want to add...");
		System.out.println("1) User");
		System.out.println("2) Room");
		System.out.println("3) Permission");
		BasicView.backOrQuit("Back");
		
		choice = BasicView.askForChoice();
		
		switch (choice) {
		
			case 1:
				User user = AddView.newUser();
				outcome = status.addNewUser(user, user.getPassword());
				BasicView.confirmOrAbort(outcome);
				break;
			
			case 2:
				Room room = AddView.newRoom();
				outcome = status.addNewRoom(room, room.getRoomPassword());
				BasicView.confirmOrAbort(outcome);
				break;
			
			case 3:
				String idUser = SelectView.selectUser(status.getAllUsers());
				String idRoom = SelectView.selectRoom(status.getAllRoom());
				//ADD NEW PERMISSION
				break;

		default:
			break;
		}
		
		
	}
	
	public static int removeMenu() {
		
		System.out.println("Select what entity do you want to remove...");
		System.out.println("1) User");
		System.out.println("2) Room");
		System.out.println("3) Permission");
		BasicView.backOrQuit("Back");
		return BasicView.askForChoice();
	}
	
	public static int showMenu() {
		
		System.out.println("Select what entity do you want to see the details...");
		System.out.println("1) User");
		System.out.println("2) Room");
		BasicView.backOrQuit("Back");
		return BasicView.askForChoice();
	}
	
	

}

package view;

import java.util.ArrayList;

import bsm.Room;
import bsm.User;
import controller.RoomStatus;
import controller.Status;

public class ShowView {
	
	private ShowView() {}
	
	public static void showUser(User user) {
		
		System.out.println("Showing user with ID " + user.getId() + ".");
		System.out.println("Name: " + user.getName());
		System.out.println("Designation: " + user.getDesignation());
		System.out.println("Department: " + user.getDepartment());
		BasicView.pressEnterToContinue();
		
	}
	
	public static void showRoom(Room room) {
		
		System.out.println("Showing room with ID " + room.getId() + ".");
		System.out.println("Name: " + room.getRoomName());
		System.out.println("Maximum capacity: " + room.getMaxSize());
		System.out.println("Has a password? " + ((room.getRoomPassword() == null)?"YES":"NO"));
		BasicView.pressEnterToContinue();
		
	}
	
	public static void showAllPermissions(Status status) {
		
		System.out.println("Showing all permissions.");
		status.showAllPermissions();
		BasicView.pressEnterToContinue();
		
	}
	
	public static void showServerStatus(Status status) {
		
		System.out.println("Status of all server.");
		ArrayList<RoomStatus> list = status.getAllRoomsStatus();
		ArrayList<User> userList = status.getLoggedOrNotUsers(false);
		
		for(int i = 0; i < list.size(); i++)
			list.get(i).print();
		
		System.out.println("Not logged:");
		for(int i = 0; i < userList.size(); i++)
			System.out.println(userList.get(i).getName());
	}

}

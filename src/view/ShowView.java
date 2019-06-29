package view;

import java.util.ArrayList;

import bsm.Room;
import bsm.User;
import controller.RoomStatus;
import controller.Status;

public class ShowView {
	
	private ShowView() {}
	
	public static void showUser(User user, ArrayList<Room> permittedRooms) {
		
		System.out.println("Showing user with ID " + user.getId() + ".");
		System.out.println("Name: " + user.getName());
		System.out.println("DoB: "+ user.getDateOfBirth());
		System.out.println("E-mail:  " + user.getEmailId());
		System.out.println("Designation: " + user.getDesignation());
		System.out.println("Department: " + user.getDepartment());
	
		System.out.println("The user can enter the following rooms: ");
		for(Room pr : permittedRooms)
			System.out.println(pr.getRoomName());
		System.out.println("END.");
		
	}
	
	public static void showRoom(Room room, ArrayList<User> permittedUsers) {
		
		System.out.println("Showing room with ID " + room.getId() + ".");
		System.out.println("Name: " + room.getRoomName());
		System.out.println("Maximum capacity: " + room.getMaxSize());
		System.out.println("Has a password? " + ((room.getRoomPassword() == null)?"YES":"NO"));
		System.out.println("The room can be entered by the following users: ");
		for(User pu: permittedUsers)
			System.out.println(pu.getName());
		System.out.println("END.");
		
	}
	
	public static void showAllPermissions(Status status) {
		
		System.out.println("Showing all permissions.");
		status.showAllPermissions();
		
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

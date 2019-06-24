package view;

import java.util.ArrayList;

import bsm.Room;
import bsm.User;

public class SelectView{
	
	private SelectView() {}
	
	public static String selectUser(ArrayList<User> userList) {
		
		System.out.println("Select User.");
		
		for(int i = 0; i < userList.size(); i++) 
			System.out.println(userList.get(i).getId() + ") "
					+ userList.get(i).getName() + " - " + userList.get(i).getDepartment()
					+ " - " + userList.get(i).getDesignation());
		
		return BasicView.askForId();		
		
	}
	
	public static String selectRoom(ArrayList<Room> roomList) {
		
		System.out.println("Select Room.");
		
		for(int i = 0; i < roomList.size(); i++) 
			System.out.println(roomList.get(i).getId() + ") "
					+ roomList.get(i).getRoomName());
			
		return BasicView.askForId();		
		
	}
	

}

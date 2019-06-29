package view;

import java.util.ArrayList;

import bsm.Room;
import bsm.User;
import controller.RoomStatus;

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
	
	public static String selectRoom(ArrayList<RoomStatus> roomStatusList) {
		
		System.out.println("Select Room.");
		
		for(int i = 0; i < roomStatusList.size(); i++) 
			System.out.println(roomStatusList.get(i).getRoom().getId() + ") "
					+ roomStatusList.get(i).getRoom().getRoomName() + 
					"(" + roomStatusList.get(i).peopleInside() + "/" + roomStatusList.get(i).getRoom().getMaxSize() + ")");
			
		return BasicView.askForId();		
		
	}
	

}

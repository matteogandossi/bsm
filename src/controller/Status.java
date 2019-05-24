package controller;

import java.util.ArrayList;

import bsm.Room;
import bsm.RoomNotFoundException;
import bsm.User;
import bsm.UserNotFoundException;

public class Status {
	
	private ArrayList<UserStatus> userStatusList;
	private ArrayList<Room> roomList;
	
	public Status(){
		userStatusList = new ArrayList<UserStatus>();
		roomList = new ArrayList<Room>();
	}
	
	/*** 				USER 				***/
	
	private int findUser(String userId) throws UserNotFoundException {
		
		for(int i = 0; i < userStatusList.size(); i++)
			if(userStatusList.get(i).user.getId().equals(userId)) 
				return i;
		
		//if I cannot find it
		throw new UserNotFoundException();
				
	}
	
	public UserStatus getUserStatus(String userId) throws UserNotFoundException {
		
		return userStatusList.get(findUser(userId));
	}
	
	public boolean addNewUser(User newUser) {
		
		try {
			
			findUser(newUser.getId());
			
		} catch (UserNotFoundException e) {
			//if there is no user with that ID I can add them
			userStatusList.add(new UserStatus(newUser));
			return true;
		}
		
		return false;
	}
	
	public int userCount() {
		return userStatusList.size();
	}
	
	public void remove(String userId) throws UserNotFoundException {	

		userStatusList.remove(findUser(userId));
	}
	
	/*** 				ROOM				***/
	
	private int findRoom(String roomId) throws RoomNotFoundException {
		
		for(int i = 0; i < roomList.size(); i++)
			if(roomList.get(i).getId().equals(roomId)) 
				return i;
		
		//if I cannot find it
		throw new RoomNotFoundException();
				
	}
	
	public Room getRoom(String roomId) throws RoomNotFoundException {
		
		return roomList.get(findRoom(roomId));
	}
	
	public boolean addNewRoom(Room newRoom) {
		
		try {
			
			findRoom(newRoom.getId());
			
		} catch (RoomNotFoundException e) {
			//if there is no user with that ID I can add them
			roomList.add(newRoom);
			return true;
		}
		
		return false;
	}
	
	public int roomCount() {
		return roomList.size();
	}
	
	public void removeRoom(String roomId) throws RoomNotFoundException {	

		roomList.remove(findRoom(roomId));
	}
	
	
	public void print() {
		
		for(int i = 0; i < userCount(); i++)
			System.out.println(userStatusList.get(i));
		
	}
	
	//function to get status TODO
		
		
}

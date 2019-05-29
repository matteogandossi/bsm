package controller;

import java.util.ArrayList;

import bsm.Room;
import bsm.RoomNotFoundException;
import bsm.User;
import bsm.UserNotFoundException;
import model.Model;

public class Status {
	
	private ArrayList<UserStatus> userStatusList;
	private ArrayList<Room> roomList;
	
	public Status(){
		userStatusList = new ArrayList<UserStatus>();
		fillUserStatusList();
		roomList = Model.loadRooms();
	}
	
	private void fillUserStatusList() {
		
		ArrayList<User> userList = Model.loadUsers();
		
		for(int i = 0; i < userList.size(); i++)
			userStatusList.add(new UserStatus(userList.get(i)));			

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
	
	public boolean addNewUser(User newUser, String password) {
		
		try {
			
			findUser(newUser.getId());
			
		} catch (UserNotFoundException e) {
			//if there is no user with that ID I can add them
			userStatusList.add(new UserStatus(newUser));
			return Model.insertNewUser(newUser, password);
		}
		
		return false;
	}
	
	public boolean updateUserPassword(String idUser, String newPassword) throws UserNotFoundException {
		
		User currentUser = userStatusList.get(findUser(idUser)).user;
		currentUser.setPassword(Model.getHashedPassword(newPassword));
		
		return  Model.updateUserPassword(currentUser.getEmailId(), newPassword);
		
	}
	
	public int userCount() {
		return userStatusList.size();
	}
	
	public void remove(String userId) throws UserNotFoundException {	

		userStatusList.remove(findUser(userId));
		Model.deleteUser(userId);
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
	
	public boolean addNewRoom(Room newRoom, String password) {
		
		try {
			
			findRoom(newRoom.getId());
			
		} catch (RoomNotFoundException e) {
			//if there is no user with that ID I can add them
			roomList.add(newRoom);
			return Model.insertNewRoom(newRoom, password);
		}
		
		return false;
	}
	
	public int roomCount() {
		return roomList.size();
	}
	
	public boolean updateRoomPassword(String idRoom, String newPassword) throws RoomNotFoundException {
		
		Room currentRoom = roomList.get(findRoom(idRoom));
		currentRoom.setRoomPassword(Model.getHashedPassword(newPassword));
		return Model.updateRoomPassword(idRoom, newPassword);
		
	}
	
	public void removeRoom(String roomId) throws RoomNotFoundException {	
		
		roomList.remove(findRoom(roomId));
		Model.deleteRoom(roomId);
		
	}
	
	/***				MIXED				***/	
	
	public ArrayList<User> getAllUsers(){
		
		ArrayList<User> list = new ArrayList<User>();
		
		for(int i = 0; i < userStatusList.size(); i++)
			list.add(userStatusList.get(i).user);
		
		return list;
	}
	
	public ArrayList<User> getLoggedOrNotUsers(boolean logged){
		
		ArrayList<User> list = new ArrayList<User>();
		
		for(int i = 0; i < userStatusList.size(); i++)
			if(logged == userStatusList.get(i).isLogged())
				list.add(userStatusList.get(i).user);		
		
		return list;
		
	}
	
	public ArrayList<RoomStatus> getAllRoomsStatus(){
		
		ArrayList<RoomStatus> list = new ArrayList<RoomStatus>();
		
		for(int i = 0; i < roomList.size(); i++) {
			
			list.add(new RoomStatus(roomList.get(i)));
			
			for(int j = 0; j < userStatusList.size(); j++)				
				if(userStatusList.get(j).getCurrentRoom() == roomList.get(i))
					list.get(i).add(userStatusList.get(j).user);			
		}
		
		return list;
	}
	
	
	public void print() {
		
		for(int i = 0; i < userCount(); i++)
			System.out.println(userStatusList.get(i));
		
	}
	
	//function to get status TODO
		
		
}

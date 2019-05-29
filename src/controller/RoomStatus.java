package controller;

import java.util.ArrayList;

import bsm.Room;
import bsm.User;

public class RoomStatus {
	
	private Room r;
	private ArrayList<User> listUser;
	
	public RoomStatus(Room r, ArrayList<User> listUser) {
		this.r = r;
		this.listUser = listUser;
	}
	
	public RoomStatus(Room r) {
		this.r = r;
		this.listUser = new ArrayList<User>();
	}
	
	public Room getRoom() {
		return r;
	}
	
	public int peopleInside() {
		return listUser.size();
	}
	
	public void add(User newUser) {
		listUser.add(newUser);
	}
	
	public ArrayList<User> getUsers(){
		return listUser;
	}
	
	public void print() {
		
		System.out.println("In room '" + r.getRoomName() + "':");
		
		if(peopleInside() == 0)
			System.out.println("No one.");
		
		for(int i = 0; i < listUser.size(); i++)
			System.out.println(listUser.get(i).getName());
		
	}

}

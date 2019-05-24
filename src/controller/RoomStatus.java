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
	
	public Room getRoom() {
		return r;
	}
	
	public int peopleInside() {
		return listUser.size();
	}
	
	public ArrayList<User> getUsers(){
		return listUser;
	}

}

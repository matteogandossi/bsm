package controller;
import java.util.ArrayList;
import bsm.Room;

public class SynchStatus {
	private UserStatus userStatus;
	private ArrayList<Room> roomList;
	private ArrayList<Integer> presentList;
	
	public SynchStatus(UserStatus userStatus,ArrayList<Room> roomList,ArrayList<Integer> presentList)
	{
		this.userStatus = userStatus;
		this.roomList = roomList;
		this.presentList = presentList;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public ArrayList<Integer> getPresentList() {
		return presentList;
	}


}

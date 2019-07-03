package controller;
import java.io.Serializable;
import java.util.ArrayList;
import bsm.RoomCount;

public class SynchStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private UserStatus userStatus;
	private ArrayList<RoomCount> roomCountList;
	
	public SynchStatus(UserStatus userStatus,ArrayList<RoomCount> roomList)
	{
		this.userStatus = userStatus;
		this.roomCountList = roomList;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public ArrayList<RoomCount> getRoomList() {
		return roomCountList;
	}


}

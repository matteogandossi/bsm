package controller;

import java.util.ArrayList;

import bsm.User;

public class Server {
	
	private Status status;
	
	public Server() {
		status = new Status();
	}
	
	public void print() {
		System.out.println("Printing server status");
		
		ArrayList<RoomStatus> list = status.getAllRoomsStatus();
		ArrayList<User> userList = status.getLoggedOrNotUsers(false);
		
		for(int i = 0; i < list.size(); i++)
			list.get(i).print();
		
		System.out.println("Not logged:");
		for(int i = 0; i < userList.size(); i++)
			System.out.println(userList.get(i).getName());
	}

}

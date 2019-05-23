package bsm;
import java.util.Scanner;

import model.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Room {
	private String id;
    private String roomName;
    private int maxSize;
    private String roomPassword;
    Scanner scanner = new Scanner(System.in);
	

public void setId(String id) { this.id = id; }
public String getId() { return id; }

public void setRoomName(String roomName) { this.roomName = roomName; }
public String getRoomName() { return roomName; }

public void setMaxSize(int maxSize) { this.maxSize = maxSize; }
public int getMaxSize() { return maxSize; }

public void setRoomPassword(String roomPassword) { this.roomPassword = roomPassword; }

public boolean checkPassword(String input) { 

    if (input.equals(roomPassword)) {
        return true;
    } 
    return false;
}

public void insertNewRoom() { 
	Room room= new Room();
	System.out.println("Please enter Room Name ");
    roomName = scanner.nextLine();
    room.setRoomName(roomName);
    
    System.out.println("Please enter Room's Maximum Size ");
    maxSize = scanner.nextInt();
    room.setMaxSize(maxSize);
    
    System.out.println("Please enter Room Password");
	roomPassword = scanner.nextLine();
	room.setRoomPassword(roomPassword);
	
	Statement st = DataBase.connect();
	DataBase.insertNewRoom(st,room,room.roomPassword) ;
    
}

public void deleteRoom() throws SQLException { 
	
	Room room= new Room();
	String answer;
	Statement st = DataBase.connect();
	ResultSet rs = DataBase.selectRooms(st);
	while(rs.next())
    System.out.println(rs.getString("ID") + ".  " + rs.getString("name")); 
	System.out.println("Please enter your room id delete room profile ");
    answer = scanner.nextLine();
    ResultSet rs1 = DataBase.roomExist(st,answer);
	if(rs1.next())
	{
    DataBase.deleteRoom(st,answer);
    DataBase.deleteRoomPermission(st,answer);
    System.out.println("Deleted the profile succesfully ");
	}
	else { System.out.println("Room Id is doesn't exist");}
}

}
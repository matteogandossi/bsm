package threadServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import bsm.Room;
import bsm.RoomNotFoundException;
import bsm.UserNotFoundException;
import controller.Status;
import controller.UserStatus;
import message.ClientMessage;
import message.ServerMessage;
import model.Model;

public class ClientHandler extends Thread{
	
	private Socket socket;
	private Status status;
	
	public ClientHandler(Socket socket, Status status) {
		this.socket = socket;
		this.status = status;
	}
	
	public void run() {
	
		ClientMessage clientMessage = null;
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			System.out.println("Problem creating OOS or OIS from Client Server.");
		}
		
		try {
			clientMessage =  (ClientMessage) ois.readObject();
		} catch (Exception e) {
			System.out.println("Error receiving client message");
		}
		
		ServerMessage serverMessage = getAnswer(clientMessage);
		
		try {
			oos.writeObject(serverMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		try {
			socket.close();
		} catch (IOException e1) {
			System.out.println("Error closing synchthread socket");
		}
		
	}

	private ServerMessage getAnswer(ClientMessage clientMessage){
		
		ServerMessage serverMessage = null;
		
		switch(clientMessage.getType()) {
		
		
			case ClientMessage.LOGIN:
				
				try {
					
					UserStatus us = status.getUserStatusByEmail(clientMessage.getEmail());
					String hashedPassword = Model.getHashedPassword(clientMessage.getPassword());
					if(us.getUser().checkPassword(hashedPassword)) {
						us.login();
						return ServerMessage.createAcceptMessage(us);
					}
					else
						return ServerMessage.createRejectMessage("Wrong password.");
					
				} catch (UserNotFoundException e) {
	
					return ServerMessage.createRejectMessage("The user doesn't exist.");
				}
				
		case ClientMessage.RECOVERY:
				
			try {
				
				UserStatus us = status.getUserStatusByEmail(clientMessage.getEmail());
				String petName = clientMessage.getPetName();
				String birthPlace = clientMessage.getBirthPlace();
				
				if(us.getUser().getSecurityQuestion1().equals(petName) && us.getUser().getSecurityQuestion2().equals(birthPlace)) {
					if(status.updateUserPassword(clientMessage.getEmail(), clientMessage.getPassword()))
						return ServerMessage.createAcceptMessage(us);
					return ServerMessage.createRejectMessage("Something went wrong in Database");
				}
				
				return ServerMessage.createRejectMessage("Wrong security questions");
				
				} catch (UserNotFoundException e) {
					
					return ServerMessage.createRejectMessage("The user doesn't exist.");
				}
			
		case ClientMessage.ENTER:
			
			try {
				
				UserStatus us = status.getUserStatus(clientMessage.getIdUser());
				String idRoom = clientMessage.getIdRoom();
				Room room = status.getRoom(idRoom);
				String password = clientMessage.getPassword();
				
				if(us.isInside())
					return ServerMessage.createRejectMessage("The user is already inside a room");
				
				if(!status.isUserAllowed(clientMessage.getIdUser(), idRoom))
					return ServerMessage.createRejectMessage("The user is not allowed to enter that room.");
							
				if(password == null || 
						(password != null && room.checkPassword(Model.getHashedPassword(password)))) {
					
					if(!status.getRoomStatus(idRoom).isFull()) {
						us.enterRoom(status.getRoom(idRoom));
						return ServerMessage.createAcceptMessage(us);
					}
					else
						return ServerMessage.createRejectMessage("The room is full");
				}
				
				return ServerMessage.createRejectMessage("Wrong room password");					
				
				
			} catch (UserNotFoundException | RoomNotFoundException e) {
				
				return ServerMessage.createRejectMessage("User or room not found");
			}
			
		case ClientMessage.EXIT:
			
			try {
				UserStatus us = status.getUserStatus(clientMessage.getIdUser());
				
				if(!us.isInside())
					return ServerMessage.createRejectMessage("The user is already out");
				
				us.exitRoom();
				
				return ServerMessage.createAcceptMessage(us);
				
			} catch (UserNotFoundException e) {
				
				return ServerMessage.createRejectMessage("User not found");
			}
			
		case ClientMessage.LOGOUT:
			
			try {
				UserStatus us = status.getUserStatus(clientMessage.getIdUser());
				
				if(!us.isLogged())
					return ServerMessage.createRejectMessage("The user is not logged");
				
				us.logout();
				
				return ServerMessage.createAcceptMessage(us);
				
			} catch (UserNotFoundException e) {
				
				return ServerMessage.createRejectMessage("User not found");
			}
			
	
		}
		
		return serverMessage;
	}


}

package threadServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import bsm.Server;
import bsm.UserNotFoundException;
import controller.Status;
import message.ClientMessage;
import message.ServerMessage;

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
				System.out.println("Name " + clientMessage.getEmail());
			try {
				serverMessage = ServerMessage.createAcceptMessage(status.getUserStatus("5"));
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
	
	
		}
		return serverMessage;
	}


}

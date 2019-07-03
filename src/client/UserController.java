package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import bsm.Server;
import controller.SynchStatus;
import message.ClientMessage;
import message.ServerMessage;
import threadClient.SynchThread;
import view.BasicView;
import view.ClientView;

public class UserController {
	
	private SynchStatus synchStatus;
	private SynchThread synchThread;
	

	public UserController(SynchStatus synchStatus, SynchThread synchThread) {
		this.synchStatus = synchStatus;
		this.synchThread = synchThread;
	}
	
	private ServerMessage send(ClientMessage clientMessage) {
		
		Socket socket = null;
		ServerMessage serverMessage = null;
		
		try {
			socket = new Socket(Server.ADDRESS, Server.PORT);
		} catch (IOException e) {
			System.out.println("Error creating socket message");
			System.exit(0);
		}
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			System.out.println("Problem creating OOS or OIS from Client Server.");
		}
		
		try {
			oos.writeObject(clientMessage);
		} catch (IOException e) {
			System.out.println("Error send message client");
		}
		
		try {
			serverMessage = (ServerMessage) ois.readObject();
		} catch (Exception e) {
			System.out.println("Error receiving server message");
		}
		
		
		try {
			socket.close();
		} catch (IOException e1) {
			System.out.println("Error closing synchthread socket");
		}
		
		return serverMessage;
		
	}
	
	public boolean login() {
		
		String email = ClientView.getString("Insert your email: ");
		String password = ClientView.getString("Inserit your password: ");
		
		ClientMessage clientMessage = ClientMessage.createLoginMessage(email, password);
		
		ServerMessage serverMessage = send(clientMessage);
		boolean outcome = serverMessage.getType() == ServerMessage.ACCEPT;
		
		BasicView.confirmOrAbort(outcome);
		if(outcome) 
			synchThread.start();

		return outcome;
	}

	public void recoveryPassword() {
		
		String email = ClientView.getString("Insert your email: ");
		String petName = ClientView.getString("Insert your first pet's name: ");
		String birthPlace = ClientView.getString("Insert your birth place: ");
		String newPassword = ClientView.getString("Insert your new password: ");
		
		ClientMessage clientMessage = ClientMessage.createRecoveryMessage(email, petName, birthPlace, newPassword);
		
		ServerMessage serverMessage = send(clientMessage);
		boolean outcome = serverMessage.getType() == ServerMessage.ACCEPT;
		
		BasicView.confirmOrAbort(outcome);
		if(!outcome)
			System.out.println("");
		//fare una funzione sola,
		
	}
	
	
	

}

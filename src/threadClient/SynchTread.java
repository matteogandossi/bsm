package threadClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import bsm.Server;
import controller.SynchStatus;

public class SynchTread extends Thread {
	
	private SynchStatus synchStatus;
	private String idUser;
	
	private Socket socket;
	private boolean stop;
	
	public SynchTread(SynchStatus synchStatus) {
		
		this.synchStatus = synchStatus;
		stop = false;
		
	}
	
	public void setUserId(String idUser) {
		this.idUser = idUser;
	}
	
	public void stopSynching() {
		stop = true;
		
	}
	
	@Override
	public void run() {
		
		
		while(!stop) {
			
			try {
				socket = new Socket(Server.ADDRESS, Server.SYNCH_PORT);
			} catch (Exception e) {
				System.out.println("Error synch client.");
				System.exit(0);
			}
			
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			
			try {
				
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				
			} catch (IOException e) {
				System.out.println("Problem creating OOS or OIS from Client Synch.");
				return;
			}
			
			try {
				oos.writeObject(idUser);
			} catch (IOException e) {
				System.out.println("Error send idUser " + idUser);
				return;
			}
			try {
				synchStatus = (SynchStatus) ois.readObject();
			} catch (Exception e) {
				System.out.println("Error receive synchstatus of user " + idUser);
			}
			
			System.out.println(synchStatus.getUserStatus());
			System.out.println("Size: " + synchStatus.getRoomList().size());
			
			try {
				socket.close();
			} catch (IOException e1) {
				System.out.println("Error closing synchthread socket");
			}
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				return;
			}
			
		}
		
	}

}

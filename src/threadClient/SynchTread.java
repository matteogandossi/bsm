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
		try {
			socket = new Socket(Server.ADDRESS, Server.SYNCH_PORT);
		} catch (Exception e) {
			System.out.println("Error synch client.");
			System.exit(0);
		}
		
	}
	
	public void setUserId(String idUser) {
		this.idUser = idUser;
	}
	
	public void stopSynching() {
		stop = true;
		
	}
	
	@Override
	public void run() {
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			
			oos = (ObjectOutputStream) socket.getOutputStream();
			ois = (ObjectInputStream) socket.getInputStream();
			
		} catch (IOException e) {
			System.out.println("Problem creating OOS or OIS from Client Synch.");
			return;
		}
		
		while(!stop) {
			
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
			
		}
		
	}

}

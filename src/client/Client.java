package client;

import controller.SynchStatus;
import threadClient.SynchThread;
import threadClient.UserThread;

public class Client {
	
	public static void main(String[] args) {
		
		SynchStatus sstatus = new SynchStatus(null, null);		
		SynchThread st = new SynchThread(sstatus);
		UserThread ut = new UserThread(sstatus);
		ut.start();		
		
	}

}

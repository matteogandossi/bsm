package threadClient;

import controller.SynchStatus;

public class UserThread extends Thread {
	
	private SynchStatus synchStatus;
	private SynchTread synchThread;
	
	public UserThread(SynchStatus synchStatus) {
		this.synchStatus = synchStatus;
		synchThread = new SynchTread(synchStatus);
	}

}

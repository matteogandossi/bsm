package message;

import controller.SynchStatus;

public class SynchMessage implements Message {
	
	private SynchStatus synchStatus;
	
	public SynchMessage(SynchStatus synchStatus) {
		this.synchStatus = synchStatus;
	}
	
	public SynchStatus getSynchStatus() {
		return synchStatus;
	}

}

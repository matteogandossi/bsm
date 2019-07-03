package threadClient;

import client.UserController;
import controller.SynchStatus;
import view.BasicView;
import view.ClientView;

public class UserThread extends Thread {
	
	private SynchStatus synchStatus;
	private UserController userController;
	private SynchThread synchThread;
	private boolean logged;
	
	public UserThread(SynchStatus synchStatus) {
		this.synchStatus = synchStatus;
		synchThread = new SynchThread(synchStatus);
		userController = new UserController(synchStatus, synchThread);
		logged = false;
	}
	
	@Override
	public void run() {
		
		int choice;
		
		do {
			
			if(!logged) {
				
				choice = ClientView.notLoggedMenu(); 
				
				switch (choice) {
					
					case 1: //login
						logged = userController.login();						
						break;
					
					case 2: //recovery
						userController.recoveryPassword();
						break;
	
					default:
						break;
				}
				
				
			}
			else {
				
				choice = ClientView.loggedMenu(synchStatus.getUserStatus());
			}
			
			
			
		} while(choice!=0);
		
	}

}

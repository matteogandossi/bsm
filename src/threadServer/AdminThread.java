package threadServer;

import java.util.Scanner;

import controller.Admin;
import controller.Status;
import view.MenuView;

public class AdminThread extends Thread {
	
	private boolean stop;
	private Admin admin;
	
	
	public AdminThread(Status status, boolean stop) {
		this.stop = stop;
		admin = new Admin(status);
	}
	
	public void run() {
		
		int choice, internalChoice;
		
		
		do {
			
			choice = MenuView.mainMenu();					
			
			switch(choice) {
				
				case 1:
					admin.serverStatus();
					break;
				case 2:
					internalChoice = MenuView.addMenu();
					admin.add(internalChoice);
					break;
				case 3:
					internalChoice = MenuView.removeMenu();
					admin.remove(internalChoice);
					break;
				case 4:
					internalChoice = MenuView.showMenu();
					admin.show(internalChoice);
					break;
			}
			
		} while(choice != 0);
		
		stop = true;
		
		System.out.println("Goodbye.");
	}

}

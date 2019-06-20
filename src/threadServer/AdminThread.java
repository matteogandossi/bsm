package threadServer;

import java.util.Scanner;

import controller.Status;
import view.AdminView;

public class AdminThread extends Thread {
	
	private Status status;
	private boolean stop;
	
	private Scanner scanner;
	
	
	public AdminThread(Status status, boolean stop) {
		this.status = status;
		this.stop = stop;
		
		scanner = new Scanner(System.in);
	}
	
	public void run() {
		
		int choice;
		
		
		do {
			
			choice = AdminView.showMainMenu();					
			
			switch(choice) {
				
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
			}
			
		} while(choice != 0);
		
		stop = true;
	}

}

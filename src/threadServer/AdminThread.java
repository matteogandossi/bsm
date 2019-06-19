package threadServer;

import java.util.Scanner;

import controller.Status;

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
			
			choice = scanner.nextInt();
			
			
			switch(choice) {
				//...
			}
			
		} while(choice != 0);
		
		stop = true;
	}

}

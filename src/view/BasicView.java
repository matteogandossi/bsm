package view;

import java.util.Scanner;

public class BasicView {
	
	protected static Scanner scanner = new Scanner(System.in);

	public static int askForChoice() {
		
		System.out.print("Choice: ");
		return scanner.nextInt();
	}
	
	public static String askForId() {
		
		System.out.print("Id: ");
		return scanner.nextLine();
	}
	
	public static void backOrQuit(String str) {
		
		System.out.println();
		System.out.println("0) " + str);
		System.out.println();
	}
	
	public static void pressEnterToContinue() {
		
		System.out.print("Press ENTER to continue...");
		scanner.next();
	}
	
	public static void confirmOrAbort(boolean outcome) {
		if(outcome)
			System.out.println("Operation completed successfully.");
		else
			System.out.println("Operation NOT completed.");
	}

}

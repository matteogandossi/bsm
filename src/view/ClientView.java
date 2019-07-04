package view;

import java.util.Scanner;

import controller.UserStatus;

public class ClientView {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private ClientView() {}
	
	public static int notLoggedMenu() {
		
		System.out.println("Welcome to the BSM system.");
		System.out.println("Choose your operation.");
		System.out.println("1) Login");
		System.out.println("2) Recovery Password");
		BasicView.backOrQuit("Quit");
		
		return BasicView.askForChoice();
		
	}
	
	public static int loggedMenu(UserStatus us) {
		
		System.out.println("Hello " + us.getUser().getName() +"!");
		System.out.println(((!us.isInside())? "You are inside the building." : "You are in room \"" + us.getCurrentRoom().getRoomName() + "\"."));
		System.out.println("Choose your operation.");
		System.out.println("1) Enter a room");
		System.out.println("2) Exit room");
		System.out.println("3) Show my information");
		BasicView.backOrQuit("Logout");
		
		return BasicView.askForChoice();
		
	}

	public static String getString(String string) {
		
		System.out.print(string);
		return scanner.next();
	}

}

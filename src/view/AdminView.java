package view;

import java.util.Scanner;

public class AdminView extends BasicView{
	
	private static Scanner scanner = new Scanner(System.in);
	
	private AdminView() {}
		
	public static int showMainMenu() {
		System.out.println("Select the operation... ");
		System.out.println("1) See Status of the building");
		System.out.println("2) Add new User/Room/Permission");
		System.out.println("3) Remove User/Room/Permission");
		System.out.println("4) Show User/Room");
		BasicView.backOrQuit("Quit");
		return BasicView.askForChoice();
	}
	
	public static int showAddMenu() {
		
		System.out.println("Select what entity do you want to add...");
		System.out.println("1) User");
		System.out.println("2) Room");
		System.out.println("3) Permission");
		BasicView.backOrQuit("Back");
		return BasicView.askForChoice();
		
	}
	
	public static int showRemoveMenu() {
		
		System.out.println("Select what entity do you want to remove...");
		System.out.println("1) User");
		System.out.println("2) Room");
		System.out.println("3) Permission");
		BasicView.backOrQuit("Back");
		return BasicView.askForChoice();
	}
	
	public static int showShowMenu() {
		
		System.out.println("Select what entity do you want to see the details...");
		System.out.println("1) User");
		System.out.println("2) Room");
		BasicView.backOrQuit("Back");
		return BasicView.askForChoice();
	}
	
	

}

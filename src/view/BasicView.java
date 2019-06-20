package view;

import java.util.Scanner;

public class BasicView {
	
	private static Scanner scanner = new Scanner(System.in);

	public static int askForChoice() {
		
		System.out.print("Choice: ");
		return scanner .nextInt();
	}
	
	public static void backOrQuit(String str) {
		
		System.out.println();
		System.out.println("0) " + str);
		System.out.println();
	}

}

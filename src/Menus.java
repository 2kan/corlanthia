import java.util.*;

public class Menus {
	static int selection		= 0;
	static String Sselection	= "";
	static Scanner input		= new Scanner(System.in);
	
	public static void MainMenu() {
		System.out.println("" +
				"Welcome to CORLANTHIA.\n\n" +
				"	1. Play\n" +
				"	2. About\n" +
				"	3. Exit\n");
		selection = input.nextInt();
		
		
		
		switch(selection) {
		case 1:	Game.Start(); break;
		case 2: About(); break;
		case 3: System.exit(1);
		
		}
		
	}

	private static void About() {
		System.out.println("" +
				"Corlanthia is a text adventure game\n\n" +
				"Version 0.1\n" +
				"This is merely a proof-of-concept demo and does not represent what the finished game will be.\n\n" +
				"Type 'exit' to go back to the main menu");
		Sselection = input.nextLine();
		
		if(Sselection.equalsIgnoreCase("exit")) {
			MainMenu();
		}
		
	}
	
	
	
}

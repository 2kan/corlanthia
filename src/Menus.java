import java.util.*;

public class Menus {
	static int selection		= 0;
	static String Sselection	= "";
	static Scanner input		= new Scanner(System.in);
	
	/**
	 * Display the main menu and enter the input options.
	 */
	public static void MainMenu() {
		GUI.log("" +
				"Welcome to CORLANTHIA.\n\n" +
				"	1. Play\n" +
				"	2. About\n" +
				"	3. Exit\n");
				
		switch(selection) {
		case 1:	Game.intro(); break;
		case 2: About(); break;
		case 3: System.exit(1);
		
		}
		
	}
	
	/**
	 * Display the About text.
	 */
	public static void About() {
		GUI.log("\nCorlanthia is a text adventure game\n\n" +
				"v" + Game.version + "\n" +
				"Type 'exit' to go back to the main menu");
	}
	
	/**
	 * Display a list of commands.
	 */
	public static void Help() {
		GUI.log("" +
				"Commands:\n" +
				"north		exit through the northern door.\n" +
				"east		exit through the eastern door.\n" +
				"south		exit through the southern door.\n" +
				"west		exit through the western door.\n" +
				"exit		go back to the main menu.\n" +
				"inspect	get more information about an item.\n" +
				"pickup		pickup an item.\n" +
				"look		get a list of all of the items in the room.\n" +
				"drop		drop an item out of your inventory.\n" +
				"read		read a book in your inventory.\n" +
				"dance		begin dancing.");
	}
}

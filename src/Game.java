/**
 * 
 * @author	Tom Penney
 * @version	0.1.8
 * 
 * Corlanthia is protected by the Creative Commons Attribution 3.0 Unported License.
 * More information about the license can be found here: http://creativecommons.org/licenses/by/3.0/
 * 
 * Corlanthia is unfinished and the proof-of-concept is still being developed.
 * This game is intended to be a 'complete' game with diverse mechanics and a gripping story,
 * isometric maps of each room may be created as a 'featured' update at some point for new
 * players to text adventure games and will be an optional feature.
 * 
 * More information about the game and the source can be found on github at https://github.com/2kan/Corlanthia
 * 
 *
 */
import java.util.*;


public class Game {
	
	private static Scanner GameScan	= new Scanner(System.in);
	private static String GameInput	= "";
	public static String Version	= "Corlanthia proof-of-concept version 0.1.8_1";
	
	public static void main(String[] args) {
		Menus.MainMenu();
	}
	
	public static void Intro() {
		System.out.println("You wake up in a daze, there is a lump on your head and you don't know how it got there. " +
				"The last thing you can remember was when you were out drinking with your mates and some unexpected +" +
				"visitors arrived.\n\n" +
				"The room you are in seems like it was from the medeval times and all you can smell are decaying rats.");
		Start();
	}
	
	public static void Start() {
		int[][] room	= Rooms.GetRoom(1);
		Rooms.currentRoom	= 1;
		
		System.out.println(Rooms.currentRoom+".");
		System.out.println("Layout of room:");
		for(int i=0; i<room.length; i++) {
			for(int j=0; j<room[i].length; j++){
				System.out.print(room[i][j]);
			}
			System.out.println();
		}
		
		instruction(1, false);
		
	}
	
	public static void instruction(int inRoom, boolean iterated) {
		
		if(iterated == false) {
			System.out.println("\n --- "+Rooms.currentRoomName+" --- \n");
			System.out.println(">> "+Rooms.RoomDescription);
			Rooms.visitedRooms[Rooms.currentRoom]	= 1;
			iterated	= true;
		}
		System.out.print("> ");
		GameInput	= GameScan.nextLine();
		
		if(GameInput.equals(null) || GameInput.equals("")) {
			instruction(Rooms.currentRoom, true);
		}
		
		if(GameInput.equalsIgnoreCase("help")) {
			Menus.Help();
			System.out.println();
			instruction(inRoom, true);
		}
		if(GameInput.equalsIgnoreCase("exit")) {
			Menus.MainMenu();
		}
		
		if(GameInput.equalsIgnoreCase("north") ||
				GameInput.equalsIgnoreCase("east") ||
				GameInput.equalsIgnoreCase("south") ||
				GameInput.equalsIgnoreCase("west")) {
			Rooms.ChangeRoom(GameInput, inRoom);
		}
		
		if(GameInput.equalsIgnoreCase("version")) {
			System.out.println(Version);
		}
		
		
		StringTokenizer commandTokens	= new StringTokenizer(GameInput, " ", false);
		String command					= commandTokens.nextToken();
		int commandCount				= commandTokens.countTokens();
		
		if(command.equals("inspect")) {
			if(commandCount == 0) {
				System.out.println("Type 'inspect' followed by an item to inspect.");
			} else {
				Actions.Inspect(commandTokens.nextToken(), Rooms.currentRoom);
			}
		}
		if(command.equals("inventory") || command.equals("invsee")) {
			Actions.InvSee();
		}
		if(command.equals("pickup")) {
			Actions.Pickup(commandTokens.nextToken());
		}
		if(command.equals("look")) {
			Actions.Look();
			instruction(Rooms.currentRoom, true);
		}
		if(command.equals("drop")) {
			Actions.Drop(commandTokens.nextToken());
		}
		if(command.equals("debug")) {
			if(commandCount == 1) {
				Actions.Debug(commandTokens.nextToken(), null);
			}
			if(commandCount == 2) {
				Actions.Debug(commandTokens.nextToken(), commandTokens.nextToken());
			}
		}
		
		
		if(Rooms.RoomChange == true) {
			iterated	= false;
		} else {
			iterated	= true;
		}
		
		instruction(Rooms.currentRoom, iterated);
	}
	
	
}

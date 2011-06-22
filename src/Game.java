/**
 * 
 * @author	Tom Penney
 * @version	0.1
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
	
	public static void main(String[] args) {
		Menus.MainMenu();
		
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
			System.out.println("\n\n --- "+Rooms.currentRoomName+" --- \n");
			System.out.println(">> "+Rooms.RoomDescription);
			iterated	= true;
		}
		System.out.print("> ");
		GameInput	= GameScan.nextLine();
		
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
		
		StringTokenizer commandTokens	= new StringTokenizer(GameInput, " ", false);
		String command					= commandTokens.nextToken();
		if(command.equals("inspect")) {
			Actions.Inspect(commandTokens.nextToken());
		}
		
		if(Rooms.RoomChange == true) {
			iterated	= false;
		} else {
			iterated	= true;
		}
		
		instruction(Rooms.currentRoom, iterated);
	}
	
	
}

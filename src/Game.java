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



public class Game {
	
	public static void main(String[] args) {
		Menus.MainMenu();
		
	}
	
	public static void Start() {
		boolean firstRun	= true;
		int[][] room	= Rooms.GetRoom(firstRun);
		
		for(int i=0; i<room.length; i++) {
			for(int j=0; j<room[i].length; j++){
				System.out.print(room[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
	
}

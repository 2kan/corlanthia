/*
 * Rooms.
 * Class defines what the rooms look like with 2d arrays.
 * Numbers represent an object.
 * 
 * 0	air
 * 1	wall
 * 2	window
 * 3	door
 * 4	table
 * 5	lamp
 * 
 */



public class Rooms {
	
	public static int[][] GetRoom(boolean start) {
		int[][] room	= {{}};
		
		if(start == true) {
			room	= startingHall();
		}
		
		return room;
	}

	public static int[][] startingHall() {
		
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		
		return room;
	}
}

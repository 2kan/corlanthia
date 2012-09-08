/*
 * Rooms.
 * Class defines what the rooms look like with 2d arrays.
 * Numbers represent an object.
 * 
 * 
 * Rooms
 * 1	Starting Hall
 * 2	King's Hall
 * 3	T-Lobby
 * 4	Eastern Lounge
 * 5	Library
 * 6	Garden Room
 * 7	Balconey
 * 8	Initiation Chamber
 * 9	Final Boss
 * 
 */

public class Rooms {
	
	public static String currentRoomName	= "";
	public static int currentRoom			= 0;
	public static String RoomDescription	= "";
	public static boolean RoomChange		= false;
	public static int[] visitedRooms		= {0,0,0,0,0,0,0,0,0};
	private static int[] keyRequired		= {0,0,0,0,402,0,401,0,400};
	private static int[][] layout	=  {{0,0,0,1,0,0,0},
										{0,0,0,2,0,0,0},
										{0,0,0,3,5,6,0},
										{0,0,0,4,0,7,0},
										{0,0,0,8,0,0,0},
										{0,0,0,9,0,0,0},
										{0,0,0,0,0,0,0}};
	
	public static int[][] GetRoom(int current) {
		int[][] room	= {{}};
		switch(current){
		case 1:		room = StartingHall();		break;
		case 2:		room = KingsHall();			break;
		case 3:		room = TLobby();			break;
		case 4:		room = EasternLounge();		break;
		case 5:		room = Library();			break;
		case 6:		room = GardenRoom();		break;
		case 7:		room = Balconey();			break;
		case 8:		room = InitiationChamber();	break;
		case 9:		room = FinalBoss();			break;
		}
		
		return room;
	}
	
	public static boolean isLocked(int roomId) {
		if(keyRequired[roomId-1] != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void unlockDoor(int roomId) {
		keyRequired[roomId-1]	= 0;
	}
	
	public static int keyIdRequired(int roomId) {
		return keyRequired[roomId-1];
	}
	
	public static int getNextRoomId(String direction, int thisRoomId) {
		// Get currentRoom coords
		int y	= -1;
		int x	= -1;
		boolean foundCoords	= false;
		for(int yi=0; yi<layout.length; yi++) {
			for(int xi=0; xi<layout[0].length; xi++) {
				if(layout[yi][xi] == thisRoomId) {
					y	= yi;
					x	= xi;
					foundCoords	= true;
					break;
				}
			}
			if(foundCoords) {
				break;
			}
		}
		
		if(y != -1 && x != -1) {
			try {
				if(direction.equals("north")) {
					return layout[y-1][x];
				} else if(direction.equals("east")) {
					return layout[y][x+1];
				} else if(direction.equals("south")) {
					return layout[y+1][x];
				} else if(direction.equals("west")) {
					return layout[y][x-1];
				} else {
					return thisRoomId;
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				System.err.println("Cannot find next room in cardinal-direction: " + direction + " from roomId: " + thisRoomId);
			}
		}
		System.out.println(thisRoomId+"");
		return thisRoomId;
	}
	
	public static int[][] ChangeRoom(String direction, int CurrentRoom, boolean start) {
		boolean broken	= false;
		int NewRoom		= 0;
		
		if(!start) {
			for(int i=0; i<layout.length; i++) {
				for(int j=0; j<layout[i].length; j++) {
					if(layout[i][j] == CurrentRoom) {
						if(direction.equals("north")) {
							try {
								NewRoom	= layout[i-1][j];
							} catch(Exception e) {
								GUI.log("There is no room to the north.");
							}
							broken	= true;
							break;
						}
						if(direction.equals("east")) {
							try {
								NewRoom	= layout[i][j+1];
							} catch(Exception e) {
								GUI.log("There is no room to the east.");
							}
							broken	= true;
							break;
						}
						if(direction.equals("south")) {
							try {
								NewRoom	= layout[i+1][j];
							} catch(Exception e) {
								GUI.log("There is no room to the south.");
							}
							broken	= true;
							break;
						}
						if(direction.equals("west")){
							try {
								NewRoom	= layout[i][j-1];
							} catch(Exception e) {
								GUI.log("There is no room to the west.");
							}
							broken	= true;
							break;
						}
					}
					
				}
				if(broken == true) {
					break;
				}
			}
		}
		
		if(NewRoom == 0) {
			NewRoom	= 1337;
		}
		
		int[][] room;
		if(start) {
			room	= GetRoom(1);
		} else {
			room	= GetRoom(NewRoom);
		}
		for(int i=0; i<visitedRooms.length; i++) {
			if(visitedRooms[i] == 0) {
				visitedRooms[i]	= currentRoom;
				break;
			}
		}
		RoomChange		= true;
		return room;
	}

	public static int[][] StartingHall() {
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,8,10,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		
		currentRoomName	= "Starting Hall";
		currentRoom		= 1;
		RoomDescription	= "The room is small, square and made of solid stone. It is cold and there is a ladder " +
				"going up through a hatch.";
		return room;
	}
	
	public static int[][] KingsHall() {
		
		// Room number	= 2;
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		currentRoomName	= "King's Hall";
		currentRoom		= 2;
		RoomDescription	= "You climb through the hatch and you are now in a bigger hall. There are red carpets magestically " +
				"hanging from the walls, next to the enormous painting of a proud looking king. There is one door at the " +
				"South of the room.";
		return room;
	}
	
	public static int[][] TLobby() {
		
		// Room number	= 3;
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		currentRoomName	= "T-Lobby";
		currentRoom		= 3;
		RoomDescription	= "As you close the wooden door behind you, you are rushed with a sense of fear from the sound of a " +
				"shotgun and the intense wind coming from the eastern doorway.";
		return room;
	}
	
	public static int[][] EasternLounge() {
		
		// Room number	= 4;
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		currentRoomName	= "Eastern Lounge";
		currentRoom		= 4;
		RoomDescription	= "You walk into the room and you catch a glimps of a man wearing a cowboy hat and dark clothing as he " +
				"runs out of the room through the huge eastern doors. There is a slight smell of cheap aftershave and you can " +
				"see the sun begining to set through the window.";
		return room;
	}
	
	
	public static int[][] Library() {
		
		// Room number	= 5;
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		currentRoomName	= "Library";
		currentRoom		= 5;
		RoomDescription	= "After taking one step into the badly lit room, the big wooden doors slam behind you from a gust of " +
				"warm wind. There is no light switch and the room has a stench of old books. There is a door at the end of the " +
				"room that looks like it was just used as you briefly see the last sketch of light from the closing door.";
		return room;
	}
	
	public static int[][] GardenRoom() {
		
		// Room number	= 6;
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		currentRoomName	= "Garden Room";
		currentRoom		= 6;
		RoomDescription	= "You nostrils are assulted with the pungant smell of roses and various other flowers. The sudden " +
				"change of light makes you double back slightly as you slowly try to gain back your vision. This is clearly" +
				"taken care of very often as every plant is perfecly shaped into the cliche form of itself.\n\n" +
				"There is but one gold wilted lilly laying in the centre of the greenhouse auraed room and a door at the end.";
		return room;
	}
	
	public static int[][] Balconey() {
		
		// Room number	= 7;
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		currentRoomName	= "Balconey";
		currentRoom		= 7;
		RoomDescription	= "The wafer thin doors are almost crushed in your hands as you open them and enter the balconey." +
				"You are immediately faced with the dark figure you saw earlier; only this time, he is slung over the " +
				"balconey with a knife in his hand and blood pouring out from his neck. You are at a dead end.";
		return room;
	}
	
	public static int[][] InitiationChamber() {
		
		// Room number	= 8;
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		currentRoomName	= "Initiation Chamber";
		currentRoom		= 8;
		RoomDescription	= "The steel doors are heavy so you charge into it and they burst open, slamming in to the wall it is " +
				"hinged to. The room is cold and bright. There is a velvet rope across the front of the door ahead of you. " +
				"In the room there are three desks, two on the left and one to your right. All of them have a drawer with a " +
				"lock on it.";
		return room;
	}
	
	public static int[][] FinalBoss() {
		
		// Room number	= 9;
		int[][] room	=  {{1,1,1,1,1,1,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,0,0,0,0,0,1},
							{1,1,1,1,1,1,1}};
		currentRoomName	= "Final Boss";
		currentRoom		= 9;
		RoomDescription	= "The door swings open and as you take a step in, the lights turn on and confetti falls from the " +
				"ceiling, a party of giant dancing lobsters come out from hiding and start to boogie.\n\n" +
				"Congratulations, you have just won Corlanthia";
		return room;
	}
}

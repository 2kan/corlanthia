
public class Items {
	
	// Check if the item exists in the room. These variables are changed when the user types 'look' or 'inspect'.
	public static boolean Window,Table,Lamp,Key,Lock,Desk,Book,Door,LockDoor,Hatch	= false;
	public static int[] taken	= {};
	
	
	// Descriptions of various items.
	public static String[] WallDesc		= {"This wall is made of stone.","It looks old.","A cold stone wall."};
	public static String[] WindowDesc	= {"A window made of scratched glass.","A regular window.","A window."};
	public static String[] DoorDesc		= {"A sold wooden door.","An old door.","An old looking wooden door."};
	public static String[] LockDoorDesc	= {"A locked door.","A locked door.... maybe there's a key around here.","It's locked."};
	public static String[] DeskDesc		= {"A fancy wooden desk.","A desk with a locked drawer.","It looks old."};
	public static String[] LampDesc		= {"A worn out golden lamp.","An old lamp.","It's a small golden lamp."};
	public static String[] KeyDesc		= {"A rusty old key.","An old key.","It looks like it could open something...."};
	public static String[] BookDesc		= {"A worn out old book.","A torn up book.","It looks old."};
	public static String[] LockDesc		= {"An old old lock.","A scratched up lock.","A regular lock."};
	public static String[] HatchDesc	= {"An old hatch.","It's made of old pine wood.","It's unlocked."};
	
	
	// Items in each room.
	public static int[][] RoomItems		=  {{8,0,0,0,0,0,0,0},
											{7,7}};
	public static int[] KingsHall		= {};
	public static int[] TLobby			= {};
	public static int[] EasternLounge	= {};
	public static int[] Library			= {};
	public static int[] GardenRoom		= {};
	public static int[] Balconey		= {};
	public static int[] InitChamber		= {};
	public static int[] FinalBoss		= {};
}

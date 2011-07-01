/*
 * Item ID numbers
 * 0	air
 * 1	wall
 * 2	window
 * 3	door
 * 4	locked door
 * 5	table
 * 6	lamp
 * 7	key
 * 8	book
 * 9	letter
 * 
 */

public class Items {
	
	// Check if the item exists in the room. These variables are changed when the user types 'look' or 'inspect'.
	public static boolean Window,Table,Lamp,Key,Lock,Desk,Book,Door,LockDoor,Hatch	= false;
	public static int[] taken	= {};
	
	
	// Descriptions of various items.
	public static String[][] ItemDesc	= {{"Wall","This wall is made of stone.","It looks old.","A cold stone wall."},
										   {"Window","A window made of scratched glass.","A regular window.","A window."},
										   {"Door","A sold wooden door.","An old door.","An old looking wooden door."},
										   {"LockedDoor","A locked door.","A locked door.... maybe there's a key around here.","It's locked."},
										   {"Desk","A fancy wooden desk.","A desk with a locked drawer.","It looks old."},
										   {"Lamp","A worn out golden lamp.","An old lamp.","It's a small golden lamp."},
										   {"Key","A rusty old key.","An old key.","It looks like it could open something...."},
										   {"Book","A worn out old book.","A torn up book.","It looks old."},
										   {"Lock","An old old lock.","A scratched up lock.","A regular lock."},
										   {"Hatch","An old hatch.","It's made of old pine wood.","It's unlocked."}};
	
	// The locations of ListItemsID correspond to ListItems. For example, ListItems[1] is the name for ListItemsID[1].
	public static String[] ListItems	= {"key","book","letter"};
	public static int[] ListItemsID		= {7,8,9};
	
	// Items in each room.
	public static int[][] RoomItems		=  {{8,0,0,0,0,0,0,0},
											{7,7,0,0,0,0,0,0}};
	
	public static String[] BookInfo		= {"BEWARE THE MAN IN THE TRENCH COAT.",""};
	public static String[] LetterInfo	= {"La de da :D"};
}

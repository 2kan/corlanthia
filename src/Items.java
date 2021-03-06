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
 * 10	sword
 * 11	axe
 * 
 */

public class Items {
	
	// Descriptions of various items.
	// Each item must have it's name, followed by three descriptive sentences.
	public static String[][] itemDesc	= {{"Wall","This wall is made of stone.","It looks old.","A cold stone wall."},
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
	public static String[] listItems	= {"Skelington Key","Book","Letter","Sword","Axe"};
	public static int[] listItemsID		= {7,8,9,10,11};
	
	// Keys
	public static String[] keyNames	= {"Blue Key", "Orange Key", "Rusted Key"};
	public static int[] keyItemIDs	= {400, 401, 402};
	
	// Items in each room.
	public static int[][] roomItems		=  {{8,0,11,300,0,0,402,0},
											{400,0,0,10,0,0,11,301},
											{0,10,11,302,401,0,0,0},
											{11,0,0,303,0,0,0,0},
											{11,10,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0},
											{10,11,0,0,0,0,0,0},
											{11,0,0,0,0,0,0,0},
											{10,0,0,0,0,0,0,0}};
	
	public static String[] bookInfo		= {"BEWARE THE MAN IN THE TRENCH COAT.",""};
	public static String[] letterInfo	= {"La de da :D"};
}

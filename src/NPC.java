/*
 * NPCs are identified by numbers, but like rooms and items.
 * 
 * Name		ID
 * -----------
 * Imp		1
 * Rabbit	2
 * Bat		3
 * Dragon	4
 * Human	5
 * Knight	6
 * 
 * 
 */

public class NPC {
	
	// Data for each NPC. Format is NPCID,Hitpoints
	public static int[][] NPCData		= {{1,10},
											{2,3},
											{3,15},
											{4,100},
											{5,50},
											{6,70}};
	
	
	public static String[] ListNPCName	= {"Imp","Rabbit","Bat","Dragon","Human","Knight"};
	public static int[] ListNPCID		= {1,2,3,4,5,6};
	
}

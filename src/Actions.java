import java.util.Random;

public class Actions {
	
	public static int[] Inventory	= {0,0,0,0,0,0,0,0};
	public static int ItemCount			= 0;
	
	public static void CountItems(int Room) {
		ItemCount	= 0;
		for(int i=0; i<Items.roomItems[Room-1].length; i++) {
			if(Items.roomItems[Room-1][i] != 0) {
				ItemCount++;
			}
		}
	}
	
	public static int GetItemID(String oldItem) {
		// Search for item name from item list
		for(int i=0; i<Items.listItems.length; i++) {
			if(Items.listItems[i].equalsIgnoreCase(oldItem)) {
				return Items.listItemsID[i];
			}
		}
		
		// If it hasn't been found, look for a book with the item name
		for(int i=300; i<Books.bookCount()+300; i++) {
			if(Books.getName(i).equals(oldItem)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static String GetItemName(int ItemID) {
		String ItemName	= "";
		
		for(int i=0; i<Items.listItemsID.length; i++) {
			if(Items.listItemsID[i] == ItemID) {
				ItemName	= Items.listItems[i];
			}
			
			if(ItemID >= 300 && ItemID <= 400) {
				ItemName	= "Book: "+Books.getName(ItemID);
			}
		}
		return ItemName;
	}
	
	public static int GetNPCID(String name) {
		int NPCID	= 0;
		
		for(int i=0; i<NPC.ListNPCName.length; i++) {
			if(NPC.ListNPCName[i].equalsIgnoreCase(name)) {
				NPCID	= NPC.ListNPCID[i];
			}
		}
		
		return NPCID;
	}
	
	public static void Inspect(String item, int Room) {
		Random number	= new Random();
		int i			= number.nextInt(3);
		i				= i+1;
		boolean shownInspection	= false;
		
		for(int k=0; k<Items.itemDesc.length; k++) {
			if(item.equalsIgnoreCase(Items.itemDesc[k][0])) {
				GUI.log(Items.itemDesc[k][i]);
				shownInspection	 = true;
			}
		}
		
		if(!shownInspection) {
			GUI.log("Can't see a "+item+".");
		}
	}
	
	public static void InvSee() {
		int count	= 0;
		for(int m=0; m<Inventory.length; m++) {
			count++;
			if(Inventory[m] != 0) {
				count--;
			}
		}
		
		GUI.log(">> You have "+count+" slots left in your inventory");
		for(int m=0; m<Inventory.length; m++) {
			if(Inventory[m] == 7) {
				System.out.print("Key ");
			}
			if(Inventory[m] == 8) {
				System.out.print("Book ");
			}
		}
	}
	
	public static void Pickup(String Item) {
		boolean added	= false;
		int ItemID	= GetItemID(Item);
		
		for(int i=0; i<Items.roomItems.length-1; i++) {
			if(Items.roomItems[Rooms.currentRoom-1][i] == ItemID) {
				for(int j=0; j<Inventory.length-1; j++) {
					if(Inventory[j] == 0) {
						Inventory[j]	= ItemID;
						added			= true;
						GUI.log("Picked up "+Item+".");
						break;
					}
				}
				Items.roomItems[Rooms.currentRoom-1][i]	= 0;
				break;
			}
		}
		
		if(added != true) {
			GUI.log("There isn't a "+Item+" in this room.");
		}
	}
	
	public static void Look() {
		CountItems(Rooms.currentRoom);
		if(ItemCount != 1) {
			GUI.log("There are "+ItemCount+" objects in this room.");
		} else {
			GUI.log("There is 1 object in this room.");
		}
		
		if(ItemCount != 0) {
			for(int i=0; i<Items.roomItems[Rooms.currentRoom-1].length; i++) {
				if(Items.roomItems[Rooms.currentRoom-1][i] != 0) {
					GUI.log(" * "+GetItemName(Items.roomItems[Rooms.currentRoom-1][i]));
				}
			}
		}
	}
	
	public static void Drop(String Item) {
		int ItemID		= 0;
		int in			= 0;
		boolean dropped	= false;
		boolean spaceInRoom	= false;
		
		ItemID	= GetItemID(Item);
		
		for(in=0; in<Inventory.length; in++) {
			if(Inventory[in] == ItemID) {
				// Add item back into room
				for(int i=0; i<Items.roomItems[0].length; i++) {
					if(Items.roomItems[Rooms.currentRoom-1][i] == 0) {
						Items.roomItems[Rooms.currentRoom-1][i]	= ItemID;
						spaceInRoom	= true;
						break;
					}
				}
				
				// If there's space in the room, drop the item
				if(spaceInRoom) {
					Inventory[in]	= 0;
					dropped	= true;
				} else {
					GUI.log("Room is full of items! Throw "+Item+" out in another room.");
				}
				break;
			}
			if(Item.equals("all") || Item.equals("*")) {
				for(int k=0; k<Inventory.length; k++) {
					Inventory[k]	= 0;
				}
				GUI.log("Inventory cleared.");
				dropped	= true;
				break;
			}
		}
		
		if(dropped == false && spaceInRoom) {
			GUI.log("You do not have that in your inventory.");
		} else if(spaceInRoom) {
			GUI.log(Item+" dropped.");
		}
	}
	
	/**
	 * Find whether or not the specified item ID is in the player's inventory
	 * @param itemId	the item ID to search for
	 * @return	true if the player's inventory contains the specified item id
	 */
	public static boolean inventoryContains(int itemId) {
		for(int i=0; i<Inventory.length; i++) {
			if(Inventory[i] == itemId) {
				return true;
			}
		}
		return false;
	}
	
	public static void Read(String book) {
		String[] books	= Books.getBookList();
		for(int j=0; j<Inventory.length; j++) {
			for(int i=0; i<books.length; i++) {
				if(GetItemName(Inventory[j]).endsWith(books[i])) {
					GUI.log(Books.getName(Inventory[j]) + "\n" + Books.getBook(Inventory[j]));
				}
			}
		}
	}
}

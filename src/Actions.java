import java.util.Random;

public class Actions {
	
	public static int[] Inventory	= {0,0,0,0,0,0,0,0};
	public static int ItemCount		= 0;
	
	/**
	 * Count the number of items inside the specified room.
	 * @param Room	the room to have items counted
	 */
	public static void CountItems(int Room) {
		ItemCount	= 0;
		for(int i=0; i<Items.roomItems[Room-1].length; i++) {
			if(Items.roomItems[Room-1][i] != 0) {
				ItemCount++;
			}
		}
	}
	
	/**
	 * Finds the item ID for the specified item name.
	 * @param oldItem	item name to find the ID of
	 * @return	the item ID or -1 if no ID is found
	 */
	public static int GetItemID(String oldItem) {
		// Search for item name from item list
		for(int i=0; i<Items.listItems.length; i++) {
			if(Items.listItems[i].equalsIgnoreCase(oldItem)) {
				return Items.listItemsID[i];
			}
		}
		
		// If the item hasn't been found, look for a book with the item name
		for(int i=300; i<Books.bookCount()+300; i++) {
			if(Books.getName(i).equalsIgnoreCase(oldItem)) {
				return i;
			}
		}
	
		// If the item still hasn't been found, look for a key with the item name
		for(int i=400; i<Items.keyItemIDs.length+400; i++) {
			if(Items.keyNames[i-400].equalsIgnoreCase(oldItem)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Find the item name of the specified item ID.
	 * @param ItemID	the ID of the item to find the name of
	 * @return	the name of the item or an empty String if no name is found
	 */
	public static String GetItemName(int ItemID) {
		String ItemName	= "";
		
		for(int i=0; i<Items.listItemsID.length; i++) {
			if(Items.listItemsID[i] == ItemID) {
				ItemName	= Items.listItems[i];
			}
		}
		
		if(ItemID >= 300 && ItemID < 400) {
			ItemName	= "Book: "+Books.getName(ItemID);
		}
		
		if(ItemID >= 400 && ItemID < 500) {
			ItemName	= Items.keyNames[ItemID-400];
		}
		
		return ItemName;
	}
	
	/**
	 * Displays the specified item's description to the player.
	 * @param item	the item name to find the description of
	 */
	public static void Inspect(String item) {
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
	
	/**
	 * Shows the player's inventory in the console log
	 */
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
	
	/**
	 * Adds the specified item name to the player's inventory if it is in the current room.
	 * @param Item	the item to try to pick up
	 */
	public static void Pickup(String Item) {
		boolean added	= false;
		if(Item.startsWith("Book: ")) {
			Item	= Item.replace("Book: ", "");
		}
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
	
	/**
	 * Displays a list of all of the items in the current room.
	 */
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
	
	/**
	 * Removes the specified item name from the player's inventory (if it is already in the inventory) and adds it to the room.
	 * Doesn't remove from the player's inventory if the room is full.
	 * @param Item	the item name to drop
	 */
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
	 * Find whether or not the specified item ID is in the player's inventory.
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
	
	/**
	 * Displays the contents of the specified book if it is in the player's inventory.
	 * @param book the name of the book to read
	 */
	public static void Read(String book) {
		if(!book.startsWith("Book:")) {
			book	= "Book:" + book;
		}
		for(int j=0; j<Inventory.length; j++) {
			if(GetItemName(Inventory[j]).equalsIgnoreCase(book)) {
				GUI.log(Books.getName(Inventory[j]) + "\n~~~~\n" + Books.getBook(Inventory[j]));
				break;
			}
		}
	}
	
	/**
	 * Removes the specified item from the player's inventory.
	 * @param itemName the name of the item to remove
	 */
	public static void destroyInventoryItem(String itemName) {
		destroyInventoryItem(GetItemID(itemName));
	}
	
	/**
	 * Removed the specified item from the player's inventory.
	 * @param itemID the id of the item to remove
	 */
	public static void destroyInventoryItem(int itemID) {
		for(int i=0; i<Inventory.length; i++) {
			if(Inventory[i] == itemID) {
				Inventory[i]	= 0;
				break;
			}
		}
	}
}

import java.util.Random;

public class Actions {
	
	public static double[] Inventory	= {0,0,0,0,0,0,0,0};
	public static int ItemCount			= 0;
	
	public static void CountItems(int Room) {
		ItemCount	= 0;
		for(int i=0; i<Items.RoomItems[Room-1].length; i++) {
			if(Items.RoomItems[Room-1][i] != 0) {
				ItemCount++;
			}
		}
	}
	
	public static int GetItemID(String oldItem) {
		int ID	= 0;
		
		for(int i=0; i<Items.ListItems.length; i++) {
			if(Items.ListItems[i].equalsIgnoreCase(oldItem)) {
				ID	= Items.ListItemsID[i];
				break;
			}
		}
		return ID;
	}
	
	public static String GetItemName(int ItemID) {
		String ItemName	= "";
		
		for(int i=0; i<Items.ListItemsID.length; i++) {
			if(Items.ListItemsID[i] == ItemID) {
				ItemName	= Items.ListItems[i];
			}
		}
		return ItemName;
	}
	
	public static void Inspect(String Object, int Room) {
		Random number	= new Random();
		int i			= number.nextInt(3);
		i				= i+1;
		
		for(int k=0; k<Items.ItemDesc.length; k++) {
			if(Object.equalsIgnoreCase(Items.ItemDesc[k][0])) {
				System.out.println(Items.ItemDesc[k][i]);
			}
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
		
		System.out.println(">> You have "+count+" slots left in your inventory");
		for(int m=0; m<Inventory.length; m++) {
			if(Inventory[m] == 7) {
				System.out.print("Key ");
			}
			if(Inventory[m] == 8) {
				System.out.print("Book ");
			}
		}
		System.out.println();
	}
	
	public static void Pickup(String Item) {
		boolean added	= false;
		int ItemID	= GetItemID(Item);
		
		for(int i=0; i<Items.RoomItems.length-1; i++) {
			if(Items.RoomItems[Rooms.currentRoom-1][i] == ItemID) {
				for(int j=0; j<Inventory.length-1; j++) {
					if(Inventory[j] == 0) {
						Inventory[j]	= ItemID;
						added			= true;
						System.out.println("Picked up "+Item+".");
						break;
					}
				}
				Items.RoomItems[Rooms.currentRoom-1][i]	= 0;
				break;
			}
		}
		
		if(added != true) {
			System.out.println("There isn't a "+Item+" in this room.");
		}
	}
	
	public static void Look() {
		CountItems(Rooms.currentRoom);
		if(ItemCount > 1 || ItemCount == 0) {
			System.out.println("There are "+ItemCount+" objects.");
		} else {
			System.out.println("There is 1 object.");
		}
		
		if(ItemCount != 0) {
			for(int i=0; i<Items.RoomItems[Rooms.currentRoom-1].length; i++) {
				if(Items.RoomItems[Rooms.currentRoom-1][i] != 0) {
					System.out.println(" * "+GetItemName(Items.RoomItems[Rooms.currentRoom-1][i]));
				}
			}
		}
	}
	
	public static void Drop(String Item) {
		int ItemID		= 0;
		int in			= 0;
		boolean dropped	= false;
		
		ItemID	= GetItemID(Item);
		
		for(in=0; in<Inventory.length; in++) {
			if(Inventory[in] == ItemID) {
				Inventory[in]	= 0;
				dropped	= true;
				break;
			}
			if(Item.equals("all") || Item.equals("*")) {
				for(int k=0; k<Inventory.length; k++) {
					Inventory[k]	= 0;
				}
				System.out.println("Inventory cleared.");
				dropped	= true;
				break;
			}
		}
		
		if(dropped == false) {
			System.out.println("You do not have that in your inventory.");
		}
		else {
			System.out.println(Item+" dropped.");
		}
	}
	
	public static void Read(String material) {
		for(int j=0; j<Inventory.length; j++) {
			if(material.equals("book") && Inventory[j] == 8) {
				System.out.println("hello :D");
				System.out.println(Items.BookInfo[Rooms.currentRoom-1]);
			}
			if(material.equals("letter") && Inventory[j] == 9) {
				System.out.println(Items.LetterInfo[Rooms.currentRoom-1]);
			}
		}
	}
}

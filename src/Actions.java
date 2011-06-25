import java.util.Random;

public class Actions {
	
	public static double[] Inventory	= {0,0,0,0,0,0,0,0};
	public static int ItemCount			= 0;
	
	public static void CheckRoom(int room) {
		for(int j=0; j<Items.RoomItems[room-1].length-1; j++) {
			switch(Items.RoomItems[room-1][j]) {
				case 2: 	Items.Window	= true;	ItemCount++;	break;
				case 3: 	Items.Door		= true;	ItemCount++;	break;
				case 4: 	Items.LockDoor	= true;	ItemCount++;	break;
				case 5: 	Items.Table		= true;	ItemCount++;	break;
				case 6: 	Items.Lamp		= true; ItemCount++;	break;
				case 7: 	Items.Key		= true;	ItemCount++;	break;
				case 8: 	Items.Book		= true;	ItemCount++;	break;
				case 9: 	Items.Lock		= true; ItemCount++;	break;
				case 10:	Items.Hatch		= true; ItemCount++;	break;
			}
		}
	}
	
	public static void CloseRoom() {
		Items.Window	= false;
		Items.Door		= false;
		Items.LockDoor	= false;
		Items.Table		= false;
		Items.Lamp		= false;
		Items.Key		= false;
		Items.Book		= false;
	}
	
	public static void Debug(String command1, String command2) {
		if(command1.equals("showitems")) {
			for(int i=0; i<Items.RoomItems[Rooms.currentRoom-1].length; i++) {
				System.out.print(Items.RoomItems[Rooms.currentRoom-1][i]+" ");
			}
			System.out.println();
		}
		if(command1.equals("additem")) {
			Integer.parseInt(command2);
			for(int i=0; i<Items.RoomItems[Rooms.currentRoom-1].length; i++) {
				if(Items.RoomItems[Rooms.currentRoom-1][i] == 0) {
					Items.RoomItems[Rooms.currentRoom-1][i]	= Integer.parseInt(command2);
					System.out.println("Item added to room.");
					break;
				}
			}
		}
	}
	
	public static void Inspect(String Object, int Room) {
		Random number	= new Random();
		int i			= number.nextInt(3);
		
		CheckRoom(Room);
		
		if(Object.equals("key") && Items.Key == true) {
			System.out.println(Items.KeyDesc[i]);
		}
		if(Object.equals("lock") && Items.Lock == true) {
			System.out.println(Items.LockDesc[i]);
		}
		if(Object.equals("desk") && Items.Desk == true) {
			System.out.println(Items.DeskDesc[i]);
		}
		if(Object.equals("wall")) {
			System.out.println(Items.WallDesc[i]);
		}
		if(Object.equals("book") && Items.Book == true) {
			System.out.println(Items.BookDesc[i]);
		}
		if(Object.equals("door") && Items.Door == true) {
			System.out.println(Items.DoorDesc[i]);
		}
		if(Object.equals("locked-door") && Items.LockDoor == true) {
			System.out.println(Items.LockDoorDesc[i]);
		}
		if(Object.equals("hatch") && Items.Hatch == true) {
			System.out.println(Items.HatchDesc[i]);
		}
		CloseRoom();
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
		CheckRoom(Rooms.currentRoom);
		boolean added	= false;
		
		for(int i=0; i<Inventory.length; i++) {
			if(Inventory[i] == 0) {
				for(int j=0; j<Items.RoomItems.length-1; j++) {
					System.out.println(i+" "+j+" "+Rooms.currentRoom);
					if(Item.equals("key") && Items.RoomItems[Rooms.currentRoom-1][j] == 7) {
						Inventory[i]	= 7;
						Items.RoomItems[Rooms.currentRoom-1][j]	= 0;
						added	= true;
						break;
					}
					if(Item.equals("book") && Items.RoomItems[Rooms.currentRoom-1][j] == 8) {
						Inventory[i]	= 8;
						Items.RoomItems[Rooms.currentRoom-1][j]	= 0;
						added	= true;
						break;
					}
				}
				
				if(added == true) {
					System.out.println(Item+" has been added to your inventory.");
					added	= true;
					break;
				}
			}
		}
		
		if(added != true) {
			System.out.println("There isn't a "+Item+" in this room.");
		}
		
		CloseRoom();
	}
	
	public static void Look() {
		CheckRoom(Rooms.currentRoom);
		
		if(ItemCount > 1 || ItemCount == 0) {
			System.out.println("There are "+ItemCount+" objects.\n");
		} else {
			System.out.println("There is 1 object.\n");
		}
		
		if(Items.Window == true) {
			System.out.println(" * Window");
		}
		if(Items.Door == true) {
			System.out.println(" * Door");
		}
		if(Items.LockDoor == true) {
			System.out.println(" * Locked Door");
		}
		if(Items.Table == true) {
			System.out.println(" * Desk");
		}
		if(Items.Lamp == true) {
			System.out.println(" * Lamp");
		}
		if(Items.Key == true) {
			System.out.println(" * Key");
		}
		if(Items.Book == true) {
			System.out.println(" * Book");
		}
		if(Items.Lock == true) {
			System.out.println(" * Lock");
		}
		if(Items.Hatch == true) {
			System.out.println(" * Hatch");
		}
		
		CloseRoom();
	}
	
	public static void Drop(String Item) {
		int ItemID		= 0;
		int in			= 0;
		boolean dropped	= false;
		
		if(Item.equals("key")) {
			ItemID	= 7;
		}
		if(Item.equals("book")) {
			ItemID	= 8;
		}
		
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
	}
}

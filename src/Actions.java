import java.util.Random;

public class Actions {
	
	public static double[] Inventory	= {0,0,0,0,0,0,0,0};
	public static int ItemCount			= 0;
	
	public static void CheckRoom(int room) {
		int[][] roomLayout	= Rooms.GetRoom(room);
		for(int j=0; j<roomLayout.length; j++) {
			for(int k=0; k<roomLayout[j].length; k++) {
				switch(roomLayout[j][k]) {
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
	
	public static void Pickup(String Item, int Room) {
		CheckRoom(Room);
		boolean added	= false;
		
		for(int l=0; l<Inventory.length; l++) {
			if(Inventory[l] == 0) {
				if(Item.equals("key") && Items.Key == true) {
					Inventory[l]	= 7;
					added	= true;
					break;
				}
				if(Item.equals("book") && Items.Book == true) {
					Inventory[l]	= 8;
					added	= true;
					break;
				}
			}
		}
		
		if(Item.equals("window") || Item.equals("door") || Item.equals("locked-door") ||
				Item.equals("desk") || Item.equals("lamp")|| Item.equals("lock") || Item.equals("hatch")) {
			System.out.println("You can't pick that up.");
		}
		if(added == false) {
			System.out.println("There isn't a "+Item+" in here.");
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
				System.out.println("Key ");
			}
			if(Inventory[m] == 8) {
				System.out.println("Book ");
			}
		}
		System.out.println();
	}
	
	public static void Pickup(String Item) {
		CheckRoom(Rooms.currentRoom);
		boolean added	= false;
		
		for(int i=0; i<Inventory.length; i++) {
			if(Inventory[i] == 0) {
				if(Items.Key == true && Item.equals("key")) {
					Inventory[i]	= 7;
				}
				if(Items.Book == true && Item.equals("book")) {
					Inventory[i]	= 8;
				}
				System.out.println(Item+" has been added to your inventory.");
				added	= true;
				break;
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
		if(Items.Table) {
			System.out.println(" * Desk");
		}
		if(Items.Lamp) {
			System.out.println(" * Lamp");
		}
		if(Items.Key) {
			System.out.println(" * Key");
		}
		if(Items.Book) {
			System.out.println(" * Book");
		}
		if(Items.Lock) {
			System.out.println(" * Lock");
		}
		if(Items.Hatch) {
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
		}
		
		if(dropped == false) {
			System.out.println("You do not have that in your inventory.");
		}
	}
}

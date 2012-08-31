
public class Debug {
	
	public static void Actions(String command1, String command2) {
		if(command1.equals("showitems") || command1.equals("look")) {
			Actions.Look();
		}
		if(command1.equals("additem")) {
			try {
				Integer.parseInt(command2);
			} catch(Exception e) {
				System.out.println("Failed to parse second parameter. Please only type integers.");
			}
			for(int i=0; i<Items.roomItems[Rooms.currentRoom-1].length; i++) {
				if(Items.roomItems[Rooms.currentRoom-1][i] == 0) {
					Items.roomItems[Rooms.currentRoom-1][i]	= Integer.parseInt(command2);
					System.out.println("Item added to room.");
					break;
				}
			}
		}
		if(command1.equals("itemcount")) {
			Actions.CountItems(Rooms.currentRoom);
		}
	}
}

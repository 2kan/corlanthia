import java.util.Random;

public class Actions {
	
	public static void Inspect(String Object) {
		Random number	= new Random();
		int i	= number.nextInt(3);
		if(Object.equals("key")) {
			System.out.println(Items.KeyDesc[i]);
		}
		if(Object.equals("lock")) {
			System.out.println(Items.LockDesc[i]);
		}
		if(Object.equals("desk")) {
			System.out.println(Items.DeskDesc[i]);
		}
		if(Object.equals("wall")) {
			System.out.println(Items.WallDesc[i]);
		}
		if(Object.equals("book")) {
			System.out.println(Items.BookDesc[i]);
		}
		
	}
	
	
}

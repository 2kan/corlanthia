
public class Books {
	
	private static String[] bookNames		= {"Derp",
										"The Story of Derpina",
										"Ode to a Derp",
										"Herpa Derpa"};
	private static String[] bookDesc		= {"A derpy looking book.",
										"An old book with freshly dried tears on the pages.",
										"A dusty book that looks like it hasn't been touched for decades.",
										"Merpy derpy derp derp derp."};
	private static String[] bookContents	= {"Bacon ipsum dolor sit amet sausage pork filet mignon pig bacon venison meatloaf short ribs chuck ground round swine t-bone shankle pancetta.",
										"Shankle flank short ribs short loin, turducken chuck strip steak tail sausage drumstick beef ribs pancetta bresaola chicken turkey.",
										"Ham hock ribeye boudin ham.",
										"Meatball pork chop bresaola ham hock shoulder."};
	
	public static String getName(int bookId) {
		return bookNames[bookId-300];
	}
	
	public static String getDesc(int bookId) {
		return bookDesc[bookId-300];
	}
	
	public static String getBook(int bookId) {
		return bookContents[bookId-300];
	}
	
	public static String[] getBookList() {
		return bookNames;
	}
	
	public static int bookCount() {
		return bookNames.length;
	}
	
}

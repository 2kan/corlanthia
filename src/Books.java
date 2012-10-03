
public class Books {
	
	/** List of all book names */
	private static String[] bookNames		= {"Derp",
										"The Story of Derpina and the Keys",
										"Ode to a Derp",
										"Herpa Derpa"};
	/** List of all book descriptions */
	private static String[] bookDesc		= {"A derpy looking book.",
										"An old book with freshly dried tears on the pages.",
										"A dusty book that looks like it hasn't been touched for decades.",
										"Merpy derpy derp derp derp."};
	/** List of the contents of each book */
	private static String[] bookContents	= {"Derp derp, herpa derp derp. Herpedy derpedy merp derp herp.",
										"Blue Keys go in the deepest, most SOUTHern doors. Rusted Keys come from the EASTern lands. And lastly, rooms beneath the GARDEN ROOM can be unlocked with Orange Keys.",
										"Derpful, Derpful. We derp thee. Herp of derp. Derp of Herp. Herps unfold like derps before herps.",
										"Meatball pork chop bresaola ham hock shoulder."};
	
	/**
	 * Gets the name of the specified book id.
	 * @param bookId	the id of the book to get the name of
	 * @return	 the name of the book
	 */
	public static String getName(int bookId) {
		return bookNames[bookId-300];
	}
	
	/**
	 * Gets the description of the specified book id.
	 * @param bookId	the id of the book
	 * @return	the book's description
	 */
	public static String getDesc(int bookId) {
		return bookDesc[bookId-300];
	}
	
	/**
	 * Gets the contents of the specified book id.
	 * @param bookId	the id of the book
	 * @return	the contents of the book
	 */
	public static String getBook(int bookId) {
		return bookContents[bookId-300];
	}
	
	/**
	 * Gets the list of all books.
	 * @return	 the list of all books
	 */
	public static String[] getBookList() {
		return bookNames;
	}
	
	/**
	 * Counts the total number of books.
	 * @return	the total number of books
	 */
	public static int bookCount() {
		return bookNames.length;
	}
	
}

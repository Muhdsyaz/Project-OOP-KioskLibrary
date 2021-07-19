package Book;

public class BookRecord {
	private static String ID;
	private static String ISBN;
	private static String borrowDate;
	private static String returnDate;
	
	public static String getID() {
		return ID;
	}
	public static void setID(String iD) {
		ID = iD;
	}
	public static String getISBN() {
		return ISBN;
	}
	public static void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public static String getBorrowDate() {
		return borrowDate;
	}
	static void setBorrowDate(String borrowDate) {
		BookRecord.borrowDate = borrowDate;
	}
	
	public static String getReturnDate() {
		return returnDate;
	}
	public static void setReturnDate(String returnDate) {
		BookRecord.returnDate = returnDate;
	}
}
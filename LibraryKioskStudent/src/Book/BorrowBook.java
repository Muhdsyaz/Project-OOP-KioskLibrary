package Book;

public class BorrowBook {
	private static String ISBN;
	private static String ID;
	private static String borrowDate;
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public String getBorrowDate() {
		return borrowDate;
	}
	
	public void setBorrowDate(String borrowDate) {
		BorrowBook.borrowDate = borrowDate;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
	
}
public class Customer {
    public String customerName;
    public int customerID;
    public int booksInUse[] = new int[20];//BookID
    public int booksInUseCount;

    public Customer(String customerName, int customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
        booksInUseCount = 0;
    }

    public void addBook(int bookID) {
        this.booksInUse[booksInUseCount] = bookID;
        booksInUseCount++;
    }

    public int returnBook(int bookInUsePosition) {
        int returnedBookPosition = bookInUsePosition;
        int returnedBookID = booksInUse[returnedBookPosition];
        booksInUse[returnedBookPosition] = 0;
        booksInUseCount--;
        return returnedBookID;
    }
}

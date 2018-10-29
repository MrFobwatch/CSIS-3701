public class Book {
    public String bookTitle;
    public int bookID;
    public int bookType;
    public int qty;

    public Book(String bookTitle, int bookID, int bookType, int qty) {
        this.bookTitle = bookTitle;
        this.bookID = bookID;
        this.bookType = bookType;
        this.qty = qty;
    }

    public void incQty() {
        this.qty++;
    }

    public void decQty() {
        this.qty--;
    }
}

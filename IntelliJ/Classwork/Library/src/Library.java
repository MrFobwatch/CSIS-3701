public class Library {
    Customer LibCustomers[] = new Customer[10];
    Book LibBooks[] = new Book[10];
    private int customerCount = 0;
    private int bookNumCount = 0;

    public Library() {

        LibCustomers[0] = new Customer("Joe", 001);
        customerCount++;
        LibCustomers[1] = new Customer("Jo", 002);
        customerCount++;
        LibCustomers[2] = new Customer("Joseph", 004);
        customerCount++;
        LibCustomers[3] = new Customer("Joey", 003);
        customerCount++;
        LibCustomers[4] = new Customer("Jough", 005);
        customerCount++;

        LibBooks[0] = new Book("StoriesVol1", 001, 10, 3);
        bookNumCount++;
        LibBooks[1] = new Book("StoriesVol2", 002, 20, 3);
        bookNumCount++;
        LibBooks[2] = new Book("StoriesVol3", 003, 30, 3);
        bookNumCount++;
        LibBooks[3] = new Book("StoriesVol4", 003, 40, 3);
        bookNumCount++;
        LibBooks[4] = new Book("StoriesVol5", 004, 50, 3);
        bookNumCount++;
    }

    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.LibCustomers[0].addBook(002);
        myLibrary.LibCustomers[2].addBook(005);
        myLibrary.LibCustomers[3].addBook(003);
        myLibrary.customersWithBooks();
        myLibrary.allLibBooks();
        myLibrary.LibCustomers[2].addBook(003);
        myLibrary.customersWithBooks();
        myLibrary.LibCustomers[2].returnBook(0);
        myLibrary.customersWithBooks();
    }

    public void customersWithBooks() {

        for (int customerNum = 0; customerNum < this.customerCount; customerNum++) {
            Customer currentCustomer = LibCustomers[customerNum];

            if (currentCustomer.booksInUseCount != 0) {
                System.out.println(
                        currentCustomer.customerName + " has " + currentCustomer.booksInUseCount +
                                " books in use.");
//				System.out.println("The title is " + LibBooks[currentCustomer.booksInUse[0]].bookTitle);
            }
        }
    }

    public void allLibBooks() {
        for (int bookNum = 0; bookNum < bookNumCount; bookNum++) {
            Book currentBook = LibBooks[bookNum];
            System.out.println(currentBook.bookTitle);
        }

    }
}

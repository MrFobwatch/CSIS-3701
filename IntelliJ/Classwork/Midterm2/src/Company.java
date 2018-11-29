import java.util.Vector;

public class Company {

    public static void main(String[] args) {
        Vector<Account> accountVector = new Vector<>();
        Account pnsee = new Account("001", "PNSee", 3654987);
        Invoice pnseeInvoice0 = new Invoice("0001", "ATMs", 40, 4000);
        Invoice pnseeInvoice1 = new Invoice("0002", "Bank Vaults", 2, 24999);
        accountVector.add(pnsee);

        Account second = new Account("002", "Second Place", 741369);
        Invoice secondInvoice0 = new Invoice("0003", "Pens", 600, 1);
        Invoice secondInvoice1 = new Invoice("0004", "Notepads", 600, 2);
        accountVector.add(second);

        Account seveneleven = new Account("003", "7 / 11ths ");
        Invoice sevelevInvoice0 = new Invoice("0005", "Checkbooks", 100, 5);
        Invoice sevelevInvoice1 = new Invoice("0006", "Debit Cards", 5000, 3);
        accountVector.add(seveneleven);

        Account lock = new Account("004", "PadLock", 159753);
        Invoice lockInvoice0 = new Invoice("0007", "Safety Deposit Box Keys", 60, 10);
        Invoice lockInvoice1 = new Invoice("0008", "Cameras", 5, 25);
        accountVector.add(lock);

        Account escape = new Account("005", "OK Escape", 5555555);
        Invoice escapeInvoice0 = new Invoice("0009", "Desks", 10, 650);
        Invoice escapeInvoice1 = new Invoice("0010", "Computers", 10, 725);
        accountVector.add(escape);
        System.out.println("These customers have a non-zero balance:");
        for (int index = 0; index < accountVector.size(); index++) {
            if (accountVector.get(index).getBalance() > 0) {
                System.out.println(accountVector.get(index).getName());
            }
        }
        System.out.println("\nThis is the list of all accounts:");
        for (int index = 0; index < accountVector.size(); index++) {
            System.out.println(accountVector.get(index).toString());
        }
    }
}

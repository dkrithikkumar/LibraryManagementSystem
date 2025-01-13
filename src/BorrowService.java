import java.util.Date;

public class BorrowService {
    private static BorrowService borrowService;
    private DisplayService displayService;
    private Inventory inventory;
    private Library library;

    private BorrowService() {
        inventory = Inventory.getInventory();
        library = Library.getLibrary();
        displayService = new DisplayServiceImpl(inventory);
    }

    public static BorrowService getBorrowService() {
        if(borrowService == null) {
            borrowService = new BorrowService();
        }
        return borrowService;
    }

    public void borrowBook(long isbn, Patron patron, int numberOfDays) {
        Inventory inventory = Inventory.getInventory();
        Book selectedBook = inventory.searchBook(isbn);
        if(selectedBook != null) {
            if(selectedBook.isBorrowed()) {
                System.out.println("This Book is borrowed.");
            } else {
                selectedBook.setBorrowed(true);
                selectedBook.setBorrowedBy(patron);

                Date borrowingDate = new Date();
                Date returningDate = new Date(borrowingDate.getTime() + ((long) numberOfDays * 24 * 60 * 60 * 1000));
                BorrowInformation borrowInformation = new BorrowInformation(borrowingDate, returningDate, numberOfDays, selectedBook);
                borrowInformation.setBorrowedBook(selectedBook);
                inventory.addBorrowInformation(borrowInformation, patron);
                displayService.displayBorrowInformation(borrowInformation, patron);
            }
        } else {
            System.out.println("This Book does not exist.");
        }
    }

    public void returnBook(Patron patron, Book book) {
        Inventory inventory = Inventory.getInventory();
        if(book != null) {
            if(!book.isBorrowed()) {
                System.out.println("This Book is available.");
            } else {
                book.setBorrowed(false);

                inventory.removeBorrowInformation(book, patron);
                displayService.displayReturnInformation(patron, book);
            }
        } else {
            System.out.println("This Book does not exist.");
        }
    }
}

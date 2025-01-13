import java.util.ArrayList;
import java.util.List;

public class DisplayServiceImpl implements DisplayService{
    private Inventory inventory;

    public DisplayServiceImpl(Inventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public void displayBookInformation(Book book) {
        if(book.isBorrowed()) {
            System.out.println("---------------------------------");
            System.out.println("        Book Information        ");
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author Name: " + book.getAuthorName());
            System.out.println("Category: " + book.getCategory());
            System.out.println("Language: " + book.getLanguage());
            System.out.println("Publication Year: " + book.getPublicationYear());
            System.out.println("Currently Borrowed By: " + book.getBorrowedBy().getFullName());
            System.out.println("---------------------------------");
        } else {
            System.out.println("---------------------------------");
            System.out.println("        Book Information        ");
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author Name: " + book.getAuthorName());
            System.out.println("Category: " + book.getCategory());
            System.out.println("Language: " + book.getLanguage());
            System.out.println("Publication Year: " + book.getPublicationYear());
            System.out.println("---------------------------------");
        }
    }

    @Override
    public void displayPatronInformation(Patron patron) {
        List<BorrowInformation> currentlyBorrowedBooks = patron.getCurrentlyBorrowedBooks();
        if(!currentlyBorrowedBooks.isEmpty()) {
            List<String> titles = new ArrayList<>();
            for(BorrowInformation info: currentlyBorrowedBooks) {
                String title = info.getBorrowedBook().getTitle();
                titles.add(title);
            }
            System.out.println("---------------------------------");
            System.out.println("        Patron Information        ");
            System.out.println("Name: " + patron.getFullName());
            System.out.println("E-Mail: " + patron.getEmail());
            System.out.println("Phone Number: " + patron.getPhoneNumber());
            System.out.println("Currently Borrowed Books: " + printListItems(titles));
            System.out.println("---------------------------------");
        } else {
            System.out.println("---------------------------------");
            System.out.println("        Patron Information        ");
            System.out.println("Name: " + patron.getFullName());
            System.out.println("E-Mail: " + patron.getEmail());
            System.out.println("Phone Number: " + patron.getPhoneNumber());
            System.out.println("---------------------------------");
        }
    }

    @Override
    public void displayBorrowInformation(BorrowInformation borrowInformation, Patron patron) {
        System.out.println("------------------------------------------------");
        System.out.println("                Borrowing Information           ");
        System.out.println("Borrowing Date: " + borrowInformation.getBorrowedDate());
        System.out.println("Returning Date: " + borrowInformation.getReturnDate());
        System.out.println("Borrowing Period: " + borrowInformation.getBorrowingPeriod());
        System.out.println("Borrowed By: " + patron.getFullName());
        System.out.println("------------------------------------------------");
    }

    @Override
    public void displayReturnInformation(Patron patron, Book book) {
        System.out.println("---------------------------------");
        System.out.println("        Returning Information        ");
        System.out.println(book.getTitle() + " has been Returned By: " + patron.getFullName());
        System.out.println("---------------------------------");
    }

    @Override
    public void displayBorrowingHistory(Patron patron) {
        if(patron.getBorrowHistory().isEmpty()) {
            System.out.println(patron.getFullName() + " has not borrowed any books yet.");
        } else {
            for (int i = 0; i < patron.getBorrowHistory().size() ; i++) {
                BorrowInformation information = patron.getBorrowHistory().get(i);
                System.out.println("-----------------------------------------------");
                System.out.println(patron.getFullName() + "'s Borrowing History ");
                System.out.println("              #" + (i + 1) +  " Borrow            ");
                System.out.println("Borrowing Date: " + patron.getBorrowHistory().get(i).getBorrowedDate());
                System.out.println("Returning Date: " + patron.getBorrowHistory().get(i).getReturnDate());
                System.out.println("Borrowing Period: " + patron.getBorrowHistory().get(i).getBorrowingPeriod());
                System.out.println("Book Title: " + information.getBorrowedBook().getTitle());
                System.out.println("-----------------------------------------------");
            }
        }
    }

    @Override
    public void displayAvailableBooks() {
        List<Book> availableBooks = inventory.getAvailableBooks();
        List<String> availableBooksTitles = new ArrayList<>();
        for(Book book: availableBooks) {
            String str = book.getTitle();
            availableBooksTitles.add(str);
        }
        System.out.println("Available Books:");
        System.out.print(printListItems(availableBooksTitles));
        System.out.println();
        System.out.println();
    }

    @Override
    public void displayBorrowedBooks() {
        List<Book> borroweedBooks = inventory.getBorrowedBooks();
        List<String> borrowedBooksTitles = new ArrayList<>();
        for(Book book: borroweedBooks) {
            String str = book.getTitle();
            borrowedBooksTitles.add(str);
        }
        System.out.println("Borrowed Books:");
        System.out.print(printListItems(borrowedBooksTitles));
        System.out.println();
        System.out.println();
    }

    public StringBuilder printListItems(List<String> list) {
        StringBuilder output = new StringBuilder(" { ");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            if (i == size - 1) {
                output.append("'" + str + "'");
            } else {
                output.append("'" + str + "', ");
            }
        }
        output.append(" }");
        return output;
    }
}

public interface DisplayService {
    void displayBookInformation(Book book);
    void displayPatronInformation(Patron patron);
    void displayBorrowInformation(BorrowInformation borrowInformation, Patron patron);
    void displayReturnInformation(Patron patron, Book book);
    void displayBorrowingHistory(Patron patron);
    void displayAvailableBooks();
    void displayBorrowedBooks();

}

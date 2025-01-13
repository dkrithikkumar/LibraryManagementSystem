    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class Inventory {
        private static Inventory inventory;
        private Map<Long, Book> allBooks;

        private Inventory() {
            allBooks = new HashMap<>();
        }

        public static Inventory getInventory() {
            if (inventory == null) {
                inventory = new Inventory();
            }
            return inventory;
        }

        public void addBook(long isbn, String title, String authorName, String category, String language, int publicationYear) {
            Book newBook = new Book(isbn, title, authorName, category, language, publicationYear);
            newBook.setBorrowed(false);
            newBook.setBorrowedBy(null);
            allBooks.put(isbn, newBook);
            System.out.println("A new book has been added successfully. The title of the book is : " + newBook.getTitle());
        }


        public void deleteBook(long isbn) {
            Book deleteBook = allBooks.get(isbn);
            if(allBooks.containsKey(isbn)) {
                allBooks.remove(isbn);
                System.out.println("The book you selected has been deleted successfully. The title of the book was : " + deleteBook.getTitle());
            } else {
                System.out.println("Book does not exist.");
            }
        }

        public List<Book> getAvailableBooks() {
            List<Book> resultSet = new ArrayList<>();
            for (Map.Entry<Long, Book> entry : allBooks.entrySet()) {
                if (!entry.getValue().isBorrowed()) {
                    resultSet.add(entry.getValue());
                }
            }
            return resultSet;
        }
        public List<Book> getBorrowedBooks() {
            List<Book> resultSet = new ArrayList<>();
            for (Map.Entry<Long, Book> entry : allBooks.entrySet()) {
                if (entry.getValue().isBorrowed()) {
                    resultSet.add(entry.getValue());
                }
            }
            return resultSet;
        }


        public Book searchBook(long isbn) {
            Book book = allBooks.get(isbn);
            if(book != null) {
                return book;
            } else {
                System.out.println("A book with the " + isbn + "  was not found.");
                return null;
            }
        }
        public Book searchBook(String title) {
            for(Map.Entry<Long, Book> entry : allBooks.entrySet()) {
                Book book = entry.getValue();
                if (book.getTitle().equalsIgnoreCase(title))
                    return book;
            }
            System.out.println("A book with the " +  title + "  was not found.");
            return null;
        }


        public void updateBookTitle(long isbn, String updatedTitle) {
            Book book = allBooks.get(isbn);
            String previousTitle = book.getTitle();
            if (book != null) {
                book.setTitle(updatedTitle);
                System.out.println("Book Title has been updated from " + previousTitle + " to " + updatedTitle);
            } else {
                System.out.println("Book not found.");
            }
        }

        public void updateAuthorName(long isbn, String updatedAuthorName) {
            Book book = allBooks.get(isbn);
            String previousAuthorName = book.getAuthorName();
            if (book != null) {
                book.setAuthorName(updatedAuthorName);
                System.out.println("Book Author Name has been updated from " + previousAuthorName + " to " + updatedAuthorName);
            } else {
                System.out.println("Book not found.");
            }
        }

        public void updateLanguage(long isbn, String updatedLanguage) {
            Book book = allBooks.get(isbn);
            String previousLanguage = book.getLanguage();
            if (book != null) {
                book.setLanguage(updatedLanguage);
                System.out.println("Book Language has been updated from " + previousLanguage + " to " + updatedLanguage);
            } else {
                System.out.println("Book not found.");
            }
        }

        public void updateCategory(long isbn, String updatedCategory) {
            Book book = allBooks.get(isbn);
            String previousCategory = book.getCategory();
            if (book != null) {
                book.setCategory(updatedCategory);
                System.out.println("Book Category has been updated from " + previousCategory + " to " + updatedCategory);
            } else {
                System.out.println("Book not found.");
            }
        }

        public void updatePublicationYear(long isbn, int updatedPublicationYear) {
            Book book = allBooks.get(isbn);
            String previousPublicationYear = book.getCategory();
            if (book != null) {
                book.setPublicationYear(updatedPublicationYear);
                System.out.println("Book Publication Year has been updated from " + previousPublicationYear + " to " + updatedPublicationYear);
            } else {
                System.out.println("Book not found.");
            }
        }

        public void addBorrowInformation(BorrowInformation borrowInformation, Patron patron) {
            List<BorrowInformation> borrowInformationList = patron.getBorrowHistory();
            List<BorrowInformation> currentlyBorrowedBooks = patron.getCurrentlyBorrowedBooks();
            borrowInformationList.add(borrowInformation);
            currentlyBorrowedBooks.add(borrowInformation);
            System.out.println("Added to " +  patron.getFullName() + "'s borrowing history.");
        }
        public void removeBorrowInformation(Book book, Patron patron) {
            List<BorrowInformation> currentlyBorrowedBooks = patron.getCurrentlyBorrowedBooks();
            for(BorrowInformation info: currentlyBorrowedBooks) {
                info.setBorrowedBook(book);
                if(info.getBorrowedBook().getIsbn() == book.getIsbn()) {
                    currentlyBorrowedBooks.remove(info);
                }
            }
            System.out.println("The books borrowed by " + patron.getFullName() + " has been returned.");
        }
    }

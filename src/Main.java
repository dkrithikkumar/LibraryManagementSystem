import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getLibrary();
        Inventory inventory = Inventory.getInventory();
        BorrowService borrowService = BorrowService.getBorrowService();
        DisplayService displayService = new DisplayServiceImpl(inventory);

        library.addPatron(10231001L, "Alice Johnson", "alice.johnson@example.com", 9851590499L);
        library.addPatron(10231002L, "Bob Smith", "bob.smith@example.com", 94515904009L);
        library.addPatron(10231003L, "Dwight Schrute", "dwight.schrute@gmail.com", 8791419874L);

        inventory.addBook(9780141036137L, "1984", "George Orwell", "Dystopian", "English", 1949);
        inventory.addBook(9780439139601L, "Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy", "English", 2000);
        inventory.addBook(9780261103573L, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "English", 1954);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("-------------------------------------------------");
                System.out.println("            Library Management System            ");
                System.out.println("-------------------------------------------------");
                System.out.println("Which operations would you like to perform?");
                System.out.println("1. Book Management");
                System.out.println("2. Patron Management");
                System.out.println("3. Inventory Management");
                System.out.println("4. Borrowing Service");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        bookManagement(scanner, inventory, displayService);
                        break;
                    case 2:
                        patronManagement(scanner, library, displayService);
                        break;
                    case 3:
                        inventoryManagement(scanner, inventory, displayService);
                        break;
                    case 4:
                        borrowingService(scanner, library, inventory, displayService, borrowService);
                        break;
                    case 5:
                        System.out.println("Exiting Library Management System.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 5);
    }

    private static void bookManagement(Scanner scanner, Inventory inventory, DisplayService displayService) {
        int choice = -1;
        do {
            try {
                System.out.println("\nBook Management:");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. Search Book");
                System.out.println("4. Update Book by Title");
                System.out.println("5. Update Book by Author Name");
                System.out.println("6. Update Book by Language");
                System.out.println("7. Update Book by Category");
                System.out.println("8. Go Back");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.println("Enter book details (ISBN, Title, Author, Category, Language, Year):");
                            System.out.print("ISBN: ");
                            long isbn = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Title: ");
                            String title = scanner.nextLine();
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            System.out.print("Category: ");
                            String category = scanner.nextLine();
                            System.out.print("Language: ");
                            String language = scanner.nextLine();
                            System.out.print("Year: ");
                            int year = scanner.nextInt();
                            inventory.addBook(isbn, title, author, category, language, year);
                            System.out.println("Book added successfully.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please try again.");
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter ISBN of the book to delete: ");
                            long isbnToDelete = scanner.nextLong();
                            inventory.deleteBook(isbnToDelete);
                            System.out.println("Book deleted successfully.");
                        } catch (Exception e) {
                            System.out.println("Error deleting book: " + e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Enter ISBN of the book to search: ");
                            long isbnToSearch = scanner.nextLong();
                            Book book = inventory.searchBook(isbnToSearch);
                            if (book != null) {
                                displayService.displayBookInformation(book);
                            } else {
                                System.out.println("Book not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error searching book: " + e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Enter ISBN of the book to update: ");
                            long isbnToUpdate = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Enter new Title: ");
                            String newTitle = scanner.nextLine();
                            inventory.updateBookTitle(isbnToUpdate, newTitle);
                            System.out.println("Book title updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Error updating book title: " + e.getMessage());
                        }
                        break;

                    case 5:
                        try {
                            System.out.print("Enter ISBN of the book to update: ");
                            long isbnToUpdate = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Enter new Author Name: ");
                            String newAuthor = scanner.nextLine();
                            inventory.updateAuthorName(isbnToUpdate, newAuthor);
                            System.out.println("Book author updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Error updating book author: " + e.getMessage());
                        }
                        break;

                    case 6:
                        try {
                            System.out.print("Enter ISBN of the book to update: ");
                            long isbnToUpdate = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Enter new Language: ");
                            String newLanguage = scanner.nextLine();
                            inventory.updateLanguage(isbnToUpdate, newLanguage);
                            System.out.println("Book language updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Error updating book language: " + e.getMessage());
                        }
                        break;

                    case 7:
                        try {
                            System.out.print("Enter ISBN of the book to update: ");
                            long isbnToUpdate = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Enter new Category: ");
                            String newCategory = scanner.nextLine();
                            inventory.updateCategory(isbnToUpdate, newCategory);
                            System.out.println("Book category updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Error updating book category: " + e.getMessage());
                        }
                        break;


                    case 8:
                        System.out.println("Returning to main menu.");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        } while (choice != 8);
    }

    private static void patronManagement(Scanner scanner, Library library, DisplayService displayService) {
        int choice = -1;
        do {
            try {
                System.out.println("\nPatron Management:");
                System.out.println("1. Create Patron");
                System.out.println("2. Delete Patron");
                System.out.println("3. Search Patron");
                System.out.println("4. Update Patron by Name");
                System.out.println("5. Update Patron by Email");
                System.out.println("6. Update Patron by Phone Number");
                System.out.println("7. Display Patron Borrowing History");
                System.out.println("8. Go Back");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.println("Enter patron details (ID, Name, Email, Phone):");
                            System.out.print("ID: ");
                            long id = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Phone: ");
                            long phone = scanner.nextLong();
                            library.addPatron(id, name, email, phone);
                            System.out.println("Patron created successfully.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please try again.");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Enter patron ID to delete: ");
                            long idToDelete = scanner.nextLong();
                            library.deletePatron(idToDelete);
                            System.out.println("Patron deleted successfully.");
                        } catch (Exception e) {
                            System.out.println("Error deleting patron: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            System.out.print("Enter patron ID to search: ");
                            long idToSearch = scanner.nextLong();
                            Patron patron = library.searchPatron(idToSearch);
                            if (patron != null) {
                                displayService.displayPatronInformation(patron);
                            } else {
                                System.out.println("Patron not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error searching patron: " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            System.out.print("Enter patron ID to update name: ");
                            long idToUpdate = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            library.updatePatronFullName(idToUpdate, newName);
                            System.out.println("Patron name updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Error updating name: " + e.getMessage());
                        }
                        break;

                    case 5:
                        try {
                            System.out.print("Enter patron ID to update email: ");
                            long idToUpdate = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Enter new email: ");
                            String newEmail = scanner.nextLine();
                            library.updatePatronEmail(idToUpdate, newEmail);
                            System.out.println("Patron email updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Error updating email: " + e.getMessage());
                        }
                        break;

                    case 6:
                        try {
                            System.out.print("Enter patron ID to update phone number: ");
                            long idToUpdate = scanner.nextLong();
                            scanner.nextLine();
                            System.out.print("Enter new phone number: ");
                            long newPhone = scanner.nextLong();
                            library.updatePatronPhoneNumber(idToUpdate, newPhone);
                            System.out.println("Patron phone number updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Error updating phone number: " + e.getMessage());
                        }
                        break;

                    case 7:
                        try {
                            System.out.print("Enter patron ID to display borrowing history: ");
                            long idToSearch = scanner.nextLong();
                            Patron patron = library.searchPatron(idToSearch);
                            if (patron.getBorrowHistory() != null && !patron.getBorrowHistory().isEmpty()) {
                                displayService.displayBorrowingHistory(patron);
                            } else {
                                System.out.println("No borrowing history found.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error retrieving borrowing history: " + e.getMessage());
                        }
                        break;

                    case 8:
                        System.out.println("Returning to main menu.");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        } while (choice != 8);
    }


    private static void inventoryManagement(Scanner scanner, Inventory inventory, DisplayService displayService) {
        int choice = -1;
        do {
            try {
                System.out.println("\nInventory Management:");
                System.out.println("1. Show All Available Books");
                System.out.println("2. Show All Borrowed Books");
                System.out.println("3. Go Back");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        displayService.displayAvailableBooks();
                        break;
                    case 2:
                        displayService.displayBorrowedBooks();
                        break;
                    case 3:
                        System.out.println("Returning to main menu.");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        } while (choice != 3);
    }

    private static void borrowingService(Scanner scanner, Library library, Inventory inventory, DisplayService displayService, BorrowService borrowService) {
        int choice = -1;
        do {
            try {
                System.out.println("\nBorrowing Service:");
                System.out.println("1. Borrow Book");
                System.out.println("2. Return Book");
                System.out.println("3. Go Back");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter Patron ID: ");
                            long patronId = scanner.nextLong();
                            scanner.nextLine();
                            Patron patron = library.searchPatron(patronId);
                            System.out.print("Enter Book ISBN to borrow: ");
                            long isbn = scanner.nextLong();
                            System.out.print("Enter the borrowing period: ");
                            int borrowingPeriod = scanner.nextInt();
                            borrowService.borrowBook(isbn, patron, borrowingPeriod);
                            System.out.println("Book borrowed successfully.");
                        } catch (Exception e) {
                            System.out.println("Error borrowing book: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter Patron ID: ");
                            long patronId = scanner.nextLong();
                            scanner.nextLine();
                            Patron patron = library.searchPatron(patronId);
                            System.out.print("Enter Book ISBN to return: ");
                            long isbn = scanner.nextLong();
                            Book book = inventory.searchBook(isbn);
                            borrowService.returnBook(patron, book);
                            System.out.println("Book returned successfully.");
                        } catch (Exception e) {
                            System.out.println("Error returning book: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Returning to main menu.");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        } while (choice != 3);
    }
}

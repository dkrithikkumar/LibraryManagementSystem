
# Library Management System
This is a simple library management system implemented in Java. It allows users (Patrons) to borrow and return books, manage patron details, and track the available and borrowed books in the library.

## Features
1. Add, delete, and update patron information.
2. Search for patrons by ID or name.
3. Add, delete, and update book information.
4. Search for books by ISBN or title.
5. Borrow and return books.
6. Track the borrow history of patrons.
7. View available and borrowed books in the inventory.

## Classes Overview
### 1. Library
   - A singleton class that manages patrons and their information.
   - Methods to add, delete, search, and update patron details.
### 2. Patron
   - Represents a library user.
   - Stores personal information, borrow history, and currently borrowed books.
   - Methods to update patron details.
### 3. Book
   - Represents a book in the library.
   - Stores book details like ISBN, title, author, category, language, and publication year.
   - Tracks whether the book is borrowed and who borrowed it.
### 4. Inventory
   - Manages the collection of books in the library.
   - Methods to add, delete, search, and update books.
   - Can return lists of available and borrowed books.
### 5. BorrowService
   - Handles book borrowing and returning actions.
   - Updates the book's borrow status and records the borrow information.
   - Displays borrow/return details for patrons.
### 6. BorrowInformation
   - Stores information related to a borrowed book, including borrowing date, return date, and the borrowing period.
   - Associated with a specific book and patron.
### 7. DisplayService
   - Displays information related to borrowing and returning books.
   - Displays patron and book information

## Getting Started
### Prerequisites
- Java 8 or higher.
### How to Run
1. Clone or download the project.
2. Run the `Main` (or Runner) class (this will provide an intuitive menu with which we can interact with the system).

## Class Diagram
![Class Diagram](resources/class_diagram.png)
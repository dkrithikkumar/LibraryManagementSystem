import java.util.ArrayList;
import java.util.List;

public class Patron {
    private long patronId;
    private String fullName;
    private String email;
    private long phoneNumber;
    private List<BorrowInformation> borrowHistory;
    private List<BorrowInformation> currentlyBorrowedBooks;

    public Patron(long patronId, String fullName, String email, long phoneNumber, List<BorrowInformation> borrowHistory, List<BorrowInformation> currentlyBorrowedBooks) {
        this.patronId = patronId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowHistory = borrowHistory;
        this.currentlyBorrowedBooks = currentlyBorrowedBooks;
    }

    public Patron(long patronId, String fullName, String email, long phoneNumber) {
        this.patronId = patronId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getPatronId() {
        return patronId;
    }

    public void setPatronId(long patronId) {
        this.patronId = patronId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BorrowInformation> getBorrowHistory() {
        return borrowHistory;
    }

    public void setBorrowHistory(List<BorrowInformation> borrowHistory) {
        this.borrowHistory = borrowHistory;
    }

    public List<BorrowInformation> getCurrentlyBorrowedBooks() {
        return currentlyBorrowedBooks;
    }

    public void setCurrentlyBorrowedBooks(List<BorrowInformation> currentlyBorrowedBooks) {
        this.currentlyBorrowedBooks = currentlyBorrowedBooks;
    }

}



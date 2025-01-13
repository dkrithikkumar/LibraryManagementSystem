import java.util.Date;

public class BorrowInformation {
    private Date borrowedDate;
    private Date returnDate;
    private int borrowingPeriod;
    private Book borrowedBook;

    public BorrowInformation(Date borrowedDate, Date returnDate, int borrowingPeriod, Book borrowedBook) {
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.borrowingPeriod = borrowingPeriod;
        this.borrowedBook = borrowedBook;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getBorrowingPeriod() {
        return borrowingPeriod;
    }

    public void setBorrowingPeriod(int borrowingPeriod) {
        this.borrowingPeriod = borrowingPeriod;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

}

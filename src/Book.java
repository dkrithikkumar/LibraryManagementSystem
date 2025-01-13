import java.util.Date;

public class Book {
    private long isbn;
    private String title;
    private String authorName;
    private String category;
    private String language;
    private int publicationYear;
    private boolean isBorrowed;
    private Patron borrowedBy;

    public Book(long isbn, String title, String authorName, String category, String language, int publicationYear, boolean isBorrowed, Patron borrowedBy) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.category = category;
        this.language = language;
        this.publicationYear = publicationYear;
        this.isBorrowed = isBorrowed;
        this.borrowedBy = borrowedBy;
    }

    public Book(long isbn, String title, String authorName, String category, String language, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.category = category;
        this.language = language;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }


    public Patron getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Patron borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

}

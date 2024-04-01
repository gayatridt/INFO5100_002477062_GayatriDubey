import java.io.Serializable;

public class Book implements Serializable {
    //region properties
    private String strBookTitle;
    private String strBookAuthor;
    private String strBookGenre;
    private String strBookISBN;
    private boolean boolBookAvailability;
    private int intBookBorrowCount;
    private byte byteBookRating;
    //endregion

    //region constructor
    public Book(String title, String author, String genre, String ISBN, byte rating) {
        this.strBookTitle = title;
        this.strBookAuthor = author;
        this.strBookGenre = genre;
        this.strBookISBN = ISBN;
        this.boolBookAvailability = true;
        this.intBookBorrowCount = 0;
        this.byteBookRating = rating;
    }
    //endregion

    //region methods
    public String getTitle() {
        return strBookTitle;
    }

    public String getAuthor() {
        return strBookAuthor;
    }

    public String getGenre() {
        return strBookGenre;
    }

    public String getISBN() {
        return strBookISBN;
    }

    public boolean isAvailable() {
        return boolBookAvailability;
    }

    public void setAvailability(boolean availability) {
        this.boolBookAvailability = availability;
    }

    public int getBorrowCount() {
        return intBookBorrowCount;
    }

    public void incrementBorrowCount() {
        this.intBookBorrowCount++;
    }

    public byte getRating() {
        return byteBookRating;
    }

    public void setRating(byte rating) {
        this.byteBookRating = rating;
    }

    public String getBookDetails() {
        return "Title: " + strBookTitle + ", Author: " + strBookAuthor + ", Genre: " + strBookGenre + ", ISBN: " + strBookISBN
                + ", Availability: " + (boolBookAvailability ? "Available" : "Not Available") + ", Borrow Count: "
                + intBookBorrowCount + ", Rating: " + byteBookRating;
    }
    //endregion
}

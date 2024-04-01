import java.io.*;
import java.util.*;

class Library implements Serializable {
    //region properties
    private ArrayList<Book> lstBooks;
    private HashMap<String, Integer> userAuthentication;
    //endregion

    //region constructor
    public Library()
    {
        lstBooks = new ArrayList<>();
        userAuthentication = new HashMap<>();
        userAuthentication.put("admin", "password".hashCode());
    }
    //endregion

    //region methods
    public void addBook(Book book)
    {
        lstBooks.add(book);
    }

    public void removeBook(Book book)
    {
        lstBooks.remove(book);
    }

    public List<Book> searchBy(String searchProperty, String searchValue)
    {
        return lstBooks.stream()
                .filter(book -> getProperty(book, searchProperty).equalsIgnoreCase(searchValue))
                .toList();
    }

    private String getProperty(Book book, String property)
    {
        switch (property)
        {
            case "title":
                return book.getTitle();
            case "author":
                return book.getAuthor();
            case "genre":
                return book.getGenre();
            default:
                return "";
        }
    }

    public List<Book> getAllAvailableBooks()
    {
        return lstBooks.stream()
                .filter(Book::isAvailable) //method reference to the isAvailable method of the Book class
                .toList();
    }

    public boolean checkOutBook(Book book)
    {
        if (book.isAvailable())
        {
            book.setAvailability(false);
            book.incrementBorrowCount();
            return true;
        }
        return false;
    }

    public void returnBook(Book book)
    {
        book.setAvailability(true);
    }

    public void sortBooks(Comparator<Book> comparator)
    {
        lstBooks.sort(comparator);
    }

    public boolean authenticateUser(String username, String password)
    {
        return userAuthentication.getOrDefault(username, 0) == password.hashCode();
    }

    public void saveLibraryToFile(String filename)
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) //opens and closes objects in one line
        {
            out.writeObject(this);
            System.out.println("Library data saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving library data to file: " + e.getMessage());
        }
    }

    public static Library loadLibraryFromFile(String filename)
    {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) //opens and closes objects in one line
        {
            Library library = (Library) in.readObject();
            System.out.println("Library data loaded from file: " + filename);
            return library;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading library data from file: " + e.getMessage());
            return null;
        }
    }
    //endregion
}

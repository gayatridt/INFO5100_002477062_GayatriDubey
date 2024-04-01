import java.util.List;
import java.util.*;

public class LibraryApp
{
    public static void main(String[] args)
    {
        Library lib = new Library();

        // Adding books to the library
        lib.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "9780590353427", (byte) 5));
        lib.addBook(new Book("The Da Vinci Code", "Dan Brown", "Mystery", "9780307474278", (byte) 4));
        lib.addBook(new Book("Five Point Someone: What Not to Do at IIT", "Chetan Bhagat", "Fiction", "9788129135508", (byte) 2));
        lib.addBook(new Book("Kane and Abel", "Jeffrey Archer", "Fiction", "9780312942726", (byte) 3));

        // Capturing input from user
        Scanner scanner = new Scanner(System.in);

        // User authentication
        System.out.println("Welcome to the Library Management System!");
        System.out.print("Enter username: ");
        String strUserName = scanner.nextLine();
        System.out.print("Enter password: ");
        String strPassword = scanner.nextLine();
        if (lib.authenticateUser(strUserName, strPassword)) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Display all available books");
            System.out.println("5. Sort books by different criteria");
            System.out.println("6. Check out a book");
            System.out.println("7. Return a book");
            System.out.println("8. Get borrow count of a book");
            System.out.println("9. Save library data to file");
            System.out.println("10. Load library data from file");
            System.out.println("11. Exit");

            int intChoice = scanner.nextInt();
            scanner.nextLine();

            switch (intChoice) {
                case 1:
                    // Adding a new book
                    System.out.println("Enter book details:");
                    System.out.print("Title: ");
                    String strTitle = scanner.nextLine();
                    System.out.print("Author: ");
                    String strAuthor = scanner.nextLine();
                    System.out.print("Genre: ");
                    String strGenre = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String strISBN = scanner.nextLine();
                    System.out.print("Rating: ");
                    byte byteRating = scanner.nextByte();
                    lib.addBook(new Book(strTitle, strAuthor, strGenre, strISBN, byteRating));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    // Removing a book
                    System.out.print("Enter title of the book to remove: ");
                    String strTitleToRemove = scanner.nextLine();
                    List<Book> lstBooksToRemove = lib.searchBy("title", strTitleToRemove);
                    if (!lstBooksToRemove.isEmpty())
                    {
                        Book bookToRemove = lstBooksToRemove.get(0);
                        lib.removeBook(bookToRemove);
                        System.out.println("Book removed successfully.");
                    } else
                    {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    // Searching for a book
                    System.out.println("Search for a book:");
                    System.out.println("1. By title");
                    System.out.println("2. By author");
                    System.out.println("3. By genre");
                    int intSearchChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter search query: ");
                    String strQuery = scanner.nextLine();
                    switch (intSearchChoice) {
                        case 1:
                            displaySearchResults(lib.searchBy("title", strQuery));
                            break;
                        case 2:
                            displaySearchResults(lib.searchBy("author", strQuery));
                            break;
                        case 3:
                            displaySearchResults(lib.searchBy("genre", strQuery));
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 4:
                    // Displaying all available books
                    displaySearchResults(lib.getAllAvailableBooks());
                    break;
                case 5:
                    // Sorting books by different criteria
                    System.out.println("Sorting criteria:");
                    System.out.println("1. By Title");
                    System.out.println("2. By Author");
                    System.out.println("3. By Genre");
                    System.out.println("4. By Borrow count");
                    int intSortChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    switch (intSortChoice) {
                        case 1:
                            // Sort books by title
                            lib.sortBooks(Comparator.comparing(Book::getTitle));
                            System.out.println("Books sorted by title.");
                            break;
                        case 2:
                            // Sort books by author
                            lib.sortBooks(Comparator.comparing(Book::getAuthor));
                            System.out.println("Books sorted by author.");
                            break;
                        case 3:
                            // Sort books by genre
                            lib.sortBooks(Comparator.comparing(Book::getGenre));
                            System.out.println("Books sorted by genre.");
                            break;
                        case 4:
                            // Sort books by borrow count
                            lib.sortBooks(Comparator.comparing(Book::getBorrowCount).reversed());
                            System.out.println("Books sorted by borrow count.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    List<Book> sortedBooks = lib.getAllAvailableBooks();
                    System.out.println("Sorted books:");
                    for (Book book : sortedBooks) {
                        System.out.println(book.getBookDetails());
                    }
                    break;
                case 6:
                    // Checking out a book
                    System.out.print("Enter title of the book to check out: ");
                    String strTitleToCheckOut = scanner.nextLine();
                    List<Book> lstBooksToCheckOut = lib.searchBy("title", strTitleToCheckOut);
                    if (!lstBooksToCheckOut.isEmpty()) {
                        Book bookToCheckOut = lstBooksToCheckOut.get(0);
                        if (lib.checkOutBook(bookToCheckOut))
                        {
                            System.out.println("Book checked out successfully.");
                        } else
                        {
                            System.out.println("Book is not available for checkout.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    // Returning a book
                    System.out.print("Enter title of the book to return: ");
                    String strTitleToReturn = scanner.nextLine();
                    List<Book> lstBooksToReturn = lib.searchBy("title", strTitleToReturn);
                    if (!lstBooksToReturn.isEmpty())
                    {
                        Book bookToReturn = lstBooksToReturn.get(0);
                        lib.returnBook(bookToReturn);
                        System.out.println("Book returned successfully.");
                    } else
                    {
                        System.out.println("Book not found.");
                    }
                    break;
                case 8:
                    // Get borrow count of a book
                    System.out.print("Enter title of the book to get borrow count: ");
                    String strTitleToBorrowCount = scanner.nextLine();
                    List<Book> lstBooksToGetBorrowCount = lib.searchBy("title", strTitleToBorrowCount);
                    if (!lstBooksToGetBorrowCount.isEmpty())
                    {
                        Book bookToGetBorrowCount = lstBooksToGetBorrowCount.get(0);
                        System.out.println("Borrow count for \"" + strTitleToBorrowCount + "\": " + bookToGetBorrowCount.getBorrowCount());
                    } else
                    {
                        System.out.println("Book not found.");
                    }
                    break;
                case 9:
                    // Saving library data to file
                    lib.saveLibraryToFile("library_data.ser");
                    break;
                case 10:
                    // Loading library data from file
                    Library loadedLibrary = Library.loadLibraryFromFile("library_data.ser");
                    if (loadedLibrary != null) {
                        System.out.println("Library data loaded successfully.");
                    }
                    break;
                case 11:
                    // Exit
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    // Method to display search results
    private static void displaySearchResults(List<Book> books)
    {
        if (!books.isEmpty())
        {
            System.out.println("Search results:");
            for (Book book : books)
            {
                System.out.println(book.getBookDetails());
            }
        }
        else
        {
            System.out.println("No matching books found.");
        }
    }
}

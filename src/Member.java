
import java.util.ArrayList;
import java.util.List;

// Encapsulation - private fields with public methods to interact with them
public class Member {
    private int id;
    private String name;
    private String email;
    private List<Book> borrowedBooks;

    public Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    // Methods representing member behaviors
public void borrowBook(Book book) {
    try {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (book.getCopiesAvailable() <= 0) {
            throw new IllegalStateException("No copies available to borrow.");
        }
        book.borrowBook();
        borrowedBooks.add(book);
        System.out.println("Book borrowed successfully.");
    } catch (IllegalArgumentException | IllegalStateException e) {
        System.err.println("Error borrowing book: " + e.getMessage());
    } finally {
        System.out.println("Attempted to borrow a book.");
    }
}

public void returnBook(Book book) {
    try {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (!borrowedBooks.contains(book)) {
            throw new IllegalStateException("This book was not borrowed by the member.");
        }
        book.returnBook();
        borrowedBooks.remove(book);
        System.out.println("Book returned successfully.");
    } catch (IllegalArgumentException | IllegalStateException e) {
        System.err.println("Error returning book: " + e.getMessage());
    } finally {
        System.out.println("Attempted to return a book.");
    }
}

    @Override
    public String toString() {
        return "Member: " + name + ", Email: " + email + ", Borrowed books: " + borrowedBooks.size() + ", ID: " + id;
    }
}

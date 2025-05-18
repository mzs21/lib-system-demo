import java.util.ArrayList;
import java.util.List;

// Encapsulation - private fields with public methods to interact with them
public class Member extends Person {
    private String email;
    private List<Book> borrowedBooks;

    public Member(int id, String name, String email) {
        super(id, name);
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getEmail() { return email; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (borrowedBooks.contains(book)) {
            throw new IllegalStateException("This member has already borrowed this book.");
        }
        if (book.getCopiesAvailable() <= 0) {
            throw new IllegalStateException("No copies available to borrow.");
        }
        if (borrowedBooks.size() >= 5) {
            throw new IllegalStateException("This member has reached the borrowing limit (5 books).");
        }
        book.borrowBook();
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (!borrowedBooks.contains(book)) {
            throw new IllegalArgumentException("This book was not borrowed by the member.");
        }
        book.returnBook();
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member: " + name + ", Email: " + email + ", Borrowed books: " + borrowedBooks.size() + ", ID: " + id;
    }
}
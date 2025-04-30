
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
        if (book != null && book.getCopiesAvailable() > 0) {
            book.borrowBook();
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        if (book != null && borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        }
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", email=" + email + 
               ", borrowedBooks=" + borrowedBooks.size() + "]";
    }
}

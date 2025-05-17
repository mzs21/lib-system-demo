import java.util.ArrayList;
import java.util.List;

// Composition - Library contains Books and Members
public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // Methods for managing books
    public void addBook(Book book) {
        try {
            if (book == null) {
                throw new IllegalArgumentException("Book cannot be null.");
            }
            books.add(book);
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding book: " + e.getMessage());
        } finally {
            System.out.println("Attempted to add a book.");
        }
    }

    public void removeBook(Book book) {
        try {
            if (book == null) {
                throw new IllegalArgumentException("Book cannot be null.");
            }
            books.remove(book);
        } catch (IllegalArgumentException e) {
            System.err.println("Error removing book: " + e.getMessage());
        } finally {
            System.out.println("Attempted to remove a book.");
        }
    }

    public Book getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Methods for managing members
    public void addMember(Member member) {
        try {
            if (member == null) {
                throw new IllegalArgumentException("Member cannot be null.");
            }
            members.add(member);
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding member: " + e.getMessage());
        } finally {
            System.out.println("Attempted to add a member.");
        }
    }

    public Member getMember(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Getters
    public List<Book> getBooks() { return books; }
    public List<Member> getMembers() { return members; }
}
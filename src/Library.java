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
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (getBook(book.getId()) != null) {
            throw new IllegalArgumentException("A book with this ID already exists.");
        }
        books.add(book);
    }

    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (!books.remove(book)) {
            throw new IllegalArgumentException("Book not found in the library.");
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
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if (getMember(member.getId()) != null) {
            throw new IllegalArgumentException("A member with this ID already exists.");
        }
        members.add(member);
    }

    public void removeMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if (!members.remove(member)) {
            throw new IllegalArgumentException("Member not found in the library.");
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
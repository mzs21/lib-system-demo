
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
        if (book != null) {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        if (book != null) {
            books.remove(book);
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
        if (member != null) {
            members.add(member);
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

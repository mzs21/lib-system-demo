
// Inheritance - Librarian could extend a Person class (though not shown in diagram)
public class Librarian {
    private int id;
    private String name;

    public Librarian(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }

    // Methods representing librarian behaviors
    public void addBook(Library library, Book book) {
        if (library != null && book != null) {
            library.addBook(book);
        }
    }

    public void removeBook(Library library, Book book) {
        if (library != null && book != null) {
            library.removeBook(book);
        }
    }

    @Override
    public String toString() {
        return "Librarian [id=" + id + ", name=" + name + "]";
    }
}
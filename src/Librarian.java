public class Librarian extends Person {

    public Librarian(int id, String name) {
        super(id, name);
    }

    public void addBook(Library library, Book book) {
        if (library == null) {
            throw new IllegalArgumentException("Library cannot be null.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        library.addBook(book);
    }

    public void removeBook(Library library, Book book) {
        if (library == null) {
            throw new IllegalArgumentException("Library cannot be null.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        library.removeBook(book);
    }

    
    public String printInfo() {
        return "Librarian - ID:" + id + ", Name=" + name;
    }
}
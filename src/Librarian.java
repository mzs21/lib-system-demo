public class Librarian extends Person {

    public Librarian(int id, String name) {
        super(id, name);
    }

    public void addBook(Library library, Book book) {
        try {
            if (library == null) {
                throw new IllegalArgumentException("Library cannot be null.");
            }
            if (book == null) {
                throw new IllegalArgumentException("Book cannot be null.");
            }
            library.addBook(book);
            System.out.println("Book added successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding book: " + e.getMessage());
        } finally {
            // System.out.println("Attempted to add a book.");
        }
    }

    public void removeBook(Library library, Book book) {
        try {
            if (library == null) {
                throw new IllegalArgumentException("Library cannot be null.");
            }
            if (book == null) {
                throw new IllegalArgumentException("Book cannot be null.");
            }
            library.removeBook(book);
            System.out.println("Book removed successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error removing book: " + e.getMessage());
        } finally {
            // System.out.println("Attempted to remove a book.");
        }
    }

    @Override
    public String toString() {
        return "Librarian - ID:" + id + ", Name=" + name;
    }
}
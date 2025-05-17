public class Book extends LibraryResource {
    private String genre;
    private int publicationYear;
    private int copiesAvailable;

    public Book(int id, String title, String author, String genre, int publicationYear, int copiesAvailable) {
        super(id, title, author);
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.copiesAvailable = copiesAvailable;
    }

    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
    public int getCopiesAvailable() { return copiesAvailable; }

    public void borrowBook() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        } else {
            throw new IllegalStateException("No copies available to borrow.");
        }
    }

    public void returnBook() {
        if (copiesAvailable < 0) {
            throw new IllegalStateException("Copies available cannot be negative.");
        }
        copiesAvailable++;
    }

    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + author + ", Genre: " + genre +
               ", P. Year: " + publicationYear + ", Available copies: " + copiesAvailable + ", ID: " + id;
    }
}
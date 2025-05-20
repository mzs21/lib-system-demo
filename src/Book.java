public class Book extends LibraryResource {
    private String genre;
    private int publicationYear;
    private int copiesAvailable;

    public Book(int id, String title, String author, String genre, int publicationYear, int copiesAvailable) {
        super(id, title, author);
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be null or empty.");
        }
        if (publicationYear < 0) {
            throw new IllegalArgumentException("Publication year cannot be negative.");
        }
        if (copiesAvailable < 0) {
            throw new IllegalArgumentException("Copies available cannot be negative.");
        }
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.copiesAvailable = copiesAvailable;
    }

    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
    public int getCopiesAvailable() { return copiesAvailable; }

    public void borrowBook() {
        if (copiesAvailable <= 0) {
            throw new IllegalStateException("No copies available to borrow.");
        }
        copiesAvailable--;
    }

    public void returnBook() {
        copiesAvailable++;
    }

    @Override
    public String printInfo() {
        return "Book: " + title + ", Author: " + author + ", Genre: " + genre +
               ", P. Year: " + publicationYear + ", Available copies: " + copiesAvailable + ", ID: " + id;
    }
}
// Encapsulation - private fields with public getters/setters
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private int copiesAvailable;

    public Book(int id, String title, String author, String genre, int publicationYear, int copiesAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.copiesAvailable = copiesAvailable;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
    public int getCopiesAvailable() { return copiesAvailable; }
    
    public void setCopiesAvailable(int copiesAvailable) { 
        this.copiesAvailable = copiesAvailable; 
    }

    // Methods representing book behaviors
    public void borrowBook() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void returnBook() {
        copiesAvailable++;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + 
               ", genre=" + genre + ", year=" + publicationYear + ", available=" + copiesAvailable + "]";
    }
}

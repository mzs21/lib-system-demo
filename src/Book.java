public class Book extends LibraryResource {
    private String categoryName;
    private int publicationYear;
    private int copiesAvailable;

    public Book(int id, String title, String author, String categoryName, int publicationYear, int copiesAvailable) {
        super(id, title, author);
        if (categoryName == null || categoryName.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty.");
        }
        if (publicationYear < 0) {
            throw new IllegalArgumentException("Publication year cannot be negative.");
        }
        if (copiesAvailable < 0) {
            throw new IllegalArgumentException("Copies available cannot be negative.");
        }
        this.categoryName = categoryName;
        this.publicationYear = publicationYear;
        this.copiesAvailable = copiesAvailable;
    }

    public String getCategoryName() { return categoryName; }
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
    public String toString() {
        return "Book: " + title + ", Author: " + author +
               ", Category: " + categoryName +
               ", P. Year: " + publicationYear +
               ", Available copies: " + copiesAvailable + ", ID: " + id;
    }
}
public abstract class LibraryResource {
    protected int id;
    protected String title;
    protected String author;

    public LibraryResource(int id, String title, String author) {
        if (id <= 0) {
            throw new IllegalArgumentException("Resource ID must be positive.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public abstract String printInfo();
}
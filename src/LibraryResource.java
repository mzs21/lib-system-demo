public abstract class LibraryResource {
    protected int id;
    protected String title;
    protected String author;

    public LibraryResource(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public abstract String toString();
}

// Inheritance - Could be a subclass of Resource if we had such a class
public class DigitalResource {
    private int id;
    private String title;
    private String type;
    private String author;
    private String fileUrl;

    public DigitalResource(int id, String title, String type, String author, String fileUrl) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.author = author;
        this.fileUrl = fileUrl;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getAuthor() { return author; }
    public String getFileUrl() { return fileUrl; }

    public void accessResource() {
        System.out.println("Accessing digital resource: " + title + " at " + fileUrl);
    }

    @Override
    public String toString() {
        return "DigitalResource [id=" + id + ", title=" + title + ", type=" + type + 
               ", author=" + author + ", url=" + fileUrl + "]";
    }
}

public class DigitalResource extends LibraryResource {
    private String type;
    private String fileUrl;

    public DigitalResource(int id, String title, String author, String type, String fileUrl) {
        super(id, title, author);
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty.");
        }
        if (fileUrl == null || fileUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("File URL cannot be null or empty.");
        }
        this.type = type;
        this.fileUrl = fileUrl;
    }

    public String getType() { return type; }
    public String getFileUrl() { return fileUrl; }

    public void accessResource() {
        System.out.println("Accessing digital resource: " + getTitle() + " at " + fileUrl);
    }

    @Override
    public String toString() {
        return "DigitalResource: " + title + ", Author: " + author + ", Type: " + type +
               ", URL: " + fileUrl + ", ID: " + id;
    }
}
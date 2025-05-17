public class DigitalResource extends LibraryResource {
    private String type;
    private String fileUrl;

    public DigitalResource(int id, String title, String author, String type, String fileUrl) {
        super(id, title, author);
        this.type = type;
        this.fileUrl = fileUrl;
    }

    public String getType() { return type; }
    public String getFileUrl() { return fileUrl; }

    public void accessResource() {
        try {
            if (fileUrl == null || fileUrl.trim().isEmpty()) {
                throw new IllegalArgumentException("File URL is invalid or missing.");
            }
            System.out.println("Accessing digital resource: " + title + " at " + fileUrl);
        } catch (IllegalArgumentException e) {
            System.err.println("Error accessing resource: " + e.getMessage());
        } finally {
            // System.out.println("Attempted to access digital resource.");
        }
    }

    @Override
    public String toString() {
        return "DigitalResource: " + title + ", Author: " + author + ", Type: " + type +
               ", URL: " + fileUrl + ", ID: " + id;
    }
}
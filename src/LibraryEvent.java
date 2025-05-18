import java.time.LocalDate;

public class LibraryEvent {
    private int id;
    private String title;
    private String description;
    private LocalDate date;

    public LibraryEvent(int id, String title, String description, LocalDate date) {
        if (id <= 0) {
            throw new IllegalArgumentException("Event ID must be positive.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Event title cannot be null or empty.");
        }
        if (description == null) {
            description = "";
        }
        if (date == null) {
            throw new IllegalArgumentException("Event date cannot be null.");
        }
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }

    public String libraryEventInfo() {
        return "Event: " + title + ", Date: " + date + ", Description: " + description + ", ID: " + id;
    }
}
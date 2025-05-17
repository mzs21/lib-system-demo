import java.time.LocalDate;

public class LibraryEvent {
    private int id;
    private String title;
    private String description;
    private LocalDate date;

    public LibraryEvent(int id, String title, String description, LocalDate date) {
        try {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Event title cannot be null or empty.");
            }
            if (date == null) {
                throw new IllegalArgumentException("Event date cannot be null.");
            }
            this.id = id;
            this.title = title;
            this.description = description;
            this.date = date;
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating LibraryEvent: " + e.getMessage());
            
            throw e;
        } finally {
            System.out.println("Attempted to create a LibraryEvent.");
        }
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

import java.time.LocalDate;

public class LibraryEvent {
    private int id;
    private String title;
    private String description;
    private LocalDate date;

    public LibraryEvent(int id, String title, String description, LocalDate date) {
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
        return "Event [id=" + id + ", title=" + title + ", date=" + date + 
               ", description=" + description + "]";
    }
}

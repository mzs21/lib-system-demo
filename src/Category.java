
public class Category {
    private int id;
    private String name;
    private String description;

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    public String categoryDetails() {
        return "Category: Name: " + name + ", Description: " + description + ", ID: " + id;
    }
}
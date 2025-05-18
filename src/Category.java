public class Category {
    private int id;
    private String name;
    private String description;

    public Category(int id, String name, String description) {
        if (id <= 0) {
            throw new IllegalArgumentException("Category ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty.");
        }
        if (description == null) {
            description = "";
        }
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    public String categoryDetails() {
        return "Category: " + name + " - " + description + " (ID: " + id + ")";
    }
}
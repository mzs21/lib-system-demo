public abstract class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Person ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
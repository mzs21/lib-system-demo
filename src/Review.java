

// Association - Review connects Book and Member
public class Review {
    private int id;
    private int bookId;
    private int memberId;
    private int rating;
    private String comment;

    public Review(int id, int bookId, int memberId, int rating, String comment) {
        try {
            if (rating < 1 || rating > 5) {
                throw new IllegalArgumentException("Rating must be between 1 and 5.");
            }
            if (comment == null) {
                throw new IllegalArgumentException("Comment cannot be null.");
            }
            this.id = id;
            this.bookId = bookId;
            this.memberId = memberId;
            this.rating = rating;
            this.comment = comment;
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating Review: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Attempted to create a Review.");
        }
    }

    // Getters
    public int getId() { return id; }
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }

    public String reviewDetails() {
        return "Review: Book ID: " + bookId + ", Member ID: " + memberId + ", Rating: " + rating + ", Comment: " + comment + ", ID: " + id;
    }
}
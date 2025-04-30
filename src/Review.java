

// Association - Review connects Book and Member
public class Review {
    private int id;
    private int bookId;
    private int memberId;
    private int rating;
    private String comment;

    public Review(int id, int bookId, int memberId, int rating, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters
    public int getId() { return id; }
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }

    public String reviewDetails() {
        return "Review [id=" + id + ", bookId=" + bookId + ", memberId=" + memberId + 
               ", rating=" + rating + ", comment=" + comment + "]";
    }
}
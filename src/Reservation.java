import java.time.LocalDate;

// Association - Reservation connects Book and Member
public class Reservation {
    private int id;
    private int bookId;
    private int memberId;
    private LocalDate reservationDate;

    public Reservation(int id, int bookId, int memberId, LocalDate reservationDate) {
        try {
            if (reservationDate == null) {
                throw new IllegalArgumentException("Reservation date cannot be null.");
            }
            this.id = id;
            this.bookId = bookId;
            this.memberId = memberId;
            this.reservationDate = reservationDate;
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating Reservation: " + e.getMessage());
            throw e;
        } finally {
            // System.out.println("Attempted to create a Reservation.");
        }
    }

    // Getters
    public int getId() { return id; }
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public LocalDate getReservationDate() { return reservationDate; }

    public String reservationInfo() {
        return "Reservation: Book ID: " + bookId + ", Member ID: " + memberId + ", Date: " + reservationDate + ", ID: " + id;
    }
}
import java.time.LocalDate;

// Association - Reservation connects Book and Member
public class Reservation {
    private int id;
    private int bookId;
    private int memberId;
    private LocalDate reservationDate;

    public Reservation(int id, int bookId, int memberId, LocalDate reservationDate) {
        if (id <= 0) {
            throw new IllegalArgumentException("Reservation ID must be positive.");
        }
        if (bookId <= 0) {
            throw new IllegalArgumentException("Book ID must be positive.");
        }
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be positive.");
        }
        if (reservationDate == null) {
            throw new IllegalArgumentException("Reservation date cannot be null.");
        }
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.reservationDate = reservationDate;
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
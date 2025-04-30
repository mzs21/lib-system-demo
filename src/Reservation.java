import java.time.LocalDate;

// Association - Reservation connects Book and Member
public class Reservation {
    private int id;
    private int bookId;
    private int memberId;
    private LocalDate reservationDate;

    public Reservation(int id, int bookId, int memberId, LocalDate reservationDate) {
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
        return "Reservation [id=" + id + ", bookId=" + bookId + 
               ", memberId=" + memberId + ", date=" + reservationDate + "]";
    }
}
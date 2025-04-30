
import java.time.LocalDate;

// Association - Loan connects Book and Member
public class Loan {
    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan(int bookId, int memberId, LocalDate borrowDate, LocalDate returnDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public String loanDetails() {
        return "Loan [bookId=" + bookId + ", memberId=" + memberId + 
               ", borrowed=" + borrowDate + ", return=" + returnDate + "]";
    }
}


import java.time.LocalDate;

// Association - Loan connects Book and Member
public class Loan {
    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan(int bookId, int memberId, LocalDate borrowDate, LocalDate returnDate) {
        try {
            if (borrowDate == null) {
                throw new IllegalArgumentException("Borrow date cannot be null.");
            }
            if (returnDate != null && returnDate.isBefore(borrowDate)) {
                throw new IllegalArgumentException("Return date cannot be before borrow date.");
            }
            this.bookId = bookId;
            this.memberId = memberId;
            this.borrowDate = borrowDate;
            this.returnDate = returnDate;
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating Loan: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Attempted to create a Loan.");
        }
    }

    // Getters
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public String loanDetails() {
        return "Loan: Book ID: " + bookId + ", Member ID: " + memberId +
       ", Borrowed: " + borrowDate + ", Return: " + returnDate;
    }
}

import java.time.LocalDate;

public class Loan {
    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate dueDate;

    public Loan(int bookId, int memberId, LocalDate borrowDate, LocalDate returnDate) {
        if (bookId <= 0) {
            throw new IllegalArgumentException("Book ID must be positive.");
        }
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be positive.");
        }
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
        this.dueDate = borrowDate.plusDays(7); // Set due date to 7 days after borrow date
    }

    // Getters
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public LocalDate getDueDate() { return dueDate; }

    public void setReturnDate(LocalDate date) {
        if (date != null && date.isBefore(borrowDate)) {
            throw new IllegalArgumentException("Return date cannot be before borrow date.");
        }
        this.returnDate = date;
    }

    public String loanDetails() {
        return "Loan: Book ID: " + bookId +
               ", Member ID: " + memberId +
               ", Borrowed: " + borrowDate +
               ", Due: " + dueDate +
               ", Return: " + (returnDate != null ? returnDate.toString() : "Not returned yet");
    }
}
// Association - Fine is associated with Member
public class Fine {
    private int memberId;
    private double amount;

    public Fine(int memberId, double amount) {
        this.memberId = memberId;
        this.amount = amount;
    }

    // Getters
    public int getMemberId() { return memberId; }
    public double getAmount() { return amount; }

    public void payFine(double payment) {
        try {
            if (payment <= 0) {
                throw new IllegalArgumentException("Payment must be positive.");
            }
            if (payment > amount) {
                throw new IllegalArgumentException("Payment exceeds the fine amount.");
            }
            amount -= payment;
            System.out.println("Payment successful. Remaining fine: " + amount);
        } catch (IllegalArgumentException e) {
            System.err.println("Error paying fine: " + e.getMessage());
        } finally {
            System.out.println("Attempted to pay fine.");
        }
    }

    @Override
    public String toString() {
        return "Fine - Member ID: " + memberId + ", Amount: " + amount;
    }
}
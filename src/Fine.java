public class Fine {
    private int memberId;
    private double amount;

    public Fine(int memberId, double amount) {
        if (memberId <= 0) {
            throw new IllegalArgumentException("Member ID must be positive.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Fine amount cannot be negative.");
        }
        this.memberId = memberId;
        this.amount = amount;
    }

    public int getMemberId() { return memberId; }
    public double getAmount() { return amount; }

    public void payFine(double payment) {
        if (payment <= 0) {
            throw new IllegalArgumentException("Payment must be positive.");
        }
        if (payment > amount) {
            throw new IllegalArgumentException("Payment exceeds the fine amount.");
        }
        amount -= payment;
        System.out.println("Payment successful. Remaining fine: " + amount);
    }

    
    public String printInfo() {
        return "Fine - Member ID: " + memberId + ", Amount: " + amount;
    }
}
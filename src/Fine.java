
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
        if (payment > 0 && payment <= amount) {
            amount -= payment;
        }
    }

    @Override
    public String toString() {
        return "Fine [memberId=" + memberId + ", amount=" + amount + "]";
    }
}

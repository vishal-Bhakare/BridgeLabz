package bridgelabzjava8features;

public class CustomerSummary {

    private double totalAmount;
    private double averageAmount;

    public CustomerSummary(double totalAmount, double averageAmount) {
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public double getTotalAmount() { return totalAmount; }
    public double getAverageAmount() { return averageAmount; }

    @Override
    public String toString() {
        return "CustomerSummary{" +
                "totalAmount=" + totalAmount +
                ", averageAmount=" + averageAmount +
                '}';
    }
}

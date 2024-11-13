package bridgelabzjava8features;

public class TransactionFraudSummary {

    private int fraudCount;
    private double totalFraudAmount;

    public TransactionFraudSummary(int fraudCount, double totalFraudAmount) {
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    public int getFraudCount() {
        return fraudCount;
    }

    public void setFraudCount(int fraudCount) {
        this.fraudCount = fraudCount;
    }

    public double getTotalFraudAmount() {
        return totalFraudAmount;
    }

    public void setTotalFraudAmount(double totalFraudAmount) {
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "TransactionFraudSummary{" +
                "fraudCount=" + fraudCount +
                ", totalFraudAmount=" + totalFraudAmount +
                '}';
    }
}

package bridgelabzjava8features;

public class Transaction {
    private int transactionId;
    private String policyNumber;
    private double amount;
    private String transactionDate;
    private boolean isFraudulent;

    public Transaction(int transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    public void setFraudulent(boolean fraudulent) {
        isFraudulent = fraudulent;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", policyNumber='" + policyNumber + '\'' + ", amount=" + amount + ", transactionDate='" + transactionDate + '\'' + ", isFraudulent=" + isFraudulent + '}';
    }
}

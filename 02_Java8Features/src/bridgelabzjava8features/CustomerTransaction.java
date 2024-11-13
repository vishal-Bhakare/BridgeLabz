package bridgelabzjava8features;

import java.time.LocalDate;

public class CustomerTransaction {

    private String customerId;
    private LocalDate transactionDate;
    private double transactionAmount;

    public CustomerTransaction(String customerId, LocalDate transactionDate, double transactionAmount) {
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "CustomerTransaction{" +
                "customerId='" + customerId + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                '}';
    }




}

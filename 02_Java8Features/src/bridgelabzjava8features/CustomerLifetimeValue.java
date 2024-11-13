package bridgelabzjava8features;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerLifetimeValue {

    public static void main(String[] args) {
        List<CustomerTransaction> transactions = Arrays.asList(
                new CustomerTransaction("C1001", LocalDate.now().minusMonths(1), 200.0),
                new CustomerTransaction("C1002", LocalDate.now().minusMonths(5), 300.0),
                new CustomerTransaction("C1001", LocalDate.now().minusMonths(6), 150.0),
                new CustomerTransaction("C1003", LocalDate.now().minusMonths(8), 500.0),
                new CustomerTransaction("C1002", LocalDate.now().minusMonths(10), 250.0),
                new CustomerTransaction("C1004", LocalDate.now().minusMonths(11), 450.0),
                new CustomerTransaction("C1005", LocalDate.now().minusMonths(13), 100.0),
                new CustomerTransaction("C1001", LocalDate.now().minusMonths(2), 350.0),
                new CustomerTransaction("C1003", LocalDate.now().minusMonths(4), 600.0),
                new CustomerTransaction("C1002", LocalDate.now().minusMonths(7), 400.0)
        );

        calculateCustomerLifetimeValue(transactions);
    }

    private static void calculateCustomerLifetimeValue(List<CustomerTransaction> transactions) {

        LocalDate today = LocalDate.now();

        //  Filter transactions within the last 12 months
        List<CustomerTransaction> recentTransactions = transactions.stream()
                .filter(transaction -> ChronoUnit.MONTHS.between(transaction.getTransactionDate(), today) <= 12)
                .collect(Collectors.toList());

        recentTransactions.forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

        //  Aggregate total and average transaction amounts per customer


    }
}

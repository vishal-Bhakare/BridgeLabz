package bridgelabzjava8features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionMain {

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction(101, "P1001", 15000.0, "2023-08-01", true),
                new Transaction(102, "P1002", 8000.0, "2023-08-05", true),
                new Transaction(103, "P1001", 12000.0, "2023-08-12", true),
                new Transaction(104, "P1003", 20000.0, "2023-08-15", false),
                new Transaction(105, "P1001", 25000.0, "2023-08-20", false),
                new Transaction(106, "P1001", 11000.0, "2023-08-22", false),
                new Transaction(107, "P1003", 16000.0, "2023-08-25", true),
                new Transaction(108, "P1001", 13000.0, "2023-08-30", true),
                new Transaction(109, "P1001", 500000.0, "2023-09-01", true)
        );
              detectFraud(transactions);
    }

    public static void detectFraud(List<Transaction> transactions){

        //1. Filter: Select transactions marked as fraudulent (isFraudulent is true) and where the
        //amount exceeds $10,000.

        List<Transaction> tranc = transactions.stream().filter(trans -> trans.isFraudulent() && trans.getAmount() > 10000).collect(Collectors.toList());
                         tranc.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

      //2. Group: Group these transactions by policyNumber
        Map<String, List<Transaction>> policy = tranc.stream().collect(Collectors.groupingBy(Transaction::getPolicyNumber));
        policy.forEach((policyno , trancs)->{
            System.out.println("Policy No : "+policyno);
            trancs.forEach(System.out::println);
        });

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //3. Aggregate: For each policy, calculate the total number of fraudulent transactions and
        //the total amount of fraud.
        Map<String, TransactionFraudSummary> fraudSummaryByPolicy = policy.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new TransactionFraudSummary(
                                entry.getValue().size(),
                                entry.getValue().stream().mapToDouble(Transaction::getAmount).sum()
                        )
                   ));

        fraudSummaryByPolicy.forEach((policyNumber, summary) -> {
            System.out.println("Policy Number: " + policyNumber + " - " + summary);
        });

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //4. Alert: Generate an alert for policies with more than 5 fraudulent transactions or a total
        //fraud amount exceeding $50,000.

        fraudSummaryByPolicy.entrySet().stream()
                .filter(entry -> entry.getValue().getFraudCount() > 5 || entry.getValue().getTotalFraudAmount() > 50000)
                .forEach(entry -> System.out.println("ALERT: Policy " + entry.getKey() + " has suspicious fraud activity! " + entry.getValue()));
    }
}

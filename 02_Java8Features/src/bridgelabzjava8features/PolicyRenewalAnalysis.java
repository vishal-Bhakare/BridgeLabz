package bridgelabzjava8features;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PolicyRenewalAnalysis {

    public static void main(String[] args) {

        List<Policy> policies = Arrays.asList(
                new Policy(101, "PH1001", LocalDate.now().plusDays(15), 500.0, "Active"),
                new Policy(102, "PH1002", LocalDate.now().plusDays(10), 600.0, "Active"),
                new Policy(103, "PH1003", LocalDate.now().plusDays(5), 700.0, "Inactive"),
                new Policy(104, "PH1001", LocalDate.now().plusDays(20), 800.0, "Active"),
                new Policy(140, "PH1004", LocalDate.now().plusDays(40), 900.0, "Active"),
                new Policy(1050, "PH1002", LocalDate.now().plusDays(25), 650.0, "Inactive")
        );

        analyzeRenewals(policies);
    }

    private static void analyzeRenewals(List<Policy> policies) {
        LocalDate today = LocalDate.now();
        //1. Filter: Select policies that are due for renewal within the next 30 days and have a
        //status of "Active".
        List<Policy> dueForRenewal = policies.stream().filter(policy -> policy.getStatus().equalsIgnoreCase("Active") && ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30)
                .collect(Collectors.toList());
        dueForRenewal.forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    //2. Transform: Create a new list of RenewalReminder objects containing policyId,
        //policyHolderId, and the remaining days until expiry

        List<PolicyRenewalReminder> reminders = policies.stream().map(policy -> new PolicyRenewalReminder(policy.getPolicyId(), policy.getPolicyHolderId(), ChronoUnit.DAYS.between(today, policy.getExpiryDate())))
                .collect(Collectors.toList());
        reminders.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //3. Sort: Sort these reminders by the remaining days until expiry in ascending order
        List<PolicyRenewalReminder> sortedReminders = reminders.stream()
                .sorted((r1, r2) -> Long.compare(r1.getRemainingDays(), r2.getRemainingDays()))
                .collect(Collectors.toList());
        sortedReminders.forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

       //4. Group: Group these reminders by policyHolderId.
        Map<String, List<PolicyRenewalReminder>> remindersByHolder = sortedReminders.stream()
                                                 .collect(Collectors.groupingBy(PolicyRenewalReminder::getPolicyHolderId));

        remindersByHolder.forEach((policyHolderId, reminderList) -> {
            System.out.println("Policy Holder ID: " + policyHolderId);
            reminderList.forEach(System.out::println);
        });
    }
}
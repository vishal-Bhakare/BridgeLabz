package bridgelabzjava8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PolicyHolderMain {
    public static void main(String[] args) {
        List<PolicyHolder> policyHolders = Arrays.asList(
                new PolicyHolder(101, "Vishal", 65, "Life", 400.0),
                new PolicyHolder(102, "Smith", 70, "Health", 300.0),
                new PolicyHolder(103, "Sauraabh", 62, "Life", 600.0),
                new PolicyHolder(104, "Pushpak", 55, "Health", 450.0),
                new PolicyHolder(105, "Vaibhav", 55, "Life", 350.0),
                new PolicyHolder(106, "Om", 66, "Life", 500.0)
        );
        RiskAssessment(policyHolders);
    }
    public static void RiskAssessment(List<PolicyHolder> holder) {

        //1. Filter: Select policyholders with a policyType of "Life" and age greater than 60.
        List<PolicyHolder> life = holder.stream().filter(hold -> hold.getPolicyType().equalsIgnoreCase("LIFE") && hold.getAge() > 60).collect(Collectors.toList());
        life.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        //2. Transform: Create a new list of RiskAssessment objects containing holderId, name,
        //and a risk score calculated as premiumAmount / age.
        List<PolicyRiskAssessment> riskAssessments = life.stream().map(hold -> new PolicyRiskAssessment(hold.getHolderId(), hold.getName(), hold.getPremiumAmount() / hold.getAge())).collect(Collectors.toList());
        riskAssessments.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        //3. Sort: Sort these risk assessments by the risk score in descending order.
        List<PolicyRiskAssessment> sortedRiskAssessments = riskAssessments.stream().sorted(Comparator.comparingDouble(PolicyRiskAssessment::getRiskScore).reversed()).collect(Collectors.toList());
        sortedRiskAssessments.forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        //4. Categorize: Group these policy holders into risk categories: "High Risk" for risk scores
        //above 0.5 and "Low Risk" otherwise.

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        Map<String, List<PolicyRiskAssessment>> risk = sortedRiskAssessments.stream().collect(Collectors.groupingBy(asses -> asses.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));
        risk.forEach((category, assessments) -> {
            System.out.println(category + ":");
            assessments.forEach(System.out::println);
        });
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
    }
}

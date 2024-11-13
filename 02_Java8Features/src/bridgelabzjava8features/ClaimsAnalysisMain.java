package bridgelabzjava8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClaimsAnalysisMain {

    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
                new Claim("C101", "P1001", 7000.0, "2023-08-01", "Approved"),
                new Claim("C102", "P1002", 3000.0, "2023-08-05", "Approved"),
                new Claim("C103", "P1001", 6000.0, "2023-08-12", "Approved"),
                new Claim("C104", "P1003", 15000.0, "2023-08-15", "Approved"),
                new Claim("C105", "P1004", 8000.0, "2023-08-20", "Rejected"),
                new Claim("C106", "P1002", 9000.0, "2023-08-22", "Rejected"),
                new Claim("C107", "P1003", 12000.0, "2023-08-25", "Rejected")
        );
        analyzeClaims(claims);
    }

    public static void analyzeClaims(List<Claim> claims) {
        //  Filter claims with "Approved" status and claimAmount > 5,000
        List<Claim> filteredClaims = claims.stream()
                .filter(claim -> claim.getStatus().equalsIgnoreCase("Approved") && claim.getClaimAmount() > 5000)
                .collect(Collectors.toList());
        filteredClaims.forEach(e -> System.out.println(e));

        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        //  Group filtered claims by policyNumber
        Map<String, List<Claim>> claimsByPolicy = filteredClaims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        for (Map.Entry<String, List<Claim>> entry : claimsByPolicy.entrySet()) {
            String key = entry.getKey();
            List<Claim> value = entry.getValue();
            for (Claim c : value) {
                System.out.println("Policy No " + key + "  Ploicy No : " + c.getStatus());
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

    }
}

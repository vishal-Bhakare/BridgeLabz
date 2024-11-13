package logics;
import java.util.regex.Pattern;

public class RejextConcept {

    private String name;
    private String city;

    private static final String NAME = "^[A-Za-z]+$";
    private static final String CITY = "^[A-Za-z0-9]+$";

    public boolean validateName(String name) {
        return Pattern.matches(NAME, name);
    }

    public boolean validateCity(String city) {
        return Pattern.matches(CITY, city);
    }
    public static void main(String[] args) {
        RejextConcept rc = new RejextConcept();
        System.out.println("Name Validation for 'Vishal': " + rc.validateName("Vishal"));
        System.out.println("City Validation for 'Mumbai123': " + rc.validateCity("Mumbai123"));
    }
}


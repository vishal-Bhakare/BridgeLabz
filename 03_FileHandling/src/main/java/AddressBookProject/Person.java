package AddressBookProject;

import java.util.Date;
import java.util.regex.Pattern;

public class Person {
    private String firstName;
    private String lastName;
    private String state;
    private String city;
    private int pincode;
    private double salary;
    private Date date;

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z]+$");
    private static final Pattern PINCODE_PATTERN = Pattern.compile("^[1-9][0-9]{5}$");
    private static final Pattern STATE_CITY_PATTERN = Pattern.compile("^[A-Za-z\\s]+$");

    public Person(String firstName, String lastName, String state, String city, int pincode, double salary, Date date)
            throws CustomValidationException {
        super();

        if (!NAME_PATTERN.matcher(firstName).matches()) {
            throw new CustomValidationException("Invalid first name. Only alphabets are allowed.");
        }

        if (!NAME_PATTERN.matcher(lastName).matches()) {
            throw new CustomValidationException("Invalid last name. Only alphabets are allowed.");
        }

        if (!STATE_CITY_PATTERN.matcher(state).matches()) {
            throw new CustomValidationException("Invalid state name. Only alphabets and spaces are allowed.");
        }

        if (!STATE_CITY_PATTERN.matcher(city).matches()) {
            throw new CustomValidationException("Invalid city name. Only alphabets and spaces are allowed.");
        }

        if (!PINCODE_PATTERN.matcher(String.valueOf(pincode)).matches()) {
            throw new CustomValidationException(
                    "Invalid pincode. It should be a 6-digit number starting with a non-zero.");
        }

        if (salary < 0) {
            throw new CustomValidationException("Salary cannot be negative.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.salary = salary;
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", state=" + state + ", city=" + city
                + ", pincode=" + pincode + ", salary=" + salary + ", date=" + date + "]";
    }

    public String toFileString() {
        return firstName + "," + lastName + "," + state + "," + city + "," + pincode + "," + salary + "," + date.getTime();
    }

}

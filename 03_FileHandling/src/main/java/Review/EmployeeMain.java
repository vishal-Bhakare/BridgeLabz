package Review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

    private static final String path = "E:\\FileHandling\\Review.txt";

    public static void writeEmployee(List<Employee> emp) {
        try (ObjectOutputStream oj = new ObjectOutputStream(new FileOutputStream(path))) {
            oj.writeObject(emp);
            System.out.println("Employee Data Written Successfully");
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for better debugging
        }
    }

    public static List<Employee> readEmployee() {
        List<Employee> emp = new ArrayList<>();

        try (ObjectInputStream oj = new ObjectInputStream(new FileInputStream(path))) {
            emp = (List<Employee>) oj.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Print stack trace for better debugging
        }
        return emp;
    }

    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "Vishal", 2000.00));
        emp.add(new Employee(2, "Saurabh", 22000.00));
        emp.add(new Employee(3, "Sahil", 25000.00));

        writeEmployee(emp);

        List<Employee> employees = readEmployee();

        for (Employee emps : employees) {
            System.out.println(emps);
        }
    }
}

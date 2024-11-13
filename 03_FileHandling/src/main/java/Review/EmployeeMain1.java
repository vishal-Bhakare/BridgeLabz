package Review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMain1 {

    private static final String path = "E:\\FileHandling\\Review.txt"; // Set your file path here

    public static void writeEmployee(List<Employee> emp) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            for (Employee employee : emp) {
                writer.write(employee.getEmpId() + "," + employee.getEmpName() + "," + employee.getSalary());
                writer.newLine();
            }
            System.out.println("Employee Data Written Successfully in the specified format");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Employee> readEmployee() {
        List<Employee> emp = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double salary = Double.parseDouble(data[2]);
                emp.add(new Employee(id, name, salary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "Vishal", 2000.00));
        emp.add(new Employee(2, "Saurabh", 22000.00));
        emp.add(new Employee(3, "Sahil", 25000.00));

        writeEmployee(emp); // Write to file

        List<Employee> employees = readEmployee(); // Read from file

        // Print the read employee data to confirm
        for (Employee emps : employees) {
            System.out.println(emps);
        }
    }
}


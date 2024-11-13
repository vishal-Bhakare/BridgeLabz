package bridgelabzjava8features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {

    public static void employeeDate(List<Employee> employees) {

        // Filter employees in the "Engineering" department with salary > 80000
        List<Employee> sortEmp = employees.stream().filter(emp -> emp.getDepartment()
                        .equalsIgnoreCase("Engineering") && emp.getSalary() > 80000)
                .collect(Collectors.toList());
        for (Employee emp : sortEmp) {
            System.out.println("1)--Department and Salary : " + emp);
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

        // Sort filtered employees by salary in descending order
        List<Employee> descSalary = sortEmp.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
                .reversed()).collect(Collectors.toList());

        for (Employee emp : descSalary) {
            System.out.println("2)--Salary In Decending Order : " + emp);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

        //Group employees by department
        Map<String, List<Employee>> groupDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        for (Map.Entry<String, List<Employee>> entry : groupDepartment.entrySet()) {

            String department = entry.getKey();
            List<Employee> employeeList = entry.getValue();

            System.out.println("Department: " + department);
            for (Employee employee : employeeList) {
                System.out.println("3)--  " + employee);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

          //Calculate average salary for each department
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        averageSalaryByDepartment.forEach((department, avgSalary) ->
                System.out.println("Department: " + department + ", Average Salary: $" + avgSalary)
        );

    }

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "VISHAL", "Engineering", 1000000));
        list.add(new Employee(2, "SAUARABH", "DEVELOPER", 100000));
        list.add(new Employee(3, "SMITH", "IT", 90000));
        list.add(new Employee(4, "SAHAIL", "Engineering", 1850000));
        list.add(new Employee(5, "AKSHAY", "MARKETING", 820000));
        list.add(new Employee(6, "KESHAV", "Engineering", 50000));
        list.add(new Employee(7, "PRAVIN", "IT", 40000));
        employeeDate(list);
    }
}

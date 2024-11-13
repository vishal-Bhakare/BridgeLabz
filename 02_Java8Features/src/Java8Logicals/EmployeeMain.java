package Java8Logicals;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {

    public static void main(String[] args) {

        List<Employee> emps = new ArrayList<Employee>();

        emps.add(new Employee(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0));
        emps.add(new Employee(2, "Smith", 25, "Male", "Sales", 2015, 13500.0));
        emps.add(new Employee(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0));
        emps.add(new Employee(4, "Orlen", 28, "Male", "Development", 2014, 32500.0));
        emps.add(new Employee(5, "Charles", 27, "Male", "HR", 2013, 22700.0));
        emps.add(new Employee(6, "Cathy", 43, "Male", "Security", 2016, 10500.0));
        emps.add(new Employee(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0));
        emps.add(new Employee(8, "Suresh", 31, "Male", "Development", 2015, 34500.0));
        emps.add(new Employee(9, "Gita", 24, "Female", "Sales", 2016, 11500.0));
        emps.add(new Employee(10, "Mahesh", 38, "Male", "Security", 2015, 11000.0));
        emps.add(new Employee(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.0));
        emps.add(new Employee(12, "Nithin", 25, "Male", "Development", 2016, 28200.0));
        emps.add(new Employee(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0));
        emps.add(new Employee(14, "Buttler", 24, "Male", "Sales", 2017, 10700.5));
        emps.add(new Employee(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0));
        emps.add(new Employee(16, "Sanvi", 26, "Female", "Development", 2015, 32499.0));


        //1. How many male and female employees are there in the organization ?
        Map<String, Long> collect = emps.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("male and female employees are there in the organization : " + collect);

        //2. Print the name of all departments in the organization ?
        Map<String, Long> depCount = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("name of all departments in the organization : " + depCount);
        //or
        emps.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        // 3. What is the average age of male and female employees ?
        Map<String, Double> avgAge = emps.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println("The average age of male and female employees : " + avgAge);

        //4. Get the details of highest paid employee in the organization ?
        Optional<Employee> highestPaidEmp = emps.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("The details of highest paid employee in the organization : " + highestPaidEmp);
        if (highestPaidEmp.isPresent()) {
            Employee employee = highestPaidEmp.get();
            System.out.println("HighestPaid Employee : " + employee);
        }

        //5. Get the names of all employees who have joined after 2015 ?
        List<Employee> aftejoinEmpList = emps.stream().filter(employee -> employee.getYearOfJoining() > 2015).collect(Collectors.toList());
        System.out.println("The names of all employees who have joined after 2015 : " + aftejoinEmpList);
        for (Employee emp : aftejoinEmpList) {
            System.out.println("The names of all employees who have joined after 2015 : " + emp);
        }

        //6. Count the number of employees in each department ?
        Map<String, Long> empCountDep = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count the number of employees in each department : " + empCountDep);

        for (String emp : empCountDep.keySet()) {
            System.out.println("Department : " + emp + ", Employee : " + empCountDep.get(emp));
        }
        System.out.println("------------------------------------------------");

        for (Map.Entry<String, Long> entry : empCountDep.entrySet()) {
            System.out.println("Department: " + entry.getKey() + ", Employee: " + entry.getValue());
        }

        //7. What is the average salary of each department ?
        Map<String, Double> avgSalaryDep = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        for (Map.Entry<String, Double> emp : avgSalaryDep.entrySet()) {
            System.out.println("Department: " + emp.getKey() + ", AverageEmployeeSalary: " + emp.getValue());

            //8. Get the details of youngest male employee in the product development department ?
            Optional<Employee> yongestEmp = emps.stream().filter(employee -> employee.getDepartment().equalsIgnoreCase("Development") && employee.getGender().equalsIgnoreCase("Male"))
                    .min(Comparator.comparingInt(Employee::getAge));
            if (yongestEmp.isPresent()) {
                Employee employee = yongestEmp.get();
                System.out.println("the details of youngest male employee in the product development department :" + employee);
            }
        }
        //9. Who has the most working experience in the organization?
        Optional<Employee> mostWorking = emps.stream().min(Comparator.comparing(Employee::getYearOfJoining));
        if (mostWorking.isPresent()) {
            Employee employee = mostWorking.get();
            System.out.println("The most working experience in the organization : " + employee);
        }

        //10. How many male and female employees are there in the Sales team?
        List<Employee> sales = emps.stream().filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales"))
                .collect(Collectors.toList());
        for (Employee emp : sales) {
            System.out.println("Male and Female employees are there in the Sales team : " + emp);
        }

        //11. What is the average salary of male and female employees ?
        Map<String, Double> avgSalary = emps.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        for (Map.Entry<String, Double> entry : avgSalary.entrySet()) {
            String gender = entry.getKey();
            Double salary = entry.getValue();
            System.out.println("Gender: " + gender + ", Average Salary: " + salary);
        }
        //12. List down the names of all employees in each department ?
        Map<String, List<Employee>> dep = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(dep);
        for (Map.Entry<String, List<Employee>> entry : dep.entrySet()) {
            String department = entry.getKey();
            List<Employee> employee = entry.getValue();
            for (Employee emp : employee) {
                System.out.println("Departments : " + department + " Employee : " + emp);
            }
        }
        //13. What is the average salary and total salary of the whole organization?
        Double avgSalray = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        double totalSalary = emps.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Average Salary : " + avgSalray);
        System.out.println("Total Salary : " + totalSalary);

        // 16. Get the employee whose salary are more than 25k.
        emps.stream().filter(employee -> employee.getSalary() > 25000).collect(Collectors.toList())
                .forEach(System.out::println);

        //17.Who is the highest paid employee in the organization?
        Optional<Employee> maxSalary = emps.stream().max(Comparator.comparingDouble(Employee::getSalary));
        Employee employee = maxSalary.get();
        System.out.println("Max Salary Employee : "+employee);

        //18.Who is the second highest paid employee in the organization?
        Optional<Employee> secondHighest = emps.stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).skip(1).findFirst();
        Employee employee1 = secondHighest.get();
        System.out.println("The second highest paid employee in the organization : "+employee1);

        //19.	Who is the third highest paid employee in the organization?
        Optional<Employee> thirdHighest = emps.stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).skip(2).findFirst();
        Employee employee2 = thirdHighest.get();
        System.out.println("The third highest paid employee in the organization : "+employee2);

       //20.Who is the lowest paid employee in the organization?
        Optional<Employee> minSalary = emps.stream().min(Comparator.comparingDouble(Employee::getSalary));
        Employee employee3 = minSalary.get();
        System.out.println("The lowest paid employee in the organization : "+employee3);

      // 21.Who is the second lowest paid employee in the organization?
        Optional<Employee> secondLowest = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1).findFirst();
        Employee employee4 = secondLowest.get();
        System.out.println("The second lowest paid employee in the organization : "+employee4);

        // 22.Who is the second lowest paid employee in the organization?
        Optional<Employee> thirdLowest = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(2).findFirst();
        Employee employee5 = thirdLowest.get();
        System.out.println("The third lowest paid employee in the organization : "+employee5);

        //22.Get the first five lowest paid employee in the organization?
        List<Employee> fistFiveSalary = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).limit(5).collect(Collectors.toList());

        for(Employee emp:fistFiveSalary){
            System.out.println("The first five lowest paid employee in the organization : "+emp);
        }
      //23.Get the first five highest paid employee in the organization?
        List<Employee> fisthigestFiveSalary = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(5).collect(Collectors.toList());
        for(Employee emp:fisthigestFiveSalary){
            System.out.println("The first five Highest paid employee in the organization : "+emp);
        }
    }
}



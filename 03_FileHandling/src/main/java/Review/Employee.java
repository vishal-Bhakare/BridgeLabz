package Review;

import java.io.Serializable;

public class Employee  implements Serializable {


    private int empId;
    private  String empName;
    private double salary;

    public Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String toCSV() {
        return empId + "," + empName + "," + salary;
    }


    public static Employee fromCSV(String csv) {
        String[] data = csv.split(",");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double salary = Double.parseDouble(data[2]);
        return new Employee(id, name, salary);
    }
}

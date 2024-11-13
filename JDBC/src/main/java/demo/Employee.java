package demo;

import java.sql.*;

public class Employee {

    private static final String DB_URL = "jdbc:mysql://localhost:3307/bridgelab";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Connect to the database
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // 1. Create Employee
    public void createEmployee(String name, String department, double salary) {
        String sql = "INSERT INTO Employee (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 1. Create Employee
    public void createDepartment(String name, String department, double salary) {
        String sql = "INSERT INTO Department (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Read All Employees
    public void readEmployees() {
        String sql = "SELECT * FROM Employee";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Update Employee Salary by ID
    public void updateEmployeeSalary(int id, double newSalary) {
        String sql = "UPDATE Employee SET salary = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newSalary);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected > 0 ? "Employee salary updated." : "Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Delete an Employee by ID
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Employee deleted." : "Employee not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. Find Employees by Department
    public void findEmployeesByDepartment(String department) {
        String sql = "SELECT * FROM Employee WHERE department = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, department);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 6. Find the Highest-Paid Employee
    public void findHighestPaidEmployee() {
        String sql = "SELECT * FROM Employee ORDER BY salary DESC LIMIT 1";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                System.out.println("Highest Paid Employee - ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department") +
                        ", Salary: " + rs.getDouble("salary"));
            } else {
                System.out.println("No employees found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 7. Count Employees by Department
    public void countEmployeesByDepartment() {
        String sql = "SELECT department, COUNT(*) as count FROM Employee GROUP BY department";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Department: " + rs.getString("department") +
                        ", Count: " + rs.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 8. Retrieve Employees within a Salary Range
    public void findEmployeesBySalaryRange(double minSalary, double maxSalary) {
        String sql = "SELECT * FROM Employee WHERE salary BETWEEN ? AND ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, minSalary);
            pstmt.setDouble(2, maxSalary);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // Add a new column to the Employee table
    public void addColumn(String columnName, String columnType) {
        String sql = "ALTER TABLE Employee ADD COLUMN " + columnName + " " + columnType;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Column '" + columnName + "' added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee();

        // Create new employees
        employee.createEmployee("SHAUBHAM", "HR", 60000);
        employee.createEmployee("DHIRAJ", "Engineering", 80000);
        employee.createEmployee("YOGESH", "Sales", 70000);
        employee.createDepartment("HR", "HR", 60000);
        employee.createDepartment("DEV", "Engineering", 80000);
        employee.createDepartment("QA", "Sales", 70000);

        // Read
        System.out.println("All Employees:");
        employee.readEmployees();

        // Update
        employee.updateEmployeeSalary(1, 80000.0);

        // Delete
        employee.deleteEmployee(1);

        // Read after update and delete
        System.out.println("Employees after update and delete:");
        employee.readEmployees();

        // Find employees by department
        System.out.println("Employees in HR department:");
        employee.findEmployeesByDepartment("HR");

        // Find the highest-paid employee
        System.out.println("Highest Paid Employee:");
        employee.findHighestPaidEmployee();

        // Count employees by department
        System.out.println("Employee count by department:");
        employee.countEmployeesByDepartment();

        // Find employees within a salary range
        System.out.println("Employees with salary between 60000 and 80000:");
        employee.findEmployeesBySalaryRange(60000, 80000);
        employee.addColumn("City", "varchar(256)");
    }
}

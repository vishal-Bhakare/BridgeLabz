package demo;

import java.sql.*;

public class Relationship {


    private static final String DB_URL = "jdbc:mysql://localhost:3307/bridgelab";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Connect to the database
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }


    public void createEmployeeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS EmployeeT (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "department_id INT UNIQUE, " +
                "position VARCHAR(50), " +
                "salary DECIMAL(10, 2), " +
                "date_of_joining DATE, " +
                "FOREIGN KEY (department_id) REFERENCES Department(id) ON DELETE SET NULL)";
        executeStatement(sql, "Employee table created.");
    }


    public void createDepartmentTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Department (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "location VARCHAR(100), " +
                "head_employee_id INT UNIQUE, " +
                "FOREIGN KEY (head_employee_id) REFERENCES Employee(id) ON DELETE SET NULL)";
        executeStatement(sql, "Department table created.");
    }

    // Utility method to execute a statement
    private void executeStatement(String sql, String successMessage) {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println(successMessage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void insertDepartment(String name, String location) {
        String sql = "INSERT INTO Department (name, location) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, location);
            pstmt.executeUpdate();
            System.out.println("Department added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertEmployee(String name, int departmentId, String position, double salary, String dateOfJoining) {
        String sql = "INSERT INTO Employee (name, department_id, position, salary, date_of_joining) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, departmentId);
            pstmt.setString(3, position);
            pstmt.setDouble(4, salary);
            pstmt.setDate(5, Date.valueOf(dateOfJoining));
            pstmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Relationship   setup = new Relationship();
        setup.createDepartmentTable();
        setup.createEmployeeTable();


        setup.insertDepartment("HR", "PUNE");
        setup.insertDepartment("Engineering", "MUMBAI");


        setup.insertEmployee("VISHAL", 1, "Manager", 75000.0, "2023-01-15");
        setup.insertEmployee("SAURABH", 2, "Engineer", 85000.0, "2023-02-20");
    }
}



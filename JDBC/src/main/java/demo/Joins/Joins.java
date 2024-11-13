package demo.Joins;

import java.sql.*;

public class Joins {

    private static final String DB_URL = "jdbc:mysql://localhost:3307/Joins";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Connect to the database
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // 1. Create the Department table
    public void createDepartmentTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Department ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "department_name VARCHAR(50) NOT NULL)";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Department table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Create the Employee table with a foreign key to the Department table
    public void createEmployeeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Employee ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(50) NOT NULL, "
                + "department_id INT, "
                + "salary DECIMAL(10, 2), "
                + "FOREIGN KEY (department_id) REFERENCES Department(id))";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Employee table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Insert data into Department table
    public void insertIntoDepartment(String departmentName) {
        String sql = "INSERT INTO Department (department_name) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, departmentName);
            pstmt.executeUpdate();
            System.out.println("Department added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Insert data into Employee table
    public void insertIntoEmployee(String name, int departmentId, double salary) {
        String sql = "INSERT INTO Employee (name, department_id, salary) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, departmentId);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Perform Inner Join
    public void innerJoin() {
        String sql = "SELECT Employee.name, Department.department_name, Employee.salary "
                + "FROM Employee "
                + "JOIN Department ON Employee.department_id = Department.id";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Inner Join Results:");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department_name") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Perform Left Join
    public void leftJoin() {
        String sql = "SELECT Employee.name, Department.department_name, Employee.salary "
                + "FROM Employee "
                + "LEFT JOIN Department ON Employee.department_id = Department.id";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Left Join Results:");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department_name") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Perform Right Join
    public void rightJoin() {
        String sql = "SELECT Employee.name, Department.department_name, Employee.salary "
                + "FROM Employee "
                + "RIGHT JOIN Department ON Employee.department_id = Department.id";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Right Join Results:");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department_name") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Perform Full Join (Using UNION since MySQL does not have FULL OUTER JOIN directly)
    public void fullJoin() {
        String sql = "(SELECT Employee.name, Department.department_name, Employee.salary "
                + "FROM Employee "
                + "LEFT JOIN Department ON Employee.department_id = Department.id) "
                + "UNION "
                + "(SELECT Employee.name, Department.department_name, Employee.salary "
                + "FROM Employee "
                + "RIGHT JOIN Department ON Employee.department_id = Department.id)";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Full Join Results:");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department_name") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Joins employee = new Joins();

        // Step 1: Create tables
        employee.createDepartmentTable();
        employee.createEmployeeTable();

        // Step 2: Insert data into tables
        employee.insertIntoDepartment("HR");
        employee.insertIntoDepartment("Engineering");
        employee.insertIntoDepartment("Sales");

        employee.insertIntoEmployee("VISHAL", 1, 60000.00);
        employee.insertIntoEmployee("SAUARBH", 2, 75000.00);
        employee.insertIntoEmployee("SAHIL", 3, 50000.00);
        employee.insertIntoEmployee("AKSHAY", 2, 70000.00);

        // Step 3: Perform join operations
        employee.innerJoin();
        employee.leftJoin();
        employee.rightJoin();
        employee.fullJoin();
    }
}
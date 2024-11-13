package demo;

import java.sql.*;

public class Review {


    private static final String DB_URL = "jdbc:mysql://localhost:3307/bridgelab";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private  static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void getEmpoyee(String name , String department) throws SQLException {

        String query ="SELECT * FROM Employee  WHERE name REGEXP 'll' AND department = 'DEVELOPER'";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
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


    public static void main(String[] args) throws SQLException {
        Review.getEmpoyee("Allen","DEVELOPER");
    }
}

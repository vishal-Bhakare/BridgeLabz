package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCurdOperations {
    public static void main(String[] args) {

        String host = "jdbc:mysql://localhost:3307/bridgelab";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(host, username, password);

            System.out.println("Connected to MySQL database");
            try (Statement statement = conn.createStatement()) {

                // Create the table
                String createTableQuery = "create table if not exists student(id int primary key, name varchar(20), age int)";
                statement.executeUpdate(createTableQuery);
                System.out.println("Table is created successfully....");

                // Insert data into the table
                String insertDataQuery1 = "insert into student (id, name, age) values (4, 'VISHAL', 20)";
                String insertDataQuery2 = "insert into student (id, name, age) values (5, 'SAURABH', 22)";
                String insertDataQuery3 = "insert into student (id, name, age) values (6, 'SAHIL', 19)";

                // Execute insert queries
                statement.executeUpdate(insertDataQuery1);
                statement.executeUpdate(insertDataQuery2);
                statement.executeUpdate(insertDataQuery3);
                System.out.println("Data inserted successfully....");

            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database: " + e.getMessage());
        }
    }
}

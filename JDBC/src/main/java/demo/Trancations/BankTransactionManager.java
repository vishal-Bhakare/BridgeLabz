package demo.Trancations;

import java.sql.*;

public class BankTransactionManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3307/bridgelab";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        BankTransactionManager manager = new BankTransactionManager();

        // Step 1: Create Account table and insert initial data
        manager.setupDatabase();

        // Step 2: Display initial balances
        System.out.println("Initial Balances:");
        manager.displayBalances();

        // Step 3: Perform a successful transfer
        System.out.println("\nAttempting to transfer $100 from Account 1 to Account 2:");
        manager.transferFunds(1, 2, 100.0);
        manager.displayBalances();

        // Step 4: Attempt a transfer that exceeds available balance (should fail)
        System.out.println("\nAttempting to transfer $1200 from Account 1 to Account 2:");
        manager.transferFunds(1, 2, 1200.0);
        manager.displayBalances();
    }

    // Method to set up database table and insert initial data
    public void setupDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Create Account table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Account ("
                    + "account_id INT PRIMARY KEY, "
                    + "balance DECIMAL(15, 2) NOT NULL)";
            stmt.execute(createTableSQL);
            System.out.println("Account table created.");

            // Insert initial data (use ON DUPLICATE KEY UPDATE to prevent duplicates)
            String insertDataSQL = "INSERT INTO Account (account_id, balance) VALUES (1, 1000.00), (2, 500.00)"
                    + " ON DUPLICATE KEY UPDATE balance=balance";
            stmt.executeUpdate(insertDataSQL);
            System.out.println("Initial data inserted into Account table.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display account balances
    public void displayBalances() {
        String sql = "SELECT * FROM Account";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Account ID: " + rs.getInt("account_id") +
                        ", Balance: $" + rs.getDouble("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to transfer funds with transaction handling
    public void transferFunds(int fromAccount, int toAccount, double amount) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            conn.setAutoCommit(false); // Begin transaction

            // Deduct amount from the source account
            String deductSql = "UPDATE Account SET balance = balance - ? WHERE account_id = ?";
            try (PreparedStatement deductStmt = conn.prepareStatement(deductSql)) {
                deductStmt.setDouble(1, amount);
                deductStmt.setInt(2, fromAccount);
                int rowsAffected = deductStmt.executeUpdate();

                if (rowsAffected == 0) {
                    throw new SQLException("Insufficient funds or account not found.");
                }
            }

            // Add amount to the destination account
            String addSql = "UPDATE Account SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement addStmt = conn.prepareStatement(addSql)) {
                addStmt.setDouble(1, amount);
                addStmt.setInt(2, toAccount);
                addStmt.executeUpdate();
            }

            conn.commit(); // Commit transaction
            System.out.println("Transfer successful.");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback transaction on error
                    System.out.println("Transaction failed. Rolled back.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }
}


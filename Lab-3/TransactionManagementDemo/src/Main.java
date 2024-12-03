import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class TransactionManagementDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your DB URL
        String user = "root"; // Replace with your DB username
        String password = ""; // Replace with your DB password

        // SQL queries
        String insertQuery = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        String updateQuery = "UPDATE students SET age = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Disable auto-commit for transaction management
            connection.setAutoCommit(false);

            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                 PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {

                // Step 1: Insert a new record
                insertStmt.setInt(1, 9); // ID
                insertStmt.setString(2, "Rohan"); // Name
                insertStmt.setInt(3, 26); // Age
                insertStmt.executeUpdate();
                System.out.println("Record inserted successfully.");

                // Step 2: Update an existing record
                updateStmt.setInt(1, 30); // New age
                updateStmt.setInt(2, 8); // ID of the record to update
                updateStmt.executeUpdate();
                System.out.println("Record updated successfully.");

                // Simulating an error (uncomment to trigger rollback)
                // int error = 1 / 0;

                // Step 3: Commit transaction
                connection.commit();
                System.out.println("Transaction committed successfully.");

            } catch (Exception e) {
                // Rollback transaction in case of any error
                connection.rollback();
                System.err.println("Transaction rolled back due to an error: " + e.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.*;
import java.util.Scanner;

class JDBCPreparedStatementDemo {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your database URL
        String username = "root"; // Replace with your username
        String password = ""; // Replace with your password
        String tableName = "result"; // Replace with your table name

        Connection connection = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Load the JDBC driver (Optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // Insert a record into the table
            System.out.println("\n--- Insert Record ---");
            System.out.print("Enter roll number: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();
            System.out.print("Enter marks obtained: ");
            int marks = scanner.nextInt();

            String insertQuery = "INSERT INTO " + tableName + " (roll_no, course_name, marks_obtained) VALUES (?, ?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setInt(1, rollNo);
                insertStmt.setString(2, courseName);
                insertStmt.setInt(3, marks);
                int rowsInserted = insertStmt.executeUpdate();
                System.out.println(rowsInserted + " record(s) inserted.");
            }

            // Retrieve and display all records
            System.out.println("\n--- Retrieve Records ---");
            String selectQuery = "SELECT * FROM " + tableName;
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
                ResultSet resultSet = selectStmt.executeQuery();
                System.out.printf("%-10s %-20s %-15s%n", "Roll No", "Course Name", "Marks Obtained");
                System.out.println("------------------------------------------------------");
                while (resultSet.next()) {
                    System.out.printf("%-10d %-20s %-15d%n",
                            resultSet.getInt("roll_no"),
                            resultSet.getString("course_name"),
                            resultSet.getInt("marks_obtained"));
                }
            }

            // Update a record in the table
            System.out.println("\n--- Update Record ---");
            System.out.print("Enter roll number to update: ");
            int updateRollNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new course name: ");
            String newCourseName = scanner.nextLine();
            String updateQuery = "UPDATE " + tableName + " SET course_name = ? WHERE roll_no = ?";
            try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                updateStmt.setString(1, newCourseName);
                updateStmt.setInt(2, updateRollNo);
                int rowsUpdated = updateStmt.executeUpdate();
                System.out.println(rowsUpdated + " record(s) updated.");
            }

            // Delete a record from the table
            System.out.println("\n--- Delete Record ---");
            System.out.print("Enter roll number to delete: ");
            int deleteRollNo = scanner.nextInt();
            String deleteQuery = "DELETE FROM " + tableName + " WHERE roll_no = ?";
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                deleteStmt.setInt(1, deleteRollNo);
                int rowsDeleted = deleteStmt.executeUpdate();
                System.out.println(rowsDeleted + " record(s) deleted.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) connection.close();
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

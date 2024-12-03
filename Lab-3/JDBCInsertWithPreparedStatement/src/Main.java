import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class JDBCInsertWithPreparedStatement {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your database URL
        String username = "root"; // Replace with your username
        String password = ""; // Replace with your password
        String tableName = "result"; // Replace with your table name

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Load the JDBC driver (Optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the SQL INSERT query
            String insertQuery = "INSERT INTO " + tableName + " (roll_no, course_name, marks_obtained) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);

            // Step 4: Insert records as long as the user wants
            String choice;
            do {
                // Get user input
                System.out.print("Enter Roll Number: ");
                int rollNo = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Course Name: ");
                String courseName = scanner.nextLine();

                System.out.print("Enter Marks Obtained: ");
                int marks = scanner.nextInt();

                // Set the parameters
                preparedStatement.setInt(1, rollNo);
                preparedStatement.setString(2, courseName);
                preparedStatement.setInt(3, marks);

                // Execute the query
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Record inserted successfully!");
                } else {
                    System.out.println("Failed to insert record.");
                }

                // Ask the user if they want to continue
                System.out.print("Do you want to insert another record? (yes/no): ");
                scanner.nextLine(); // Consume newline
                choice = scanner.nextLine().toLowerCase();

            } while (choice.equals("yes"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

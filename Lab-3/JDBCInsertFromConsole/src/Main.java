import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

class JDBCInsertFromConsole {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your database URL
        String username = "root"; // Replace with your username
        String password = ""; // Replace with your password
        String tableName = "table1"; // Replace with your table name

        Connection connection = null;
        Statement statement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Load the JDBC driver (Optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Get user input
            System.out.println("Enter the following details to insert into the table:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Roll Number: ");
            int rollNo = scanner.nextInt();

            System.out.print("Gender (Male/Female): ");
            scanner.nextLine(); // Consume newline
            String gender = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            // Step 4: Create a Statement
            statement = connection.createStatement();

            // Step 5: Prepare the SQL INSERT query
            String insertQuery = "INSERT INTO " + tableName + " (Name, Roll_No, Gender, Age) " +
                    "VALUES ('" + name + "', " + rollNo + ", '" + gender + "', " + age + ")";

            // Step 6: Execute the query
            int rowsAffected = statement.executeUpdate(insertQuery);

            // Step 7: Confirm insertion
            if (rowsAffected > 0) {
                System.out.println("Row inserted successfully into " + tableName);
            } else {
                System.out.println("No rows were inserted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 8: Close the resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class JDBCReadRecord {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your database URL
        String username = "root"; // Replace with your username
        String password = ""; // Replace with your password
        String tableName = "result"; // Replace with your table name

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Load the JDBC driver (Optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Get user input for the roll number
            System.out.print("Enter the roll number to search: ");
            int rollNo = scanner.nextInt();

            // Step 4: Create a Statement
            statement = connection.createStatement();

            // Step 5: Prepare the SQL SELECT query
            String selectQuery = "SELECT * FROM " + tableName + " WHERE roll_no = " + rollNo;

            // Step 6: Execute the query
            resultSet = statement.executeQuery(selectQuery);

            // Step 7: Display the result
            boolean recordFound = false;
            System.out.println("\nRecord for Roll Number: " + rollNo);
            System.out.printf("%-10s %-20s %-15s%n", "Roll No", "Course Name", "Marks Obtained");
            System.out.println("------------------------------------------------------");

            while (resultSet.next()) {
                recordFound = true;
                int RollNo = resultSet.getInt("roll_no");
                String courseName = resultSet.getString("course_name");
                int marksObtained = resultSet.getInt("marks_obtained");

                System.out.printf("%-10d %-20s %-15d%n", RollNo, courseName, marksObtained);
            }

            if (!recordFound) {
                System.out.println("No record found for Roll Number: " + rollNo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 8: Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

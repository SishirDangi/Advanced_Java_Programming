import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class JDBCDisplayRecord {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your database URL
        String username = "root"; // Replace with your username
        String password = ""; // Replace with your password
        String tableName = "salary"; // Replace with your table name

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Load the JDBC driver (Optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Get the employee ID from the user
            System.out.print("Enter Employee ID to search: ");
            int empId = scanner.nextInt();

            // Step 4: Prepare the SQL SELECT query
            String selectQuery = "SELECT * FROM " + tableName + " WHERE emp_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, empId);

            // Step 5: Execute the query
            resultSet = preparedStatement.executeQuery();

            // Step 6: Display the result
            boolean recordFound = false;
            System.out.println("\nRecord for Employee ID: " + empId);
            System.out.printf("%-10s %-20s %-15s%n", "Emp ID", "Emp Name", "Emp Salary");
            System.out.println("------------------------------------------------------");

            while (resultSet.next()) {
                recordFound = true;
                int id = resultSet.getInt("emp_id");
                String name = resultSet.getString("emp_name");
                double salary = resultSet.getDouble("emp_salary");

                System.out.printf("%-10d %-20s %-15.2f%n", id, name, salary);
            }

            if (!recordFound) {
                System.out.println("No record found for Employee ID: " + empId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

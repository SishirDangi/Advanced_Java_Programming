import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JDBCInsertAndDisplay {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your database URL
        String username = "root"; // Replace with your username
        String password = ""; // Replace with your password
        String tableName = "table1"; // Replace with your table name

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the JDBC driver (Optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a Statement
            statement = connection.createStatement();

            // Step 4: Prepare the SQL INSERT query
            String insertQuery = "INSERT INTO " + tableName + " (Name, Roll_No, Gender, Age) " +
                    "VALUES ('Sabin Karki', 211866, 'Male', 39)";

            // Step 5: Execute the query
            int rowsAffected = statement.executeUpdate(insertQuery);

            // Step 6: Confirm insertion
            if (rowsAffected > 0) {
                System.out.println("Row inserted successfully into " + tableName);
            } else {
                System.out.println("No rows were inserted.");
            }

            // Step 7: Retrieve and display the table data
            String selectQuery = "SELECT * FROM " + tableName;
            resultSet = statement.executeQuery(selectQuery);

            // Display the table data
            System.out.println("\nData from table: " + tableName);
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Print column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
            }
            System.out.println();

            // Print table rows
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 8: Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

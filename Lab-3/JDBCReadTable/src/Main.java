import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JDBCReadTable {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your database URL
        String username = "root"; // Replace with your username
        String password = ""; // Replace with your password
        String tableName = "table1"; // Your database table name

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

            // Step 4: Execute a SQL query to retrieve all data from the table
            String query = "SELECT * FROM " + tableName; // Correct usage of table name
            resultSet = statement.executeQuery(query);

            // Step 5: Process the result set
            System.out.println("Data from table: " + tableName);

            // Fetch column count and print column headers
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s", resultSet.getMetaData().getColumnName(i));
            }
            System.out.println();

            // Print data rows
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
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

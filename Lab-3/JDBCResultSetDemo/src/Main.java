import java.sql.*;

class JDBCResultSetDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your DB URL
        String user = "root"; // Replace with your DB username
        String password = ""; // Replace with your DB password

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Scrollable and Updatable ResultSet
            System.out.println("Demonstrating Scrollable and Updatable ResultSet...");
            demonstrateScrollableAndUpdatableResultSet(connection);

            // Multiple ResultSet
            System.out.println("\nDemonstrating Multiple ResultSet...");
            demonstrateMultipleResultSet(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void demonstrateScrollableAndUpdatableResultSet(Connection connection) throws SQLException {
        String query = "SELECT id, name, age FROM students";

        try (Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, // Allows scrolling
                ResultSet.CONCUR_UPDATABLE // Allows updates
        )) {
            ResultSet resultSet = statement.executeQuery(query);

            // Move to the last row
            if (resultSet.last()) {
                System.out.println("Last Record: ID=" + resultSet.getInt("id") +
                        ", Name=" + resultSet.getString("name") +
                        ", Age=" + resultSet.getInt("age"));
            }

            // Move to the first row
            if (resultSet.first()) {
                System.out.println("First Record: ID=" + resultSet.getInt("id") +
                        ", Name=" + resultSet.getString("name") +
                        ", Age=" + resultSet.getInt("age"));
            }

            // Update a record
            if (resultSet.absolute(2)) { // Move to the second row
                resultSet.updateString("name", "UpdatedName");
                resultSet.updateRow();
                System.out.println("Updated Record at Row 2");
            }

            // Add a new record
            resultSet.moveToInsertRow();
            resultSet.updateInt("id", 7); // Adjust ID accordingly
            resultSet.updateString("name", "Sishir");
            resultSet.updateInt("age", 23);
            resultSet.insertRow();
            System.out.println("Inserted a new record");
        }
    }

    private static void demonstrateMultipleResultSet(Connection connection) throws SQLException {
        // First query
        String query1 = "SELECT id, name FROM students";
        // Second query
        String query2 = "SELECT id, age FROM students";

        try (Statement statement = connection.createStatement()) {
            // Execute the first query
            ResultSet resultSet1 = statement.executeQuery(query1);
            System.out.println("Result Set 1 (id, name):");
            ResultSetMetaData metaData1 = resultSet1.getMetaData();
            int columnCount1 = metaData1.getColumnCount();

            while (resultSet1.next()) {
                for (int i = 1; i <= columnCount1; i++) {
                    System.out.print(metaData1.getColumnLabel(i) + "=" + resultSet1.getObject(i) + " ");
                }
                System.out.println();
            }

            // Execute the second query
            ResultSet resultSet2 = statement.executeQuery(query2);
            System.out.println("\nResult Set 2 (id, age):");
            ResultSetMetaData metaData2 = resultSet2.getMetaData();
            int columnCount2 = metaData2.getColumnCount();

            while (resultSet2.next()) {
                for (int i = 1; i <= columnCount2; i++) {
                    System.out.print(metaData2.getColumnLabel(i) + "=" + resultSet2.getObject(i) + " ");
                }
                System.out.println();
            }
        }
    }
}

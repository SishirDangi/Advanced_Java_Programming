import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class RowSetDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sishir_database"; // Replace with your DB URL
        String user = "root"; // Replace with your DB username
        String password = ""; // Replace with your DB password

        try {
            // JdbcRowSet demonstration
            System.out.println("Demonstrating JdbcRowSet...");
            demonstrateJdbcRowSet(url, user, password);

            // CachedRowSet demonstration
            System.out.println("\nDemonstrating CachedRowSet...");
            demonstrateCachedRowSet(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void demonstrateJdbcRowSet(String url, String user, String password) throws SQLException {
        // Create JdbcRowSet using RowSetProvider
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(user);
        jdbcRowSet.setPassword(password);

        // Set the query
        jdbcRowSet.setCommand("SELECT id, name, age FROM students");
        jdbcRowSet.execute();

        // Iterate through the results
        while (jdbcRowSet.next()) {
            System.out.println("ID: " + jdbcRowSet.getInt("id") +
                    ", Name: " + jdbcRowSet.getString("name") +
                    ", Age: " + jdbcRowSet.getInt("age"));
        }

        // Update a record
        jdbcRowSet.absolute(2); // Move to the second row
        jdbcRowSet.updateString("name", "UpdatedNameJdbcRowSet");
        jdbcRowSet.updateRow();
        System.out.println("Updated row 2 using JdbcRowSet.");
    }

    private static void demonstrateCachedRowSet(String url, String user, String password) throws SQLException {
        // Create CachedRowSet using RowSetProvider
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(user);
        cachedRowSet.setPassword(password);

        // Set the query and populate
        cachedRowSet.setCommand("SELECT id, name, age FROM students");
        cachedRowSet.execute();

        // Iterate through the results
        while (cachedRowSet.next()) {
            System.out.println("ID: " + cachedRowSet.getInt("id") +
                    ", Name: " + cachedRowSet.getString("name") +
                    ", Age: " + cachedRowSet.getInt("age"));
        }

        // Modify data (disconnected mode)
        cachedRowSet.absolute(2); // Move to the second row
        cachedRowSet.updateString("name", "UpdatedNameCachedRowSet");
        cachedRowSet.updateRow();

        // Sync changes back to the database
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Disable auto-commit
            connection.setAutoCommit(false);

            // Sync changes
            cachedRowSet.acceptChanges(connection);

            // Commit changes manually
            connection.commit();
        }

        System.out.println("Updated row 2 using CachedRowSet.");
    }
}

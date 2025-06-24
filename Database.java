
import java.sql.*;

public class Database {
    private static final String URL = "jdbc:sqlite:DhakaBusFinder.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initialize() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {

            // Create user table
            String usersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT NOT NULL UNIQUE," +
                    "password TEXT NOT NULL" +
                    ");";

            // Create buses table
            String busesTable = "CREATE TABLE IF NOT EXISTS buses (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "route TEXT NOT NULL," + // could store comma-separated or JSON
                    "fare INTEGER NOT NULL" +
                    ");";

            stmt.execute(usersTable);
            stmt.execute(busesTable);

            System.out.println("✅ Database initialized successfully.");

        } catch (SQLException ex) {
            System.out.println("❌ Database initialization error: " + ex.getMessage());
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Modify these values based on your local database configuration
    private static final String URL = "jdbc:mysql://localhost:3306/game_project";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Add your MySQL password here if you have one

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}

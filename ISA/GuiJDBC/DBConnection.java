import java.sql.Connection;
import java.sql.DriverManager;

// Shared MySQL connection for all GuiJDBC programs
// Database: test | User: root | Password: (empty)
// Change PASS if your MySQL root has a password.
public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/lab06_jdbc1";
    private static final String USER = "root"; 
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println(" Khong the ket noi den MySQL!");
            
            if (e.getMessage().contains("Access denied")) {
                System.err.println(" Sai username hoac password");
            } else if (e.getMessage().contains("Communications link failure")) {
                System.err.println(" MySQL chua duoc bat");
            } else if (e.getMessage().contains("Unknown database")) {
                System.err.println(" Database khong ton tai");
            } else {
                System.err.println(" Loi khac: " + e.getMessage());
            }

            return null;
        }
    }
}
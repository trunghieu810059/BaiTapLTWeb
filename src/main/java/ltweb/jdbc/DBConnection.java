package ltweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // instance duy nhất của Connection
    private static Connection connection = null;

    // Tên driver JDBC cho MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // URL kết nối đến database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ltweb";
    // Tên người dùng và mật khẩu
    private static final String USER = "root";
    private static final String PASSWORD = "Hieu@12345";

    // Constructor mặc định để class con có thể gọi super()
    protected DBConnection() {
        // có thể để trống hoặc log ra
    }

    // Phương thức công khai để lấy Connection duy nhất
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Tải driver JDBC
                Class.forName(DRIVER);
                // Tạo kết nối nếu chưa tồn tại
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Kết nối đến MySQL thành công!");
            } catch (ClassNotFoundException e) {
                System.err.println("Không tìm thấy Driver JDBC: " + DRIVER);
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Kết nối đến MySQL thất bại!");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Phương thức để đóng kết nối
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Đã đóng kết nối MySQL.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


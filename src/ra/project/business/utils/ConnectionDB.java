package ra.project.business.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "123456$";

    public static Connection getConnection(){
        // mở kết nối
        // khai báo driver
        try {
            Class.forName(DRIVER); // kiểm tra xem đã có driver chưa
            // mổ kết nối
            Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void closeConnection(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        // mở kê nối
        Connection conn = getConnection();
        System.out.println(conn + " kêt nối thành công !!");
        closeConnection(conn);
    }
}

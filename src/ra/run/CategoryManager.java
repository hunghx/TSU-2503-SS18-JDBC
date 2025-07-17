package ra.run;

import ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManager {
    public static void main(String[] args) {
        displayCategories();
        addStudent();
        displayCategories();
    }

    //Hienr thi danh sách danh

    public static void displayCategories(){
        List<Category> list = new ArrayList<>();
        // B1 mở kết nối
        Connection conn = ConnectionDB.getConnection();
        // B2 : tao và thực thi truy vấn
        try {
            CallableStatement call = conn.prepareCall("{call getAllCategories()}");
            // thuc
            ResultSet rs = call.executeQuery(); // thực thi câu select
            // B3 : xử lí kết
            while (rs.next()){
                Category cat = new Category();
                cat.setId(rs.getInt("category_id"));
                cat.setName(rs.getString("name"));
                cat.setDescription(rs.getString("description"));
                list.add(cat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }

        // hiển thị
        if (list.isEmpty()){
            System.err.println("ko có dữ liệu");
        }else {
            list.forEach(System.out::println);
        }
    }

    public static void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên danh mục");
        String name = sc.nextLine();
        System.out.println("Nhập mô tả danh mục");
        String desc = sc.nextLine();

        // B1 mở kết nối
        Connection conn = ConnectionDB.getConnection();
        // B2 : tao và thực thi truy vấn
        try {
            CallableStatement call = conn.prepareCall("{call insertNewCategory(?,?)}");
            call.setString(1,name);
            call.setString(2,desc);
            int rows = call.executeUpdate();
            if (rows>0){
                System.out.println("Thêm mới thành công");
            }else {
                System.err.println("thêm mới thất bại");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }

        sc.close();
    }
}

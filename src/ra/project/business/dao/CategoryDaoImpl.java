package ra.project.business.dao;

import ra.run.Category;
import ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao{
    @Override
    public List<Category> findAll() {
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
        return list;
    }

    @Override
    public Category findByCategory(int id) {
        return null;
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }

    @Override
    public boolean insertCategory(Category category) {
        // B1 mở kết nối
        Connection conn = ConnectionDB.getConnection();
        // B2 : tao và thực thi truy vấn
        try {
            CallableStatement call = conn.prepareCall("{call insertNewCategory(?,?)}");
            call.setString(1,category.getName());
            call.setString(2,category.getDescription());
            int rows = call.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean deleteCategoryById(int id) {
        return false;
    }
}

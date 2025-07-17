package ra.project.business.dao;

import ra.project.business.utils.ConnectionDB;
import ra.project.entity.CountProductByCategory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IProductDao{
    @Override
    public List<CountProductByCategory> countProductByCategory() {
        List<CountProductByCategory> list = new ArrayList<>();
        Connection conn = ConnectionDB.getConnection();
        try{
            CallableStatement call = conn.prepareCall("{call countProductByCategory()}");
            ResultSet rs = call.executeQuery();

            while (rs.next()){
                CountProductByCategory countProductByCategory = new CountProductByCategory(
                        rs.getString("Product_catalog"),
                        rs.getInt("count_product")
                );
                list.add(countProductByCategory);
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}

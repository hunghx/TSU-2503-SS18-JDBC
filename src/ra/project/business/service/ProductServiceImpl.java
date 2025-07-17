package ra.project.business.service;

import ra.project.business.dao.IProductDao;
import ra.project.business.dao.ProductDaoImpl;
import ra.project.entity.CountProductByCategory;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    private IProductDao productDao = new ProductDaoImpl();
    @Override
    public void displayCountProductGroupByCategory() {
        List<CountProductByCategory> list = productDao.countProductByCategory();
        if (list.isEmpty()){
            System.err.println("Chưa có du liệu");
        }else {
            // hiển thi ra
            list.forEach(System.out::println);
        }
    }
}

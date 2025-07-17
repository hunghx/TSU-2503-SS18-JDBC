package ra.project.business.service;

import ra.project.business.dao.CategoryDaoImpl;
import ra.project.business.dao.ICategoryDao;
import ra.run.Category;

import java.util.List;

public class CategoryServiceImpl {
    private ICategoryDao categoryDao = new CategoryDaoImpl();
    // chức năng hiển thi
    public void displayCategories(){
        List<Category> list = categoryDao.findAll();
    }
}

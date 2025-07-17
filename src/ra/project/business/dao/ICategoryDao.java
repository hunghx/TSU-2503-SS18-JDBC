package ra.project.business.dao;

import ra.run.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();
    Category findByCategory(int id);
    boolean updateCategory(Category category);
    boolean insertCategory(Category category);
    boolean deleteCategoryById(int id);
}

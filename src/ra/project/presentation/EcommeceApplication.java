package ra.project.presentation;

import ra.project.business.dao.CategoryDaoImpl;
import ra.project.business.service.CategoryServiceImpl;

public class EcommeceApplication {
    private static CategoryServiceImpl categoryService = new CategoryServiceImpl();
    public static void main(String[] args) {
        categoryService.displayCategories();
    }
}

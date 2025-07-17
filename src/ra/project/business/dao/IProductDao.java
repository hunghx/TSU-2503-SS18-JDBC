package ra.project.business.dao;

import ra.project.entity.CountProductByCategory;

import java.util.List;

public interface IProductDao {
    List<CountProductByCategory> countProductByCategory();
}

package bkap.dao;

import java.util.List;

import bkap.entities.Categories;
import bkap.entities.Products;

public interface CategoryDAO {
	
    public List<Categories> getList();
    
    public boolean insert(Categories cat);
    
    public Categories getById(Integer id);
    
    public boolean update(Categories cat);
    
    public boolean delete(Integer id);     
    
    public List<Categories> checkUnique(String name);
    
    public List<Products> getByProduct(Integer cateId);
}

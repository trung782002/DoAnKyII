package bkap.dao;

import java.util.List;

import bkap.entities.Categories;

public interface CategoryDAO {
	
    public List<Categories> getList();
    
    public boolean insert(Categories cat);
    
    public Categories getById(Integer id);
    
    public boolean update(Categories cat);
    
    public boolean delete(Integer id);     
    

}

package bkap.dao;

import java.util.List;
import bkap.entities.Product_images;

public interface Product_imageDAO {
	
	public List<Product_images> getByProId(Integer proId);
    
    public boolean insert(Product_images product_image);
    
    public boolean delete(Integer proId);
    
    public boolean deleteId(Integer id);
    
}

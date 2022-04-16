package bkap.dao;

import java.util.List;

import bkap.entities.Brands;

public interface BrandDAO {
	public List<Brands> getList();
	
	public List<Brands> searchByName(String name);
	
	public Brands getById(Integer id);
	
	public boolean insert(Brands brand);
	
	public boolean update(Brands brand);
	
	public boolean delete(Integer id);
}

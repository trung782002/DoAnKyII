package bkap.dao;

import java.util.List;

import bkap.entities.Products;

public interface ProductDAO {
	
	public List<Products> getList();
	
	public List<Products> getListStatus();
	
	public List<Products> searchByName(String name);
	
	public Products getById(Integer id);
	
	public Products insert(Products product);
	
	public boolean update(Products product);
	
	public boolean delete(Integer id);
	
}

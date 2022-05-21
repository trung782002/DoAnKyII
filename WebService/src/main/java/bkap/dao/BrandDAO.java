package bkap.dao;

import java.util.List;

import bkap.entities.Brands;

public interface BrandDAO {
	public List<Brands> getAll();
	public boolean insertBrand(Brands brands);
	public Brands getBrandsById(Integer Id);
	public boolean updateBrands(Brands brands);
	public boolean deleteBrands(Integer Id);
	public List<Brands> getBrandsByName(String name);
	public List<Brands> checkUnique(String name);
}

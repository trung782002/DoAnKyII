package bkap.dao;

import java.util.List;
import bkap.entities.Blogs;

public interface BlogDAO {
	public List<Blogs> getList(Integer status);
	
	public List<Blogs> searchByName(String name);
	
	public Blogs getById(Integer id);
	
	public boolean insert(Blogs blog);
	
	public boolean update(Blogs blog);
	
	public boolean delete(Integer id);
}

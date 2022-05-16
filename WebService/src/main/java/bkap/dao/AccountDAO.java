package bkap.dao;

import java.util.List;

import bkap.entities.Accounts;

public interface AccountDAO {
	public List<Accounts> getList();
	
	/* public List<Accounts> searchByName(String name); */
	
	public Accounts getById(Integer id);
	
	public List<Accounts> getEmail(String email);
	
	public boolean insert(Accounts account);
	
	public boolean update(Accounts account);
	
	public boolean delete(Integer id);
}

package bkap.dao;

import java.util.List;

import bkap.entities.Account_Roles;

public interface Account_RoleDAO {
	public List<Account_Roles> getList();
	
	/* public List<Account_roles> searchByName(String name); */
	
	public Account_Roles getById(Integer id);
	
	public boolean insert(Account_Roles account_role);
	
	public boolean update(Account_Roles account_role);
	
	public boolean delete(Integer id);
}

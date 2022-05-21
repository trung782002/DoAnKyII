package bkap.dao;

import java.util.List;

import bkap.entities.Contacts;
import bkap.entities.Orders;

public interface ContactDAO {
	public List<Contacts> getList();
	
	public boolean insert(Contacts contact);
	
	public boolean delete(Integer id);
	
	public Contacts getById(Integer id);
	
	public List<Contacts> searchByName(String fullName);
}

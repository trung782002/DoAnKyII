package bkap.dao;

import java.util.List;

import bkap.entities.Contacts;

public interface ContactDAO {
	public List<Contacts> getList();
	
	public boolean insert(Contacts contact);
	
	public boolean update(Contacts contact);
}

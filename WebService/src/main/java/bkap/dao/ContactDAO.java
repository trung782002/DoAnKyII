package bkap.dao;

import java.util.List;

import bkap.entities.Contacts;

public interface ContactDAO {
	public List<Contacts> getListContacts();
	
	public boolean insert(Contacts contact);
	
	public boolean update(Contacts contact);
}

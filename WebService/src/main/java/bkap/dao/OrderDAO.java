package bkap.dao;

import java.util.List;

import bkap.entities.Orders;

public interface OrderDAO {
	public List<Orders> getList();
	
	/* public List<Orders> searchByName(String name); */
	
	public Orders getById(Integer id);
	
	public boolean insert(Orders order);
	
	public boolean update(Orders order);
	
	/* public boolean delete(Integer id); */
}

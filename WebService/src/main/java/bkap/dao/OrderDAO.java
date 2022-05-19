package bkap.dao;

import java.util.List;

import bkap.entities.Orders;

public interface OrderDAO {
	public List<Orders> getList(Integer accId,Integer status);
		
	public Orders getById(Integer id);
	
	public Orders insert(Orders order);
	
	public boolean update(Orders order);
	
}

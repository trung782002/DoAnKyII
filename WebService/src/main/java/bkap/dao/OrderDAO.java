package bkap.dao;

import java.sql.Date;
import java.util.List;

import bkap.entities.Orders;

public interface OrderDAO {
	public List<Orders> getList(Integer accId,Integer status);
		
	public Orders getById(Integer id);
	
	public Orders insert(Orders order);
	
	public boolean update(Orders order);
	
	public List<Orders> getListStatus(Integer status);
	
	public List<Orders> getListCreateDate(Date createedAt);
}

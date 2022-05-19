package bkap.dao;

import java.util.List;

import bkap.entities.OrderDetails;

public interface OrderDetailDAO {
	
	public List<OrderDetails> getByOrder(Integer orderId);
	
	public boolean insert(OrderDetails order);
	
}

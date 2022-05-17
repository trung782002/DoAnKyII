package bkap.dao;

import java.util.List;

import bkap.entities.OrderDetails;

public interface OrderDetailDAO {
	/* public List<OrderDetails> getList(); */
	
	public List<OrderDetails> getByOrderId(Integer orderId);
	
	public List<OrderDetails> getOrderStatus(Integer orderId, Integer status);
	
	/* public OrderDetails getById(Integer id); */
	
	public boolean insert(OrderDetails order);

	
	/* public boolean update(OrderDetails order); */
	
	/* public boolean delete(Integer id); */
}

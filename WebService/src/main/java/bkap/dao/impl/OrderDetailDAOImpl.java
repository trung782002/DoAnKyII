package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.OrderDetailDAO;
import bkap.entities.OrderDetails;
import bkap.util.HibernateUtil;

public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Override
	public List<OrderDetails> getByOrder(Integer orderId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from OrderDetails where OrderId = :orderId").setParameter("orderId", orderId).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	
	public List<OrderDetails> getByOrderId(Integer orderId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from OrderDetails where OrderId = :orderId").setParameter("orderId", orderId).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public boolean insert(OrderDetails order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

}

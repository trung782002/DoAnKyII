package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.OrderDAO;
import bkap.entities.Accounts;
import bkap.entities.Orders;
import bkap.util.HibernateUtil;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<Orders> getList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Orders").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public List<Orders> getOrderAccId(Integer accId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Orders where AccId = :accId").setParameter("accId", accId).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Orders getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Orders order = session.get(Orders.class, id);
			return order;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Orders insert(Orders order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			return order;
		} catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean update(Orders order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(order);
			session.getTransaction().commit();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
}

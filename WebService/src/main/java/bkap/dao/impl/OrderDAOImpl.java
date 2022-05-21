package bkap.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bkap.dao.OrderDAO;
import bkap.entities.Accounts;
import bkap.entities.Orders;
import bkap.util.HibernateUtil;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public List<Orders> getList(Integer accId,Integer status) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Orders where AccId = :accId and Status = :status").setParameter("accId", accId).setParameter("status", status).list();
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
	
	public List<Orders> getListStatus(Integer status) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Orders where Status = :status").setParameter("status", status).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public List<Orders> getListCreateDate(Date createedAt){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Orders where createdAt = :createdAt").setParameter("createdAt", createedAt).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	
	public List<Orders> getList() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from Orders").list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

		return null;
	}
	
	
	public List<Orders> searchByName(String fullName) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (fullName == null || fullName.length() == 0) {
				fullName = "%";
			} else {
				fullName = "%" + fullName + "%";
			}
			List list = session.createQuery("from Orders where FullName like :fullName ").setParameter("fullName", fullName).list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}

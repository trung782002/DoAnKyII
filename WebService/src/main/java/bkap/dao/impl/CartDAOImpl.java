package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.CartDAO;
import bkap.entities.Brands;
import bkap.entities.Carts;
import bkap.util.HibernateUtil;

public class CartDAOImpl implements CartDAO {

	@Override
	public List<Carts> getList() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Carts").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insert(Carts carts) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(carts);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean update(Carts carts) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(carts);
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

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(getById(id));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Carts getById(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Carts cart = session.get(Carts.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

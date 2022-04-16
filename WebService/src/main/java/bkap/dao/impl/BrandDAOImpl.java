package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.BrandDAO;
import bkap.entities.Brands;
import bkap.util.HibernateUtil;

public class BrandDAOImpl implements BrandDAO {

	@Override
	public List<Brands> getList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Brands").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Brands> searchByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (name == null || name.length() == 0) {
				name = "%";
			} else {
				name = "%" + name + "%";
				List list = session.createQuery("from Brands where Name like :name").setParameter("name", name).list();
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Brands getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Brands brand = session.get(Brands.class, id);
			return brand;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insert(Brands brand) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(brand);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean update(Brands brand) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(brand);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) {
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
		} finally {
			session.close();
		}
		return false;
	}

}

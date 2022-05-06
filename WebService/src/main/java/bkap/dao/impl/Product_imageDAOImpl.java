package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.Product_imageDAO;
import bkap.entities.Product_images;
import bkap.util.HibernateUtil;

public class Product_imageDAOImpl implements Product_imageDAO{

	@Override
	public List<Product_images> getByProId(Integer proId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
				List list = session.createQuery("from Product_images where ProId = : ProId").setParameter("ProId", proId).list();
				return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insert(Product_images product_image) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(product_image);
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
	public boolean delete(Integer proId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List<Product_images> list = new Product_imageDAOImpl().getByProId(proId);
			for (Product_images product_images : list) {
				deleteId(product_images.getId());	
			}
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
	
	@Override
	public boolean deleteId(Integer id) {
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
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Product_images getById(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Product_images product_images = session.get(Product_images.class, id);
			return product_images;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	} 
}

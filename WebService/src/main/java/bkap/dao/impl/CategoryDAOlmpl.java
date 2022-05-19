package bkap.dao.impl;

import java.util.List;


import org.hibernate.Session;
import bkap.dao.CategoryDAO;
import bkap.entities.Categories;
import bkap.entities.Products;
import bkap.util.HibernateUtil;

public class CategoryDAOlmpl implements CategoryDAO{

	@Override
	public List<Categories> getList(Integer status) {
		String query;
		if(status == 0)
			query = "from Categories order by CateId desc";
		else 
			query = "from Categories where Status = " + status + "order by CateId desc";
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery(query).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(new CategoryDAOlmpl().getList(0));
	}
	@Override
	public Categories getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Categories category = session.get(Categories.class, id);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insert(Categories cate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(cate);
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
	public boolean update(Categories cat) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(cat);
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
	
	public List<Categories> checkUnique(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		 List list =  session.createQuery("from Categories where name = :name").setParameter("name", name).list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return null;
	}
	
    public List<Products> getByProduct(Integer cateId){
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		 List list =  session.createQuery("from Products where Status != 3 and CateId = :cateId").setParameter("cateId", cateId).list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return null;
    }

}

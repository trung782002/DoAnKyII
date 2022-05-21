package bkap.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.google.gson.Gson;

import bkap.dao.BrandDAO;
import bkap.entities.Brands;
import bkap.entities.Products;
import bkap.entities.dto.BrandsDTO;

import bkap.util.HibernateUtil;

public class BrandDAOImpl implements BrandDAO {
	@Override
	public List<Brands> getAll() {
		// TODO Auto-generated method stub
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
	public boolean insertBrand(Brands brands) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(brands);
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
	public Brands getBrandsById(Integer Id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Brands brand = session.get(Brands.class, Id);
			return brand;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean updateBrands(Brands brands) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(brands);
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

	@Override
	public boolean deleteBrands(Integer Id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("update Brands set Status = 0 where id =: id").setParameter("id", Id)
					.executeUpdate();
			session.getTransaction().commit();
			if (i > 0) {
				return true;
			}
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
	public List<Brands> getBrandsByName(String name) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (name == null || name.length() == 0) {
				name = "%";
			} else {
				StringTokenizer stk = new StringTokenizer(name, "+");
				name = "";
				while(stk.hasMoreElements()) {
					name = name + stk.nextToken()+" ";					
				}
				name = name.trim();
				name = "%"+name+"%";
				List list = session.createQuery("from Brands where Name like :Name").setParameter("Name", name).list();
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

	public static void main(String[] args) {

		System.out.println(new BrandDAOImpl().getAll());
	}

	@Override
	public List<Brands> checkUnique(String name) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (name == null || name.length() == 0) {
				name = "%";
			} else {
				StringTokenizer stk = new StringTokenizer(name, "+");
				name = "";
				while(stk.hasMoreElements()) {
					name = name + stk.nextToken()+" ";					
				}
				name = name.trim();
				name = "%"+name+"%";
			}
			List list = session.createQuery("from Brands where Name = :name").setParameter("name", name).list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().commit();
		} finally {
			session.close();
		}
		return null;
	}

    public List<Products> getByProduct(Integer brandId){
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		 List list =  session.createQuery("from Products where Status = 1 and BrandId = :brandId").setParameter("brandId", brandId).list();
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

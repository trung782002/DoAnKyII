package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.ContactDAO;
import bkap.entities.Contacts;
import bkap.entities.Orders;
import bkap.util.HibernateUtil;

public class ContactDAOImpl implements ContactDAO {

	@Override
	public List<Contacts> getList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Contacts").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insert(Contacts contact) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(contact);
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
	public Contacts getById(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Contacts contact = session.get(Contacts.class, id);
			return contact;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
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
	public List<Contacts> searchByName(String fullName) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if (fullName == null || fullName.length() == 0) {
				fullName = "%";
			} else {
				fullName = "%" + fullName + "%";
			}
			List list = session.createQuery("from Contacts where FullName like :fullName ").setParameter("fullName", fullName).list();
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

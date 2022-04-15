package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.ContactDAO;
import bkap.entities.Contacts;
import bkap.util.HibernateUtil;

public class ContactDAOImpl implements ContactDAO {

	@Override
	public List<Contacts> getListContacts() {
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
	public boolean update(Contacts contact) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(contact);
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

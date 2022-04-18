package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.Account_RoleDAO;
import bkap.entities.Account_Roles;
import bkap.entities.Accounts;
import bkap.util.HibernateUtil;

public class Account_RoleDAOImpl implements Account_RoleDAO {

	@Override
	public List<Account_Roles> getList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Account_Roles").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Account_Roles getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Account_Roles account_role = session.get(Account_Roles.class, id);
			return account_role;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insert(Account_Roles account_role) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(account_role);
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
	public boolean update(Account_Roles account_role) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(account_role);
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(getById(id));
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

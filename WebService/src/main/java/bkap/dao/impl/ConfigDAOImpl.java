package bkap.dao.impl;

import java.util.List;

import org.hibernate.Session;

import bkap.dao.ConfigDAO;
import bkap.entities.Configs;
import bkap.util.HibernateUtil;

public class ConfigDAOImpl implements ConfigDAO {

	@Override
	public List<Configs> getList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Configs").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean update(Configs config) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(config);
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
	public Configs getById(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Configs config = session.get(Configs.class, id);
			return config;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}

package bkap.dao.impl;

import org.hibernate.Session;

import bkap.dao.ConfigDAO;
import bkap.entities.Configs;
import bkap.util.HibernateUtil;

public class ConfigDAOImpl implements ConfigDAO {

	@Override
	public Configs getConfig() {
		Integer id = 1;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Configs config = session.get(Configs.class, id);
			return config;
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

}

package bkap.dao;

import java.util.List;

import bkap.entities.Configs;

public interface ConfigDAO {
	public List<Configs> getList();
	
	public boolean update(Configs config);
	
	public Configs getById(Integer id);
}

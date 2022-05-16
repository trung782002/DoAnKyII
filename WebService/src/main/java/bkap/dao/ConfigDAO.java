package bkap.dao;

import bkap.entities.Configs;

public interface ConfigDAO {
	
	public Configs getConfig();
	
	public boolean update(Configs config);
	
}

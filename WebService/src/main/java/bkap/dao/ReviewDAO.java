package bkap.dao;

import java.util.List;

import bkap.entities.Reviews;

public interface ReviewDAO {
	public List<Reviews> getList();

	public boolean insert(Reviews review);

	public boolean update(Reviews review);

	public boolean delete(Integer id);

	public Reviews getById(Integer id);
}

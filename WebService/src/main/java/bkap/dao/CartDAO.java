package bkap.dao;

import java.util.List;

import bkap.entities.Carts;

public interface CartDAO {
	public List<Carts> getList();

	public boolean insert(Carts carts);

	public boolean update(Carts carts);

	public boolean delete(Integer id);

	public Carts getById(Integer id);
}

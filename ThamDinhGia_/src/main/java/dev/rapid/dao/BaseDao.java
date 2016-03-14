package dev.rapid.dao;

import java.util.Collection;
import java.util.List;

public interface BaseDao<T> {
	// Create - Insert - Update
	public boolean saveOrUpdate(T object);
	public boolean saveOrUpdate(Collection<T> objects);

	// Delete
	public boolean delete(Integer id);
	public boolean delete(Collection<Integer> ids);

	//Select - retrieve
	public T find(Integer id);
	public List<T> findAll();
}

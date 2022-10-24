package com.gcu.data;

import java.util.List;



public interface DataAccessInterface <T> 
{
	public List<T> findAll();
	public T findById(int id);
	public int create(T t);
	public int update(T t);
	public int delete(T t);
}

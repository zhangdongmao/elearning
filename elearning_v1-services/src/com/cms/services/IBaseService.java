package com.cms.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface IBaseService<T> {
	public void delete(T entity);
	public void update(T entity);
	public void save(T entity);
	public Session getSession();
	public void closeSession();
	public T get(Serializable id);
	public T load(Serializable id);
	public List<T> list(String hql);	
	public List<T> find(String hql,Object ... params);
	public void deleteById(Serializable id);
}

package com.cms.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface IBaseDao<T> {
	public void delete(T entity);
	public void update(T entity);
	public void save(T entity);
	
	public void closeSession();
	public Session getSession();
	public T get(Serializable id);
	public T load(Serializable id);
	
	public List<T> list(String queryString);
	
	public List<T> find(String hql,Object ... params);
	
	public List<T> queryPage(String hsql,int pageNo,int pageSize,Object ... params);
	
	public int updateObjects(final String hql, final Object... conditions);
}


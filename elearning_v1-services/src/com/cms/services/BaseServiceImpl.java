package com.cms.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cms.dao.IBaseDao;



public class BaseServiceImpl<T> implements IBaseService<T>{
	//@Autowired  -- 这里不能用autiwire，因为IBaseDao类型多于一个,框架会报错
		//提供set，有子类来注入
		IBaseDao<T> baseDao;
		
		@Override
		@Transactional(propagation=Propagation.REQUIRED)
		public void delete(T entity) {
			baseDao.delete(entity);
		}

		@Override
		@Transactional(propagation=Propagation.REQUIRED)
		public void update(T entity) {
			baseDao.update(entity);
		}

		@Override
		@Transactional(propagation=Propagation.REQUIRED)
		public void save(T entity) {
			baseDao.save(entity);
			//int i = 1/0;//会抛出除数为零异常。测试事务是否自动回滚
			//throw new Exception("ssss");//如果不是RunTimeException，不会回滚.
		}

		@Override
		public T get(Serializable id) {
			// TODO Auto-generated method stub
			return baseDao.get(id);
		}

		@Override
		public T load(Serializable id) {
			return baseDao.load(id);
		}

		@Override
		public List<T> list(String hql) {
			return baseDao.list(hql);
		}
		
		//提供baseDao的set方法，让子类可以将子类的dao设置进来(注意子类的dao本身也是IBaseDao的实现类)
		public void setBaseDao(IBaseDao<T> baseDao) {
			this.baseDao = baseDao;
		}

		@Override
		@Transactional(propagation=Propagation.REQUIRED)
		public void deleteById(Serializable id) {
			T entity = this.get(id);
			this.delete(entity);
		}

		@Override
		public List<T> find(String hql, Object... params) {
			
			return baseDao.find(hql,params);
		}

		@Override
		public Session getSession() {
		
			return baseDao.getSession();
		}

		@Override
		public void closeSession() {
			baseDao.closeSession();
		}

		@Override
		public List<T> queryPage(String hsql, int pageNo, int pageSize, Object... params) {
			
			return baseDao.queryPage(hsql, pageNo, pageSize, params);
		}

		

	
}

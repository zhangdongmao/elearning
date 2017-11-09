package com.cms.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T>  {
	private Class<T> entityClass;
	
	
    //在构造函数中获取运行时候pojo的类型
   public BaseDaoImpl() {
		// 是得到这个类的得到泛型父类
		Type genType = getClass().getGenericSuperclass();
		//返回表示此类型实际类型参数的Type对象的数组,对应类型的Class
        //可能有多个，取第0个。
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	
	@Override
	public void delete(Object entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(Object entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void save(Object entity) {
		this.getHibernateTemplate().save(entity);
		
	}
	
	@Override
	public T get(Serializable id) {
		
		return this.getHibernateTemplate().get(entityClass, id);
		
	}

	@Override
	public T load(Serializable id) {
		return this.getHibernateTemplate().load(entityClass, id);
	}


	@Override
	public List<T> queryPage(String hsql, int pageNo, int pageSize, Object... params) {
		
		List<T> list= this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createQuery(hsql);
				
				//设置hql参数
				if(params!=null){
					for (int i = 0; i < params.length; i++) {
						query.setParameter(i, params[i]);
						
					}
				}
				query.setFirstResult((pageNo-1)*pageSize);
				query.setMaxResults(pageSize);
				
				return query.list();
			}
		});
		return list;
	}


	@Override
	public List list(String queryString) {
		return this.getHibernateTemplate().find(queryString);
		
	}


	@Override
	public List<T> find(String hql, Object... params) {
		return (List<T>) this.getHibernateTemplate().find(hql, params);
	}


	//实现批量的更新或者删除 //测试视频的录制大小
		@Override
		public int updateObjects(final String hql, final Object... conditions) {
			int count = this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
				@Override
				public Integer doInHibernate(Session session) throws HibernateException {
					try{
						Query query = session.createQuery(hql);
						for(int i=0;i<conditions.length;i++){
							query.setParameter(i, conditions[i]);
						}				
						return query.executeUpdate();
					}catch(Exception e){
						e.printStackTrace();
					}
					return 0;
				}
			});
			return count;
		}


		@Override
		public Session getSession() {
			Session session= this.getHibernateTemplate().getSessionFactory().openSession();
			return session;
		}


		@Override
		public void closeSession() {
			this.getHibernateTemplate().getSessionFactory().close();
		}


	
}

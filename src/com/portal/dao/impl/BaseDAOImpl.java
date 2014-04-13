package com.portal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.portal.dao.BaseDAO;


@Repository("baseDAO")
public class BaseDAOImpl<T> implements BaseDAO<T> {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory	sessionFactory;

	/**
	 * 获取session对象.
	 * @return session对象
	 */
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 根据id取得实体.
	 * @param clasz 实体
	 * @param id 实体主键
	 * @return 返回实体
	 */
	@SuppressWarnings("unchecked")

	public T load(Class<T> clasz, Serializable id) {
		return (T) getSession().get(clasz, id);
	}

	/**
	 *  根据HQL取得实体列表.
	 * @param resultSQL 查询语句
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	
	public List<T> findBySql(String resultSQL) {
		return getSession().createQuery(resultSQL).list();
	}

	/**
	 *  根据HQL取得实体列表.
	 * @param resultSQL 查询语句
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	
	public Query excuteHQL(String resultSQL) {

		return getSession().createQuery(resultSQL);
	}

	/**
	 * 根据DetachedCriteria查询.
	 * @param criteria 查询条件
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	
	public List<T> findByCriteria(DetachedCriteria criteria) {
		return criteria.getExecutableCriteria(getSession()).list();
	}

	/**
	 * 保存实体.
	 * @param clazs 实体对象
	 */
	
	public void save(Object clazs) {
		getSession().save(clazs);
	}

	/**
	 * 根据id删除指定实体.
	 * @param clazs  实体的类别
	 * @param id  主键
	 */
	
	public void delete(Class<T> clazs, Serializable id) {
		Object o = getSession().get(clazs, id);
		if (o != null) {
			getSession().delete(o);
		}

	}

	/**
	 * 更新实体对象.
	 * @param clazs 实体对象
	 */
	
	public void update(Object clazs) {
		getSession().update(clazs);

	}

	/**
	 * 
	* @Title: updateBySql.
	* @Description: 使用Sql语句进行更新
	* @param sql Sql语句
	* @return 更新记录数
	* @throws
	 */
	
	public int updateBySql(String sql) {
		return getSession().createQuery(sql).executeUpdate();
	}

}

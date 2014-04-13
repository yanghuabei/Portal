package com.portal.dao;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;


public interface BaseDAO<T> {
	
	/**
	 * 根据id取得实体.
	 * @param clasz 实体
	 * @param id 实体主键
	 * @return 返回实体
	 */
	T load(Class<T> clasz, Serializable id);

	/**
	 *  根据HQL取得实体列表.
	 * @param resultSQL 查询语句
	 * @return 查询结果
	 */
	List<T> findBySql(String resultSQL);

	/**
	 * 根据DetachedCriteria查询.
	 * @param criteria 查询条件
	 * @return 查询结果
	 */
	List<T> findByCriteria(DetachedCriteria criteria);

	/**
	 * 保存实体.
	 * @param clazs 实体对象
	 */
	void save(Object clazs);

	/**
	 * 根据id删除指定实体.
	 * @param clazs  实体的类别
	 * @param id  主键
	 */
	void delete(Class<T> clazs, Serializable id);

	/**
	 * 更新实体对象.
	 * @param clazs 实体对象
	 */
	void update(Object clazs);

	/**
	 * 
	* @Title: updateBySql.
	* @Description: 使用Sql语句进行更新
	* @param sql Sql语句
	* @return 更新记录数
	* @throws
	 */
	int updateBySql(String sql);


	/**
	 * 
	* @Title: excuteHQL.
	* @Description: 使用hql进行批量操作
	* @param resultSQL hql语句
	* @return 查询的结果
	* @throws
	 */
	Query excuteHQL(String resultSQL);

}

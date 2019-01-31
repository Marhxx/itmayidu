package com.spring.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.spring.common.entity.PageBean;



/**
 * BaseService 方法已经封装好了  直接用
 * @author HXX
 *
 */
public interface BaseService<T, ID extends Serializable> {

	void save(T entity) throws Exception;

	void delete(ID id) throws Exception;

	void update(T entity) throws Exception;
	
	void updateSelective(T entity) throws Exception;
	
	T findById(ID id);

	List<T> findAll();
	
	PageBean<T> getPage(T t, PageBean<T> pageBean);
	
	PageBean<T> getPageByParams(Map<String, Object> map, PageBean<T> pageBean);
	
	public T searchOne(T t);
	
	



}

package com.spring.api.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.spring.api.dao.TbstarDao;
import com.spring.api.entity.Tbstar;
import com.spring.base.dao.impl.BaseDaoMysqlImpl;

/**
 * TbstarDaoImpl 继承 BaseDaoMysqlImpl服务 拥有父类BaseDaoMysqlImpl 下的所有服务
 * 
 * @author HXX
 *
 */
@Repository
public class TbstarDaoImpl extends BaseDaoMysqlImpl<Tbstar, Serializable> implements TbstarDao {
	public TbstarDaoImpl() {

		super(Tbstar.class);
	}

	/*
	 * @Override public Integer getFindAll(String id) {
	 * 
	 * return null; }
	 */

}

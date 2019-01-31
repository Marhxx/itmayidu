package com.spring.api.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.api.dao.TbInformationDao;
import com.spring.api.entity.TbInformation;
import com.spring.base.dao.impl.BaseDaoMysqlImpl;

/**
 * 
 * @author JoeyChen
 * @date 2018年8月2日 
 *
 */
@Repository
public class TbInformationDaoImpl extends BaseDaoMysqlImpl<TbInformation, Long> implements TbInformationDao {
	public TbInformationDaoImpl(){
		super(TbInformation.class);
	}
}

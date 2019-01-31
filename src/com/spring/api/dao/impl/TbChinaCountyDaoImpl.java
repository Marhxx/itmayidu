package com.spring.api.dao.impl;

import org.springframework.stereotype.Repository;
import com.spring.api.entity.TbChinaCounty;
import com.spring.base.dao.impl.BaseDaoMysqlImpl;
import com.spring.api.dao.TbChinaCountyDao;

/**
 * 区业务类
 *
 * @author LiaoJinKe
 * @Date 2018-07-04 15:59:12
 */
 
@Repository
public class TbChinaCountyDaoImpl extends BaseDaoMysqlImpl<TbChinaCounty, Long> implements
		TbChinaCountyDao {

	public TbChinaCountyDaoImpl(){
		super(TbChinaCounty.class);
	}
}
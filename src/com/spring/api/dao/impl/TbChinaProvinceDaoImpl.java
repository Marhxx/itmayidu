package com.spring.api.dao.impl;

import org.springframework.stereotype.Repository;
import com.spring.api.entity.TbChinaProvince;
import com.spring.base.dao.impl.BaseDaoMysqlImpl;
import com.spring.api.dao.TbChinaProvinceDao;

/**
 * 省业务类
 *
 * @author LiaoJinKe
 * @Date 2018-07-04 16:41:12
 */
 
@Repository
public class TbChinaProvinceDaoImpl extends BaseDaoMysqlImpl<TbChinaProvince, Long> implements
		TbChinaProvinceDao {

	public TbChinaProvinceDaoImpl(){
		super(TbChinaProvince.class);
	}
}
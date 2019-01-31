package com.spring.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.ChinaCountyDao;
import com.spring.common.entity.ChinaCounty;
import com.spring.common.service.ChinaCountyService;


@Service("chinaCountyService")
public class ChinaCountyServiceImpl  extends
BaseServiceImpl<ChinaCounty, Long> implements ChinaCountyService{
	
	@Resource
	ChinaCountyDao chinaCountyDao;

	@Override
	public List<ChinaCounty> findAllCounty() {
		return chinaCountyDao.getAll();
	}

	@Override
	public List<ChinaCounty> findAllCountyByCity(Long cid) {
		String sql="SELECT * FROM china_county o WHERE o.cid="+cid;
		return chinaCountyDao.search(sql, null);
	}

	@Override
	public BaseDao<ChinaCounty, Long> getGenericDao() {
		return chinaCountyDao;
	}

	@Override
	public ChinaCounty findCountyById(Long id) {
		return chinaCountyDao.get(id);
	}

	@Override
	public List<Map<String, Object>> findCounty(String cid) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("SELECT o.* FROM `china_county` o ");
		sbSql.append("WHERE 1=1 ");
		List<Object> values = new ArrayList<>();
		if(!StringUtils.isBlank(cid)){
			sbSql.append(" AND o.`cid` = ? ");
			values.add(cid);
		}
		sbSql.append("ORDER BY o.`cid` ");
		return chinaCountyDao.searchForMap(sbSql.toString(), values);
	}
	
}

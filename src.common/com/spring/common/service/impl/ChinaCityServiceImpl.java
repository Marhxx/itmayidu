package com.spring.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.ChinaCityDao;
import com.spring.common.entity.ChinaCity;
import com.spring.common.service.ChinaCityService;


@Service("chinaCityService")
public class ChinaCityServiceImpl  extends
BaseServiceImpl<ChinaCity, Long> implements ChinaCityService{
	
	@Resource
	ChinaCityDao chinaCityDao;

	@Override
	public List<ChinaCity> findAllCity() {
		return chinaCityDao.getAll();
	}

	@Override
	public List<ChinaCity> findAllCityByPro(Long pid) {
		String sql=" SELECT * FROM china_city c WHERE c.pid = "+pid;
		return chinaCityDao.search(sql, null);
	}

	@Override
	public BaseDao<ChinaCity, Long> getGenericDao() {
		return chinaCityDao;
	}

	@Override
	public ChinaCity findCityById(Long id) {
		return chinaCityDao.get(id);
		
	}

	@Override
	public List<Map<String, Object>> listByProId(Long pid) {
		String sql = "";
		if(pid == 0){
			sql += "select cid,cname,pfl from china_city";
			
		}else{
			sql += "select cid,cname,pfl from china_city where pid="+pid+"";
		}
		return chinaCityDao.searchForMap(sql, null);
	}

	@Override
	public Map<String, Object> findByName(Integer cid, String name) {
		String sql = "SELECT * FROM `china_city` c WHERE 1=1 ";
		List<Object> values = new ArrayList<>();
		if (cid!=null) {
			sql += " AND c.`cid` = ?";
			values.add(cid);
		}
		
		if (!StringUtils.isBlank(name)) {
			sql += " AND c.`cname` = ?";
			values.add(name);
		}
		
		List<Map<String, Object>> list = chinaCityDao.searchForMap(sql, values);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public List<Map<String, Object>> findCity(String pid) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("SELECT * FROM `china_city` ci ");
		sbSql.append("WHERE 1=1 ");
		List<Object> values = new ArrayList<>();
		if(!StringUtils.isBlank(pid)){
			sbSql.append(" AND ci.`pid` = ? ORDER BY ci.`pfl`");
			values.add(pid);
		}
		if(StringUtils.isBlank(pid)){
			sbSql.append(" ORDER BY ci.`pfl` ");
		}
		return chinaCityDao.searchForMap(sbSql.toString(), values);
	}
	
	
	@Override
	public Map<String, Object> findByAddress(String address) {
		String sql = "SELECT * FROM `china_city` c WHERE 1=1 ";
		List<Object> values = new ArrayList<>();
		
		if (!StringUtils.isBlank(address)) {
			sql += " AND c.`cname` = ?";
			values.add(address);
		}
		
		List<Map<String, Object>> list = chinaCityDao.searchForMap(sql, values);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}
	

}

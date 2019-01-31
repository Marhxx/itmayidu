package com.spring.common.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.ChinaProvinceDao;
import com.spring.common.entity.ChinaProvince;
import com.spring.common.service.ChinaProvinceService;



@Service("chinaProvinceService")
public class ChinaProvinceServiceImpl  extends
BaseServiceImpl<ChinaProvince, Long> implements ChinaProvinceService{
	
	@Resource
	ChinaProvinceDao chinaProvinceDao;

	@Override
	public List<ChinaProvince> findAllPro() {
		return chinaProvinceDao.getAll();
	}

	@Override
	public ChinaProvince findProById(Long id) {
		return chinaProvinceDao.get(id);
	}

	@Override
	public BaseDao<ChinaProvince, Long> getGenericDao() {
		return chinaProvinceDao;
	}

	@Override
	public List<Map<String, Object>> listProvince() {
		String sql = "select * from china_province";
		return chinaProvinceDao.searchForMap(sql, null);
	}

	@Override
	public List<Map<String, Object>> findProvice() {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("SELECT * FROM `china_province` ORDER BY `pfl`");
		return chinaProvinceDao.searchForMap(sbSql.toString(), null);
	}

    @Override
    public ChinaProvince findproByCityName(String address) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("SELECT * FROM china_province p,china_city c WHERE" +
				"c.cname= "+address+"AND p.pid = c.pid");
		List<ChinaProvince> list = chinaProvinceDao.search(sbSql.toString(),null);
		if (list.size()>0)
			return list.get(0);
		return null;
    }


}

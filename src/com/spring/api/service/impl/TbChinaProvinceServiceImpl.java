package com.spring.api.service.impl;

import org.springframework.stereotype.Service;
import com.spring.base.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.spring.common.entity.PageBean;
import com.spring.api.entity.TbChinaProvince;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.api.service.TbChinaProvinceService;
import com.spring.api.dao.TbChinaProvinceDao;
import com.spring.base.dao.BaseDao;

/**
 * 省业务类
 *
 * @author LiaoJinKe
 * @Date 2018-07-04 16:41:12
 */
 @Service
public class TbChinaProvinceServiceImpl extends BaseServiceImpl<TbChinaProvince, Long> implements TbChinaProvinceService {
	
	@Resource TbChinaProvinceDao tbChinaProvinceDao;

	@Override
	public BaseDao<TbChinaProvince, Long> getGenericDao() {
		return tbChinaProvinceDao;
	}
	
	@Override
	public Map<String, Object> findForJson(Map<String, String> params) {
		Map<String, Object> json = new HashMap<String, Object>();
		String AddDate = params.get("AddDate");
		String AddDateEnd = params.get("AddDateEnd");
		int page = params.get("page") == null ? 0:Integer.parseInt(params.get("page"));
		int pageSize = params.get("rows") == null ? 0:Integer.parseInt(params.get("rows"));
		String sort = params.get("sort");
		String order = params.get("order");
		List<Object> values = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		//逻辑判断开始
		
		
		//逻辑判断结束
		if(!StringUtils.isEmpty(AddDate)){
			sql.append(" AND DATE_FORMAT(XXXX,'%Y-%m-%d') >= DATE_FORMAT('"+AddDate+"','%Y-%m-%d')");
		}
		if(!StringUtils.isEmpty(AddDateEnd)){
			sql.append(" AND DATE_FORMAT(XXXX,'%Y-%m-%d') <= DATE_FORMAT('"+AddDateEnd+"','%Y-%m-%d')");
		}
		if(!StringUtil.isEmptyNull(sort)){
			sql.append(" order by  " + sort);
		}
		if(!StringUtil.isEmptyNull(order)){
			sql.append("  " + order);
		}
		if (pageSize == 0) {
			List<Map<String,Object>> list = tbChinaProvinceDao.searchForMap(sql.toString(), values);
			json.put("total", list.size());
			json.put("rows", list);
			return json;
		}else {
			PageBean<Map<String,Object>> pageBean = new PageBean<Map<String,Object>>(page, pageSize);
			pageBean = tbChinaProvinceDao.searchForMap(sql.toString(), values, pageBean);
			json.put("total", pageBean.getRowCount());
			json.put("rows", pageBean.getList());
			return json;
		}
	}

	@Override
	public List<Map<String, Object>> findListAll() {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select pid,pname from china_province where pname!= '全国'");
		List<Map<String, Object>> list = tbChinaProvinceDao.searchForMap(sbSql.toString(), null);
		return list;
	}
}
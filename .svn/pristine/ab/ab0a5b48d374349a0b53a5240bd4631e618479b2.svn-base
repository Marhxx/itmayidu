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
import com.spring.api.entity.TbChinaCounty;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.api.service.TbChinaCountyService;
import com.spring.api.dao.TbChinaCountyDao;
import com.spring.base.dao.BaseDao;

/**
 * 区业务类
 *
 * @author LiaoJinKe
 * @Date 2018-07-04 15:59:12
 */
 @Service
public class TbChinaCountyServiceImpl extends BaseServiceImpl<TbChinaCounty, Long> implements TbChinaCountyService {
	
	@Resource TbChinaCountyDao tbChinaCountyDao;

	@Override
	public BaseDao<TbChinaCounty, Long> getGenericDao() {
		return tbChinaCountyDao;
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
			List<Map<String,Object>> list = tbChinaCountyDao.searchForMap(sql.toString(), values);
			json.put("total", list.size());
			json.put("rows", list);
			return json;
		}else {
			PageBean<Map<String,Object>> pageBean = new PageBean<Map<String,Object>>(page, pageSize);
			pageBean = tbChinaCountyDao.searchForMap(sql.toString(), values, pageBean);
			json.put("total", pageBean.getRowCount());
			json.put("rows", pageBean.getList());
			return json;
		}
	}

	@Override
	public List<Map<String, Object>> findListById(String cid) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select oid,oname from china_county where cid = "+Integer.valueOf(cid));
		List<Map<String, Object>> list = tbChinaCountyDao.searchForMap(sbSql.toString(), null);
		return list;
	}
}
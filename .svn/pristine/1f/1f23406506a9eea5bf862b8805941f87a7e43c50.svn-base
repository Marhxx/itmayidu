package com.spring.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.UserinfoDao;
import com.spring.common.entity.PageBean;
import com.spring.common.entity.Userinfo;
import com.spring.common.service.UserinfoService;

@Service("userinfoService")
public class UserinfoServiceImpl extends BaseServiceImpl<Userinfo, Long> implements
		UserinfoService {

	@Resource UserinfoDao userinfoDao;
	@Override
	public BaseDao<Userinfo, Long> getGenericDao() {
		return userinfoDao;
	}

	@Override
	public PageBean<Userinfo> findByPage(Userinfo params,PageBean<Userinfo> pageBean) {
		return userinfoDao.search(params, pageBean);
	}
	
	@Override
	public Userinfo findUserinfo(Userinfo searchParams) {
		return userinfoDao.searchOne(searchParams);
	}

	@Override
	public List<Userinfo> findAll(Userinfo searchParams) {
		return userinfoDao.search(searchParams);
	}
	
	@Override
	public Userinfo findUserinfoByAccount(String account, String groupId) {
		Userinfo userinfo = null;
		String sql = "select * from userinfo where account = '"+account+"' AND delete_mark <> 0 ";
		if(!StringUtils.isBlank(groupId)){
			sql += "AND groupId = '"+groupId+"' ";
		}
		if(userinfoDao.search(sql, null).size()>0){
			userinfo = userinfoDao.search(sql, null).get(0);
		}
		return userinfo;
	}

	@Override
	public HashMap<String, Object> findForJson(HashMap<String, String> params) {
		HashMap<String, Object> json = new HashMap<String, Object>();

		int page = params.get("page") == null ? 0:Integer.parseInt(params.get("page"));
		int pageSize = params.get("pageSize") == null ? 0:Integer.parseInt(params.get("pageSize"));
		String group = params.get("group");
		
		String sql = "select u.id,u.name,u.groupId,u.account,u.sex,u.email,u.remark,u.create_user_name as createUserName,u.create_time as createTime,g.name as groupName,g.id from userinfo u,usergroup g where u.groupId = g.id ";
		List<Object> values = new ArrayList<Object>();
		if(!StringUtils.isBlank(group)) {
			sql += " and u.groupId = ?";
			values.add(Integer.parseInt(group));
		}
		if (pageSize == 0) {
			List<Userinfo> list = userinfoDao.search(sql, values);
			json.put("total", list.size());
			json.put("rows", list);
			return json;
		}else {
			PageBean<Userinfo> pageBean = new PageBean<Userinfo>(page, pageSize);
			pageBean = userinfoDao.search(sql, values, pageBean);
			
			json.put("total", pageBean.getRowCount());
			json.put("rows", pageBean.getList());
			return json;
		}
	}
	
	@Override
	public List<Map<String, Object>> findProvice() {
		String sql = "SELECT p.pid,p.pname FROM china_province p";
		return userinfoDao.searchForMap(sql, null);
	}
	
	@Override
	public List<Map<String, Object>> findCity(int pid) {
		String sql = "SELECT c.cid,c.cname FROM china_city c WHERE c.pid = '"+pid+"'";
		return userinfoDao.searchForMap(sql, null);
	}
	
	@Override
	public List<Map<String, Object>> findCounty(int cid) {
		String sql = "SELECT o.oid,o.oname FROM china_county o WHERE o.cid = '"+cid+"'";
		return userinfoDao.searchForMap(sql, null);
	}
	
}

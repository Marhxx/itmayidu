package com.spring.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.base.service.BaseService;
import com.spring.common.entity.PageBean;
import com.spring.common.entity.Userinfo;

public interface UserinfoService extends BaseService<Userinfo, Long> {

	/**
	 * 分页查询
	 * @param params 条件参数
	 * @param pageBean 
	 * @return
	 */
	PageBean<Userinfo> findByPage(Userinfo params,PageBean<Userinfo> pageBean);
	
	Userinfo findUserinfo(Userinfo searchParams);
	
	Userinfo findUserinfoByAccount(String account, String groupId);
	
	List<Userinfo> findAll(Userinfo searchParams);
	
	HashMap<String, Object> findForJson(HashMap<String, String> params);
	
	List<Map<String, Object>> findProvice();
	List<Map<String, Object>> findCity(int pid);
	List<Map<String, Object>> findCounty(int cid);
	
	
}

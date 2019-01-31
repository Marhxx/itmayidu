package com.spring.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.UsergroupDao;
import com.spring.common.entity.MenuTree;
import com.spring.common.entity.Usergroup;
import com.spring.common.service.UsergroupService;

@Service("usergroupService")
public class UsergroupServiceImpl extends BaseServiceImpl<Usergroup, Integer> implements
		UsergroupService {

	@Resource UsergroupDao usergroupDao;
	
	@Override
	public BaseDao<Usergroup, Integer> getGenericDao() {
		return usergroupDao;
	}

	@Override
	public List<MenuTree> findForTree() {
		return usergroupDao.search("select id,parent_id as parendId,name as text from usergroup order by create_time asc", null, MenuTree.class);
	}

}

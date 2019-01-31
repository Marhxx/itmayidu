package com.spring.common.service;

import java.util.List;

import com.spring.base.service.BaseService;
import com.spring.common.entity.MenuTree;
import com.spring.common.entity.Usergroup;

public interface UsergroupService extends BaseService<Usergroup, Integer> {

	List<MenuTree> findForTree();
	
}

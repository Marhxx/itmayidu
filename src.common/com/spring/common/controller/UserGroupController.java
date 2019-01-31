package com.spring.common.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.base.controller.BaseController;
import com.spring.common.entity.MenuTree;
import com.spring.common.entity.Usergroup;
import com.spring.common.service.UsergroupService;

@Controller
@RequestMapping(value="/group")
public class UserGroupController extends BaseController{

	static{
		PREFIX = "system";
	}
	
	@Resource UsergroupService usergroupService;
	
	@ResponseBody
	@RequestMapping(value="/treelist")
	public List<MenuTree> treeList() {
		
		return usergroupService.findForTree();
	}
	
	@ResponseBody
	@RequestMapping(value="/list")
	public List<Usergroup> list() {
		
		return usergroupService.findAll();
	}
}

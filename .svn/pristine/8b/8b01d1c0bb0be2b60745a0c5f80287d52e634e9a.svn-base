package com.spring.common.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.base.controller.BaseController;
import com.spring.common.entity.Sysmenu;
import com.spring.common.service.GroupandmenuService;
import com.spring.common.service.UserandmenuService;

@Controller
@RequestMapping(value="perms")
public class PermsController extends BaseController {

	static{
		PREFIX = "system";
	}
	
	@Resource UserandmenuService userandmenuService;
	@Resource GroupandmenuService groupandmenuService;
	
	@ResponseBody
	@RequestMapping(value="/list")
	public List<Sysmenu> list(HttpServletRequest request) {
		
		String type = request.getParameter("type");
		String userId = request.getParameter("userId");

		if (StringUtils.isBlank(userId)) {
			return null;
		}
		
		if(StringUtils.isBlank(type)) type = "0";
		
		if (type.equals("0")) {//0查询用户组权限
			return groupandmenuService.list(userId);
		}else if (type.equals("1")) {//查询用户权限
			return userandmenuService.list(userId);
		}
		
		return null;
	}
	
	public String setting(HttpServletRequest request) {
		
		String type = request.getParameter("type");
		String menuIds = request.getParameter("menuIds");
		String btnIds = request.getParameter("btnIds");
		String userId = request.getParameter("userId");
		
		if(StringUtils.isBlank(menuIds)) menuIds = "";
		if(StringUtils.isBlank(btnIds)) btnIds = "";
		
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(type)) {
			return "2";
		}
		if (type.equals("1")) {
			groupandmenuService.addPerms(menuIds, btnIds, userId);
		}else if (type.equals("2")) {
			userandmenuService.addPerms(menuIds, btnIds, userId);
		}
		
		return "1";
	}
}

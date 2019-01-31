package com.spring.common.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.base.controller.BaseController;
import com.spring.base.shiro.ShiroUser;
import com.spring.base.utils.GlobalStatic;
import com.spring.common.entity.MenuTree;
import com.spring.common.entity.Sysmenu;
import com.spring.common.entity.Userinfo;
import com.spring.common.service.GroupandmenuService;
import com.spring.common.service.SysmenuService;
import com.spring.common.service.UserandmenuService;

@Controller
@RequestMapping(value="/menu")
public class SysmenuController extends BaseController {

	@Resource SysmenuService sysmenuService;
	@Resource UserandmenuService userandmenuService;
	@Resource GroupandmenuService groupandmenuService;
	
	static{
		PREFIX = "system";
	}
	
	@ResponseBody
	@RequestMapping(value="/list")
	public List<Sysmenu> list() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", "-1");
		List<Sysmenu> list = sysmenuService.list(params);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/leftmenu")
	public List<MenuTree> lefTrees(HttpServletRequest request) {
		Userinfo userinfo = (Userinfo) request.getSession().getAttribute(GlobalStatic.DEFAULT_LOGIN_SESSION_NAME);
		List<MenuTree> list = sysmenuService.findMenuByUser(userinfo);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(HttpServletRequest request) {
		
		ShiroUser userinfo = (ShiroUser)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
//		Userinfo userinfo = (Userinfo) session.getAttribute(GlobalStatic.DEFAULT_LOGIN_SESSION_NAME);
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		Integer parentId = request.getParameter("parentId") == null ? 0:Integer.parseInt(request.getParameter("parentId"));
		Integer sortCode = request.getParameter("sortCode") == null ? 0:Integer.parseInt(request.getParameter("sortCode"));
		Integer type = request.getParameter("type") == null ? 0:Integer.parseInt(request.getParameter("type"));
		
		Sysmenu menu = new Sysmenu();
		menu.setParentId(parentId);
		menu.setName(name);
		menu.setUrl(url);
		menu.setAllowEdit(1);
		menu.setAllowDelete(1);
		menu.setSortCode(sortCode);
		menu.setStatus(1);
		menu.setType(type);
		menu.setAddtime(new Timestamp(new Date().getTime()));
		menu.setAddUserId(userinfo.getId());
		menu.setAddUsername(userinfo.getAccount());
		try {
			sysmenuService.save(menu);
		} catch (Exception e) {
			return "0";
		}
		
		return "1";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/del/{id}")
	public String del(@PathVariable Integer id) {
//		Sysmenu menu = sysmenuService.findById(id);
		if (id == null) {
			return "2";
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", id);
		List<Sysmenu> list = sysmenuService.list(params);
		if (list!=null && list.size()>0) {
			return "3";
		}
		
		sysmenuService.del(id);
		
		return "1";
	}
	
}

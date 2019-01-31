package com.spring.common.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.base.controller.BaseController;
import com.spring.common.entity.PageBean;
import com.spring.common.entity.Userinfo;
import com.spring.common.service.UserinfoService;

@Controller
@RequestMapping(value="/user")
public class UserinfoController extends BaseController {
	
	@Resource UserinfoService userinfoService;
	
	static{
		PREFIX = "system";
	}
	
	@ResponseBody
	@RequestMapping(value="/list")
	public HashMap<String, Object> list(HttpServletRequest request) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("page", request.getParameter("page"));
		params.put("pageSize", request.getParameter("pageSize"));
		params.put("group", request.getParameter("group"));
		
		return userinfoService.findForJson(params);
		
	}
	
	

}

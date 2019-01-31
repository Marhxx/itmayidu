package com.spring.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.spring.base.utils.GlobalStatic;
import com.spring.base.utils.RequestUtil;
import com.spring.base.utils.StringTool;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		
		String requestPath = RequestUtil.getRequestPath(arg0);// 用户访问的资源地址
		System.out.println("[INFO]"+requestPath);
		
		String code = arg0.getParameter("code");
		String key = arg0.getParameter("key");
		String result = "{\"result\":-1,\"details\":\"验证不通过，非法用户\"}";
//		if (StringUtils.isBlank(key) || StringUtils.isBlank(code)) {
//			arg1.setHeader("Content-type", "text/json;charset=UTF-8");
//			arg1.setCharacterEncoding("UTF-8");
//			arg1.getWriter().write(result);
//			return false;
//		}
		
//		String authCode = StringTool.toBase64(StringTool.md5(key.trim()+GlobalStatic.AUTH_KEY).toUpperCase());
//		
//		if (!authCode.equals(code.trim())) {
//			arg1.setHeader("Content-type", "text/json;charset=UTF-8");
//			arg1.setCharacterEncoding("UTF-8");
//			arg1.getWriter().write(result);
//			return false;
//		}
		
		return true;
	}

}

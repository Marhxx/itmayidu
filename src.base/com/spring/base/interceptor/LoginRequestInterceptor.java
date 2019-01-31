package com.spring.base.interceptor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//import com.spring.api.entity.TbMemberAccount;
import com.spring.api.entity.TbMemberInfo;
//import com.spring.api.entity.TbMemberOnlineType;

public class LoginRequestInterceptor implements HandlerInterceptor {
	
//	@Resource
//	TbMemberOnlineTypeDao tbMemberOnlineTypeDao;
//	@Resource
//	TbMemberInfoDao tbMemberInfoDao;
//	@Resource
//	TbMemberAccountDao tbMemberAccountDao;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url=request.getServletPath();
		/*if("/vcode/get".equals(url)){
			if("1".equals(request.getParameter("type"))||"2".equals(request.getParameter("type"))){
				return true;
			}
		}
		String key=request.getParameter("requestCode");
		String result = "{\"code\":-1,\"message\":\"验证不通过，非法用户\"}";
		String resultStatusFreeze = "{\"code\":-1,\"message\":\"验证不通过，用户已被冻结\"}";
		String resultStatusDelete = "{\"code\":-1,\"message\":\"验证不通过，用户已被删除\"}";
		if(StringUtils.isEmpty(key)){
			response.setHeader("Content-type", "text/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return false;
		}
		if(!key.equals("-1")){
			TbMemberOnlineType tbMemberOnlineType=new TbMemberOnlineType();
			tbMemberOnlineType.setTmotCode(key);
			tbMemberOnlineType=tbMemberOnlineTypeDao.searchOne(tbMemberOnlineType);
			if(tbMemberOnlineType==null){
				response.setHeader("Content-type", "application/json;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(result);
				return false;
			}
			TbMemberInfo tbMemberInfo=tbMemberInfoDao.get(tbMemberOnlineType.getTmotMemberId());
			if(tbMemberInfo.getTmiType()==3){
				TbMemberAccount tbMemberAccount=new TbMemberAccount();
				tbMemberAccount.setTmaMemberId(tbMemberInfo.getTmiId());
				tbMemberAccount=tbMemberAccountDao.searchOne(tbMemberAccount);
				TbMemberInfo parentT=tbMemberInfoDao.get(tbMemberAccount.getTmaParentId());
				if(parentT.getTmiStatus()==0){
					response.setHeader("Content-type", "application/json;charset=UTF-8");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(resultStatusDelete);
					return false;
				}
				if(parentT.getTmiStatus()==2){
					response.setHeader("Content-type", "application/json;charset=UTF-8");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(resultStatusFreeze);
					return false;
				}
			}else{
				if(tbMemberInfo.getTmiStatus()==0){
					response.setHeader("Content-type", "application/json;charset=UTF-8");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(resultStatusDelete);
					return false;
				}
				if(tbMemberInfo.getTmiStatus()==2){
					response.setHeader("Content-type", "application/json;charset=UTF-8");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(resultStatusFreeze);
					return false;
				}
			}
			tbMemberInfo.setTmiLastIp(getIpAddr(request));
			tbMemberInfo.setTmiLastDate(new Timestamp(System.currentTimeMillis()));
			tbMemberInfoDao.update(tbMemberInfo);
			//验证通过更改请求时间
			tbMemberOnlineType.setTmotRequestTime(System.currentTimeMillis());
			tbMemberOnlineTypeDao.update(tbMemberOnlineType);
		}*/
		return true;
	}
	
	/**
	 * 获取ip地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request){  
        String ipAddress = request.getHeader("x-forwarded-for");  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
                ipAddress = request.getRemoteAddr();  
                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
                    //根据网卡取本机配置的IP  
                    InetAddress inet=null;  
                    try {  
                        inet = InetAddress.getLocalHost();  
                    } catch (UnknownHostException e) {  
                        e.printStackTrace();  
                    }  
                    ipAddress= inet.getHostAddress();  
                }  
            }  
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
                if(ipAddress.indexOf(",")>0){  
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
                }  
            }  
            return ipAddress;   
    }

}

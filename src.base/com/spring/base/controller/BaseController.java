package com.spring.base.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.JsTicket;
import com.jfinal.weixin.sdk.api.JsTicketApi;
import com.spring.base.utils.BaseLogger;
import com.spring.base.utils.HashUtil;

public class BaseController extends BaseLogger{
	
	public static int PAGE_SIZE = 10;
	public static String PREFIX = "";

	@Value("#{config['imgPath']}")
	public String imgPath="";
	
	@Value("#{config['base_url']}")
	public String baseUrl="";
	@Value("#{config['baiduAk']}")
	public String baiduAk="";
	@Value("#{config['base_url_wechat']}")
	public String baseUrlWechat = "";
	@ExceptionHandler
	public String exp(HttpServletRequest request,Exception e){
		e.printStackTrace();
		request.setAttribute("e", e);
		logger.error(e.getMessage(),e);
		return "/error";
	}

	/**
	 * 公共下载方法
	 * 
	 * @param response
	 * @param file
	 *            
	 * @param fileName
	 *            
	 * @return
	 * @throws Exception
	 */
	public HttpServletResponse downFile(HttpServletResponse response,
			File file, String fileName,boolean delFile) throws Exception {
		response.setContentType("application/x-download");
		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control",
				"must-revalidate, post-check=0, pre-check=0");
		OutputStream out = null;
		InputStream in = null;
		fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
		response.addHeader("Content-disposition", "attachment;filename="
				+ fileName);// 

		try {
			out = response.getOutputStream();
			in = new FileInputStream(file);
			int len = in.available();
			byte[] b = new byte[len];
			in.read(b);
			out.write(b);
			out.flush();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new Exception("!");
		} finally {
			if(in!=null){  
			   in.close(); 
			}
			if(out!=null){
			    out.close();
			}
			if(delFile){
				file.delete(); 
			}
		}
		return response;
	}
	public Map<String, Object> setMsgResult(Map<String, Object> result, Integer code, Object value){
		if (result == null){
			result = new HashMap<>();
		}

		result.put("code", code);
		result.put("message", value);
		return result;
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
	
//	 public void setWxConfigShare(HttpServletRequest request, String appId, String appSecret, String wxShareUrl) throws Exception {
//	        String _wxShareUrl = request.getHeader("Referer");
//	        logger.error("setWxConfigShare->");
//	        logger.error("appId->" + appId + "                appSecret->" + appSecret);
//	        logger.error("_wxShareUrl:" + _wxShareUrl);
//
//	        _wxShareUrl = wxShareUrl;
////			_wxShareUrl = URLEncoder.encode(wxShareUrl,"UTF-8");
//	        logger.error("_wxShareUrl:" + _wxShareUrl);
//	        ApiConfig ac = new ApiConfig();
//	        ac.setAppId(appId);
//	        ac.setAppSecret(appSecret);
//
//	        ApiConfigKit.setThreadLocalApiConfig(ac);
//	        String _wxJsapiTicket = "";
//	        try {
//	            JsTicket jsTicket = JsTicketApi.getTicket(JsTicketApi.JsApiType.jsapi);
//	            _wxJsapiTicket = jsTicket.getTicket();
//	        } finally {
//	            ApiConfigKit.removeThreadLocalApiConfig();
//	        }
//
//	        Map<String, String> _wxMap = new TreeMap<String, String>();
//	        //noncestr
//	        String _wxNoncestr = UUID.randomUUID().toString().replace("-", "");
//	        //timestamp
//	        String _wxTimestamp = (System.currentTimeMillis() / 1000) + "";
//
//	        //参数封装
//	        _wxMap.put("jsapi_ticket", _wxJsapiTicket);
//	        _wxMap.put("noncestr", _wxNoncestr);
//	        _wxMap.put("timestamp", _wxTimestamp);
//	        _wxMap.put("url", _wxShareUrl);
////			System.out.println("noncestr:"+_wxNoncestr+",timestamp:"+_wxTimestamp+",jsapi_ticket:"+_wxJsapiTicket+",url:"+_wxShareUrl);
//	        logger.error("noncestr:" + _wxNoncestr + ",timestamp:" + _wxTimestamp + ",jsapi_ticket:" + _wxJsapiTicket + ",url:" + _wxShareUrl);//收到的消息报记录到GSO文件
//	        logger.error(_wxMap.toString());
//	        // 加密获取signature
//	        StringBuilder _wxBaseString = new StringBuilder();
//	        for (Map.Entry<String, String> param : _wxMap.entrySet()) {
//	            _wxBaseString.append(param.getKey()).append("=").append(param.getValue()).append("&");
//	        }
//	        String _wxSignString = _wxBaseString.substring(0, _wxBaseString.length() - 1);
//	        // signature
//	        String _wxSignature = HashUtil.sha1(_wxSignString);
//	        System.out.println("_wxSignature:" + _wxSignature);
//	        _wxMap.put("appId", appId);
//	        _wxMap.put("wxSignature", _wxSignature);
//	        request.setAttribute("map", _wxMap);
//	    }
}

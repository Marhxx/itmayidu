package com.spring.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.spring.api.config.HttpUtilS;
import com.spring.api.service.ThirdpartyService;

/**
 * 第三方业务实现类
 * @author Administrator
 *
 */
@Service
public class ThirdpartyServiceImpl implements ThirdpartyService{

	
	public Logger logger = LoggerFactory.getLogger(ThirdpartyService.class);
	
	@Value("#{config['verificationPhoneKey']}")
	public String verificationPhoneKey="";
	
	@Override
	public boolean verificationPhone(String phone,String idcard,String realname) {
		Map<String,Object> httpDate=new HashMap<String,Object>();
		httpDate.put("key", verificationPhoneKey);
		httpDate.put("idcard", idcard);
		httpDate.put("mobile", phone);
		httpDate.put("realname", realname);
		String httpDateStr=HttpUtilS.buildPostDataString(httpDate);
		String rs = HttpUtilS.post("http://v.juhe.cn/telecom/query", httpDateStr, null);
		JSONObject xjsStr = JSONObject.parseObject(rs);
		logger.error("verificationPhone-----"+xjsStr.toString());
  		String successFlg=xjsStr.get("error_code").toString();
  		if(successFlg.equals("0")){
  			return true;
  		}else{
  			return false;
  		}
	}

	@Override
	public boolean verificationIdentityCard(String idcard, String realname) {
		Map<String,Object> httpDate=new HashMap<String,Object>();
		httpDate.put("key", "9c36398ad23f0dce8062d9a30b2accec");
		httpDate.put("idcard", idcard);
		httpDate.put("realname", realname);
		String httpDateStr=HttpUtilS.buildPostDataString(httpDate);
		String rs = HttpUtilS.post("http://op.juhe.cn/idcard/query", httpDateStr, null);
		JSONObject xjsStr = JSONObject.parseObject(rs);
		logger.error("verificationIdentityCard-----"+xjsStr.toString());
  		String successFlg=xjsStr.get("error_code").toString();
  		if(successFlg.equals("0")){
  			return true;
  		}else{
  			return false;
  		}
	}

	@Override
	public boolean verificationBankcard(String bankcard, String realname) {
		Map<String,Object> httpDate=new HashMap<String,Object>();
		httpDate.put("key", "aeb23293139662c02f2023ff8de73677");
		httpDate.put("bankcard", bankcard);
		httpDate.put("realname", realname);
		String httpDateStr=HttpUtilS.buildPostDataString(httpDate);
		String rs = HttpUtilS.post("http://v.juhe.cn/verifybankcard/query", httpDateStr, null);
		JSONObject xjsStr = JSONObject.parseObject(rs);
		logger.error("verificationBankcard-----"+xjsStr.toString());
  		String successFlg=xjsStr.get("error_code").toString();
  		JSONObject result=JSONObject.parseObject(xjsStr.get("result").toString());
  		String res = result.get("res").toString();
  		if(successFlg.equals("0") && res.equals("1")){//1表示匹配
  			return true;
  		}else{
  			return false;
  		}
	}
	
	
	
}

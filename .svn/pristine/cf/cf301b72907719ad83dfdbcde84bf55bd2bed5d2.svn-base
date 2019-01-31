/*package com.spring.common.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.spring.api.entity.TbMemberInfo;
import com.spring.api.service.TbMemberInfoService;
import com.spring.base.controller.BaseController;
import com.spring.base.utils.StringUtil;
import com.spring.common.entity.TbVcode;
import com.spring.common.service.TbVcodeService;

*//**
 * 
 * 短信验证码
 * 2017年3月18日上午11:31:31
 * @author lcx
 *
 *//*
@Controller
@RequestMapping(value="/vcode")
public class TbVcodeController extends BaseController {

	@Autowired
	TbVcodeService tbVcodeService;
	@Autowired
	TbMemberInfoService tbMemberInfoService;
	
	*//**
	 * 
	* @Title: vcode 
	* @Description:  生成验证码  有效期1分钟 
	* @param @param phone
	* @param @param type
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 *//*
	@ResponseBody
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public  Map<String, Object> getVcode(String phone,String type){//类型: 1：注册 2：忘记密码 登录 3：更换手机号
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isEmptyNull(phone)){
			map.put("code", 102);
			map.put("message", "参数提交不完整");
			return map;
		}
		TbVcode tbVcode = new  TbVcode();
		tbVcode.setTvPhone(phone);
		tbVcode = tbVcodeService.searchOne(tbVcode);
		if (tbVcode != null) {
			Long firsttime = System.currentTimeMillis();
			String string = firsttime.toString();
			firsttime = Long.valueOf(firsttime.toString().substring(0, string.length()-3)+"000");
			long compareTime  = firsttime -tbVcode.getTvAddDate().getTime();
			if (compareTime/1000 < 60) {
				map.put("code", 106);
				map.put("message", "获取验证码的时间间隔不能小于60秒");
				return map;
			}
		}
		TbMemberInfo tbCustomers = tbMemberInfoService.findByPhoneAndTmiStatus(phone);//根据手机号码查询用户
		//参数验证
		if(!StringUtil.checkMobile(phone)){
			map.put("code", -1);
			map.put("message", "验证不通过");
			return map;
		}
		if(!"1".equals(type)&&!"2".equals(type)&&!"3".equals(type)){
			map.put("code", -1);
			map.put("message", "验证不通过");
			return map;
		}
		if("1".equals(type)||"3".equals(type)){
			//判断该手机号是否已经注册
			if(null != tbCustomers){
				map.put("code", 103);
				map.put("message", "账号已被注册");
				return map;
			}
		}else if("2".equals(type)){
			//判断该手机号是否已经注册
			if(null == tbCustomers){
				map.put("code", 104);
				map.put("message", "账号未注册");
				return map;
			}
		}
		
		String code = StringUtil.getRandomForLen(5);//随机获取5位验证码
				
		//保存验证码.先验证该手机号是否已经获取验证码，有则修改，无则新增
		try {
			tbVcodeService.saveOrUpdate(phone, code+"",type);
			map.put("code", 100);
			map.put("message", "获取成功");
			
			*//**
			 * 发送短信
			 *//*
			
			map.put("vcode", code);
			return map;
		} catch (Exception e) {
			logger.error("[TbVcodeController --> getVcode]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", -101);
			map.put("message", "获取失败");
			return map;
		}
		
	}
	*//**
	 * 验证码验证
	 * @param phone 手机号
	 * @param vcode 验证码
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public Map<String, Object> check(String phone,String vcode){
		Map<String, Object> map = new HashMap<String, Object>();
		//参数验证
		if(StringUtil.isEmptyNull(phone)){
//			setResultMsg(map,102,"手机号不能为空");
			map.put("code", 102);
			map.put("message", "手机号不能为空");
			return map;
		}
		if(StringUtil.isEmptyNull(vcode)){
//			setResultMsg(map,103,"验证码不能为空");
			map.put("code", 103);
			map.put("message", "验证码不能为空");
			return map;
		}
		try {
			//短信验证码验证
			int err = tbVcodeService.checkCode(phone, vcode, "900");
			if (err == 0) {
//				setResultMsg(map,105,"验证码已过期");
				map.put("code", 205);
				map.put("message", "验证码已过期");
				return map;
			} else if (err == -1) {
//				setResultMsg(map,104,"验证码错误");
				map.put("code", 204);
				map.put("message", "验证码错误");
				return map;
			}
//			setResultMsg(map,100,"验证码正确");
			map.put("code", 100);
			map.put("message", "验证码正确");
			return map;
		} catch (Exception e) {
			logger.error("[TbVcodeController --> getVcode]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
//			setResultMsg(map,-101,"操作失败");
			map.put("code", -101);
			map.put("message", "操作失败");
			return map;
		}
	}
}
*/
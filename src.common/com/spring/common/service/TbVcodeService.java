package com.spring.common.service;

import com.spring.base.service.BaseService;
import com.spring.common.entity.TbVcode;


public interface TbVcodeService extends BaseService<TbVcode, Long>{

	void saveOrUpdate(String mobile, String code,String type);
	
	/**
	 * 
	* @Title: checkCode 
	* @Description: 验证通过返回1  过期返回0  错误返回-1 
	* @param @param mobile
	* @param @param captcha
	* @param time 验证码有效时间
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	int checkCode(String mobile, String captcha, String time);
	
}

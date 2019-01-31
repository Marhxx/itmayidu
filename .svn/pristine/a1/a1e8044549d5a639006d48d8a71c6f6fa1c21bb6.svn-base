package com.spring.api.service;



/**
 * 第三方业务接口
 * @author Administrator
 *
 */
public interface ThirdpartyService {
	
	/**
	 * 验证手机号码是否存在(调用聚合第三方验证)
	 * @param phone					手机号
	 * @param idcard				身份证号
	 * @param realname				真实姓名
	 * @return
	 */
	boolean  verificationPhone(String phone,String idcard,String realname);
	/**
	 * 验证身份证是否存在(调用聚合第三方验证)
	 * @param idcard				身份证号
	 * @param realname				真实姓名
	 * @return
	 */
	boolean  verificationIdentityCard(String idcard,String realname);
	/**
	 * 验证银行卡是否存在(调用聚合第三方验证)
	 * @param bankcard			          银行卡号
	 * @param realname				真实姓名
	 * @return
	 */
	boolean  verificationBankcard(String bankcard,String realname);
	

}

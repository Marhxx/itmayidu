package com.spring.common.entity;

import java.io.Serializable;
/**
 * 用于短信需要上传数据
 * 2016年11月11日下午10:22:33
 * @author lcx
 *
 */
public class SmsEntity implements Serializable{
	private String mobile;//售价号
	private String content;//内容
	private String name;//用户名称
//	private String 
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContent() {
		return content;
	}
	public void setContext(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SmsEntity(String mobile, String content, String name) {
		super();
		this.mobile = mobile;
		this.content = content;
		this.name = name;
	}
	public SmsEntity() {
		super();
	}
	
}

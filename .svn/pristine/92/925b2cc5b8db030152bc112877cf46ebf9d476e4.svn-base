package com.spring.common.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
   /**
    * tb_vcode 实体类
    * Sat Mar 18 11:03:28 CST 2017 lcx
    */ 
@Entity
@Table(name = "tb_vcode")
public class TbVcode implements java.io.Serializable {
	private Long tvId;
	private String tvPhone;//手机号码
	private String tvCode;//验证码
	private Integer tvType;//类型
	private Timestamp tvAddDate;//创建时间
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tv_id", unique = true, nullable = false)
	public Long getTvId() {
		return tvId;
	}
	public void setTvId(Long tvId) {
		this.tvId = tvId;
	}
	@Column(name = "tv_phone")
	public String getTvPhone() {
		return tvPhone;
	}
	public void setTvPhone(String tvPhone) {
		this.tvPhone = tvPhone;
	}
	@Column(name = "tv_code")
	public String getTvCode() {
		return tvCode;
	}
	public void setTvCode(String tvCode) {
		this.tvCode = tvCode;
	}
	@Column(name = "tv_type")
	public Integer getTvType() {
		return tvType;
	}
	public void setTvType(Integer tvType) {
		this.tvType = tvType;
	}
	@Column(name = "tv_add_date")
	public Timestamp getTvAddDate() {
		return tvAddDate;
	}
	public void setTvAddDate(Timestamp tvAddDate) {
		this.tvAddDate = tvAddDate;
	}
	public TbVcode(Long tvId, String tvPhone, String tvCode, Integer tvType,
			Timestamp tvAddDate) {
		super();
		this.tvId = tvId;
		this.tvPhone = tvPhone;
		this.tvCode = tvCode;
		this.tvType = tvType;
		this.tvAddDate = tvAddDate;
	}
	public TbVcode() {
		super();
	}
	
	
}


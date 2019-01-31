package com.spring.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChinaCity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "china_city")
public class ChinaCity implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cname;
	private Integer pid;
	private String pfl;//'城市首个拼音大写字母(用于排序）

	// Constructors

	/** default constructor */
	public ChinaCity() {
	}

	/** full constructor */
	public ChinaCity(String cname, Integer pid, String pfl) {
		super();
		this.cname = cname;
		this.pid = pid;
		this.pfl = pfl;
	}
	
	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "cname", length = 100)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "pid")
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	@Column(name = "pfl")
	public String getPfl() {
		return pfl;
	}

	public void setPfl(String pfl) {
		this.pfl = pfl;
	}

}
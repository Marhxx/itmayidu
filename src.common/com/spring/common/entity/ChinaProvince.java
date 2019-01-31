package com.spring.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChinaProvince entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "china_province")
public class ChinaProvince implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String pname;
	private String pfl;//首字母

	// Constructors

	/** default constructor */
	public ChinaProvince() {
	}
	public ChinaProvince(String pname, String pfl) {
		super();
		this.pname = pname;
		this.pfl = pfl;
	}

	/** full constructor */

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "pid", unique = true, nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "pname", length = 100)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Column(name = "pname", length = 4)
	public String getPfl() {
		return pfl;
	}

	public void setPfl(String pfl) {
		this.pfl = pfl;
	}

}
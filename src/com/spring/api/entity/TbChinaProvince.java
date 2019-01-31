package com.spring.api.entity;

import static javax.persistence.GenerationType.IDENTITY;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

/**
 * 省控制器
 *
 * @author LiaoJinKe
 * @Date 2018-07-04 16:41:12
 */
@Entity
@Table(name = "china_province")
public class TbChinaProvince implements java.io.Serializable {
	
	// Fields
	
	private Long pid;
	private String pname;
	private String pfl;
	
	// Constructors

	/** default constructor */
	public TbChinaProvince() {
	}
	
	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pid", unique = true, nullable = false, length=19)
	public Long getPid() {
		return this.pid;
	}
	
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	@Column(name = "pname",  nullable = false, length=100)
	public String getPname() {
		return this.pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Column(name = "pfl",  nullable = false, length=4)
	public String getPfl() {
		return this.pfl;
	}
	
	public void setPfl(String pfl) {
		this.pfl = pfl;
	}
	
	
}
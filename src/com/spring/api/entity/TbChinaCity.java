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
 * 区控制器
 *
 * @author LiaoJinKe
 * @Date 2018-07-04 16:40:33
 */
@Entity
@Table(name = "china_city")
public class TbChinaCity implements java.io.Serializable {
	
	// Fields
	
	private Long cid;
	private String cname;
	//城市首个拼音大写字母(用于排序）
	private String pfl;
	private Integer pid;
	
	// Constructors

	/** default constructor */
	public TbChinaCity() {
	}
	
	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cid", unique = true, nullable = false, length=19)
	public Long getCid() {
		return this.cid;
	}
	
	public void setCid(Long cid) {
		this.cid = cid;
	}
	
	@Column(name = "cname",  nullable = false, length=100)
	public String getCname() {
		return this.cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Column(name = "pfl",  nullable = false, length=4)
	public String getPfl() {
		return this.pfl;
	}
	
	public void setPfl(String pfl) {
		this.pfl = pfl;
	}
	
	@Column(name = "pid",  nullable = false, length=10)
	public Integer getPid() {
		return this.pid;
	}
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	
}
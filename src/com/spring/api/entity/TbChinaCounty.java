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
 * @Date 2018-07-04 15:59:12
 */
@Entity
@Table(name = "china_county")
public class TbChinaCounty implements java.io.Serializable {
	
	// Fields
	
	private Long oid;
	private String oname;
	private Integer cid;
	
	// Constructors

	/** default constructor */
	public TbChinaCounty() {
	}
	
	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "oid", unique = true, nullable = false, length=19)
	public Long getOid() {
		return this.oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	@Column(name = "oname",  nullable = false, length=100)
	public String getOname() {
		return this.oname;
	}
	
	public void setOname(String oname) {
		this.oname = oname;
	}
	
	@Column(name = "cid",  nullable = false, length=10)
	public Integer getCid() {
		return this.cid;
	}
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	
}
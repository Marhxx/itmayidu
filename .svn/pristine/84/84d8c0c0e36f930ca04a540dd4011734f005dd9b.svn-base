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
 * 控制器
 *
 * @author maoannan
 * @Date 2018-04-23 16:42:13
 */
@Entity
@Table(name = "tb_function_info")
public class TbFunctionInfo implements java.io.Serializable {
	
	// Fields
	
	//序列号
	private Long tfiId;
	//函数名称
	private String tfiName;
	//函数
	private String tfiFunction;
	//描述
	private String tfiDesp;
	//添加人
	private Long tfiAddPerson;
	//添加时间now()
	private Timestamp tfiAddDate;
	//状态1:正常0: 删除
	private Integer tfiStatus;
	//1: 光谱数据2:时间域数据3:二位成像数
	private Integer tfiType;
	
	// Constructors

	/** default constructor */
	public TbFunctionInfo() {
	}
	
	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tfi_id", unique = true, nullable = false, length=19)
	public Long getTfiId() {
		return this.tfiId;
	}
	
	public void setTfiId(Long tfiId) {
		this.tfiId = tfiId;
	}
	
	@Column(name = "tfi_name",  nullable = false, length=20)
	public String getTfiName() {
		return this.tfiName;
	}
	
	public void setTfiName(String tfiName) {
		this.tfiName = tfiName;
	}
	
	@Column(name = "tfi_function",  nullable = false, length=256)
	public String getTfiFunction() {
		return this.tfiFunction;
	}
	
	public void setTfiFunction(String tfiFunction) {
		this.tfiFunction = tfiFunction;
	}
	
	@Column(name = "tfi_desp",  nullable = false, length=256)
	public String getTfiDesp() {
		return this.tfiDesp;
	}
	
	public void setTfiDesp(String tfiDesp) {
		this.tfiDesp = tfiDesp;
	}
	
	@Column(name = "tfi_add_person",  nullable = false, length=19)
	public Long getTfiAddPerson() {
		return this.tfiAddPerson;
	}
	
	public void setTfiAddPerson(Long tfiAddPerson) {
		this.tfiAddPerson = tfiAddPerson;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	@Column(name = "tfi_add_date",  nullable = false, length=19)
	public Timestamp getTfiAddDate() {
		return this.tfiAddDate;
	}
	
	public void setTfiAddDate(Timestamp tfiAddDate) {
		this.tfiAddDate = tfiAddDate;
	}
	
	@Column(name = "tfi_status",  nullable = false, length=10)
	public Integer getTfiStatus() {
		return this.tfiStatus;
	}
	
	public void setTfiStatus(Integer tfiStatus) {
		this.tfiStatus = tfiStatus;
	}
	
	@Column(name = "tfi_type",  nullable = false, length=10)
	public Integer getTfiType() {
		return this.tfiType;
	}
	
	public void setTfiType(Integer tfiType) {
		this.tfiType = tfiType;
	}
	
	
}
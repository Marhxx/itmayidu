package com.spring.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;

/**
 * 
 * @author JoeyChen
 * @date 2018年8月3日 
 *
 */
@Entity
@Table(name="tb_information_cata")
public class TbInformationCata implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ticId;

	private Date ticAddDate;

	private String ticName;

	private Integer ticOrder;

	private Long ticParentId;

	private Integer ticStatus;

	public TbInformationCata() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tic_id")
	public String getTicId() {
		return this.ticId;
	}

	public void setTicId(String ticId) {
		this.ticId = ticId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tic_add_date")
	public Date getTicAddDate() {
		return this.ticAddDate;
	}

	public void setTicAddDate(Date ticAddDate) {
		this.ticAddDate = ticAddDate;
	}
	
	@Column(name="tic_name")
	public String getTicName() {
		return this.ticName;
	}

	public void setTicName(String ticName) {
		this.ticName = ticName;
	}

	@Column(name="tic_order")
	public Integer getTicOrder() {
		return this.ticOrder;
	}

	public void setTicOrder(Integer ticOrder) {
		this.ticOrder = ticOrder;
	}

	@Column(name="tic_parent_id")
	public Long getTicParentId() {
		return this.ticParentId;
	}

	public void setTicParentId(Long ticParentId) {
		this.ticParentId = ticParentId;
	}

	@Column(name="tic_status")
	public Integer getTicStatus() {
		return this.ticStatus;
	}

	public void setTicStatus(Integer ticStatus) {
		this.ticStatus = ticStatus;
	}

}
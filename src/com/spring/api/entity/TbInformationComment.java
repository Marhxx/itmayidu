package com.spring.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;

/**
 * 
 * @author JoeyChen
 * @date 2018年8月20日 
 *
 */
@Entity
@Table(name="tb_information_comment")
public class TbInformationComment implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ticId;
	private Date ticAddDate;
	private String ticContent;
	private Long ticInforId;
	private Long ticMemberId;
	private Long ticParentId;
	private Integer ticStatus;
	private String ticSnap;

	public TbInformationComment() {
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


	@Column(name="tic_content")
	public String getTicContent() {
		return this.ticContent;
	}

	public void setTicContent(String ticContent) {
		this.ticContent = ticContent;
	}


	@Column(name="tic_infor_id")
	public Long getTicInforId() {
		return this.ticInforId;
	}

	public void setTicInforId(Long ticInforId) {
		this.ticInforId = ticInforId;
	}


	@Column(name="tic_member_id")
	public Long getTicMemberId() {
		return this.ticMemberId;
	}

	public void setTicMemberId(Long ticMemberId) {
		this.ticMemberId = ticMemberId;
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

	@Column(name="tic_snap")
	public String getTicSnap() {
		return ticSnap;
	}


	public void setTicSnap(String ticSnap) {
		this.ticSnap = ticSnap;
	}
	
}
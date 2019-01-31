package com.spring.common.entity;

import javax.persistence.*;
import java.sql.*;

/**
 * tb_message 实体类
 * Wed Dec 27 09:21:48 CST 2017 lcx
 */


@Entity
@Table(name = "tb_message")
public class TbMessage implements java.io.Serializable {
	private Long tmId;
	private Long tmMemberId;
	private String tmTitle;
	private String tmContent;
	private Timestamp tmAddtime;
	private Integer tmStatus;
	private Long tmAddperson;
	private String tmNumber;
	private Integer tmType;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tm_id", unique = true, nullable = false)
	public Long getTmId() {
		return tmId;
	}

	public void setTmId(Long tmId) {
		this.tmId = tmId;
	}

	@Column(name = "tm_member_id")
	public Long getTmMemberId() {
		return tmMemberId;
	}

	public void setTmMemberId(Long tmMemberId) {
		this.tmMemberId = tmMemberId;
	}

	@Column(name = "tm_title")
	public String getTmTitle() {
		return tmTitle;
	}

	public void setTmTitle(String tmTitle) {
		this.tmTitle = tmTitle;
	}

	@Column(name = "tm_content")
	public String getTmContent() {
		return tmContent;
	}

	public void setTmContent(String tmContent) {
		this.tmContent = tmContent;
	}

	@Column(name = "tm_addtime")
	public Timestamp getTmAddtime() {
		return tmAddtime;
	}

	public void setTmAddtime(Timestamp tmAddtime) {
		this.tmAddtime = tmAddtime;
	}

	@Column(name = "tm_status")
	public Integer getTmStatus() {
		return tmStatus;
	}

	public void setTmStatus(Integer tmStatus) {
		this.tmStatus = tmStatus;
	}

	@Column(name = "tm_addperson")
	public Long getTmAddperson() {
		return tmAddperson;
	}

	public void setTmAddperson(Long tmAddperson) {
		this.tmAddperson = tmAddperson;
	}

	@Column(name = "tm_number")
	public String getTmNumber() {
		return tmNumber;
	}

	public void setTmNumber(String tmNumber) {
		this.tmNumber = tmNumber;
	}

	@Column(name = "tm_type")
	public Integer getTmType() {
		return tmType;
	}

	public void setTmType(Integer tmType) {
		this.tmType = tmType;
	}

	public TbMessage() {
	}

	public TbMessage(Long tmId, Long tmMemberId, String tmTitle, String tmContent, Timestamp tmAddtime, Integer tmStatus, Long tmAddperson, String tmNumber, Integer tmType) {
		this.tmId = tmId;
		this.tmMemberId = tmMemberId;
		this.tmTitle = tmTitle;
		this.tmContent = tmContent;
		this.tmAddtime = tmAddtime;
		this.tmStatus = tmStatus;
		this.tmAddperson = tmAddperson;
		this.tmNumber = tmNumber;
		this.tmType = tmType;
	}
}


package com.spring.common.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbInformation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_information", catalog = "xiaomianao")
public class TbInformation implements java.io.Serializable {

	// Fields

	private Long tiId;//id
	private Long tiCataId;//分类id
	private String tiTitle;//资讯标题
	private String tiContent;//资讯内容
	private String tiPhoto;//图片
	private String tiAddPreson;//创建人
	private Timestamp tiAddDate;//创建时间
	private Integer tiStatus;//状态 , 0：删除 1：正常
	private Integer tiViewCount;//'浏览量',
	private String tiKeywords;//'关键字 逗号分隔',
	private String tiDetailPhoto;//'案例详情图',
	private String tiLianjie;// '视频连接',
	private Integer tiPaixu;//
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ti_id", unique = true, nullable = false)
	public Long getTiId() {
		return this.tiId;
	}

	public void setTiId(Long tiId) {
		this.tiId = tiId;
	}

	@Column(name = "ti_cata_id", nullable = false)
	public Long getTiCataId() {
		return this.tiCataId;
	}

	public void setTiCataId(Long tiCataId) {
		this.tiCataId = tiCataId;
	}

	@Column(name = "ti_title", nullable = false, length = 50)
	public String getTiTitle() {
		return this.tiTitle;
	}

	public void setTiTitle(String tiTitle) {
		this.tiTitle = tiTitle;
	}

	@Column(name = "ti_content", nullable = false, length = 65535)
	public String getTiContent() {
		return this.tiContent;
	}

	public void setTiContent(String tiContent) {
		this.tiContent = tiContent;
	}

	@Column(name = "ti_add_date", nullable = false, length = 19)
	public Timestamp getTiAddDate() {
		return this.tiAddDate;
	}

	public void setTiAddDate(Timestamp tiAddDate) {
		this.tiAddDate = tiAddDate;
	}

	@Column(name = "ti_status", nullable = false)
	public Integer getTiStatus() {
		return this.tiStatus;
	}

	public void setTiStatus(Integer tiStatus) {
		this.tiStatus = tiStatus;
	}
	@Column(name = "ti_add_preson")
	public String getTiAddPreson() {
		return tiAddPreson;
	}

	public void setTiAddPreson(String tiAddPreson) {
		this.tiAddPreson = tiAddPreson;
	}
	@Column(name = "ti_photo")
	public String getTiPhoto() {
		return tiPhoto;
	}

	public void setTiPhoto(String tiPhoto) {
		this.tiPhoto = tiPhoto;
	}
	@Column(name = "ti_view_count")
	public Integer getTiViewCount() {
		return tiViewCount;
	}

	public void setTiViewCount(Integer tiViewCount) {
		this.tiViewCount = tiViewCount;
	}
	@Column(name = "ti_keywords")
	public String getTiKeywords() {
		return tiKeywords;
	}

	public void setTiKeywords(String tiKeywords) {
		this.tiKeywords = tiKeywords;
	}
	@Column(name = "ti_detail_photo")
	public String getTiDetailPhoto() {
		return tiDetailPhoto;
	}

	public void setTiDetailPhoto(String tiDetailPhoto) {
		this.tiDetailPhoto = tiDetailPhoto;
	}
	@Column(name = "ti_lianjie")
	public String getTiLianjie() {
		return tiLianjie;
	}

	public void setTiLianjie(String tiLianjie) {
		this.tiLianjie = tiLianjie;
	}
	@Column(name = "ti_paixu")
	public Integer getTiPaixu() {
		return tiPaixu;
	}

	public void setTiPaixu(Integer tiPaixu) {
		this.tiPaixu = tiPaixu;
	}


	public TbInformation(Long tiId, Long tiCataId, String tiTitle, String tiContent, String tiPhoto, String tiAddPreson,
			Timestamp tiAddDate, Integer tiStatus, Integer tiViewCount, String tiKeywords, String tiDetailPhoto,
			String tiLianjie, Integer tiPaixu) {
		super();
		this.tiId = tiId;
		this.tiCataId = tiCataId;
		this.tiTitle = tiTitle;
		this.tiContent = tiContent;
		this.tiPhoto = tiPhoto;
		this.tiAddPreson = tiAddPreson;
		this.tiAddDate = tiAddDate;
		this.tiStatus = tiStatus;
		this.tiViewCount = tiViewCount;
		this.tiKeywords = tiKeywords;
		this.tiDetailPhoto = tiDetailPhoto;
		this.tiLianjie = tiLianjie;
		this.tiPaixu = tiPaixu;
	}

	public TbInformation() {
		super();
	}


}
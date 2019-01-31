package com.spring.api.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * 
 * @author JoeyChen
 * @date 2018年8月2日 
 *
 */
@Entity
@Table(name="tb_information")
public class TbInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long tiId;

	private Date tiAddDate;

	private Long tiCataId;

	private String tiContent;

	private String tiIcon;

	private String tiKeywords;

	private Long tiPartion;

	private String tiRoute;

	private Integer tiStatus;

	private String tiTitle;

	private Integer tiViewCount;
	
	private Integer tiIsTop;

	public TbInformation() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ti_id", unique = true, nullable = false, length=8)
	public Long getTiId() {
		return this.tiId;
	}

	public void setTiId(Long tiId) {
		this.tiId = tiId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ti_add_date")
	public Date getTiAddDate() {
		return this.tiAddDate;
	}

	public void setTiAddDate(Date tiAddDate) {
		this.tiAddDate = tiAddDate;
	}

	@Column(name="ti_cata_id")
	public Long getTiCataId() {
		return this.tiCataId;
	}

	public void setTiCataId(Long tiCataId) {
		this.tiCataId = tiCataId;
	}

	@Lob
	@Column(name="ti_content")
	public String getTiContent() {
		return this.tiContent;
	}

	public void setTiContent(String tiContent) {
		this.tiContent = tiContent;
	}

	@Column(name="ti_icon")
	public String getTiIcon() {
		return this.tiIcon;
	}

	public void setTiIcon(String tiIcon) {
		this.tiIcon = tiIcon;
	}

	@Column(name="ti_keywords")
	public String getTiKeywords() {
		return this.tiKeywords;
	}

	public void setTiKeywords(String tiKeywords) {
		this.tiKeywords = tiKeywords;
	}

	@Column(name="ti_partion")
	public Long getTiPartion() {
		return this.tiPartion;
	}

	public void setTiPartion(Long tiPartion) {
		this.tiPartion = tiPartion;
	}

	@Column(name="ti_route")
	public String getTiRoute() {
		return this.tiRoute;
	}

	public void setTiRoute(String tiRoute) {
		this.tiRoute = tiRoute;
	}

	@Column(name="ti_status")
	public Integer getTiStatus() {
		return this.tiStatus;
	}

	public void setTiStatus(Integer tiStatus) {
		this.tiStatus = tiStatus;
	}

	@Column(name="ti_title")
	public String getTiTitle() {
		return this.tiTitle;
	}

	public void setTiTitle(String tiTitle) {
		this.tiTitle = tiTitle;
	}

	@Column(name="ti_view_count")
	public Integer getTiViewCount() {
		return this.tiViewCount;
	}

	public void setTiViewCount(Integer tiViewCount) {
		this.tiViewCount = tiViewCount;
	}
	
	@Column(name="ti_is_top")
	public Integer getTiIsTop() {
		return this.tiIsTop;
	}

	public void setTiIsTop(Integer tiIsTop) {
		this.tiIsTop = tiIsTop;
	}

}
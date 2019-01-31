package com.spring.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用戶信息
 * 
 * @author HXX
 *
 */
@Entity
@Table(name = "tb_star")
public class Tbstar {
	private int ts_id;
	private String ts_user_name;
	private String ts_type;
	private String ts_photo;
	private String ts_addtime;
	private int ts_status;
	private String ts_adduser;
	private String ts_desc;
	private String ts_content;

	public Tbstar() {

	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ts_id")
	public int getTs_id() {
		return ts_id;
	}

	public void setTs_id(int ts_id) {
		this.ts_id = ts_id;
	}

	public String getTs_user_name() {
		return ts_user_name;
	}

	public void setTs_user_name(String ts_user_name) {
		this.ts_user_name = ts_user_name;
	}

	public String getTs_type() {
		return ts_type;
	}

	public void setTs_type(String ts_type) {
		this.ts_type = ts_type;
	}

	public String getTs_photo() {
		return ts_photo;
	}

	public void setTs_photo(String ts_photo) {
		this.ts_photo = ts_photo;
	}

	public String getTs_addtime() {
		return ts_addtime;
	}

	public void setTs_addtime(String ts_addtime) {
		this.ts_addtime = ts_addtime;
	}

	public int getTs_status() {
		return ts_status;
	}

	public void setTs_status(int ts_status) {
		this.ts_status = ts_status;
	}

	public String getTs_adduser() {
		return ts_adduser;
	}

	public void setTs_adduser(String ts_adduser) {
		this.ts_adduser = ts_adduser;
	}

	public String getTs_desc() {
		return ts_desc;
	}

	public void setTs_desc(String ts_desc) {
		this.ts_desc = ts_desc;
	}

	public String getTs_content() {
		return ts_content;
	}

	public void setTs_content(String ts_content) {
		this.ts_content = ts_content;
	}

	@Override
	public String toString() {
		return "Tbstar [ts_id=" + ts_id + ", ts_user_name=" + ts_user_name + ", ts_type=" + ts_type + ", ts_photo="
				+ ts_photo + ", ts_addtime=" + ts_addtime + ", ts_status=" + ts_status + ", ts_adduser=" + ts_adduser
				+ ", ts_desc=" + ts_desc + ", ts_content=" + ts_content + "]";
	}

}

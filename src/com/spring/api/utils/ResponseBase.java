package com.spring.api.utils;

import java.util.List;
import java.util.Map;

public class ResponseBase {

	private Integer rtnCode;
	private String msg;
	private Object data;
	private List<Map<String, Object>> map;

	public final Integer getRtnCode() {
		return rtnCode;
	}

	public final void setRtnCode(Integer rtnCode) {
		this.rtnCode = rtnCode;
	}

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}

	public final Object getData() {
		return data;
	}

	public final void setData(Object data) {
		this.data = data;
	}

	public final List<Map<String, Object>> getMap() {
		return map;
	}

	public final void setMap(List<Map<String, Object>> map) {
		this.map = map;
	}

	public ResponseBase(Integer rtnCode, String msg, Object data) {
		super();
		this.rtnCode = rtnCode;
		this.msg = msg;
		this.data = data;
	}

	
	public ResponseBase(Integer rtnCode, String msg, List<Map<String, Object>> map) {
		super();
		this.rtnCode = rtnCode;
		this.msg = msg;
		this.map = map;
	}

	public ResponseBase() {
		super();
	}

	@Override
	public String toString() {
		return "ResponseBase [rtnCode=" + rtnCode + ", msg=" + msg + ", data=" + data + ", map=" + map + "]";
	}

}

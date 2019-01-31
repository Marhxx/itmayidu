package com.spring.api.utils;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class BaseApiService {

	// 返回错误，可以传msg
	public ResponseBase setResultError(String msg) {
		return setResult(Constants.HTTP_RES_CODE_500, msg, null);
	}
	// 返回错误，可以传msg
	public ResponseBase setResultError(String code,String msg) {
		return setResult(Constants.HTTP_RES_CODE_500, msg, code);
	}

	// 返回成功，可以传data值
	public ResponseBase setResultSuccess(Object data) {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
	}

	// 返回成功，沒有data值
	public ResponseBase setResultSuccess() {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
	}

	// 返回成功，沒有data值
	public ResponseBase setResultSuccess(String msg) {
		return setResult(Constants.HTTP_RES_CODE_200, msg, null);
	}

	// 通用封装
	public ResponseBase setResult(Integer code, String msg, Object data) {
		return new ResponseBase(code, msg, data);
	}

	
	// 返回成功，可以传map值
		public ResponseBase setMapResultSuccess(List<Map<String,Object>> map) {
			return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, map);
		}
	
	// List<Map<String,Object>> map格式的
	public ResponseBase setMapResult(Integer code, String msg, List<Map<String,Object>> map) {
		return new ResponseBase(code, msg, map);
	}
}

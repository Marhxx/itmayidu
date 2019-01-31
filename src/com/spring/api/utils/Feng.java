package com.spring.api.utils;

public class Feng {

	/**
	 * 实列
	 * 
	 * @param rtnCode
	 * @param msg
	 * @return
	 */
	ResponseBase setErrorResult(Integer rtnCode, String msg) {
		ResponseBase base = new ResponseBase();
		base.setRtnCode(Constants.HTTP_RES_CODE_500);
		return base;

	}

	// 错误 代号 消息
	ResponseBase setErrorCodeMsg(String msg) {
		return setResult(Constants.HTTP_RES_CODE_500, msg, null);

	}

	// 错误 代号 消息 可以穿两个
	ResponseBase setErrorCodeMsg2(Integer rtnCode, String msg) {
		return setResult(rtnCode, msg, null);

	}

	ResponseBase setSuccessCodeMsg(Integer rtnCode, String msg) {
		return setResult(Constants.HTTP_RES_CODE_200, msg, null);

	}

	ResponseBase setSuccessMsg(String msg) {
		return setResult(Constants.HTTP_RES_CODE_200, msg, null);

	}

	ResponseBase setSuccessCodeMsgData(String msg, Object data) {
		return setResult(Constants.HTTP_RES_CODE_200, msg, data);

	}

	ResponseBase setSuccessCodeMsgData3(Integer rtnCode, String msg, Object data) {
		return setResult(rtnCode, msg, data);

	}

	// 通用的工具类
	ResponseBase setResult(Integer rtnCode, String msg, Object data) {
		ResponseBase base = new ResponseBase(rtnCode, msg, data);
		return base;

	}

}

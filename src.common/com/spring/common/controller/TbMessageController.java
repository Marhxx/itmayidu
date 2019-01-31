/*package com.spring.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.api.entity.TbMemberInfo;
import com.spring.api.service.TbMemberInfoService;
import com.spring.base.controller.BaseController;
import com.spring.base.utils.StringUtil;
import com.spring.common.entity.TbMessage;
import com.spring.common.service.TbMessageService;

*//**
 * 
*    
* 项目名称：DdzbBackstage   
* 类名称：MessageController   
* 类描述：   消息管理控制类
* 创建人：limeng  
* 创建时间：2014年12月5日 下午2:15:38   
* @version    
*
 *//*
@Controller
@RequestMapping(value = "/message")
public class TbMessageController extends BaseController {
	@Resource
	TbMessageService tbMessageService;
	
	@Resource
	TbMemberInfoService tbMemberInfoService;
	*//**
	 * 
	* @Title: findMessage 
	* @Description:  根据接收人id和接收人类型分页查询消息列表
	* @param @param tmId
	* @param @param type
	* @param @param page
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 *//*
	@ResponseBody
	@RequestMapping(value="/messageList",method=RequestMethod.POST)
	public Map<String, Object> findMessage(String tmId,String type,String page,String pageSize){
		Map<String,Object> result = new HashMap<>();
		//参数验证
		if(StringUtil.isEmptyNull(tmId)){
			result.put("code", "102");
			result.put("message", "会员id不能为空");
			return result;
		}
		TbMemberInfo tbMemberInfo = tbMemberInfoService.findById(Long.valueOf(tmId));
		if(tbMemberInfo==null){
			result.put("code", "103");
			result.put("message", "该账号不存在");
			return result;
		}
//		if(StringUtil.isEmptyNull(type)){
//			result.put("code", "105");
//			result.put("message", "类型不能为空");
//		     return result;
//		}
		try {
			String regEx="^[0123456789]*$"; 
			 if(!StringUtil.isEmptyNull(page)) {
				 if(!(page.matches(regEx) && Integer.valueOf(page)>=1)){
					 result.put("code", "201");
					 result.put("message", "页数需大于0(页数不能小于1)");
					 return result;
				 }
				 if(StringUtil.isEmptyNull(pageSize))
					 pageSize = "10";
				 else {
					 if(Integer.valueOf(pageSize)<=0){
						 result.put("code", "202");
						 result.put("message", "每页条数需大于等于1");
						 return result;
					 }
				 }
			 }
			List<Map<String, Object>> messageList = tbMessageService.findMessageList(tmId, type, page, pageSize);
			if (messageList.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据");
		        return result;
		    }
			result.put("code", "100");
			result.put("message", "消息列表");
			result.put("list", messageList);
	 	    return result;
		} catch (Exception e) {
			logger.error("[TbMessageController --> findMessageList]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code","-101");
			result.put("message","查询失败");
			return result;
		}
	}
	
	*//**
	 * 删除
	 * @param tmId 用户id
	 * @param type 类型 
	 * @param messageId 消息id，多个用","拼接
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping(value="/delMessage",method=RequestMethod.POST)
	public Map<String, Object> delMessage(String tmId,String messageId){
		Map<String, Object> map = new HashMap<String, Object>();
		//参数验证
		if(StringUtil.isEmptyNull(tmId)){
			map.put("code", "101");
			map.put("message", "会员id不能为空");
			return map;
		}
		TbMemberInfo tbMemberInfo = tbMemberInfoService.findById(Long.valueOf(tmId));
		if(tbMemberInfo==null){
			map.put("code", "102");
			map.put("message", "该账号不存在");
			return map;
		}
		try {
			tbMessageService.deleteMessage(tmId,messageId);
			map.put("code", 100);
			map.put("message", "消息清空成功");
			return map;
		} catch (Exception e) {
			logger.error("[TbMessageController --> delMessage]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", -101);
			map.put("message", "消息清空操作失败");
			return map;
		}
	}
	*//**
	 * 消息详情
	 * @param messageId
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping(value="/messageDetail",method=RequestMethod.POST)
	public Map<String, Object> detail(String messageId){
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isEmptyNull(messageId)){
			map.put("code", "102");
			map.put("message", "消息Id数据为空");
			return map;
		}
		try {
			TbMessage tbMessage =tbMessageService.findById(Long.valueOf(messageId));
			if(tbMessage.getTmStatus()==0) {
				map.put("code", "199");
				map.put("message", "暂无数据");
		        return map;
			}
			List<Map<String, Object>> messageList = tbMessageService.findMessageListByTmId(messageId);
			if (messageList.size() == 0) {
				map.put("code", "199");
				map.put("message", "暂无数据");
		        return map;
		    }
			tbMessageService.updateMessage(messageId);
			TbMessage message = tbMessageService.findById(Long.valueOf(messageId));
			map.put("code", 100);
			map.put("message", "请求成功");
			map.put("detail",message);
			return map;
		} catch (Exception e) {
			logger.error("[TbMessageController --> updateMessage]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", -101);
			map.put("message", "请求失败");
			return map;
		}
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/messageIsNotRead",method=RequestMethod.POST)
	public Map<String, Object> messageIsNotRead(String tmId){
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isEmptyNull(tmId)){
			map.put("code", 102);
			map.put("message", "会员数据为空");
			return map;
		}
		try {
			List<Map<String,Object>> message = tbMessageService.messageIsNotRead(tmId);
			if(message.size()>0){
				System.out.println(Integer.valueOf(message.get(0).get("count").toString()));
				if((Integer.valueOf(message.get(0).get("count").toString()))>0){
					map.put("messageIsNotRead",true);
				}else{
					map.put("messageIsNotRead",false);
				}
			}else{
				map.put("messageIsNotRead",false);
			}
			map.put("code", 100);
			map.put("message", "请求成功");
			return map;
		} catch (Exception e) {
			logger.error("[TbMessageController --> updateMessage]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", -101);
			map.put("message", "请求失败");
			return map;
		}
	}
	
	
}
*/
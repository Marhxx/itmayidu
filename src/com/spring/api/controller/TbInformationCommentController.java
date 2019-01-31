/*package com.spring.api.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.api.entity.TbInformation;
import com.spring.api.entity.TbInformationComment;
import com.spring.api.entity.TbMemberInfo;
import com.spring.api.service.TbInformationCommentService;
import com.spring.api.service.TbInformationService;
import com.spring.api.service.TbMemberInfoService;
import com.spring.base.controller.BaseController;
import com.spring.base.utils.StringUtil;
*//**
 * @author zhangzhenya
 *	资讯评论
 * @date 2018年8月21日 
 *//*
@Controller
@RequestMapping("/tbInformationComment")
public class TbInformationCommentController extends BaseController{
	@Autowired
	private TbInformationCommentService tbInformationCommentService;
	@Autowired
	private TbInformationService tbInformationService;
	@Autowired
	private TbMemberInfoService tbMemberInfoService;
	*//**
	 * 获取资讯父评价列表
	 * 
	 * @param ticInfoId
	 * @param pageId
	 * @param pageCount
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getInformationCommentList")
	public Map<String, Object> getInformationCommentList(String ticInfoId,String pageId, String pageCount) {
		Map<String, Object> result = new HashMap<>();
		if (StringUtil.isEmptyNull(ticInfoId)) {
			result.put("code", "101");
			result.put("message", "资讯id不能为空！");
			return result;
		}
		String regEx="^[0123456789]*$"; 
		 if(StringUtil.isEmptyNull(pageId)) {
			 pageId="1";
			
		 }
		 else{
			 if(!(pageId.matches(regEx) && Integer.valueOf(pageId)>=1)){
				 result.put("code", "201");
				 result.put("message", "页数需大于0(页数不能小于1)");
				 return result;
			 }
		 }
		 if(StringUtil.isEmptyNull(pageCount))
			 pageCount = "15";
		 else {
			 if(Integer.valueOf(pageCount)<=0){
				 result.put("code", "202");
				 result.put("message", "每页条数需大于等于1");
				 return result;
			 }
		 }
	
		
		try{
			List<Map<String, Object>> InformationCommentList= tbInformationCommentService.getInformationCommentByTicId(ticInfoId, pageId, pageCount);
			for (Map<String, Object> map : InformationCommentList) {
	    		String id = map.get("tic_id").toString();
	    		List<Map<String, Object>> InfoCommentCount= tbInformationCommentService.getChildInfoCommentCount(ticInfoId,id);
	    		if(InfoCommentCount != null && InfoCommentCount.get(0).get("childCount") != null){
	    			map.put("InfoCommentCount", InfoCommentCount.get(0).get("childCount"));

	    		}
	    	}
			
			if (InformationCommentList.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据！");
		        return result;
		    }
			result.put("code", "100");
			result.put("message", "操作成功！");
			result.put("InformationCommentList", InformationCommentList);
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getInformationCommentList]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	*//**
	 * 获取资讯子评价列表
	 * 
	 * @param ticInfoId
	 * @param parentId
	 * @param pageId
	 * @param pageCount
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getChildInfoCommentList")
	public Map<String, Object> getChildInfoCommentList(String ticInfoId, String parentId,String pageId, String pageCount) {
		Map<String, Object> result = new HashMap<>();
		
		if (StringUtil.isEmptyNull(ticInfoId)) {
			result.put("code", "101");
			result.put("message", "资讯id不能为空！");
			return result;
		}
		if (StringUtil.isEmptyNull(parentId)) {
			result.put("code", "102");
			result.put("message", "父级评论id不能为空！");
			return result;
		}
		String regEx="^[0123456789]*$"; 
		 if(StringUtil.isEmptyNull(pageId)) {
			 pageId="1";	
		 }
		 else{
			 if(!(pageId.matches(regEx) && Integer.valueOf(pageId)>=1)){
				 result.put("code", "201");
				 result.put("message", "页数需大于0(页数不能小于1)");
				 return result;
			 }
		 }
		 if(StringUtil.isEmptyNull(pageCount))
			 pageCount = "15";
		 else {
			 if(Integer.valueOf(pageCount)<=0){
				 result.put("code", "202");
				 result.put("message", "每页条数需大于等于1");
				 return result;
			 }
		 }
		
		
		try{
			TbInformationComment tbInformationComment = tbInformationCommentService.findById(Long.valueOf(parentId));
			if(tbInformationComment==null){
				result.put("code", "101");
				result.put("message", "评论内容不存在！");
				return result;
				
			}
			TbMemberInfo tbMemberInfo=tbMemberInfoService.findById(tbInformationComment.getTicMemberId());
			if(tbMemberInfo==null){
				result.put("code", "101");
				result.put("message", "该会员不存在！");
				return result;
				
			}
			List<Map<String, Object>> childInfoCommentList= tbInformationCommentService.getInformationChildCommentByTicId(ticInfoId, parentId, pageId, pageCount);
			List<Map<String, Object>> childInfoCommentCount= tbInformationCommentService.getChildInfoCommentCount(ticInfoId, parentId);
			if (childInfoCommentList.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据！");
		        return result;
		    }
			if (childInfoCommentCount.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据！");
		        return result;
		    }
			result.put("code", "100");
			result.put("message", "操作成功！");
			result.put("tbInformationComment", tbInformationComment);
			result.put("tmiIcon", tbMemberInfo.getTmiIcon());
			result.put("tmiNickName", tbMemberInfo.getTmiNickName());
			result.put("childInfoCommentCount", childInfoCommentCount);
			result.put("chidInfoCommentList", childInfoCommentList);
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getInformationChildCommentList]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	*//**
	 * 获取资讯评价个数
	 *
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getInfoCommentCount")
	public Map<String, Object> getInfoCommentCount(String ticInfoId) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> InfoCommentCount= tbInformationCommentService.getInfoCommentCount(ticInfoId);
		try{
			
			if (InfoCommentCount.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据！");
		        return result;
		    }
			result.put("code", "100");
			result.put("message", "操作成功！");
			result.put("InfoCommentCount", InfoCommentCount);
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getInfoCommentCount]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	*//**
	 * 获取资讯子评价信息
	 *
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getChildInfoComment")
	public Map<String, Object> getChildInfoCommentCount(String ticId) {
		Map<String, Object> result = new HashMap<>();
		TbInformationComment tbInformationComment=tbInformationCommentService.findById(Long.valueOf(ticId));
		try{
			
			if (tbInformationComment==null) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据！");
		        return result;
		    }
			result.put("code", "100");
			result.put("message", "操作成功！");
			result.put("tbInformationComment", tbInformationComment);
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getInfoCommentCount]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	*//**
	 * 获取资讯子评价个数
	 * @param parentId
	 * @param ticInfoId
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getChildInfoCommentCount")
	public Map<String, Object> getChildInfoCommentCount(String ticInfoId,String parentId) {
		Map<String, Object> result = new HashMap<>();
		if (StringUtil.isEmptyNull(ticInfoId)) {
			result.put("code", "101");
			result.put("message", "资讯id不能为空！");
			return result;
		}
		if (StringUtil.isEmptyNull(parentId)) {
			result.put("code", "102");
			result.put("message", "父级评论id不能为空！");
			return result;
		}
		List<Map<String, Object>> childInfoCommentCount= tbInformationCommentService.getChildInfoCommentCount(ticInfoId, parentId);
		try{
			
			if (childInfoCommentCount.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据！");
		        return result;
		    }
			result.put("code", "100");
			result.put("message", "操作成功！");
			result.put("childInfoCommentCount", childInfoCommentCount);
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getChildInfoCommentCount]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	*//**
	 * 添加资讯评价
	 * @param tmiId
	 * @param ticInfoId
	 * @param comment
	 *//*
	@ResponseBody
	@RequestMapping(value = "/addInfoComment")
	public Map<String, Object> addInfoComment(String ticInfoId,String tmiId,String comment) {
		Map<String, Object> result = new HashMap<>();
		if (StringUtil.isEmptyNull(ticInfoId)) {
			result.put("code", "101");
			result.put("message", "资讯id不能为空！");
			return result;
		}
		if (StringUtil.isEmptyNull(tmiId)) {
			result.put("code", "102");
			result.put("message", "会员id不能为空！");
			return result;
		}
		if (StringUtil.isEmptyNull(comment)) {
			result.put("code", "103");
			result.put("message", "内容不能为空！");
			return result;
		}
		try{
			TbInformation tbInformation = tbInformationService.findById(Long.valueOf(ticInfoId));
			if(tbInformation==null){
				result.put("code", "102");
				result.put("message", "输入的资讯id不存在！");
				return result;
			}
			TbMemberInfo tbMemberInfo = tbMemberInfoService.findById(Long.valueOf(tmiId));
			if(tbMemberInfo == null){
				result.put("code", "101");
				result.put("message", "该父评价会员id不存在！");
				return result;
			}
			TbInformationComment tbInfoComment=new TbInformationComment();
			tbInfoComment.setTicAddDate(new Timestamp(System.currentTimeMillis()));
			tbInfoComment.setTicContent(comment);
			tbInfoComment.setTicInforId(Long.valueOf(ticInfoId));
			tbInfoComment.setTicMemberId(Long.valueOf(tmiId));
			tbInfoComment.setTicParentId(Long.valueOf("0"));
			tbInfoComment.setTicStatus(1);
			tbInfoComment.setTicSnap("0");
			tbInformationCommentService.save(tbInfoComment);
			result.put("code", "100");
			result.put("message", "评论成功！");
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getChildInfoCommentCount]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	*//**
	 * 回复资讯评价
	 * @param tmiId
	 * @param ticInfoId
	 * @param comment
	 * @param parentId
	 *//*
	@ResponseBody
	@RequestMapping(value = "/replyInfoComment")
	public Map<String, Object> replyInfoComment(String ticInfoId,String tmiId,String comment,String commId) {
		Map<String, Object> result = new HashMap<>();
		if (StringUtil.isEmptyNull(ticInfoId)) {
			result.put("code", "101");
			result.put("message", "资讯id不能为空！");
			return result;
		}
		if (StringUtil.isEmptyNull(tmiId)) {
			result.put("code", "102");
			result.put("message", "会员id不能为空！");
			return result;
		}
		if (StringUtil.isEmptyNull(commId)) {
			result.put("code", "103");
			result.put("message", "回复评价id不能为空！");
			return result;
		}
		if (StringUtil.isEmptyNull(comment)) {
			result.put("code", "103");
			result.put("message", "内容不能为空！");
			return result;
		}
		
		try{
			TbInformation tbInformation = tbInformationService.findById(Long.valueOf(ticInfoId));
			if(tbInformation==null){
				result.put("code", "102");
				result.put("message", "输入的资讯id不存在！");
				return result;
			}
			TbMemberInfo tbMemberInfo = tbMemberInfoService.findById(Long.valueOf(tmiId));
			if(tbMemberInfo == null){
				result.put("code", "104");
				result.put("message", "该父评价会员id不存在！");
				return result;
			}
			TbInformationComment tbInfoComm=tbInformationCommentService.findById(Long.valueOf(commId));
			if(tbInfoComm==null){
				result.put("code", "105");
				result.put("message", "回复评价id不存在！");
				return result;
			}
			TbInformationComment tbInfoComment=new TbInformationComment();
			tbInfoComment.setTicAddDate(new Timestamp(System.currentTimeMillis()));
			tbInfoComment.setTicContent(comment);
			tbInfoComment.setTicInforId(Long.valueOf(ticInfoId));
			tbInfoComment.setTicMemberId(Long.valueOf(tmiId));
			tbInfoComment.setTicParentId(Long.valueOf(commId));
			tbInfoComment.setTicStatus(1);
			tbInfoComment.setTicSnap("0");
			tbInformationCommentService.save(tbInfoComment);
			result.put("code", "100");
			result.put("message", "回复成功！");
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getChildInfoCommentCount]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	*//**
	 * 资讯评价点赞
	 * @param commId
	 *//*
	@ResponseBody
	@RequestMapping(value = "/addCommentSnap")
	public Map<String, Object> addCommentSnap(String commId) {
		Map<String, Object> result = new HashMap<>();
		if (StringUtil.isEmptyNull(commId)) {
			result.put("code", "101");
			result.put("message", "资讯评价id不能为空！");
			return result;
		}
		try{
			TbInformationComment tbInfoComment=tbInformationCommentService.findById(Long.valueOf(commId));
			if(tbInfoComment==null){
				result.put("code", "102");
				result.put("message", "输入的评价id不正确！");
				return result;
			}
			String snap=tbInfoComment.getTicSnap();
			if(snap==null || snap.equals("")){
				snap="0";
			}
			Long newSnap=Long.valueOf(snap)+1;
			tbInfoComment.setTicSnap(newSnap.toString());
			tbInformationCommentService.update(tbInfoComment);
			result.put("code", "100");
			result.put("message", "点赞成功！");
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getChildInfoCommentCount]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	*//**
	 * 删除自己的回复
	 * @param commId
	 *//*
	@ResponseBody
	@RequestMapping(value = "/delMyselfComment")
	public Map<String, Object> delMyselfComment(String commId) {
		Map<String, Object> result = new HashMap<>();
		if (StringUtil.isEmptyNull(commId)) {
			result.put("code", "101");
			result.put("message", "资讯评价id不能为空！");
			return result;
		}
		try{
			TbInformationComment tbInfoComment=tbInformationCommentService.findById(Long.valueOf(commId));
			if(tbInfoComment==null){
				result.put("code", "102");
				result.put("message", "输入的评价id不正确！");
				return result;
			}
			
			tbInformationCommentService.delete(Long.valueOf(commId));
			result.put("code", "100");
			result.put("message", "删除成功！");
			return result;
		}catch(Exception e){
			logger.error("[tbInformationComment --> getChildInfoCommentCount]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
}
*/
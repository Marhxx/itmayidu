package com.spring.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.api.entity.TbMemberInfo;
import com.spring.base.controller.BaseController;
import com.spring.base.utils.StringUtil;
import com.spring.common.entity.TbInformation;
import com.spring.common.service.TbInformationService;

/**
 * 
 * @author Administrator
 *	2016-10-18
 */
@Controller
@RequestMapping(value = "/information")
public class TbInformationController extends BaseController{

	@Resource
	TbInformationService tbInformationService;
	
	/**
	 * 资讯列表，cataId 会对应不同意义
	 * 
	 * @param cataId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list")
	public Map<String,Object> informationList(String cataId,String page,String pageSize){
		Map<String,Object> map = new HashMap<String,Object>();
		//参数验证
		if(StringUtil.isEmptyNull(cataId)){
			map.put("code", "102");
			map.put("message", "分类id不能为空");
			return  map;
		}
		
		try {
			List<TbInformation> list = tbInformationService.informationList(cataId,page,pageSize);
			if(list.size()==0){
				map.put("code", "199");
				map.put("message", "暂无数据");
				return map;
			}
			List<TbInformation> listSize = tbInformationService.informationList(cataId,null,null);
			map.put("code", "100");
			map.put("message", "查询成功");
			map.put("list", list);
			map.put("size", listSize.size());
			return map;
		} catch (Exception e) {
			logger.error("[TbInformationController --> informationList]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", "-101");
			map.put("message", "查询失败");
			return map;
		}
	}
	
	/**
	 * 快报详情
	 * @param tiId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/detail")
	public Map<String,Object> informationDetail(String tiId){
		Map<String,Object> map = new HashMap<String,Object>();
		//参数验证
		if(StringUtil.isEmptyNull(tiId)){
			map.put("code", "102");
			map.put("message", "快报id不能为空");
			return map;
		}
		
		TbInformation tbInformation = tbInformationService.findById(Long.valueOf(tiId));
		if(tbInformation==null||tbInformation.getTiStatus()!=1){
			map.put("code", "103");
			map.put("message", "快报不存在");
			return map;
		}
		
		try {
			map.put("code", "100");
			map.put("message", "查询成功");
			map.put("tbInformation", tbInformation);
			return map;
		} catch (Exception e) {
			logger.error("[TbInformationController --> informationDetail]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", "-101");
			map.put("message", "查询失败");
			return map;
		}
	}
	/**
	 * 资讯信息
	* @param catalogId
	* @param pageId
	* @param pageCount
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/getInfoList",method=RequestMethod.POST)
	public Map<String, Object> getInfoList(String catalogId,String pageId,String pageCount){
		Map<String,Object> result = new HashMap<>();
		//参数验证
		/*TbMemberInfo tbMemberInfo = tbMemberInfoService.findByMemberId(memberId);
		if (tbMemberInfo==null) {
			result.put("code", "101");
			result.put("message", "您传入的会员id参数不存在，请检查！");
			return result;
		}*/
//		1. 如果分类id不传，则默认查询所有的分类
//		   select * from tb_information  where  ti_status =1 
//		2. 如果page_id为空，page_id = 1；
//		3. 如果page_count为空,page_count =15;
//		4.  
//		   select * from tb_information where ti_status =1
		
		
//			TbMemberScoreHistory  memberScoreHistory=new TbMemberScoreHistory();
		/*if(StringUtil.isEmptyNull(catalogId)||catalogId.equals("")){
			TbInformation tbInformation=new TbInformation();
			tbInformation=tbInformationService.findByCataAll(tbInformation);			
		}*/
		try {
			String regEx="^[0123456789]*$"; 
			 if(!StringUtil.isEmptyNull(pageId)) {
				 if(!(pageId.matches(regEx) && Integer.valueOf(pageId)>=1)){
					 result.put("code", "201");
					 result.put("message", "页数需大于0(页数不能小于1)");
					 return result;
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
			 }
			List<Map<String, Object>> infoList = tbInformationService.findInfoList(catalogId, pageId, pageCount);
			if (infoList.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据！");
		        return result;
		    }
			result.put("code", "100");
			result.put("message", "查询成功！");
			result.put("infoList", infoList);
	 	    return result;
		} catch (Exception e) {
			logger.error("[TbMessageController --> getInfoList]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code","-101");
			result.put("message","查询失败");
			return result;
		}
	}
}

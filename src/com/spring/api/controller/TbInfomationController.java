package com.spring.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.api.entity.TbInformation;
import com.spring.api.entity.TbInformationCata;
import com.spring.api.service.TbInformationCataService;
import com.spring.api.service.TbInformationCommentService;
import com.spring.api.service.TbInformationService;
import com.spring.base.controller.BaseController;
import com.spring.base.utils.StringUtil;

@Controller
@RequestMapping("/tbInfomation")
public class TbInfomationController extends BaseController{

	@Autowired
	private TbInformationCataService tbInformationCataService;
	
	@Autowired
	private TbInformationService tbInformationService;
	@Autowired
	private TbInformationCommentService tbInformationCommentService;
	
	/**
	 * 測試11111111111111
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getnameaa")
	public Map<String, Object> getCatalog(String name){
		System.out.println("resu1"+name);
		Map<String, Object> result = new HashMap<>();
		List<TbInformationCata> list = tbInformationCataService.findAll();
		System.out.println("aaa"+list);
		for (TbInformationCata tbInformationCata : list) {
			System.out.println(tbInformationCata.getTicId()+tbInformationCata.getTicAddDate());
		}
		result.put("name", list);
		return result;
		
	}
	
	
	/**
 	 * 获取资讯分类
	 * 
	 * @param request
	 * @param catalog_id	分类id(不传返回所有)
	 * @param pageId  某页
	 * @param pageCount  某页数量 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getCatalog")
	public Map<String, Object> getCatalog(HttpServletRequest request,String CatalogId
			,String pageId,String pageCount){
		Map<String, Object> result = new HashMap<>();
		
		String regEx="^[0123456789]*$"; 
		if(StringUtil.isEmptyNull(pageId)){
			pageId = "1";
		}else {
			 if(!(pageId.matches(regEx) && Integer.valueOf(pageId)>=1)){
				 result.put("code", "201");
				 result.put("message", "页数需大于0(页数不能小于1)");
				 return result;
			 }
		}
		if(StringUtil.isEmptyNull(pageCount)){
			pageCount = "15";
		}else {
			 if(Integer.valueOf(pageCount)<=0){
				 result.put("code", "202");
				 result.put("message", "每页条数需大于等于1");
				 return result;
			 }
		}

		try{
			List<TbInformationCata> tbInformationCatas = tbInformationCataService.getCatalog(CatalogId);
			if (tbInformationCatas.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "[]");
		        return result;
		    }

			result.put("title_data", tbInformationCatas);
			
			if(StringUtil.isEmptyNull(CatalogId)){
				for(int i=0,length=tbInformationCatas.size();i<length;i++){
					String strCatalogId = tbInformationCatas.get(i).getTicId();
					List<Map<String,Object>> listTbInformations = 
							tbInformationService.listTbInformation(strCatalogId, pageId, pageCount, 1);
					
					if (listTbInformations.size() == 0) {
				    	result.put("data_"+strCatalogId, "[]");
				    }else {
				    	for (Map<String, Object> map : listTbInformations) {
				    		String id = map.get("ti_id").toString();

				    		List<Map<String, Object>> InfoCommentCount= tbInformationCommentService.getInfoCommentCount(id);
				    		if(InfoCommentCount != null && InfoCommentCount.get(0).get("count") != null){
				    			map.put("InfoCommentCount", InfoCommentCount.get(0).get("count"));
				    		}
				    	}
				    	result.put("data_"+strCatalogId, listTbInformations);
					}
				}
			}else {
				//不分页，所有置顶数据展示在第一页
				if(pageId.equals("1")){
					List<Map<String,Object>> listTbInformationsByTop = 
							tbInformationService.listTbInformation(CatalogId, pageId, pageCount, 1);
					if (listTbInformationsByTop.size() == 0) {
				    	result.put("data_top", "[]");
				    }else {
				    	for (Map<String, Object> map : listTbInformationsByTop) {
				    		String id = map.get("ti_id").toString();
				    		List<Map<String, Object>> InfoCommentCount= tbInformationCommentService.getInfoCommentCount(id);
				    		if(InfoCommentCount != null && InfoCommentCount.get(0).get("count") != null){
				    			map.put("InfoCommentCount", InfoCommentCount.get(0).get("count"));

				    		}
				    	}
				    	result.put("data_top", listTbInformationsByTop);
					}
				}		
				//分页，非置顶数据滚动刷新？
				List<Map<String,Object>> listTbInformationsByNotTop = 
						tbInformationService.listTbInformation(CatalogId, pageId, pageCount, 2);
				if (listTbInformationsByNotTop.size() == 0) {
			    	result.put("data_notop", "[]");
			    }else {
			    	for (Map<String, Object> map : listTbInformationsByNotTop) {
			    		String id = map.get("ti_id").toString();
			    		List<Map<String, Object>> InfoCommentCount= tbInformationCommentService.getInfoCommentCount(id);
			    		if(InfoCommentCount != null && InfoCommentCount.get(0).get("count") != null){
			    			map.put("InfoCommentCount", InfoCommentCount.get(0).get("count"));

			    		}
			    	}
			    	result.put("data_notop", listTbInformationsByNotTop);
				}
			}
			
			result.put("code", "100");
			result.put("message", "操作成功！");
			return result;
		}catch(Exception e){
			logger.error("[member --> getCatalog]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	
	/**
	 * 获取资讯信息--资讯Id
	 * 
	 * @param request
	 * @param tiId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getInformation")
	public Map<String, Object> getInformation(HttpServletRequest request,String tiId){
		Map<String, Object> result = new HashMap<>();
		//判断是否为空
		if(StringUtil.isEmptyNull(tiId)){
			result.put("code", "101");
			result.put("message", "资讯Id不能为空！");
			return result;
		}

		try{
			TbInformation tbInformation = new TbInformation();
			tbInformation.setTiId(Long.valueOf(tiId));
			tbInformation.setTiStatus(1);
			tbInformation = tbInformationService.searchOne(tbInformation);
			if (tbInformation == null) {
		    	result.put("code", "199");
		    	result.put("message", "[]");
		        return result;
		    }else {
		    	tbInformation.setTiViewCount(tbInformation.getTiViewCount()+1);
				result.put("data",tbInformation);
				tbInformationService.update(tbInformation);
			}
			List<Map<String, Object>> InfoCommentCount= tbInformationCommentService.getInfoCommentCount(tiId);
			if (InfoCommentCount == null) {
		    	result.put("code", "199");
		    	result.put("message", "[]");
		        return result;
		    }
			result.put("InfoCommentCount", InfoCommentCount);
			result.put("code", "100");
			result.put("message", "操作成功！");
			return result;
		}catch(Exception e){
			logger.error("[member --> getInformation]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
	
	/**
	 * 获取资讯信息
	 * 
	 * @param request
	 * @param catalogId	分类id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getInfo")
	public Map<String, Object> getInfo(HttpServletRequest request,String catalogId,String pageId, String pageCount){
		Map<String, Object> result = new HashMap<>();
		
		try{
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
			List<Map<String, Object>> tbInformations = tbInformationService.getTbInformationLists(catalogId, pageId, pageCount);
			if (tbInformations.size() == 0) {
		    	result.put("code", "199");
		    	result.put("message", "暂无数据！");
		        return result;
		    }
			result.put("code", "100");
			result.put("message", "操作成功！");
			result.put("tbInformations", tbInformations);
			return result;
		}catch(Exception e){
			logger.error("[member --> getInfo]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			result.put("code", "-101");
			result.put("message", "数据库操作失败,请联系开发人员！");
			return result;
		}
	}
}
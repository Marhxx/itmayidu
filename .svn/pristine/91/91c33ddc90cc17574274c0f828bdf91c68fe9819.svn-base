package com.spring.api.service;

import java.util.List;
import java.util.Map;

import com.spring.api.entity.TbInformation;
import com.spring.base.service.BaseService;

/**
 * 
 * @author JoeyChen
 * @date 2018年8月2日 
 *
 */
public interface TbInformationService extends BaseService<TbInformation, Long> {
	
	public List<Map<String, Object>> getTbInformationList(String memberId,String pageId,String pageCount);
	public List<Map<String,Object>> getTbInformationLists(String catalogId,String pageId,String pageCount);
	
	public List<Map<String,Object>> listTbInformation(String catalogId,String pageId,String pageCount,int type);

	
}
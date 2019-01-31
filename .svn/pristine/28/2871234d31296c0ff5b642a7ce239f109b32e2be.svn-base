package com.spring.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.base.service.BaseService;
import com.spring.common.entity.TbInformation;

public interface TbInformationService extends BaseService<TbInformation, Long>{
	public HashMap<String, Object> findByParam(HashMap<String, String> params);
	
	List<TbInformation> findByCataId(long cataId);
	
	TbInformation findOne(TbInformation information);
	/**
	 * 获取分类下资讯
	 * @param cataId 分类id
	 * @param pageSize 
	 * @param page 
	 * @return
	 */
	public List<TbInformation> informationList(String cataId, String page, String pageSize);

	public List<Map<String, Object>> findInfoList(String catalogId, String pageId, String pageCount);

	public TbInformation findByCataAll(TbInformation tbInformation);

}

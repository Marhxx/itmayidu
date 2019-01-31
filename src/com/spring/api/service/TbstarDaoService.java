package com.spring.api.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.spring.api.entity.Tbstar;
import com.spring.base.service.BaseService;


/**
 * TbstarDaoService 继承 BaseService服务  拥有父类BaseService 下的所有方法
 * @author HXX
 *
 */
public interface TbstarDaoService extends BaseService<Tbstar, Serializable>{
	

	
	/**
	 * 自定义方法  这个接口 extends 了BaseService类拥有子类的方法可以直接调用
	 * @param CatalogId
	 * @return
	 * 
	 * 根据ID查询
	 */
	
	public List<Tbstar> getHXX(String CatalogId);

	//limik
	public List<Map<String, Object>> getTbInformationLists(String name, String pageId, String pageCount);
	
	
	/**
	 * delete all
	 * @param CatalogId
	 * @return
	 */
	public Integer delAll(String CatalogId);
	

}

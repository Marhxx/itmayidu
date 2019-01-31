package com.spring.common.service;


import java.util.List;
import java.util.Map;

import com.spring.base.service.BaseService;
import com.spring.common.entity.ChinaCity;



public interface ChinaCityService extends
	BaseService< ChinaCity, Long> {
	/**
	 * 根据id查询ChinaCity
	 */
	public ChinaCity findCityById(Long id);
	/**
	 * 查询所有城市
	 * @author jinlei
	 *	@time: 2015年1月9日 上午10:12:09
	 * @return
	 */
	public List<ChinaCity> findAllCity();
	
	Map<String, Object> findByAddress(String address);
	/**
	 * 查询所有省份下的城市
	 * @author jinlei
	 *	@time: 2015年1月9日 上午10:12:34
	 * @param pid
	 * @return
	 */
	public List<ChinaCity> findAllCityByPro(Long pid);
	/**
	 * 根据省id获取城市
	 * @param pid
	 * @return
	 */
	public List<Map<String, Object>> listByProId(Long pid);
	
	/**
	 * 根据城市名获取城市
	 * @param id
	 * @param name
	 * @return
	 */
	public Map<String, Object> findByName(Integer cid,String name);
	/**
	 * 获取城市
	 * @param pid
	 * @return
	 */
	public List<Map<String, Object>> findCity(String pid);
}

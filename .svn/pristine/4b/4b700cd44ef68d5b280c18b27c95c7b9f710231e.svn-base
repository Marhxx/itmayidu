package com.spring.common.service;


import java.util.List;
import java.util.Map;

import com.spring.base.service.BaseService;
import com.spring.common.entity.ChinaProvince;



public interface ChinaProvinceService extends
	BaseService< ChinaProvince, Long> {
	/**
	 * 根据id查询ChinaProvince
	 */
	public ChinaProvince findProById(Long id);
	/**
	 * 查询所有省份
	 * @author jinlei
	 *	@time: 2015年1月9日 上午10:13:10
	 * @return
	 */
	public List<ChinaProvince> findAllPro();
	/**
	 * 获取省市区
	 * @return
	 */
	public List<Map<String, Object>> listProvince();
	/**
	 * 获取省列表
	 * @return
	 */
	public List<Map<String, Object>> findProvice();
	/**
	 * 根据城市名称获取身份
	 * @param address
	 * @return
	 */
    ChinaProvince findproByCityName(String address);
}

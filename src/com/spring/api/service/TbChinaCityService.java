package com.spring.api.service;

import java.util.List;
import java.util.Map;
import com.spring.base.service.BaseService;
import com.spring.api.entity.TbChinaCity;

/**
 * 区业务接口
 *
 * @author LiaoJinKe
 * @Date 2018-07-04 16:40:33
 */
public interface TbChinaCityService extends BaseService<TbChinaCity, Long> {

	public Map<String, Object> findForJson(Map<String, String> params);

	public List<Map<String, Object>> findListById(String pid);

}
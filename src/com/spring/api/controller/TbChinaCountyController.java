package com.spring.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.api.service.TbChinaCityService;
import com.spring.api.service.TbChinaCountyService;
import com.spring.api.service.TbChinaProvinceService;
import com.spring.base.controller.BaseController;
import com.spring.base.org.json.JSONArray;

/**
 * 区控制器
 *
 * @author LiaoJinKe
 * @Date 2018-07-04 15:59:12
 */
@Controller
@RequestMapping("/tbChinaCounty")
public class TbChinaCountyController extends BaseController {

	@Autowired
	private TbChinaCountyService tbChinaCountyService;
	@Autowired
	private TbChinaCityService tbChinaCityService;
	@Autowired
	private TbChinaProvinceService tbChinaProvinceService;

	/**
	 * 省市区
	 * 
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = "/getProvinceCityCount")
	public List<Map<String, Object>> getProvinceCityCount(HttpServletRequest request) {
		List<Map<String, Object>> provinceList = tbChinaProvinceService.findListAll();
		for (Map<String, Object> pro : provinceList) {
			List<Map<String, Object>> cityList = tbChinaCityService.findListById(pro.get("pid").toString());
			pro.put("children", cityList);
			for (Map<String, Object> city : cityList) {
				List<Map<String, Object>> countyList = tbChinaCountyService.findListById(city.get("cid").toString());
				city.put("children", countyList);
			}
		}
		return provinceList;
	}
}

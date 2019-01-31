package com.spring.api.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.spring.api.entity.Tbstar;
import com.spring.api.service.TbstarDaoService;
import com.spring.api.utils.BaseApiService;
import com.spring.api.utils.ResponseBase;
import com.spring.base.controller.BaseController;
import com.spring.base.utils.StringUtil;

@RestController
public class TbController extends BaseController {

	@Autowired
	private TbstarDaoService tbstardaoservice;

	@ResponseBody
	@RequestMapping("/getTbstartss")
	public ResponseBase getTbstarS(BaseApiService baseapiservice, HttpServletRequest request, String name,
			String pageId, String pageCount) {

		Map<String, Object> result = new HashMap<>();

		try {
			String regEx = "^[0123456789]*$";
			if (StringUtil.isEmptyNull(pageId)) {
				pageId = "1";

			} else {
				if (!(pageId.matches(regEx) && Integer.valueOf(pageId) <= 0)) {
					return baseapiservice.setResultError("页数需大于0(页数不能小于1)", "201");
				}
			}
			if (StringUtil.isEmptyNull(pageCount))
				pageCount = "6";
			else {
				if (Integer.valueOf(pageCount) <= 0) {
					return baseapiservice.setResultError("202", "每页条数需大于等于1");
				}
			}
			List<Map<String, Object>> tbInformations = tbstardaoservice.getTbInformationLists(name, pageId, pageCount);
			if (tbInformations.size() == 0) {
				return baseapiservice.setResultError("199", "暂无数据");

			}
			return baseapiservice.setMapResultSuccess(tbInformations);
		} catch (Exception e) {
			logger.error("[member --> getInfo]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			return baseapiservice.setResultError("-101", "数据库操作失败,请联系开发人员！");
		}

	}

	/**
	 * 批量刪除
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/getdeall")
	@ResponseBody
	public Integer getdell(BaseApiService baseapiservice,@RequestParam(value = "userIds[]") String[] userIds) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < userIds.length; i++) {
			sb.append(userIds[i] + ",").toString();

		}

		if (sb.length() > 0) {
			// 方法一 : substring
			String string1 = sb.substring(0, sb.length() - 1);
			// 执行删除
			 Integer all = tbstardaoservice.delAll(string1);
			 return all;
		}
		return 1;

		

	}

	@ResponseBody
	@RequestMapping("/getTbstart")
	public Map<String, Object> getTbstar(String CatalogId) {

		/**
		 * 自定义方法
		 */
		List<Tbstar> hxx = tbstardaoservice.getHXX(CatalogId);
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", hxx);
		return map;

		// 这个是调用封装好的方法
		/*
		 * System.out.println("来吧"+CatalogId); List<Tbstar> all =
		 * tbstardaoservice.findAll(); HashMap<String,Object> map = new HashMap<>();
		 * map.put("list", all); System.out.println("第一次"+all); return map;
		 */

	}

	/**
	 * 刪除
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping("/delTbstart")
	public Integer delTbstar(Integer id) throws Exception {
		tbstardaoservice.delete(id);
		return id;
	}

	/**
	 * 修i該
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping("/updateTbstart")
	public Integer updateTbstar(Tbstar tbstar) throws Exception {
		tbstardaoservice.update(tbstar);
		return null;

	}

	/**
	 * 添加
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping("/insertTbstar")
	public Integer insertTbstar(Tbstar tbstar) throws Exception {
		tbstardaoservice.save(tbstar);
		return null;

	}

}

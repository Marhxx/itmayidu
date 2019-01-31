package com.spring.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.base.controller.BaseController;
import com.spring.base.utils.StringUtil;
import com.spring.common.service.ChinaCityService;
import com.spring.common.service.ChinaCountyService;
import com.spring.common.service.ChinaProvinceService;
import com.spring.common.service.ChinaStreetService;
import com.spring.common.service.UserinfoService;

/**
 * 
*    
* 项目名称：hjtech-api   
* 类名称：TbRegionController   
* 类描述：   获取省市区
* 创建人：lcx 
* 创建时间：2017年3月15日 上午16:10:34   
* @version    
*
 */
@Controller
@RequestMapping(value="/region")
public class TbRegionController extends BaseController {

	@Autowired
	UserinfoService userinfoService;
	@Resource
	ChinaCityService chinaCityService;
	@Resource
	ChinaProvinceService chinaProvinceService;
	@Resource
	ChinaCountyService chinaCountyService;
	@Resource
	ChinaStreetService chinaStreetService;

	@ResponseBody
	@RequestMapping(value = "/all")
	public Map<String, Object> findAll(){
		Map<String, Object> result = new HashMap<>();

		List<Map<String, Object>> province = chinaProvinceService.findProvice();
		List<Map<String, Object>> city = chinaCityService.findCity(null);
		List<Map<String, Object>> county = chinaCountyService.findCounty(null);

//		province = province.stream().sorted((p1, p2) -> p1.get("pfl").toString().compareToIgnoreCase(p2.get("pfl").toString()) ).collect(Collectors.toList());
//
//		city = city.stream().sorted((c1, c2) -> c1.getPfl().compareToIgnoreCase(c2.getPfl()) ).collect(Collectors.toList());

		result.put("province", province);
		result.put("city", city);
		result.put("county", county);
//		setMsgResult(result, 100, "success");
		result.put("code", 100);
		result.put("message", "查询成功");
		return result;
	}
	/**
	 * 
	* @Title: findProvice 
	* @Description:  省列表
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/provice/list",method=RequestMethod.POST)
	public Map<String, Object> findProvice(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = null;
		
		try {
//			list = userinfoService.findProvice();
			list = chinaProvinceService.findProvice();
			map.put("code", 100);
			map.put("message", "查询成功");
			map.put("list", list);
			return map;
		} catch (Exception e) {
			logger.error("[TbRegionController --> findProvice]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", 101);
			map.put("message", "查询失败");
			return map;
		}
	}
	
	/**
	 * 
	* @Title: findCity 
	* @Description:  市列表
	* @param @param pid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/city/list",method=RequestMethod.POST)
	public Map<String, Object> findCity(String pid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = null;
		
		//参数验证（id可不传，获取全部市）
//		if(StringUtil.isEmptyNull(pid)){
//			map.put("code", 102);
//			map.put("message", "参数提交不完整");
//			return map;
//		}
		if(!StringUtils.isBlank(pid)){
			if(!StringUtil.isNumber(pid)){
				map.put("code", -1);
				map.put("message", "验证不通过");
				return map;
			}
		}
		
		try {
			list = chinaCityService.findCity(pid);
			map.put("code", 100);
			map.put("message", "查询成功");
			map.put("list", list);
			return map;
		} catch (Exception e) {
			logger.error("[TbRegionController --> findCity]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", 101);
			map.put("message", "查询失败");
			return map;
		}
	}
	
	/**
	 * 
	* @Title: findCounty 
	* @Description:  区列表
	* @param @param cid
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/county/list",method=RequestMethod.POST)
	public Map<String, Object> findCounty(String cid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = null;
		
		//参数验证
//		if(StringUtil.isEmptyNull(cid)){
//			map.put("code", 102);
//			map.put("message", "参数提交不完整");
//			return map;
//		}
		if(!StringUtils.isBlank(cid)){
			if(!StringUtil.isNumber(cid)){
				map.put("code", -1);
				map.put("message", "验证不通过");
				return map;
			}
		}

		try {
			list = chinaCountyService.findCounty(cid);
			
			map.put("code", 100);
			map.put("message", "查询成功");
			map.put("list", list);
			return map;
		} catch (Exception e) {
			logger.error("[TbRegionController --> findCounty]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", 101);
			map.put("message", "查询失败");
			return map;
		}
	}
	/**
	 * 查询街道
	 * @param oid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/street/list",method=RequestMethod.POST)
	public Map<String, Object> findStreet(String oid){
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> list = null;

		//参数验证
		if(StringUtil.isEmptyNull(oid)){
			map.put("code", 102);
			map.put("message", "参数提交不完整");
			return map;
		}
		if(!StringUtil.isNumber(oid)){
			map.put("code", -1);
			map.put("message", "验证不通过");
			return map;
		}

		try {
			list = chinaStreetService.findStreet(oid);

			map.put("code", 100);
			map.put("message", "查询成功");
			map.put("list", list);
			return map;
		} catch (Exception e) {
			logger.error("[TbRegionController --> findStreet]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", 101);
			map.put("message", "查询失败");
			return map;
		}
	}
	/**
	 * 根据城市id，城市名称查询城市
	 * @param cid
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/search_city")
	public Map<String, Object> searchCity(Integer cid,String name) {
		Map<String, Object> result = new HashMap<String,Object>();
		if (StringUtils.isBlank(name) && cid == null) {
			result.put("code", 101);
			result.put("message", "参数提交不完整");
			return result;
		}
		result.put("code", 100);
		result.put("city", chinaCityService.findByName(cid, name));
		
		return result;
	}
}

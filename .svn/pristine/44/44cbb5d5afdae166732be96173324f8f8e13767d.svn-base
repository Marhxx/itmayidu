package com.spring.common.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.base.controller.BaseController;
import com.spring.base.shiro.ShiroUser;
import com.spring.base.utils.StringUtil;
import com.spring.common.entity.TbWords;
import com.spring.common.service.TbWordsService;
/**
 * 数据字典
 * 2017年3月15日下午4:46:07
 * @author lcx
 *
 */
@Controller
@RequestMapping(value = "/words")
public class TbWordsController extends BaseController {

	@Resource
	TbWordsService tbWordsService;
	/**
	 * 数据字典
	 * @param code
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String, Object> findTbServiceOrder(String twcode){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = null;
		
		//参数验证
		if(StringUtil.isEmptyNull(twcode)){
			map.put("code", "102");
			map.put("message", "code不能为空");
			return map;
		}
		try {
			list = tbWordsService.findByCode(twcode);
			
			map.put("code", "100");
			map.put("message", "查询成功");
			map.put("list", list);
			return map;
		} catch (Exception e) {
			logger.error("[TbWordsController --> list]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", 101);
			map.put("message", "查询失败");
			return map;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/getEngineerWords")
	public List<TbWords> getEngineerWords(HttpServletRequest request) {
		String strReferId = request.getParameter("id");
		return tbWordsService.getEngineerWords(Long.parseLong(strReferId));
	}

	@ResponseBody
	@RequestMapping(value = "/queryWordsByTwId")
	public TbWords queryWordsByTwId(HttpServletRequest request) {
		String twId = request.getParameter("twId");
		return tbWordsService.findById(Long.parseLong(twId));
	}
	
	/**
	 * 银行列表
	 * @param request
	 * @param twCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bankList")
	public Map<String,Object> bankList(HttpServletRequest request,String twCode){
		Map<String,Object> map = new HashMap<String,Object>();
		if (StringUtil.isEmptyNull(twCode)) {
			map.put("code","101");
			map.put("message","编号不能为空");
		    return map;
		 }
		try {
			if("03".equals(twCode.substring(0, 1))) {
				List<TbWords> bankList = tbWordsService.findBankByCode(twCode);
			    if (bankList.size() == 0) {
			    	map.put("code", "199");
			    	map.put("message", "暂无数据");
			        return map;
			    }else {
			    	map.put("code", "100");
			    	map.put("message", "银行列表");
			    	map.put("list", bankList);
			 	    return map;
			    }
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("[TbWordsController --> bankList]:出错,错误原因:" + e.getMessage());
			e.printStackTrace();
			map.put("code", 101);
			map.put("message", "查询失败");
			return map;
		}
		return map;
		
	}
	

	/**
	 * 
	 * @Title: add
	 * @Description: 添加
	 * @param @param userinfo
	 * @param @return
	 * @return String
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request,TbWords words) {
		String code = request.getParameter("code");
		
		if (StringUtils.isBlank(words.getTwName())
				|| StringUtils.isBlank(code)) {
			return "101";
		}
		// 判断编码是否已存在
		TbWords searchPars = new TbWords();
		searchPars.setTwCode(code);
		searchPars.setTwStatus(1);
		TbWords w = tbWordsService.searchOne(searchPars);
		if (w != null) {
			return "102";// 编码已存在
		}
		TbWords tbWordsOne = new TbWords();
		tbWordsOne.setTwName(words.getTwName());
		tbWordsOne.setTwStatus(1);
		tbWordsOne = tbWordsService.searchOne(tbWordsOne);
		if(tbWordsOne!=null){
			return "112";//编码名称已存在
		}
		// 验证编码是否为数字
		if (!StringUtils.isNumeric(words.getTwCode()))
			return "103";
		
		//编码长度只能为2或者4位
		if (!(words.getTwCode().length() == 2))
			return "104";

		try {
			ShiroUser loginUser = (ShiroUser) SecurityUtils.getSubject()
					.getPrincipals().getPrimaryPrincipal();// 获取当前登录用户
			words.setTwCode(code);
			words.setTwAddDate(new Timestamp(new Date().getTime()));
			words.setTwAddPerson(loginUser.getId());
			words.setTwStatus(1);
			tbWordsService.save(words);
			return "100";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[TbWordsController-add()]：错误原因:" + e.getMessage());
			return "110";
		}
	}

	/**
	 * 
	 * @Title: edit
	 * @Description: 修改
	 * @param @param userinfo
	 * @param @return
	 * @return String
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,TbWords wordsInfo) {
		String code = request.getParameter("code");
		if (StringUtils.isBlank(wordsInfo.getTwName())
				|| StringUtils.isBlank(code)) {
			return "101";
		}

		// 判断编码是否已存在
		/*TbWords w = new TbWords();
		w.setTwCode(code);
		TbWords sw = tbWordsService.searchOne(w);
		if (sw != null) {
			return "102";// 编码已存在
		}*/
		
		TbWords searchPars = new TbWords();
		searchPars.setTwId(wordsInfo.getTwId());
		TbWords words = tbWordsService.searchOne(searchPars);

		// 增加对编码的验证功能
		/*if (!StringUtils.isNumeric(words.getTwCode()))
			return "103";

		if (!(words.getTwCode().length() == 2))
			return "104";*/

		try {
			//words.setTwCode(wordsInfo.getTwCode());
			words.setTwName(wordsInfo.getTwName());
			words.setTwMemo(wordsInfo.getTwMemo());

			tbWordsService.update(words);
			return "100";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[TbWordsController-edit()]：错误原因:" + e.getMessage());
			return "110";
		}

	}

	/**
	 * 
	 * @Title: del
	 * @Description: 删除
	 * @param @param tcId
	 * @param @return
	 * @return String
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/del")
	public String del(HttpServletRequest request) {

		String twId = request.getParameter("twId");

		if (StringUtil.isEmptyNull(twId)) {
			return "101";
		}
		try {
			TbWords words = tbWordsService.findById(Long.valueOf(twId));
			if(words.getTwCode().length()==2){
				List<TbWords> list = tbWordsService.selectList(words.getTwCode());
				if(list!=null && list.size()>0){
					return "102";
				}
			}
			
			tbWordsService.delete(Long.parseLong(twId));
			return "100";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[TbWordsController-del()]：错误原因:" + e.getMessage());
			return "110";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getWordsByCode")
	public List<TbWords> getWordsByCode(HttpServletRequest request) {
		String strCode = request.getParameter("code");
		return tbWordsService.selectList(strCode);
	}

	@ResponseBody
	@RequestMapping(value = "/getRootWords")
	public List<TbWords> getRootWords(HttpServletRequest request) {
		// String strCode = request.getParameter("code");
		return tbWordsService.getRootWords();
	}

	@ResponseBody
	@RequestMapping(value = "/getWordsByCodeEx")
	public List<TbWords> getWordsByCodeEx(HttpServletRequest request) {
		String strCode = request.getParameter("code");
		return tbWordsService.selectListEx(strCode);
	}

	@ResponseBody
	@RequestMapping(value = "/getProvAll")
	public List<TbWords> getProvAll(HttpServletRequest request) {
		return tbWordsService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/findAllGangWei")
	public List<TbWords> findAllGangWei(HttpServletRequest request) {
		return tbWordsService.findAllGangWei("");
	}

	/**
	 * 
	 * @Title: findSuperCodeById
	 * @Description: 通过ID查找父项目编码
	 * @param @param request
	 * @param @return
	 * @return String
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/findSuperCodeById", method = RequestMethod.POST)
	public String findSuperCodeById(HttpServletRequest request,
			String superCodeid) {
		if (superCodeid == null) {
			return "";
		}

		TbWords words = new TbWords();

		try {
			// 获取ID
			Long id = Long.valueOf(superCodeid);
			String superCode = tbWordsService.findSuperCodeById(id);// 查找跟项目code

			return superCode;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[TbWordsController-findSuperCodeById()]：错误原因:"
					+ e.getMessage());
			return null;
		}
	}

	/**
	 * 
	* @Title: findSuerNameByCode 
	* @Description:  根据编码查询父级名称
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/findSuerNameByCode", method = RequestMethod.POST)
	public String findSuerNameByCode(HttpServletRequest request) {
		String code = request.getParameter("code");
	
		try {
			// 获取ID
			String name = tbWordsService.findIdByCode(code);// 根据code查询id
			
			return name;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[TbWordsController-findSuerNameByCode()]：错误原因:"
					+ e.getMessage());
			return null;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/findWordsByCode")
	public List<TbWords> findWordsByCode(HttpServletRequest request) {
		String strCode = request.getParameter("code");
		return tbWordsService.selectWordsList(strCode);
	}
	
//	//
//	@ResponseBody
//	@RequestMapping(value = "/findWordsByCode")
//	public List<TbWords> findWordsByCode(HttpServletRequest request) {
//		String twCode=request.getParameter("twCode");
//		System.out.println("查编号"+twCode+"后面的words");
//		return tbWordsService.findWordsByCode(twCode);
//	}
}

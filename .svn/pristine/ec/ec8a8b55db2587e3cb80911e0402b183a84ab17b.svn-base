package com.spring.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.base.service.BaseService;
import com.spring.common.entity.TbWords;


public interface TbWordsService extends BaseService<TbWords, Long> {
	
	public TbWords searchOne(TbWords t);
	
	public HashMap<String, Object> findForJson(HashMap<String, String> params);

	public List<TbWords> selectList(String code);
	public List<TbWords> selectListEx(String code);
	public List<TbWords> findAllGangWei(String code);
	public List<TbWords> findAllPro();
	
	public List<TbWords> getEngineerWords(Long id);
	
	public List<TbWords> allParentById();
	public List<TbWords> allParentByWelfare();
	
	//获取数据字典的根目录
	public List<TbWords> getRootWords();
	
	public String findSuperCodeById(Long id);
	
	public String findIdByCode(String code);

	public List<TbWords> selectWordsList(String strCode);
	/**
	 * 获取twcode下数据字典信息
	 * @param twcode
	 * @return
	 */
	public List<Map<String, Object>> findByCode(String twcode);
	
	
	/**
	 * 银行列表接口      wuhao
	 * @param twCode
	 * @return
	 */
	List<TbWords> findBankByCode(String twCode);
}

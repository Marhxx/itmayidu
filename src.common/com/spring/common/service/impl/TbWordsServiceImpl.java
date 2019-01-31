package com.spring.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.TbWordsDao;
import com.spring.common.entity.PageBean;
import com.spring.common.entity.TbWords;
import com.spring.common.service.TbWordsService;


@Service("tbWordsService")
@Transactional
public class TbWordsServiceImpl extends BaseServiceImpl<TbWords, Long>
		implements TbWordsService {

	@Resource TbWordsDao tbWordsDao;

	@Override
	public BaseDao<TbWords, Long> getGenericDao() {
		return tbWordsDao;
	}
	
	@Override
	public TbWords searchOne(TbWords t)
	{
		return tbWordsDao.searchOne(t);
	}

	@Override
	public HashMap<String, Object> findForJson(HashMap<String, String> params) {
		HashMap<String, Object> json = new HashMap<String, Object>();
		String AddDate = params.get("AddDate");
		String AddDateEnd = params.get("AddDateEnd");
		int page = params.get("page") == null ? 0:Integer.parseInt(params.get("page"));
		int pageSize = params.get("pageSize") == null ? 0:Integer.parseInt(params.get("pageSize"));
		
		String sql = "select tw_id,tw_name,tw_code,DATE_FORMAT(tw_add_date,'%Y-%m-%d %H:%i:%s') as tw_add_date,tw_memo,tw_status,tw_value from tb_words w where tw_status = 1";
		List<Object> values = new ArrayList<Object>();
		
		if(params.get("twCode") != null && !params.get("twCode").equalsIgnoreCase(""))
		{
			sql += " and tw_code like '%" + params.get("twCode") + "%'";
		}
		
		if(params.get("twName") != null && !params.get("twName").equalsIgnoreCase(""))
		{
			sql += " and tw_name like '%" + params.get("twName") + "%'";
		}
		
		if (AddDate != null && !AddDate.equalsIgnoreCase("")) {
			sql +=" AND DATE_FORMAT(tw_add_date,'%Y-%m-%d') >= DATE_FORMAT('"+AddDate+"','%Y-%m-%d')";
		} 
		
		if (AddDateEnd!= null && !AddDateEnd.equalsIgnoreCase("")) {
			sql +=" AND DATE_FORMAT(tw_add_date,'%Y-%m-%d') <= DATE_FORMAT('"+AddDateEnd+"','%Y-%m-%d')";
		}
		
		
		if(params.get("sort") != null && !params.get("sort").equalsIgnoreCase("")){
			sql +=" order by  " + params.get("sort");
		}
		
		
		if(params.get("order") != null && !params.get("order").equalsIgnoreCase("")){
			sql +=" " + params.get("order");
		}
		System.out.println("sql-->" + sql);
		
		if (pageSize == 0) {
			List<Map<String,Object>> list = tbWordsDao.searchForMap(sql, values);
			json.put("total", list.size());
			json.put("rows", list);
			return json;
		}else {
			PageBean<Map<String,Object>> pageBean = new PageBean<Map<String,Object>>(page, pageSize);
			
			if(params.get("orderBy") != null)
				pageBean.setOrderBy(params.get("orderBy"));
			if(params.get("orderType") != null)
				pageBean.setOrderType(params.get("orderType"));
			
			pageBean = tbWordsDao.searchForMap(sql, values, pageBean);
			
			json.put("total", pageBean.getRowCount());
			json.put("rows", pageBean.getList());
			return json;
		}
	}
	
	
	public List<TbWords> getRootWords(){
		
		StringBuffer sbSql = new StringBuffer();
		sbSql.append(" select tw_id,tw_code,tw_name  ");
		sbSql.append("  from tb_words ");
		sbSql.append(" where LENGTH(tw_code) =2 and tw_status = 1" );
		return tbWordsDao.search(sbSql.toString(), null);
		
	}
	
	@Override
	public String findSuperCodeById(Long id) {
		String sql = "select tw_code from tb_words where tw_id = "+id+" ";
		String code = tbWordsDao.getDouble(sql);
		return code;
	}
	
	@Override
	public String findIdByCode(String code) {
		String sql ="select tw_name from tb_words where tw_code = '"+code+"'";
		return tbWordsDao.getDouble(sql);
	}
	
	public List<TbWords> selectList(String code){

		//String strCode = params.get("code");
		StringBuffer sbSql = new StringBuffer();
		sbSql.append(" select tw_id,tw_code,tw_name  ");
		sbSql.append("  from tb_words ");
		sbSql.append(" where tw_code like '" + code + "%' and LENGTH(tw_code) > 2" );
		return tbWordsDao.search(sbSql.toString(), null);
	}
	
	public List<TbWords> selectListEx(String code){

		//String strCode = params.get("code");
		StringBuffer sbSql = new StringBuffer();
		sbSql.append(" select tw_id,tw_code,tw_name from tb_words where tw_code like '21%' and length(tw_code) =6 ");
		return tbWordsDao.search(sbSql.toString(), null);
	}
	public List<TbWords> findAllGangWei(String code){
		StringBuffer sbSql = new StringBuffer();
		sbSql.append(" select tw_id,tw_code,tw_name from tb_words where tw_code like '01%'");
		return tbWordsDao.search(sbSql.toString(), null);
	}

	@Override
	public List<TbWords> findAllPro() {
		return tbWordsDao.getAll();
	}

	@Override
	public List<TbWords> getEngineerWords(Long id) {
		String sql = "select wor.* from tb_words wor,tb_engineer_words ew where wor.tw_id = ew.tb_words_id and tb_engineer_id = " + id;
		return tbWordsDao.search(sql, null);
	}
	@Override
	public List<TbWords> allParentById() {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append(" select tw_id,tw_code,tw_name from tb_words where tw_code like '04%' and length(tw_code) = 4");
		return tbWordsDao.search(sbSql.toString(), null);
	}
	@Override
	public List<TbWords> allParentByWelfare() {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append(" select tw_id,tw_code,tw_name from tb_words where tw_code like '05%' and length(tw_code) = 4");
		return tbWordsDao.search(sbSql.toString(), null);
	}

	@Override
	public List<TbWords> selectWordsList(String strCode) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append(" select *  ");
		sbSql.append("  from tb_words ");
		sbSql.append(" where tw_code like '" + strCode + "%' and tw_status=1 and  length(tw_code) = 4" );
		return tbWordsDao.search(sbSql.toString(), null);
	}

	@Override
	public List<Map<String, Object>> findByCode(String twcode) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("SELECT tw_id, tw_name,tw_value FROM tb_words WHERE tw_status=1 AND tw_code LIKE '"+twcode+"_%'");
		return tbWordsDao.searchForMap(sbSql.toString(), null);
	}

	/**
	 * 银行列表接口实现   
	 * wuhao
	 */
	@Override
	public List<TbWords> findBankByCode(String twCode) {
		//创建sql参数集合
		List<Object> values=new ArrayList<Object>();
		//创建sql语句
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select tw_name AS twName,tw_id AS twId ");
		sbSql.append("from tb_words ");
		sbSql.append("WHERE tw_code like '%03_%' ");
		sbSql.append("AND tw_status=1 ");
		//执行sql语句
		List<TbWords> tbWordsList=tbWordsDao.search(sbSql.toString(), values);
		if(tbWordsList.size()>0){
			return  tbWordsList;
		}
		else {
			return null;
		}
	}
	
	
}

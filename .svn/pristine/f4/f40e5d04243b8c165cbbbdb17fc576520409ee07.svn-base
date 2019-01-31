package com.spring.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.api.dao.TbInformationDao;
import com.spring.api.entity.TbInformation;
import com.spring.api.service.TbInformationService;
import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.base.utils.StringUtil;

/**
 * 
 * @author JoeyChen
 * @date 2018年8月2日 
 *
 */
@Service
@Transactional
public class TbInformationServiceImpl extends BaseServiceImpl<TbInformation, Long> implements TbInformationService {

	@Autowired
	private TbInformationDao tbInformationDao;
	
	@Override
	public BaseDao<TbInformation, Long> getGenericDao() {
		return tbInformationDao;
	}
	
	@Override
	public List<Map<String, Object>> getTbInformationList(String memberId,String pageId,String pageCount){
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select b.*,a.*");
		sbSql.append(" from tb_member_collect a");
		sbSql.append(" join tb_information b on a.tmc_collect_id =b.ti_id");
		sbSql.append(" where a.tmc_member_id ="+ memberId+ " and a.tmc_type = 2");//关联id和type联合控制视频信息
		sbSql.append(" and tmc_status=1");//取消收藏的不显示
		sbSql.append(" limit "+ (Integer.parseInt(pageId)-1)*Integer.parseInt(pageCount)+ ","+ pageCount);
		logger.debug(sbSql.toString());
		List<Map<String, Object>> listTbInformation = tbInformationDao.searchForMap(sbSql.toString(),null);
		return listTbInformation;
	}

	@Override
	public List<Map<String, Object>> getTbInformationLists(String catalogId, String pageId, String pageCount) {
		StringBuffer sbsql = new StringBuffer();
		sbsql.append("select * from tb_information ");
		sbsql.append(" where ti_status=1 ");
		//不传默认返回所有的分类
		if(!StringUtil.isEmptyNull(catalogId)){
			sbsql.append(" and ti_cata_id = ").append(catalogId);
		}
		sbsql.append(" ORDER BY ti_add_date DESC ");
		sbsql.append(" limit "+ (Integer.parseInt(pageId)-1)*Integer.parseInt(pageCount)+ ","+ pageCount);
		List<Map<String, Object>> listTbInformations = tbInformationDao.searchForMap(sbsql.toString(),null);
		return listTbInformations;
	}
	
	@Override
	public List<Map<String,Object>> listTbInformation(String catalogId,String pageId,String pageCount,int type) {
		StringBuffer sbsql = new StringBuffer();
		sbsql.append("select * from tb_information");
		sbsql.append(" where ti_status = 1 and ti_cata_id = "+ catalogId);
		if(type==1){
			sbsql.append(" and ti_is_top = 1");
		}
		if(type==2){
			sbsql.append(" and ti_is_top = 0");
		}
		sbsql.append(" order by ti_id desc");//对时间排序- 等价- 对Id排序
		if(type==2){
			sbsql.append(" limit "+ (Integer.parseInt(pageId)-1)*Integer.parseInt(pageCount)+ ","+ pageCount);
		}
		List<Map<String,Object>> listTbInformations = tbInformationDao.searchForMap(sbsql.toString(),null);
		return listTbInformations;
	}
	
}
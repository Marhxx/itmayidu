package com.spring.api.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dao.TbInformationCataDao;
import com.spring.api.entity.TbInformationCata;
import com.spring.api.service.TbInformationCataService;
import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.base.utils.StringUtil;

/**
 * 
 * @author JoeyChen
 * @date 2018年8月3日 
 *
 */
@Service
public class TbInformationCataServiceImpl extends BaseServiceImpl<TbInformationCata, Long > 
implements TbInformationCataService{
	@Autowired
	private TbInformationCataDao tbInformationCataDao;

	@Override
	public BaseDao<TbInformationCata, Long> getGenericDao() {
		return tbInformationCataDao;
	}
	
	@Override
	public List<TbInformationCata> getCatalog(String CatalogId){
		StringBuffer updatesql = new StringBuffer();
		updatesql.append("select * from tb_information_cata");
		updatesql.append(" where tic_status = 1");
		if(StringUtil.isEmptyNull(CatalogId)){
			updatesql.append(" and tic_parent_id =0");
		}else {
			updatesql.append(" and tic_id = ").append(CatalogId);
		}
		updatesql.append(" order by tic_order asc");
		logger.debug(updatesql.toString());
		System.out.println("sql語句");
		List<TbInformationCata> tbScoreCatalogInfos = tbInformationCataDao.search(updatesql.toString(), null);
		return tbScoreCatalogInfos;
	}
	
}
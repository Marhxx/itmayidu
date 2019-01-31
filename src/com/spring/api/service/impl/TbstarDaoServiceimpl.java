package com.spring.api.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dao.TbstarDao;
import com.spring.api.entity.Tbstar;
import com.spring.api.service.TbstarDaoService;
import com.spring.api.utils.BaseApiService;
import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.base.utils.StringUtil;

/**
 * 这个层专门服务自定义接口的 实现  写sql语句
 * @author HXX
 *
 */

@Service
public class TbstarDaoServiceimpl extends BaseServiceImpl<Tbstar, Serializable>
implements TbstarDaoService {
	
	@Autowired
	private  BaseApiService baseapiservice;
	
	@Autowired
	private TbstarDao tbstardao;

	/**
	 * 未解 有这个方法
	 */
	@Override
	public BaseDao<Tbstar, Serializable> getGenericDao() {
	
		return tbstardao;
	}

	
	
	/**
	 * 自定义SQL
	 */
	@Override
	public List<Tbstar> getHXX(String CatalogId) {
		StringBuffer addbuffer=new StringBuffer();
		addbuffer.append("select * from tb_star ");
		addbuffer.append(" where 1=1");
		if(com.spring.base.utils.StringUtil.isEmptyNull(CatalogId)) {
			addbuffer.append(" and ts_user_name='赵子龙'");
		}else {
			addbuffer.append(" and ts_id= ").append(CatalogId).append(" and ts_user_name='赵子龙'");
		}
		System.out.println("拼接sql"+addbuffer);
		logger.info("getHXX方法已启动");
		
		
		//查询
		List<Tbstar> list = tbstardao.search(addbuffer.toString(),null);
		return list;
	}



	/*
	 * @Override 
	 * public List<Map<String, Object>> getTbInformationLists(String name, String pageId, String pageCount) { 
	 *           StringBuffer sbsql = new StringBuffer();
	 *               sbsql.append("select * from tb_star ");
	 *            //不传默认返回所有的分类
	 *               if(!StringUtil.isEmptyNull(name)){
	 *              sbsql.append("where ts_user_name = ").append("'"+name+"'");
	 *                   }
	 *                     sbsql.append(" limit "+(Integer.parseInt(pageId)-1)*Integer.parseInt(pageCount)+ ","+ pageCount);
	 *                      System.out.println("出来；额"+sbsql); List<Map<String, Object>>
	 *                          listTbInformations = tbstardao.searchForMap(sbsql.toString(),null); 
	 *                             return listTbInformations;
	 *                     
	 *              }
	 */	
	
	public List<Map<String ,Object>> getTbInformationLists(String name,String pageId, String pageCount){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from tb_star ");
		if(StringUtil.isEmptyNull(name)) {
			buffer.append("where 1=1 ");
		}else {
			buffer.append(" and ts_user_name= ").append("'"+name+"'" );
		}
		
		
		
		
		buffer.append( "limit "+(Integer.parseInt(pageId)-1)*Integer.parseInt(pageCount)+","+pageCount);
		List<Map<String, Object>> list = tbstardao.searchForMap(buffer.toString(), null);
		return list;
		
	}



	@Override
	public Integer delAll(String CatalogId) {
			StringBuffer buffer=new StringBuffer();
			buffer.append("DELETE FROM tb_star ");
			buffer.append("WHERE ts_id IN ").append("("+CatalogId+")");
			System.out.println("接口"+buffer);
			int i = tbstardao.delp(buffer.toString(), null);
			System.out.println(i);
			return i;
		
	}

}

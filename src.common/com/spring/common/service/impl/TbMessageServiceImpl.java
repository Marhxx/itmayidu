package com.spring.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.base.utils.StringUtil;
import com.spring.common.dao.TbMessageDao;
import com.spring.common.entity.PageBean;
import com.spring.common.entity.TbMessage;
import com.spring.common.service.TbMessageService;

@Service("tbMessageService")
@Transactional
public class TbMessageServiceImpl extends BaseServiceImpl<TbMessage, Long>
		implements TbMessageService {

	@Resource
	TbMessageDao tbMessageDao;

	@Override
	public BaseDao<TbMessage, Long> getGenericDao() {
		return tbMessageDao;
	}

	@Override
	public TbMessage findTbMessage(TbMessage searchParams) {
		return tbMessageDao.searchOne(searchParams);
	}

	@Override
	public PageBean<TbMessage> findByPage(TbMessage params,
			PageBean<TbMessage> pageBean) {
		return tbMessageDao.search(params, pageBean);
	}

	/**
	 * 
	 * @Title: findForJson
	 * @Description: 分页消息
	 * @param @param params
	 * @param @return
	 * @return
	 * @see com.spring.backstage.service.SalaryService#findForJson(java.util.HashMap)
	 */
	@Override
	public HashMap<String, Object> findForJson(HashMap<String, String> params) {
		HashMap<String, Object> json = new HashMap<String, Object>();

		int page = params.get("page") == null ? 0 : Integer.parseInt(params
				.get("page"));
		int pageSize = params.get("pageSize") == null ? 0 : Integer
				.parseInt(params.get("pageSize"));
		String order = params.get("order");
		String tmTitle = params.get("tmTitle");
		String tmAddDate = params.get("tmAddDate");
		String tmAddDateEnd = params.get("tmAddDateEnd");
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("tm_id tmId,");//消息id
		sql.append("tm_number tmNumber,");//消息id
		sql.append("tm_content tmContent,");//消息内容
		sql.append("tm_title tmTitle,");//消息标题
		sql.append("(SELECT account FROM userinfo WHERE tm_addperson=id) tmAddperson,");//创建人
		sql.append("DATE_FORMAT(tm_addtime,'%Y-%m-%d %H:%i:%s') tmAddtime ");//创建时间
		sql.append("FROM tb_message ");//查询表
		sql.append("WHERE tm_status<>0 ");

		if (!StringUtils.isBlank(tmTitle)) {
			sql.append("AND tm_title like '%" + tmTitle + "%'");
		}
		if (tmAddDate != null && !tmAddDate.equalsIgnoreCase("")) {
			sql.append(" AND DATE_FORMAT(tm_addtime,'%Y-%m-%d') >= DATE_FORMAT('"+tmAddDate+"','%Y-%m-%d')");
		} 
		if (tmAddDateEnd!= null && !tmAddDateEnd.equalsIgnoreCase("")) {
			sql.append(" AND DATE_FORMAT(tm_addtime,'%Y-%m-%d') <= DATE_FORMAT('"+tmAddDateEnd+"','%Y-%m-%d')");
		}
		sql.append("GROUP BY tm_number ");
		if (!StringUtils.isBlank(order)) {
			sql.append(" order by tm_addtime " + order);
		} else {
			sql.append(" order by tm_addtime desc");
		}

		if (pageSize == 0) {
			List<Map<String, Object>> list = tbMessageDao.searchForMap(sql.toString(), null);
			json.put("total", list.size());
			json.put("rows", list);
			return json;
		}else {
			PageBean<Map<String, Object>> pageBean = new PageBean<Map<String, Object>>(page, pageSize);
			pageBean = tbMessageDao.searchForMap(sql.toString(), null, pageBean);
			
			json.put("total", pageBean.getRowCount());
			json.put("rows", pageBean.getList());
			return json;
		}
	}

	/**
	 * 
	 * Title: findForJsonByTitle Description: 根据消息标题分页显示消息详情
	 * 
	 * @param params
	 * @return
	 * @see com.spring.backstage.service.MessageService#findForJsonByTitle(java.util.HashMap)
	 */
	@Override
	public HashMap<String, Object> findForJsonByTitle(
			HashMap<String, String> params) {
		HashMap<String, Object> json = new HashMap<String, Object>();

		int page = params.get("page") == null ? 0 : Integer.parseInt(params
				.get("page"));
		int pageSize = params.get("pageSize") == null ? 0 : Integer
				.parseInt(params.get("pageSize"));
		
		String tmNumber = params.get("tmNumber");
		String tmType = params.get("tmType");
		System.out.println("qqqqqqq"+tmType);
		
		String sql="";
		if(Long.valueOf(tmType)==1||Long.valueOf(tmType)==5||Long.valueOf(tmType)==4){
			sql ="select A.tm_number tmNumber,A.tm_id tmId,B.tm_name tmName,B.tm_account tmAccount,B.tm_phone tmPhone,"
					+ "pname pName,cname cName,oname oName,B.tm_real_name tmRealName,"
					+ "B.tm_type tmType,A.tm_status tmStatus "
					+" from tb_message A,tb_member B "
					+" left join china_province on pid=tm_province_id "
					+" left join china_city on cid=tm_city_id "
					+" left join china_county on oid=tm_county_id "
					+" where A.tm_type= "+tmType+" AND A.tm_member_id = B.tm_id "
					+ "AND A.tm_number = "+tmNumber+" AND A.tm_status <>0 ";
		}
		if(Long.valueOf(tmType)==2){
			sql ="select C.ts_name tsName,A.tm_number tmNumber,A.tm_id tmId,B.tm_name tmName,B.tm_account tmAccount,B.tm_phone tmPhone,"
					+ "pname pName,cname cName,oname oName,B.tm_real_name tmRealName,"
					+ "B.tm_type tmType,A.tm_status tmStatus "
					+" from tb_message A,tb_member B "
					+" left join china_province on pid=tm_province_id "
					+" left join china_city on cid=tm_city_id "
					+" left join china_county on oid=tm_county_id "
					+" left join tb_sales C on ts_member_id=B.tm_id "
					+" where A.tm_type= "+tmType+" AND A.tm_member_id = B.tm_id "
					+ "AND A.tm_number = "+tmNumber+" AND A.tm_status <>0 ";
		}
		if(Long.valueOf(tmType)==3){
			sql ="select P.tc_name tcName,A.tm_number tmNumber,A.tm_id tmId,B.tm_name tmName,B.tm_account tmAccount,B.tm_phone tmPhone,"
					+ "pname pName,cname cName,oname oName,B.tm_real_name tmRealName,"
					+ "B.tm_type tmType,A.tm_status tmStatus "
					+" from tb_message A,tb_member B "
					+" left join china_province on pid=tm_province_id "
					+" left join china_city on cid=tm_city_id "
					+" left join china_county on oid=tm_county_id "
					+" left join tb_company P on tc_member_id=B.tm_id "
					+" where A.tm_type= "+tmType+" AND A.tm_member_id = B.tm_id "
					+ "AND A.tm_number = "+tmNumber+" AND A.tm_status <>0 ";
		}
		

		List<Object> values = new ArrayList<Object>();

		if (pageSize == 0) {
			List<Map<String, Object>> list = tbMessageDao.searchForMap(sql, values);
			json.put("total", list.size());
			json.put("rows", list);
			return json;
		} else {
			PageBean<Map<String, Object>> pageBean = new PageBean<Map<String, Object>>(page,
					pageSize);
			pageBean = tbMessageDao.searchForMap(sql, values, pageBean);

			json.put("total", pageBean.getRowCount());
			json.put("rows", pageBean.getList());
			return json;
		}
	}

	@Override
	public int updateByNumber(String tmNumber) {
		String sql = "UPDATE tb_message SET tm_status = 0 WHERE tm_number = '"+tmNumber+"'";
		return tbMessageDao.update(sql, null);
	}
	
	/**
	 * 
	 * @Title: findForJson
	 * @Description: 会员列表
	 * @param @param params
	 * @param @return
	 * @return
	 * @see com.spring.backstage.service.SalaryService#findForJson(java.util.HashMap)
	 */
	@Override
	public HashMap<String, Object> findForMember(HashMap<String, String> params) {
		HashMap<String, Object> json = new HashMap<String, Object>();

		int page = params.get("page") == null ? 0 : Integer.parseInt(params
				.get("page"));
		int pageSize = params.get("pageSize") == null ? 0 : Integer
				.parseInt(params.get("pageSize"));
		String order = params.get("order");
		String tmType = params.get("tmType");
		String tmAccount = params.get("tmAccount");
		String pid = params.get("pid");
		String cid = params.get("cid");
		String oid = params.get("oid");
		
		StringBuffer sql = new StringBuffer();
		sql.append("select tm_province_id,tm_city_id,tm_county_id,tm_id tmId,tm_type tmType,tm_real_name tmRealName,tm_account tmAccount,pname pName,cname cName,oname oName ");
		sql.append("from tb_member ");
		sql.append("left join china_province on pid=tm_province_id ");
		sql.append("left join china_city on cid=tm_city_id ");
		sql.append("left join china_county on oid=tm_county_id ");
		sql.append("where 1=1 ");
//		sql.append("tmName,");//姓名
//		sql.append("tmAccount,");//登录账号
//		sql.append("tmPhone,");//手机号码
//		sql.append("tmType,");//会员类型
//		sql.append("tmStatus ");//状态
//		sql.append("FROM ");
//		sql.append("(SELECT tm_id tmId, tm_real_name tmRealName,tm_account tmAccount,tm_phone tmPhone,type tmType,tm_status tmStatus FROM tb_member ");
//		sql.append("UNION ALL ");
//		sql.append("SELECT ts_id tsId, ts_name tmName,ts_account tmAccount,ts_contac_mobile tmPhone,type tmType,ts_status tmStatus FROM tb_sales ");
//		sql.append("UNION ALL ");
//		sql.append("SELECT tc_id tcId, tc_name tmName,tw_account tmAccount,tw_phone tmPhone,type tmType,tw_status tmStatus FROM tb_company)");
//		sql.append("AS tm ");
//		sql.append("WHERE tmStatus = 1 ");
//
		if (!StringUtils.isBlank(tmType)) {
			sql.append("AND tm_type = '"+tmType+"' ");
		}
		if (!StringUtils.isBlank(tmAccount)) {
			sql.append("AND tm_account like '%"+tmAccount+"%'");
		}
		//根据省市区查询
		if (!StringUtils.isBlank(pid)) {
			sql.append(" and tm_province_id  = "+pid);
			if (!StringUtils.isBlank(cid)) {
				sql.append(" and tm_city_id  = "+cid);
				if (!StringUtils.isBlank(oid)) {
					sql.append(" and tm_county_id  = "+oid);
				}
			}
			
		}

		if (pageSize == 0) {
			List<Map<String, Object>> list = tbMessageDao.searchForMap(sql.toString(), null);
			json.put("total", list.size());
			json.put("rows", list);
			return json;
		}else {
			PageBean<Map<String, Object>> pageBean = new PageBean<Map<String, Object>>(page, pageSize);
			pageBean = tbMessageDao.searchForMap(sql.toString(), null, pageBean);
			
			json.put("total", pageBean.getRowCount());
			json.put("rows", pageBean.getList());
			return json;
		}
	}

	@Override
	public List<Map<String, Object>> findMessage(String tmId,String page) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select m.* ");
		sbSql.append("from tb_message m ");
		sbSql.append("where m.tm_member_id = '"+tmId+"' ");
		sbSql.append("and m.tm_status <> 0 ORDER BY m.tm_addtime DESC ");
		if(!StringUtils.isBlank(page))
			sbSql.append("LIMIT "+(Integer.parseInt(page)-1)*10+","+10);
		
		return tbMessageDao.searchForMap(sbSql.toString(), null);
	}

	@Override
	public void deleteMessage(String tmId,  String messageId) {//接收人类型 
        StringBuffer sbSql = new StringBuffer();
        sbSql.append("UPDATE `tb_message` SET `tm_status` = 0 WHERE 1=1 ");
		if (!StringUtils.isBlank(messageId))
			sbSql.append("AND `tm_id` IN("+messageId+") ");
		if (!StringUtils.isBlank(tmId))
			sbSql.append("AND `tm_member_id` = "+tmId+" ");
		tbMessageDao.update(sbSql.toString(),null);
	}
	
	
	@Override
	public List<Map<String,Object>> messageIsNotRead(String tmId) {//接收人类型 
        StringBuffer sbSql = new StringBuffer();
        sbSql.append("SELECT COUNT(1) AS count FROM tb_message WHERE tm_status=1 AND tm_member_id="+tmId);
		return tbMessageDao.searchForMap(sbSql.toString(), null);
	}
	
	

	@Override
	public void updateMessage(String messageId) throws Exception {
		StringBuffer sbSql = new StringBuffer();
        sbSql.append("UPDATE `tb_message` SET `tm_status` = 2 WHERE 1=1 ");
		if (!StringUtils.isBlank(messageId))
			sbSql.append("AND `tm_id` IN("+messageId+") ");
		tbMessageDao.update(sbSql.toString(),null);
	}

	@Override
	public List<Map<String, Object>> findMessageList(String tmId, String type, String page, String pageSize) {
		//创建sql参数集合
		List<Object> values=new ArrayList<Object>();
		//创建sql语句
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT a.* FROM tb_message a LEFT JOIN tb_member_info b ON tm_member_id = tmi_id ");
		sql.append("  WHERE tm_status <> 0 AND tmi_status=1  ");
		sql.append("AND tm_member_id=? ");
		values.add(tmId);
//		sql.append("AND tmi_type=? ");
//		values.add(type);
		sql.append(" ORDER BY tm_add_date DESC ");
		if(!StringUtil.isEmptyNull(page)){
			sql.append( " LIMIT "+(Integer.valueOf(page)-1)*Integer.valueOf(pageSize)+" , "+pageSize );
		}
		return tbMessageDao.searchForMap(sql.toString(), values);
	}

	@Override
	public List<Map<String, Object>> findMessageListByTmId(String tmId) {
		//创建sql参数集合
		List<Object> values=new ArrayList<Object>();
		//创建sql语句
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM tb_message WHERE tm_status <> 0 ");
		sql.append("AND tm_id=? ");
		values.add(tmId);
		return tbMessageDao.searchForMap(sql.toString(), values);
	}
}

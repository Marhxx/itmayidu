package com.spring.api.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.api.dao.TbInformationCommentDao;
import com.spring.api.entity.TbInformationComment;
import com.spring.api.service.TbInformationCommentService;
import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
/**
 * @author zhangzhenya
 *	资讯评论
 * @date 2018年8月21日 
 */
@Service
public class TbInformationCommentServiceImpl extends BaseServiceImpl<TbInformationComment, Long> implements TbInformationCommentService {
	@Resource
	private TbInformationCommentDao tbInformationCommentDao;
	@Override
	public BaseDao<TbInformationComment, Long> getGenericDao() {
		// TODO Auto-generated method stub
		return tbInformationCommentDao;
	}
	
	@Override
	public List<Map<String, Object>> getInformationCommentByTicId(String ticInfoId,String pageId, String pageCount) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select t2.*,t3.tmi_nick_name,t3.tmi_icon ,t3.tmi_desp ");
		sbSql.append(" from tb_information t1,tb_information_comment t2,tb_member_info t3 ");
		sbSql.append(" where t1.ti_id=t2.tic_infor_id ");
		sbSql.append(" and t2.tic_member_id=t3.tmi_id ");
		sbSql.append(" and t2.tic_parent_id=0 ");
		sbSql.append(" and t2.tic_infor_id= "+ ticInfoId);
		sbSql.append(" and  t1.ti_status =1 ");
		sbSql.append(" and t2.tic_status=1  ");
		sbSql.append(" ORDER BY tic_add_date DESC ");
		sbSql.append(" limit "+ (Integer.parseInt(pageId)-1)*Integer.parseInt(pageCount)+ ","+ pageCount);
		logger.debug(sbSql.toString());
		List<Map<String, Object>> listTbInforComment = tbInformationCommentDao.searchForMap(sbSql.toString(),null);
		return listTbInforComment;
	}

	@Override
	public List<Map<String, Object>> getInformationChildCommentByTicId(String ticInfoId, String parentId, String pageId,
			String pageCount) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select t2.*,t3.tmi_nick_name,t3.tmi_icon ,t3.tmi_desp ");
		sbSql.append(" from tb_information t1,tb_information_comment t2,tb_member_info t3 ");
		sbSql.append(" where t1.ti_id=t2.tic_infor_id ");
		sbSql.append(" and t2.tic_member_id=t3.tmi_id ");
		sbSql.append(" and t2.tic_parent_id= "+parentId);
		sbSql.append(" and t2.tic_infor_id= "+ ticInfoId);
		sbSql.append(" and  t1.ti_status =1 ");
		sbSql.append(" and t2.tic_status=1 ");
		sbSql.append(" ORDER BY tic_add_date DESC ");
		sbSql.append(" limit "+ (Integer.parseInt(pageId)-1)*Integer.parseInt(pageCount)+ ","+ pageCount);
		logger.debug(sbSql.toString());
		List<Map<String, Object>> listTbChildInforComment = tbInformationCommentDao.searchForMap(sbSql.toString(),null);
		return listTbChildInforComment;
	}

	@Override
	public List<Map<String, Object>> getInfoCommentCount(String ticInfoId) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select count(*) as count");
		sbSql.append(" from tb_information t1,tb_information_comment t2 ");
		sbSql.append(" where t1.ti_id=t2.tic_infor_id ");
		sbSql.append(" and t2.tic_infor_id= "+ ticInfoId);
		sbSql.append(" and  t1.ti_status =1 ");
		sbSql.append(" and t2.tic_status=1 ");
		logger.debug(sbSql.toString());
		return tbInformationCommentDao.searchForMap(sbSql.toString(), null);
	}

	@Override
	public List<Map<String, Object>> getChildInfoCommentCount(String ticInfoId, String parentId) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select count(*) as childCount");
		sbSql.append(" from tb_information t1,tb_information_comment t2,tb_member_info t3 ");
		sbSql.append(" where t1.ti_id=t2.tic_infor_id ");
		sbSql.append(" and t2.tic_member_id=t3.tmi_id ");
		sbSql.append(" and t2.tic_parent_id= "+parentId);
		sbSql.append(" and t2.tic_infor_id= "+ ticInfoId);
		sbSql.append(" and  t1.ti_status =1 ");
		sbSql.append(" and t2.tic_status=1  ");
		logger.debug(sbSql.toString());
		return tbInformationCommentDao.searchForMap(sbSql.toString(), null);
	}

	@Override
	public List<TbInformationComment> getInfoCommentByParentId(String ticInfoId, String parentId) {
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("select * ");
		sbSql.append(" from tb_information t1,tb_information_comment t2 ");
		sbSql.append(" where t2.tic_parent_id= "+parentId);
		sbSql.append(" and t2.tic_infor_id= "+ ticInfoId);
		sbSql.append(" and  t1.ti_status =1 ");
		sbSql.append(" and t2.tic_status=1  ");
		logger.debug(sbSql.toString());
		return tbInformationCommentDao.search(sbSql.toString(), null);
	}

}

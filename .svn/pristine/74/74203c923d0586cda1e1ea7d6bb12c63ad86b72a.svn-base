package com.spring.api.service;

import java.util.List;
import java.util.Map;

import com.spring.api.entity.TbInformationComment;
import com.spring.base.service.BaseService;

public interface TbInformationCommentService extends BaseService<TbInformationComment, Long>{
	//获取父级评论信息
	public List<Map<String,Object>> getInformationCommentByTicId(String ticInfoId,String pageId, String pageCount);
	//获取子级评论信息
	public List<Map<String,Object>> getInformationChildCommentByTicId(String ticInfoId,String parentId,String pageId, String pageCount);
	//所有评价数
	public List<Map<String, Object>> getInfoCommentCount(String ticInfoId);
	//父级下面的子评价数
	public List<Map<String, Object>> getChildInfoCommentCount(String ticInfoId,String parentId);
	//查询父类id是否存在
	public List<TbInformationComment> getInfoCommentByParentId(String ticInfoId,String parentId);
	
}

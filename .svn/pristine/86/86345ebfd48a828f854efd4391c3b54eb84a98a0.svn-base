package com.spring.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.common.dao.GroupandmenuDao;
import com.spring.common.dao.SysmenuDao;
import com.spring.common.dao.UserandmenuDao;
import com.spring.common.entity.MenuTree;
import com.spring.common.entity.Sysmenu;
import com.spring.common.entity.Userinfo;
import com.spring.common.service.SysmenuService;
import com.spring.common.service.UserandmenuService;

@Service("sysmenuService")
public class SysmenuServiceImpl extends BaseServiceImpl<Sysmenu, Integer> implements
		SysmenuService {

	@Resource SysmenuDao sysmenuDao;
	@Resource UserandmenuDao userandmenuDao;
	@Resource GroupandmenuDao groupandmenuDao;
	
	@Override
	public BaseDao<Sysmenu, Integer> getGenericDao() {
		return sysmenuDao;
	}

	public List<MenuTree> convertTrees(List<Sysmenu> menus) {
		
		List<MenuTree> list = new ArrayList<MenuTree>();
		
		if (menus!=null && menus.size()>0) {
			for (Sysmenu menu : menus) {
				MenuTree tree = new MenuTree();
				tree.setId(menu.getId());
				tree.setText(menu.getName());
				tree.setState("open");
				tree.setChecked(false);
				tree.setParendId(menu.getParentId());
				HashMap<String, String> attr = new HashMap<String, String>();
				attr.put("url", menu.getUrl());
				tree.setAttributes(attr);
				list.add(tree);
			}
		}
		
		return list;
	}

	@Override
	public List<MenuTree> findMenuByUser(Userinfo userInfo) {
		List<MenuTree> menus = new ArrayList<MenuTree>();
		if (userInfo.getCode()!=null && "admin".equals(userInfo.getCode())) {
			List<Sysmenu> list = sysmenuDao.search("select * from sysmenu where parentId = 0 order by sortCode asc", null);
			menus = convertTrees(list);
			if (menus!=null && menus.size()>0) {
				for (MenuTree tree : menus) {
					List<Sysmenu> childList = sysmenuDao.searchp("select * from sysmenu where parentId = ? order by sortCode asc", tree.getId());
					if (childList!=null && childList.size()>0) {
						tree.setChildren(convertTrees(childList));
					}
				}
			}
		}else {
//			String sql = "SELECT sm.id as mId,sm.parent_id,sm.`name` as mName,sm.url FROM sysmenu sm LEFT JOIN userandmenu um ON sm.id = um.menu_id WHERE 1=1 AND sm.parent_id = ? AND um.user_id = ? ORDER BY sm.sort_code ASC";
//			Query query = em.createNativeQuery(sql);
//			query.setParameter(1, 0);
//			query.setParameter(2, userInfo.getId()); 
//			List<Object[]> list = query.getResultList();
//			
//			if (list!=null && list.size()>0) {
//				for (Object[] objects : list) {
//					String sql2 = "SELECT sm.id as mId,sm.parent_id,sm.`name` as mName,sm.url FROM sysmenu sm LEFT JOIN userandmenu um ON sm.id = um.menu_id WHERE 1=1 AND sm.parent_id = ? AND um.user_id = ? ORDER BY sm.sort_code ASC";
//					Query query2 = em.createNativeQuery(sql2);
//					query2.setParameter(1, objects[0]);
//					query2.setParameter(2, userInfo.getId());
//					List<Object[]> childList = query2.getResultList();
//					if (childList!=null && childList.size()>0) {
//						Menu menu = new Menu(Long.parseLong(objects[0].toString()), Long.parseLong(objects[1].toString()), 
//								objects[2].toString(), objects[3].toString());
//						List<Menu> childMenus = new ArrayList<Menu>();
//						for (Object[] objects2 : childList) {
//							Menu childMenu = new Menu(Long.parseLong(objects2[0].toString()), Long.parseLong(objects2[1].toString()), 
//									objects2[2].toString(), objects2[3].toString());
//							HashMap<String, String> attributes = new HashMap<String, String>();
//							attributes.put("url", objects2[3].toString());
//							childMenu.setAttributes(attributes);
//							childMenus.add(childMenu);
//						}
//						menu.setChildren(childMenus);
//						menus.add(menu);
//					}
//				}
//			}
		}
		return menus;
	}

	@Override
	public List<Sysmenu> list(Map<String, Object> params) {
		
		String sql = "select * from sysmenu where 1 = 1";
		List<Object> values = new ArrayList<Object>();
		
		Object parentId = params.get("parentId");
		
		if (parentId !=null && parentId.equals("-1")) {
			
			List<Sysmenu> list = sysmenuDao.search("select * from sysmenu where parentId = 0 order by sortCode asc",null);
			if (list!=null && list.size()>0) {
				for (Sysmenu sysmenu : list) {
					List<Sysmenu> childList = sysmenuDao.searchp("select * from sysmenu where parentId = ? order by sortCode asc", sysmenu.getId());
					sysmenu.setChildren(childList);
				}
			}
			
			return list;
		}else {
			sql += " and parentId = ?";
			values.add(parentId);
			sql += " order by sortCode asc";
			
			List<Sysmenu> list = sysmenuDao.search(sql,values);
			return list;
		}
		
	}

	@Override
	public void del(Integer id) {
		userandmenuDao.delp("delete from userandmenu where menu_id = ?", id);
		groupandmenuDao.delp("delete from groupandmenu where menuId = ?", id);
		sysmenuDao.del(id);
	}
	
}

package com.spring.common.service.impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.spring.base.dao.BaseDao;
import com.spring.base.service.impl.BaseServiceImpl;
import com.spring.base.shiro.ShiroUser;
import com.spring.common.dao.SysmenuDao;
import com.spring.common.dao.UserandmenuDao;
import com.spring.common.entity.Sysmenu;
import com.spring.common.entity.Userandmenu;
import com.spring.common.service.UserandmenuService;

@Service("userandmenuService")
public class UserandmenuServiceImpl extends BaseServiceImpl<Userandmenu, Long> implements
		UserandmenuService {

	@Resource UserandmenuDao userandmenuDao;
	@Resource SysmenuDao sysmenuDao;
	
	@Override
	public BaseDao<Userandmenu, Long> getGenericDao() {
		return userandmenuDao;
	}

	@Override
	public List<Userandmenu> findList(Long userId) {
		// TODO Auto-generated method stub
		return userandmenuDao.searchp("select * from userandmenu where user_id = ?", userId);
	}
	
	@Override
	public void addPerms(String menuIds, String btnIds, String userId) {
		
		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPreviousPrincipals().getPrimaryPrincipal();
		
		
		String menuIdArray[] = menuIds.split(",");
		for (String id : menuIdArray) {
			if (!StringUtils.isBlank(id)) {
				
				//删除菜单权限配置
				userandmenuDao.delp("delete from userandmenu where type = 0 and user_id = ? and menu_id = ?", 
						Integer.parseInt(userId),Long.parseLong(id));
				
				//添加菜单权限配置
				Userandmenu userandmenu = new Userandmenu();
				userandmenu.setAddtime(new Timestamp(new Date().getTime()));
				userandmenu.setAddUserId(shiroUser.getId());
				userandmenu.setAddUsername(shiroUser.getAccount());
				userandmenu.setMenuId(Integer.parseInt(id));
				userandmenu.setType(0);//0表示保存的事菜单配置
				userandmenu.setUserId(Long.parseLong(userId));
				userandmenuDao.save(userandmenu);
				
			}
		}
		
		String btnIdArray[] = menuIds.split(",");
		for (String id : btnIdArray) {
			if (!StringUtils.isBlank(id)) {
				//删除按钮权限配置
				userandmenuDao.delp("delete from userandmenu where type = 1 and user_id = ? and menu_id = ?", 
						Integer.parseInt(userId),Long.parseLong(id));
				
				//添加按钮权限配置
				Userandmenu userandmenu = new Userandmenu();
				userandmenu.setAddtime(new Timestamp(new Date().getTime()));
				userandmenu.setAddUserId(shiroUser.getId());
				userandmenu.setAddUsername(shiroUser.getAccount());
				userandmenu.setMenuId(Integer.parseInt(id));
				userandmenu.setType(1);//1表示保存的是按钮配置
				userandmenu.setUserId(Long.parseLong(userId));
				userandmenuDao.save(userandmenu);
				
			}
		}
	}

	@Override
	public void delByMenu(Integer menuId) {
		userandmenuDao.delp("delete from userandmenu where menu_id = ?", menuId);
	}

	@Override
	public List<Sysmenu> list(String userId) {
		List<Sysmenu> list = sysmenuDao.search("select * from sysmenu where parentId = 0 order by sortCode asc", null);
		for (Sysmenu sysmenu : list) {
			List<Sysmenu> childList = sysmenuDao.searchp("select * from sysmenu where parentId = ? order by sortCode asc", sysmenu.getId());
			int count = userandmenuDao.getInt("select count(*) from userandmenu where type = 0 and user_id = ? and menu_id = ?", Integer.parseInt(userId),sysmenu.getId());
			if(count>0) sysmenu.setChecked(true);
			if (childList!=null && childList.size()>0) {
				for (Sysmenu child : childList) {
					int childCount = userandmenuDao.getInt("select count(*) from userandmenu where type = 0 and user_id = ? and menu_id = ?", Integer.parseInt(userId),child.getId());
					if(childCount>0) child.setChecked(true);
					
					List<Sysmenu> btnList = sysmenuDao.searchp("select * from sysmenu where parentId = ? order by sortCode asc", child.getId());
					if (btnList!=null && btnList.size()>0) {
						for (Sysmenu btn : btnList) {
							int btnCount = userandmenuDao.getInt("select count(*) from userandmenu where type = 1 and user_id = ? and menu_id = ?", Integer.parseInt(userId),btn.getId());
							if(btnCount>0) btn.setChecked(true);
						}
						child.setChildren(btnList);
					}
				}
				sysmenu.setChildren(childList);
				
			}
			
		}
		return list;
	}

}

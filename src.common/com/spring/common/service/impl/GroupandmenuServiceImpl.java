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
import com.spring.common.dao.GroupandmenuDao;
import com.spring.common.dao.SysbuttonsDao;
import com.spring.common.dao.SysmenuDao;
import com.spring.common.entity.Groupandmenu;
import com.spring.common.entity.Sysmenu;
import com.spring.common.service.GroupandmenuService;

@Service("groupandmenuService")
public class GroupandmenuServiceImpl extends BaseServiceImpl<Groupandmenu, Long> implements
		GroupandmenuService {

	@Resource GroupandmenuDao groupandmenuDao;
	@Resource SysmenuDao sysmenuDao;
	@Resource SysbuttonsDao sysbuttonsDao;
	
	@Override
	public BaseDao<Groupandmenu, Long> getGenericDao() {
		return groupandmenuDao;
	}

	@Override
	public void addPerms(String menuIds, String btnIds, String groupId) {
		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPreviousPrincipals().getPrimaryPrincipal();
		
		String menuIdArray[] = menuIds.split(",");
		for (String id : menuIdArray) {
			if (!StringUtils.isBlank(id)) {
				//删除菜单权限配置
				groupandmenuDao.delp("delete from groupandmenu where type = 0 and groupId = ? and menuId = ?", 
						Integer.parseInt(groupId),Long.parseLong(id));
				
				//添加菜单权限配置
				Groupandmenu t = new Groupandmenu();
				t.setAddtime(new Timestamp(new Date().getTime()));
				t.setAddUserId(shiroUser.getId());
				t.setAddUsername(shiroUser.getAccount());
				t.setGroupId(Integer.parseInt(groupId));
				t.setMenuId(Integer.parseInt(id));
				t.setType(0);//0表示保存的事菜单配置
				groupandmenuDao.save(t);
				
			}
		}
		
		String btnIdArray[] = menuIds.split(",");
		for (String id : btnIdArray) {
			if (!StringUtils.isBlank(id)) {
				
				//删除按钮权限配置
				groupandmenuDao.delp("delete from groupandmenu where type = 1 and groupId = ? and menuId = ?", 
						Integer.parseInt(groupId),Long.parseLong(id));
				
				//添加按钮权限配置
				Groupandmenu t = new Groupandmenu();
				t.setAddtime(new Timestamp(new Date().getTime()));
				t.setAddUserId(shiroUser.getId());
				t.setAddUsername(shiroUser.getAccount());
				t.setGroupId(Integer.parseInt(groupId));
				t.setMenuId(Integer.parseInt(id));
				t.setType(1);//1表示保存的是按钮配置
				groupandmenuDao.save(t);
				
			}
		}
		
	}

	@Override
	public List<Sysmenu> list(String grouId) {
		
		List<Sysmenu> list = sysmenuDao.search("select * from sysmenu where parentId = 0 order by sortCode asc", null);
		for (Sysmenu sysmenu : list) {
			List<Sysmenu> childList = sysmenuDao.searchp("select * from sysmenu where parentId = ? order by sortCode asc", sysmenu.getId());
			int count = groupandmenuDao.getInt("select count(*) from groupandmenu where type = 0 and groupId = ? and menuId = ?", Integer.parseInt(grouId),sysmenu.getId());
			if(count>0) sysmenu.setChecked(true);
			if (childList!=null && childList.size()>0) {
				for (Sysmenu child : childList) {
					int childCount = groupandmenuDao.getInt("select count(*) from groupandmenu where type = 0 and groupId = ? and menuId = ?", Integer.parseInt(grouId),child.getId());
					if(childCount>0) child.setChecked(true);
					
					List<Sysmenu> btnList = sysmenuDao.searchp("select * from sysmenu where parentId = ? order by sortCode asc", child.getId());
					if (btnList!=null && btnList.size()>0) {
						for (Sysmenu btn : btnList) {
							int btnCount = groupandmenuDao.getInt("select count(*) from groupandmenu where type = 1 and groupId = ? and menuId = ?", Integer.parseInt(grouId),btn.getId());
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

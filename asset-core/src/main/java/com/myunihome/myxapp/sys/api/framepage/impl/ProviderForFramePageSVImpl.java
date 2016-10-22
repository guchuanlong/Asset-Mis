package com.myunihome.myxapp.sys.api.framepage.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.StringUtil;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnMenu;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenu;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystem;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystemKey;
import com.myunihome.myxapp.sso.service.IMenuService;
import com.myunihome.myxapp.sso.service.IRoleService;
import com.myunihome.myxapp.sso.service.ITabSystemService;
import com.myunihome.myxapp.sys.api.framepage.interfaces.IProviderForFramePageSV;
import com.myunihome.myxapp.sys.api.framepage.param.Menu;
import com.myunihome.myxapp.sys.api.framepage.param.MenuQuery;
import com.myunihome.myxapp.sys.api.framepage.param.SystemContext;
import com.myunihome.myxapp.sys.api.framepage.param.SystemContextQuery;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

@Service
@Component
public class ProviderForFramePageSVImpl implements IProviderForFramePageSV {

	@Autowired
	IRoleService iRoleService;

	@Autowired
	IMenuService iMenuService;

	@Autowired
	ITabSystemService tabSystemService;

	@Override
	public List<Menu> queryFirstLevelMenusByLimited(MenuQuery query) throws CallerException {
		return queryMenusByLimited(query);
	}

	@Override
	public List<Menu> querySubMenusByLimited(MenuQuery query) throws CallerException {
		return queryMenusByLimited(query);
	}

	private List<Menu> queryMenusByLimited(MenuQuery query) {
		List<Menu> menus = null;
		if (query != null) {
			Long operId = query.getOperId();
			String tenantId = query.getTenantId();
			String systemId = query.getSystemId();
			String systemModeId = query.getSystemModeId();
			Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
			if (tenantId != null) {
				List<GnOperRole> gnOperRoles = iRoleService.getRolesByOperId4FramePage(operId, tenantId, systemId, systemModeId);
				if (gnOperRoles != null && gnOperRoles.size() > 0) {
					List<Long> roleIdList = new ArrayList<Long>();
					for (int i = 0; i < gnOperRoles.size(); i++) {
						roleIdList.add(gnOperRoles.get(i).getRoleId());
					}
					if (roleIdList.size() > 0) {
						List<GnRoleMenu> gnRolemenus = iRoleService.getMenuByRole(roleIdList, tenantId);
						if (gnRolemenus.size() > 0) {
							List<Long> menuIds = new ArrayList<Long>();
							// 过滤掉重复的menuId
							for (int i = 0; i < gnRolemenus.size(); i++) {
								long menuId = gnRolemenus.get(i).getMenuId();
								if (menuIds.indexOf(menuId) == -1) {
									menuIds.add(menuId);
								}
							}

							// 根据menuId,获取菜单完整信息
							if (menuIds.size() > 0) {
								GnMenu param = new GnMenu();
								param.setTenantId(tenantId);
								param.setSystemId(systemId);
								param.setSystemModeId(systemModeId);
								param.setActiveTime(currTimestamp);
								param.setInactiveTime(currTimestamp);
								List<GnMenu> gnMenus = iMenuService.getFramePageMenuByConditon(menuIds, param);
								if (query.getMenuPid() != null && query.getMenuPid() != 0) {
									menus = populateFramePageMenuList(query.getMenuPid(), gnMenus);
								} else {
									menus = populateFramePageMenuList(-1, gnMenus);
								}
								if (menus.size() > 0) {
									return menus;
								}
							}
						}
					}
				}
			}
		}
		return menus;
	}

	private List<Menu> populateFramePageMenuList(long pid, List<GnMenu> list) {
		List<Menu> munuList = new ArrayList<Menu>();
		for (GnMenu vo : list) {
			if (vo.getMenuPid() == pid) {
				Menu menuVo = new Menu();
				menuVo.setMenuId(vo.getMenuId());
				menuVo.setMenuName(vo.getMenuName());
				menuVo.setMenuDesc(vo.getMenuDesc());
				menuVo.setMenuPid(vo.getMenuPid());
				menuVo.setMenuUrl(vo.getMenuUrl());
				menuVo.setMenuPic(vo.getMenuPic());
				menuVo.setSystemId(vo.getSystemId());
				menuVo.setSystemModeId(vo.getSystemModeId());
				// 查询菜单上下文context
				GnTabSystemKey tabSystemKey = new GnTabSystemKey();
				tabSystemKey.setTenantId(vo.getTenantId());
				tabSystemKey.setSystemId(vo.getSystemId());
				GnTabSystem tabSystem = tabSystemService.getGnTabSystem(tabSystemKey);
				if (tabSystem != null && !StringUtil.isBlank(tabSystem.getSystemUrlContext())) {
					menuVo.setSystemUrlContext(tabSystem.getSystemUrlContext());
				} else {
					menuVo.setSystemUrlContext("");
				}
				menuVo.setSubMenus(populateFramePageMenuList(menuVo.getMenuId().longValue(), list));
				munuList.add(menuVo);
			}
		}

		return munuList;

	}

	@Override
	public List<SystemContext> querySystemContextList(SystemContextQuery query) throws CallerException {
		List<SystemContext> systemContextList = null;
		if (StringUtils.isNotEmpty(query.getTenantId())) {
			GnTabSystemKey tabSystemKey = new GnTabSystemKey();
			BeanUtils.copyProperties(tabSystemKey, query);
			List<GnTabSystem> gnTabSystemList = tabSystemService.queryGnTabSystemList(tabSystemKey);
			if (gnTabSystemList != null && gnTabSystemList.size() > 0) {
				systemContextList = new LinkedList<SystemContext>();
				for (GnTabSystem gnTabSystem : gnTabSystemList) {
					SystemContext systemContext = new SystemContext();
					BeanUtils.copyProperties(systemContext, gnTabSystem);
					systemContextList.add(systemContext);
				}
			}
		}
		return systemContextList;

	}

	// private void validateQuerySystemContextList(SystemContextQuery query) {
	// String errorMessage = "";
	// if(query==null){
	// errorMessage +="查询参数对象不能为空！";
	// }else{
	// String tenantId = query.getTenantId();
	// if(StringUtils.isEmpty(tenantId)){
	// errorMessage +="租户ID（tenantId）不能为空！";
	// }
	// }
	// if(StringUtils.isNotEmpty(errorMessage)){
	// throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMessage);
	// }
	// }

}

package com.myunihome.myxapp.sso.api.menu.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.menu.interfaces.IGetMenuByOperidSV;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByConditionVO;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByOperIDVO;
import com.myunihome.myxapp.sso.api.menu.param.GnParamsVO;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenu;
import com.myunihome.myxapp.sso.service.IMenuService;
import com.myunihome.myxapp.sso.service.IRoleService;

@Service
@Component
public class GetMenuByOperidSVImpl implements IGetMenuByOperidSV {

	@Autowired
	IRoleService iRoleService;

	@Autowired
	IMenuService iMenuService;

	@Override
	public List<GetMenuByOperIDVO> getMenuByOperID(Long staffnoId, String tenantId) throws CallerException {
		List<GetMenuByOperIDVO> menus = null;

		List<GnOperRole> gnOperRoles = iRoleService.getRolesByOperId(staffnoId, tenantId);
		if (gnOperRoles.size() > 0) {
			List<Long> operRolesId = new ArrayList<Long>();
			for (int i = 0; i < gnOperRoles.size(); i++) {
				operRolesId.add(gnOperRoles.get(i).getRoleId());
			}
			if (operRolesId.size() > 0) {
				List<GnRoleMenu> gnRolemenus = iRoleService.getMenuByRole(operRolesId, tenantId);
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
						menus = iMenuService.getMenuByMenuId(menuIds, tenantId);
						if (menus.size() > 0) {
							return menus;
						}
					}
				}
			}
		}

		return menus;
	}

	@Override
	public List<GetMenuByConditionVO> getMenuByCondition(GnParamsVO paramsVO)  throws CallerException{
		List<GetMenuByConditionVO> menus = null;

		if (paramsVO != null) {
			Long operId = paramsVO.getOperId();
			String tenantId = paramsVO.getTenantId();
			String systemModeId = paramsVO.getSystemModeId();

			if (tenantId != null) {

				List<GnOperRole> gnOperRoles = iRoleService.getRolesByOperId(operId, tenantId, systemModeId);
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
								menus = iMenuService.getMenuByConditon(menuIds, tenantId, systemModeId);
								if (menus.size() > 0) {
									/*
									 * menus = createMenuTree(menus); JSONArray
									 * menuInfos = JSONArray.fromObject(menus);
									 * return menuInfos.toString();
									 */
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

	/**
	 * 构建菜单分级
	 * 
	 * @param menuList
	 * @return
	 */
	public List<GetMenuByOperIDVO> createMenuTree(List<GetMenuByOperIDVO> menuList) {
		List<GetMenuByOperIDVO> nodeList = new ArrayList<GetMenuByOperIDVO>();
		for (GetMenuByOperIDVO menu1 : menuList) {
			boolean mark = false;
			for (GetMenuByOperIDVO menu2 : menuList) {
				if (menu1.getMenuPid() == menu2.getMenuId()) {
					mark = true;
					if (menu2.getChildMenu() == null) {
						menu2.setChildMenu(new ArrayList<GetMenuByOperIDVO>());
					}
					menu2.getChildMenu().add(menu1);
					break;
				}
			}
			if (!mark) {
				nodeList.add(menu1);
			}
		}
		return nodeList;
	}

}

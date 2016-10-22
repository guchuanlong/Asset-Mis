package com.myunihome.myxapp.sys.api.sysrolemenu.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.constants.Constants.ResponseState;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenu;
import com.myunihome.myxapp.sso.service.IMenuService;
import com.myunihome.myxapp.sso.service.IRoleMenuService;
import com.myunihome.myxapp.sys.api.sysrolemenu.interfaces.IGnRoleMenuManageSV;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuParamsVO;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuResponseVO;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Service
@Component
public class GnRoleMenuManageSVImpl implements IGnRoleMenuManageSV {

	private static final Logger LOGGER = LoggerFactory.getLogger(GnRoleMenuManageSVImpl.class);

	@Autowired
	IRoleMenuService roleMenuService;
	@Autowired
	IMenuService menuService;

	@Override
	public Long addMenuToRole(GnRoleMenuParamsVO roleMenuParamsVO) throws CallerException {
		LOGGER.info("角色赋予菜单权限服务addMenuToRole方法参数列表：" + JSONObject.fromObject(roleMenuParamsVO));

		String msg = null;
		Long roleMenuRelId = null;
		if (roleMenuParamsVO != null) {
			if (StringUtils.isEmpty(roleMenuParamsVO.getTenantId())) {
				msg = "租户编码[tenantId]不能为空！";
			} else if (roleMenuParamsVO.getRoleId() == null) {
				msg = "角色id[roleId]不能为空！";
			} else if (roleMenuParamsVO.getMenuId() == null) {
				msg = "菜单id[menuId]不能为空！";
			} else {
				GnRoleMenu gnRoleMenu = new GnRoleMenu();
				BeanUtils.copyProperties(gnRoleMenu, roleMenuParamsVO);
				roleMenuRelId = roleMenuService.addMenuToRole(gnRoleMenu);
			}
			if (msg != null) {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}

		return roleMenuRelId;
	}

	@Override
	public PageInfo<GnRoleMenuVO> queryMenuByRole(GnRoleMenuParamsVO roleMenuParamsVO) throws CallerException {
		LOGGER.info("角色拥有菜单列表服务queryMenuByRole方法参数列表：" + JSONObject.fromObject(roleMenuParamsVO));

		PageInfo<GnRoleMenu> pageInfo = null;
		if (roleMenuParamsVO != null) {
			if (StringUtils.isEmpty(roleMenuParamsVO.getTenantId())) {
				LOGGER.error("tenantId不能为空！");
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, "tenantId不能为空！");
			} else {
				// roleMenuParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
				pageInfo = roleMenuService.queryMenuByRole(roleMenuParamsVO);
			}
		}

		PageInfo<GnRoleMenuVO> resultPage = new PageInfo<GnRoleMenuVO>();
		if (pageInfo != null) {
			resultPage.setPageNo(pageInfo.getPageNo());
			resultPage.setPageSize(pageInfo.getPageSize());
			resultPage.setCount(pageInfo.getCount());

			List<GnRoleMenuVO> gnRoleMenuVOList = new ArrayList<GnRoleMenuVO>();
			if (!CollectionUtil.isEmpty(pageInfo.getResult())) {
				Gson gson = new Gson();
				gnRoleMenuVOList = gson.fromJson(gson.toJson(pageInfo.getResult()), new TypeToken<List<GnRoleMenuVO>>() {
				}.getType());
			}
			resultPage.setResult(gnRoleMenuVOList);
		}

		return resultPage;
	}

	// @Override
	// public PageInfo<GnMenuVO> queryMenuFilterIds(GnRoleMenuParamsVO
	// roleMenuParamsVO, GnMenuParamsVO menuParamsVO) {
	// LOGGER.info("角色菜单服务 queryMenuFilterIds方法参数列表：" +
	// JSONObject.fromObject(roleMenuParamsVO));
	// PageInfo<GnMenuVO> pageInfo = new PageInfo<GnMenuVO>();
	// String errorMsg = "";
	// if (StringUtils.isEmpty(roleMenuParamsVO.getTenantId())) {
	// errorMsg += "GnRoleMenuParamsVO : tenantId 不能为空！";
	// }
	// if (roleMenuParamsVO.getRoleId() == null) {
	// errorMsg += "GnRoleMenuParamsVO : roleId 不能为空！";
	// }
	// if (StringUtils.isEmpty(menuParamsVO.getTenantId())) {
	// errorMsg += "GnMenuParamsVO : tenantId 不能为空！";
	// }
	// if ("".equals(errorMsg)) {
	// // 通过角色id获得拥有的菜单id list
	// List<Long> menuIdList = getMenuIdListByOperId(roleMenuParamsVO);
	// // 设置条件
	// menuParamsVO.setFilterMenuIdList(menuIdList);
	// // menuParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
	// // 获得操作员可赋角色列表
	// pageInfo = menuService.getMenuFilterIds(menuParamsVO);
	// } else {
	// LOGGER.error("橘色可赋菜单查询失败：" + errorMsg);
	// }
	// return pageInfo;
	// }
	//
	// /**
	// * 通过角色id获得拥有的菜单id list
	// *
	// * @param roleMenuParamsVO
	// */
	// private List<Long> getMenuIdListByOperId(GnRoleMenuParamsVO
	// roleMenuParamsVO) {
	// List<Long> menuIdList = new LinkedList<Long>();
	// // roleMenuParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
	// List<GnRoleMenu> roleMenuList =
	// roleMenuService.queryMenuListByRoleId(roleMenuParamsVO);
	// if (roleMenuList != null && roleMenuList.size() > 0) {
	// for (GnRoleMenu roleMenu : roleMenuList) {
	// Long menuId = roleMenu.getMenuId();
	// if (menuId != null) {
	// menuIdList.add(menuId);
	// }
	// }
	// }
	// return menuIdList;
	// }

	@Override
	public GnRoleMenuResponseVO deleteRoleMenu(GnRoleMenuParamsVO roleMenuParamsVO) throws CallerException {
		LOGGER.info("角色菜单服务 deleteRoleMenu方法参数列表：" + JSONObject.fromObject(roleMenuParamsVO));
		GnRoleMenuResponseVO gnRoleMenuResponseVO = new GnRoleMenuResponseVO();
		String errorMsg = "";
		String tenantId = roleMenuParamsVO.getTenantId();
		if (StringUtils.isEmpty(tenantId)) {
			errorMsg += "tenantId 不能为空！";
		}
		Long roleMenuRelId = roleMenuParamsVO.getRoleMenuRelId();
		Long menuId = roleMenuParamsVO.getMenuId();
		Long roleId = roleMenuParamsVO.getRoleId();
		if (roleMenuRelId == null && menuId == null && roleId == null) {
			errorMsg += "roleMenuRelId、menuId、roleId不能同时为null！";
		}
		if ("".equals(errorMsg)) {
			Integer result = roleMenuService.deleteRoleMenu(roleMenuParamsVO);
			if (result != null && result > 0) {
				gnRoleMenuResponseVO.setResponseCode(ResponseState.SUCCESS);
				gnRoleMenuResponseVO.setRespondeDesc("删除角色菜单关系成功！");
				LOGGER.info(" deleteRoleMenu操作成功！：" + errorMsg);
			}else{
				gnRoleMenuResponseVO.setResponseCode(ResponseState.FAILED);
				gnRoleMenuResponseVO.setRespondeDesc("删除角色菜单关系失败！");
				LOGGER.error(" deleteRoleMenu操作失败！");
			}
		} else {
			LOGGER.error(" deleteRoleMenu操作失败！：" + errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return gnRoleMenuResponseVO;
	}

	@Override
	public List<GnRoleMenuVO> queryRoleMenuListByRoleId(GnRoleMenuParamsVO roleMenuParamsVO) throws CallerException {
		LOGGER.info("角色菜单服务 queryMenuFilterIds方法参数列表：" + JSONObject.fromObject(roleMenuParamsVO));
		List<GnRoleMenuVO> roleMenuVOList = new LinkedList<GnRoleMenuVO>();
		String errorMsg = "";
		if (StringUtils.isEmpty(roleMenuParamsVO.getTenantId())) {
			errorMsg += "GnRoleMenuParamsVO : tenantId 不能为空！";
		}
		if (roleMenuParamsVO.getRoleId() == null) {
			errorMsg += "GnRoleMenuParamsVO : roleId 不能为空！";
		}
		if ("".equals(errorMsg)) {
			if(roleMenuParamsVO.getInactiveTime()==null){
				roleMenuParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
			}
			// 通过角色id获得拥有的菜单 list
			List<GnRoleMenu> roleMenuList = roleMenuService.queryMenuListByRoleId(roleMenuParamsVO);
			if(roleMenuList != null && roleMenuList.size()>0){
				for(GnRoleMenu roleMenu : roleMenuList){
					GnRoleMenuVO gnRoleMenuVO = new GnRoleMenuVO();
					BeanUtils.copyProperties(gnRoleMenuVO, roleMenu);
					roleMenuVOList.add(gnRoleMenuVO);
				}
			}
		} else {
			LOGGER.error("橘色可赋菜单查询失败：" + errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return roleMenuVOList;
	}

}

package com.myunihome.myxapp.sys.api.sysmenu.impl;

import java.util.ArrayList;
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
import com.myunihome.myxapp.paas.util.DateUtil;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.constants.Constants.ResponseState;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnMenu;
import com.myunihome.myxapp.sso.service.IMenuService;
import com.myunihome.myxapp.sso.service.IRoleMenuService;
import com.myunihome.myxapp.sys.api.sysmenu.interfaces.IGnMenuManageSV;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuParamsVO;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuResponseVO;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuVO;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuParamsVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Service
@Component
public class GnMenuManageSVImpl implements IGnMenuManageSV {

	private static final Logger LOGGER = LoggerFactory.getLogger(GnMenuManageSVImpl.class);

	@Autowired
	IMenuService menuService;
	@Autowired
	IRoleMenuService roleMenuService;

	@Override
	public Long addMenu(GnMenuParamsVO menuParamsVO) throws CallerException {
		LOGGER.info("菜单创建服务addMenu方法参数列表：" + JSONObject.fromObject(menuParamsVO));

		String msg = null;
		Long menuId = null;
		if (menuParamsVO != null) {
			if (StringUtils.isEmpty(menuParamsVO.getTenantId())) {
				msg = "tenantId不能为空！";
			} else if (StringUtils.isEmpty(menuParamsVO.getSystemId())) {
				msg = "systemId不能为空！";
			} else if (menuParamsVO.getMenuPid() == null) {
				msg = "menuPid不能为空！";
			} else if (StringUtils.isEmpty(menuParamsVO.getMenuName())) {
				msg = "menuName不能为空！";
			} else if (StringUtils.isEmpty(menuParamsVO.getSystemModeId())) {
				msg = "systemModeId不能为空！";
			} else {
				GnMenu gnMenu = new GnMenu();
				BeanUtils.copyProperties(gnMenu, menuParamsVO);
				menuId = menuService.addMenu(gnMenu);
			}
			if (msg != null) {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}
		return menuId;
	}

	@Override
	public GnMenuResponseVO updateMenu(GnMenuParamsVO menuParamsVO) throws CallerException {
		LOGGER.info("菜单更新服务updateMenu方法参数列表：" + JSONObject.fromObject(menuParamsVO));
		boolean result = false;
		String msg = null;
		Integer index = null;
		if (menuParamsVO != null) {
			GnMenu gnMenu = new GnMenu();
			BeanUtils.copyProperties(gnMenu, menuParamsVO);
			if (StringUtils.isEmpty(gnMenu.getTenantId())) {
				msg = "tenantId不能为空！";
			} else if (gnMenu.getMenuId() == null) {
				msg = "menuId不能为空！";
			} else {
				index = menuService.updateMenu(gnMenu);
				result = (index != null && index > 0);
				// 同步更新关联表
				boolean updateRelTab = updateRelationTableByMenu(menuParamsVO);
				result = updateRelTab && result;
			}
			if (msg != null) {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}

		GnMenuResponseVO responseResults = new GnMenuResponseVO();
		if (result) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc("菜单更新成功！");
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc("菜单更新失败！" + msg);
		}
		return responseResults;
	}

	/**
	 * 同步更新关联表
	 * 
	 * @param menuParamsVO
	 * @return
	 */
	private boolean updateRelationTableByMenu(GnMenuParamsVO menuParamsVO) {
		LOGGER.info("菜单修改同步更新关联表 角色对象相关数据为：" + JSONObject.fromObject(menuParamsVO));
		String errorMsg = "";
		String successMsg = "";
		// 同步更新关联表前数据检查
		errorMsg = checkBefUpdateRelationTable(menuParamsVO);
		if ("".equals(errorMsg)) {
			// 同步更新角色菜单表
			GnRoleMenuParamsVO roleMenuParamsVO = new GnRoleMenuParamsVO();
			roleMenuParamsVO.setTenantId(menuParamsVO.getTenantId());
			roleMenuParamsVO.setMenuId(menuParamsVO.getMenuId());
			roleMenuParamsVO.setMenuName(menuParamsVO.getMenuName());
			roleMenuParamsVO.setUpdateOperId(menuParamsVO.getUpdateOperId());
			roleMenuParamsVO.setUpdateTime(DateUtil.getSysDate());
			Integer updateRoleMenuResult = roleMenuService.updateRoleMenu(roleMenuParamsVO);
			if (updateRoleMenuResult != null && updateRoleMenuResult >= 0) {
				successMsg += "角色菜单表更新成功！";
			} else {
				errorMsg += "角色菜单表更新失败！";
			}
		} else {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		boolean result = "".equals(errorMsg);
		LOGGER.info("菜单修改同步更新关联表 操作结果：" + (result ? successMsg : errorMsg));
		return result;
	}

	/**
	 * 同步更新关联表前数据检查
	 * 
	 * @param roleParamsVO
	 * @param errorMsg
	 * @return
	 */
	private String checkBefUpdateRelationTable(GnMenuParamsVO menuParamsVO) {
		String errorMsg = "";
		String tenantId = menuParamsVO.getTenantId();
		if (StringUtils.isEmpty(tenantId)) {
			errorMsg += "tenantId 不能为空！ ";
		}
		Long menuId = menuParamsVO.getMenuId();
		if (menuId == null) {
			errorMsg += "menuId 不能为空！ ";
		}
		return errorMsg;
	}

	@Override
	public GnMenuResponseVO delMenuByID(GnMenuParamsVO menuParamsVO) throws CallerException {
		LOGGER.info("菜单删除服务delMenuByID方法参数列表：" + JSONObject.fromObject(menuParamsVO));

		Integer index = null;
		checkParamsBefDelMenuByID(menuParamsVO);
		GnMenu gnMenu = new GnMenu();
		BeanUtils.copyProperties(gnMenu, menuParamsVO);
		index = menuService.delMenuByID(gnMenu);

		GnMenuResponseVO responseResults = new GnMenuResponseVO();
		if (index != null && index > 0) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc("菜单删除成功！");
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc("菜单删除失败!");
		}
		return responseResults;
	}

	/**
	 * 删除前参数检查
	 * 
	 * @param menuParamsVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkParamsBefDelMenuByID(GnMenuParamsVO menuParamsVO) {
		String errorMsg = "";
		if (menuParamsVO == null) {
			errorMsg += "参数对象不能为空！";
		} else {
			if (StringUtils.isEmpty(menuParamsVO.getTenantId())) {
				errorMsg = "tenantId不能为空！";
			} else if (menuParamsVO.getMenuId() == null) {
				errorMsg = "menuId不能为空！";
			}
		}
		if (StringUtils.isNotEmpty(errorMsg)) {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public GnMenuVO queryMenuById(GnMenuParamsVO menuParamsVO) throws CallerException {
		LOGGER.info("根据菜单编码获取菜单信息服务queryMenuById方法参数列表：" + JSONObject.fromObject(menuParamsVO));

		checkParamsBefQueryMenuById(menuParamsVO);
		GnMenu param = new GnMenu();
		BeanUtils.copyProperties(param, menuParamsVO);
		// param.setInactiveTime(DateTimeUtil.getCurrTimestamp());
		GnMenu gnMenu = menuService.queryMenuById(param);
		GnMenuVO gnMenuVO = null;
		if (gnMenu != null) {
			gnMenuVO = new GnMenuVO();
			BeanUtils.copyProperties(gnMenuVO, gnMenu);
		}
		return gnMenuVO;
	}

	/**
	 * 查询前前参数检查
	 * 
	 * @param menuParamsVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkParamsBefQueryMenuById(GnMenuParamsVO menuParamsVO) {
		String errorMsg = "";
		if (menuParamsVO == null) {
			errorMsg += "参数对象不能为空！";
		} else {
			if (StringUtils.isEmpty(menuParamsVO.getMenuId().toString())) {
				errorMsg = "menuId不能为空！";
			} else if (StringUtils.isEmpty(menuParamsVO.getTenantId())) {
				errorMsg = "tenantId不能为空！";
			}
		}
		if (StringUtils.isNotEmpty(errorMsg)) {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public PageInfo<GnMenuVO> queryMenu(GnMenuParamsVO menuParamsVO) throws CallerException {
		LOGGER.info("根据查询条件获取菜单列表服务queryMenu方法参数列表：" + JSONObject.fromObject(menuParamsVO));

		PageInfo<GnMenu> pageInfo = null;
		if (menuParamsVO != null) {
			if (StringUtils.isEmpty(menuParamsVO.getTenantId())) {
				LOGGER.error("tenantId不能为空！");
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, "tenantId不能为空！");
			} else {
				// menuParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
				pageInfo = menuService.queryMenu(menuParamsVO);
			}
		}

		PageInfo<GnMenuVO> resultPage = new PageInfo<GnMenuVO>();
		if (pageInfo != null) {
			resultPage.setPageNo(pageInfo.getPageNo());
			resultPage.setPageSize(pageInfo.getPageSize());
			resultPage.setCount(pageInfo.getCount());

			List<GnMenuVO> gnMenuVOList = new ArrayList<GnMenuVO>();
			if (!CollectionUtil.isEmpty(pageInfo.getResult())) {
				Gson gson = new Gson();
				gnMenuVOList = gson.fromJson(gson.toJson(pageInfo.getResult()), new TypeToken<List<GnMenuVO>>() {
				}.getType());
			}
			resultPage.setResult(gnMenuVOList);
		}

		return resultPage;
	}

	@Override
	public PageInfo<GnMenuVO> queryMenuFilterIds(GnMenuParamsVO menuParamsVO) throws CallerException {
		LOGGER.info("角色菜单服务 queryMenuFilterIds方法参数列表：" + JSONObject.fromObject(menuParamsVO));
		if (StringUtils.isEmpty(menuParamsVO.getTenantId())) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, "tenantId不能为空！");
		}
		if (menuParamsVO.getInactiveTime() == null) {
			menuParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
		}
		// 获得角色列表
		return menuService.getMenuFilterIds(menuParamsVO);
	}

}

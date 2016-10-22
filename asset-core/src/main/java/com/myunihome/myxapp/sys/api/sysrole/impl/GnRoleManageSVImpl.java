package com.myunihome.myxapp.sys.api.sysrole.impl;

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
import com.myunihome.myxapp.paas.util.DateUtil;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.constants.Constants.ResponseState;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRole;
import com.myunihome.myxapp.sso.service.IOperRoleService;
import com.myunihome.myxapp.sso.service.IRoleMenuService;
import com.myunihome.myxapp.sso.service.IRoleService;
import com.myunihome.myxapp.sso.service.impl.RoleServiceImpl;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleParamsVO;
import com.myunihome.myxapp.sys.api.sysrole.interfaces.IGnRoleManageSV;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleParamsVO;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleResponseVO;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleVO;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuParamsVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Service
@Component
public class GnRoleManageSVImpl implements IGnRoleManageSV {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	IRoleService roleService;
	@Autowired
	IOperRoleService operRoleService;
	@Autowired
	IRoleMenuService roleMenuService;

	@Override
	public Long addRole(GnRoleParamsVO roleParamsVO) throws CallerException {
		LOGGER.info("角色创建服务addRole方法参数列表：" + JSONObject.fromObject(roleParamsVO));
		Long roleId = null;
		if (roleParamsVO != null) {
			String msg = "";
			if (StringUtils.isEmpty(roleParamsVO.getTenantId())) {
				msg += "tenantId不能为空！";
			}
			if (StringUtils.isEmpty(roleParamsVO.getSystemId())) {
				msg += "systemId不能为空！";
			}
			if (roleParamsVO.getRolePid() == null) {
				msg += "rolePid不能为空！";
			}
			if (StringUtils.isEmpty(roleParamsVO.getSystemModeId())) {
				msg += "systemModeId不能为空！";
			}
			if ("".equals(msg)) {
				GnRole gnRole = new GnRole();
				BeanUtils.copyProperties(gnRole, roleParamsVO);
				roleId = roleService.addRole(gnRole);
			} else {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}
		return roleId;
	}

	@Override
	public GnRoleResponseVO updateRole(GnRoleParamsVO roleParamsVO) throws CallerException {
		LOGGER.info("角色更新服务updateRole方法参数列表：" + JSONObject.fromObject(roleParamsVO));
		Integer index = null;
		boolean result = false;
		if (roleParamsVO != null) {
			String msg = "";
			if (roleParamsVO.getRoleId() == null) {
				msg += "roleId不能为空！";
			}
			if (StringUtils.isEmpty(roleParamsVO.getTenantId())) {
				msg += "tenantId不能为空！";
			}
			if ("".equals(msg)) {
				GnRole gnRole = new GnRole();
				BeanUtils.copyProperties(gnRole, roleParamsVO);
				index = roleService.updateRole(gnRole);
				result = (index != null && index > 0);
				// 同步更新关联表
				boolean updateRelationTabResult = updateRelationTabByRole(roleParamsVO);
				result = result && updateRelationTabResult;
			} else {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}
		return getResopnsResults(result, "角色更新成功！", "角色更新失败！");
	}

	/**
	 * 同步更新关联表
	 * 
	 * @param roleParamsVO
	 * @return
	 */
	private boolean updateRelationTabByRole(GnRoleParamsVO roleParamsVO) {
		LOGGER.info("角色修改同步更新关联表 角色对象相关数据为：" + JSONObject.fromObject(roleParamsVO));
		String errorMsg = "";
		String successMsg = "";
		// 同步更新关联表前数据检查
		errorMsg = checkBefUpdateRelationTable(roleParamsVO);
		if ("".equals(errorMsg)) {
			// 同步更新操作员角色表
			GnOperRoleParamsVO operRoleParamsVO = new GnOperRoleParamsVO();
			operRoleParamsVO.setTenantId(roleParamsVO.getTenantId());
			operRoleParamsVO.setRoleId(roleParamsVO.getRoleId());
			operRoleParamsVO.setRoleName(roleParamsVO.getRoleName());
			operRoleParamsVO.setUpdateOperId(roleParamsVO.getUpdateOperId());
			operRoleParamsVO.setUpdateTime(DateUtil.getSysDate());
			//BeanUtils.copyProperties(operRoleParamsVO, roleParamsVO);
			Integer updateOperRoleResult = operRoleService.updateOperRole(operRoleParamsVO);
			if (updateOperRoleResult != null && updateOperRoleResult >= 0) {
				successMsg += "操作员角色表更新成功！";
			} else {
				errorMsg += "操作员角色表更新失败！";
			}
			// 同步更新角色菜单表
			GnRoleMenuParamsVO roleMenuParamsVO = new GnRoleMenuParamsVO();
			roleMenuParamsVO.setTenantId(roleParamsVO.getTenantId());
			roleMenuParamsVO.setRoleId(roleParamsVO.getRoleId());
			roleMenuParamsVO.setRoleName(roleParamsVO.getRoleName());
			roleMenuParamsVO.setUpdateOperId(roleParamsVO.getUpdateOperId());
			roleMenuParamsVO.setUpdateTime(DateUtil.getSysDate());
			//BeanUtils.copyProperties(roleMenuParamsVO, roleParamsVO);
			Integer updateRoleMenuResult = roleMenuService.updateRoleMenu(roleMenuParamsVO);
			if (updateRoleMenuResult != null && updateRoleMenuResult >= 0) {
				successMsg += "角色菜单表更新成功！";
			} else {
				errorMsg += "角色菜单表更新失败！";
			}
		}else{
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		boolean isSuccess = "".equals(errorMsg);
		LOGGER.info("角色修改同步更新关联表 操作结果：" + (isSuccess ? successMsg : errorMsg));
		return isSuccess;
	}

	/**
	 * 同步更新关联表前数据检查
	 * 
	 * @param roleParamsVO
	 * @param errorMsg
	 * @return
	 */
	private String checkBefUpdateRelationTable(GnRoleParamsVO roleParamsVO) {
		String errorMsg = "";
		String tenantId = roleParamsVO.getTenantId();
		if (StringUtils.isEmpty(tenantId)) {
			errorMsg += "tenantId 不能为空！ ";
		}
		Long roleId = roleParamsVO.getRoleId();
		if (roleId == null) {
			errorMsg += "roleId 不能为空！ ";
		}
		return errorMsg;
	}

	@Override
	public GnRoleResponseVO delRoleByID(GnRoleParamsVO roleParamsVO) throws CallerException {
		LOGGER.info("角色删除服务delRoleByID方法参数列表：" + JSONObject.fromObject(roleParamsVO));

		Integer index = null;
		if (roleParamsVO != null) {
			String msg = "";
			if (roleParamsVO.getRoleId() == null) {
				msg += "roleId不能为空！";
			}
			if (StringUtils.isEmpty(roleParamsVO.getTenantId())) {
				msg += "tenantId不能为空！";
			}
			if ("".equals(msg)) {
				GnRole gnRole = new GnRole();
				BeanUtils.copyProperties(gnRole, roleParamsVO);
				index = roleService.delRoleByID(gnRole);
			} else {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}
		boolean result = (index != null && index > 0);
		return getResopnsResults(result, "角色删除成功！", "角色删除失败！");
	}

	@Override
	public GnRoleVO queryRoleById(GnRoleParamsVO roleParamsVO) throws CallerException {
		LOGGER.info("根据菜单编码获取菜单信息服务queryMenuById方法参数列表：" + JSONObject.fromObject(roleParamsVO));
		GnRole gnRole = new GnRole();
		if (roleParamsVO != null) {
			BeanUtils.copyProperties(gnRole, roleParamsVO);
			// gnRole.setInactiveTime(DateTimeUtil.getCurrTimestamp());
			gnRole = roleService.queryRoleById(gnRole);
		}
		GnRoleVO gnRoleVO = new GnRoleVO();
		if (gnRole != null) {
			BeanUtils.copyProperties(gnRoleVO, gnRole);
		} else {
			gnRoleVO = null;
		}
		return gnRoleVO;
	}

	@Override
	public PageInfo<GnRoleVO> queryRole(GnRoleParamsVO roleParamsVO) throws CallerException {
		LOGGER.info("根据查询条件获取菜单列表服务queryMenu方法参数列表：" + JSONObject.fromObject(roleParamsVO));

		PageInfo<GnRole> pageInfo = new PageInfo<GnRole>();
		if (roleParamsVO != null) {
			// roleParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
			pageInfo = roleService.queryRole(roleParamsVO);
		}

		PageInfo<GnRoleVO> resultPage = null;
		if (pageInfo != null) {
			resultPage = new PageInfo<GnRoleVO>();
			resultPage.setPageNo(pageInfo.getPageNo());
			resultPage.setPageSize(pageInfo.getPageSize());
			resultPage.setCount(pageInfo.getCount());

			List<GnRoleVO> gnRoleVOList = new LinkedList<GnRoleVO>();
			if (!CollectionUtil.isEmpty(pageInfo.getResult())) {
				Gson gson = new Gson();
				gnRoleVOList = gson.fromJson(gson.toJson(pageInfo.getResult()), new TypeToken<List<GnRoleVO>>() {
				}.getType());
			}
			resultPage.setResult(gnRoleVOList);
		} 
		return resultPage;
	}

	/**
	 * 根据结果返回结果集对象
	 * 
	 * @param isOk
	 * @param successMsg
	 * @param errorMsg
	 * @return
	 */
	private GnRoleResponseVO getResopnsResults(boolean isOk, String successMsg, String errorMsg) {
		GnRoleResponseVO responseResults = new GnRoleResponseVO();
		if (isOk) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc(successMsg);
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc(errorMsg);
		}
		return responseResults;
	}

	@Override
	public PageInfo<GnRoleVO> queryRoleFilterIds(GnRoleParamsVO roleParamsVO) throws CallerException {
		LOGGER.info("操作员角色服务 queryRoleFilterIds方法参数列表：" + JSONObject.fromObject(roleParamsVO));
		PageInfo<GnRoleVO> pageInfo = null;
		String errorMsg = "";
		if (StringUtils.isEmpty(roleParamsVO.getTenantId())) {
			errorMsg += "GnRoleParamsVO ：tenantId 不能为空！";
		}
		if ("".equals(errorMsg)) {
			if (roleParamsVO.getInactiveTime() == null) {
				roleParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
			}
			// 获得操作员可赋角色列表
			PageInfo<GnRole> pageInfoResut = roleService.getRolesFilterIds(roleParamsVO);
			pageInfo = getRoleVOPageInfo(pageInfoResut);
		} else {
			LOGGER.error("操作员可赋角色查询失败：" + errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return pageInfo;
	}
	
	/**
	 * 转换为返回对象的页面信息并返回
	 *
	 * @param pageInfo
	 * @return
	 */
	private PageInfo<GnRoleVO> getRoleVOPageInfo(PageInfo<GnRole> pageInfo) {
		PageInfo<GnRoleVO> resultPage = null;
		if (pageInfo != null) {
			resultPage = new PageInfo<GnRoleVO>();
			resultPage.setPageNo(pageInfo.getPageNo());
			resultPage.setPageSize(pageInfo.getPageSize());
			resultPage.setCount(pageInfo.getCount());

			List<GnRoleVO> gnOperRoleVOList = new LinkedList<GnRoleVO>();
			if (!CollectionUtil.isEmpty(pageInfo.getResult())) {
				Gson gson = new Gson();
				gnOperRoleVOList = gson.fromJson(gson.toJson(pageInfo.getResult()), new TypeToken<List<GnRoleVO>>() {
				}.getType());
			}
			resultPage.setResult(gnOperRoleVOList);
		}
		return resultPage;
	}

}

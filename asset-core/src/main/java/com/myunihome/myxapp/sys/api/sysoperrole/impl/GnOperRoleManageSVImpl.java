package com.myunihome.myxapp.sys.api.sysoperrole.impl;

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
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.constants.Constants.ResponseState;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sso.service.IOperRoleService;
import com.myunihome.myxapp.sso.service.IRoleService;
import com.myunihome.myxapp.sso.service.impl.OperRoleServiceImpl;
import com.myunihome.myxapp.sys.api.sysoperrole.interfaces.IGnOperRoleManageSV;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleParamsVO;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleResponseVO;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Service
@Component
public class GnOperRoleManageSVImpl implements IGnOperRoleManageSV {

	@Autowired
	IOperRoleService operRoleService;
	@Autowired
	IRoleService roleService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OperRoleServiceImpl.class);

	@Override
	public GnOperRoleResponseVO addRoleToOper(GnOperRoleParamsVO operRoleParamsVO) throws CallerException {
		LOGGER.info("操作员赋予角色权限服务addRoleToOper方法参数列表：" + JSONObject.fromObject(operRoleParamsVO));
		String errorMsg = "";
		Integer result = null;
		if (operRoleParamsVO != null) {
			if (StringUtils.isEmpty(operRoleParamsVO.getTenantId())) {
				errorMsg += "tenantId不能为空！";
			}
			if (operRoleParamsVO.getRoleId() == null) {
				errorMsg += "roleId不能为空！";
			}
			if (operRoleParamsVO.getStaffnoId() == null) {
				errorMsg += "staffnoId不能为空！";
			}
			if ("".equals(errorMsg)) {
				GnOperRole operRole = new GnOperRole();
				BeanUtils.copyProperties(operRole, operRoleParamsVO);
				result = operRoleService.addRoleToOper(operRole);
			} else {
				LOGGER.error(errorMsg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
			}
		}
		return getResopnsResults(result, "操作员赋予角色权限成功！", "操作员赋予角色权限失败:" + errorMsg);
	}

	@Override
	public PageInfo<GnOperRoleVO> queryRoleByOperId(GnOperRoleParamsVO operRoleParamsVO) throws CallerException {
		LOGGER.info("操作员拥有角色列表服务queryRoleByOperId方法参数列表：" + JSONObject.fromObject(operRoleParamsVO));
		PageInfo<GnOperRoleVO> resultPage = new PageInfo<GnOperRoleVO>();
		String errorMsg = "";
		if (operRoleParamsVO != null) {
			if (StringUtils.isEmpty(operRoleParamsVO.getTenantId())) {
				errorMsg += "tenantId不能为空！";
			}
			if (operRoleParamsVO.getStaffnoId() == null) {
				errorMsg += "staffnoId不能为空！";
			}
			if ("".equals(errorMsg)) {
				if (operRoleParamsVO.getInactiveTime() == null) {
					operRoleParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
				}
				PageInfo<GnOperRole> pageInfo = operRoleService.queryRoleByOperId(operRoleParamsVO);
				Gson gson = new Gson();
				resultPage = gson.fromJson(gson.toJson(pageInfo), new TypeToken<PageInfo<GnOperRoleVO>>() {
				}.getType());
			} else {
				LOGGER.error(errorMsg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
			}
		}
		return resultPage;
	}

	/**
	 * 根据结果返回结果集对象
	 * 
	 * @param result
	 * @param successMsg
	 * @param errorMsg
	 * @return
	 */
	private GnOperRoleResponseVO getResopnsResults(Integer result, String successMsg, String errorMsg) {
		GnOperRoleResponseVO responseResults = new GnOperRoleResponseVO();
		if (result != null && result > 0) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc(successMsg);
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc(errorMsg);
		}
		return responseResults;
	}

	// @Override
	// public PageInfo<GnRoleVO> queryRoleFilterIds(GnOperRoleParamsVO
	// operRoleParamsVO, GnRoleParamsVO roleParamsVO) {
	// LOGGER.info("操作员角色服务 queryRoleFilterIds方法参数列表：" +
	// JSONObject.fromObject(operRoleParamsVO));
	// PageInfo<GnRoleVO> pageInfo = new PageInfo<GnRoleVO>();
	// String errorMsg = "";
	// if (StringUtils.isEmpty(operRoleParamsVO.getTenantId())) {
	// errorMsg += "GnOperRoleParamsVO ：tenantId 不能为空！";
	// }
	// if (operRoleParamsVO.getOperId() == null) {
	// errorMsg += "operRoleParamsVO ：operId 不能为空！";
	// }
	// if (StringUtils.isEmpty(roleParamsVO.getTenantId())) {
	// errorMsg += "GnRoleParamsVO ：tenantId 不能为空！";
	// }
	// if ("".equals(errorMsg)) {
	// // 通过操作员id获得角色id list
	// List<Long> roleIdList = getRoleListByOperId(operRoleParamsVO);
	// // 设置条件
	// roleParamsVO.setFilterRoleIdList(roleIdList);
	// // roleParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
	// // 获得操作员可赋角色列表
	// PageInfo<GnRole> pageInfoResut =
	// roleService.getRolesFilterIds(roleParamsVO);
	// pageInfo = getRoleVOPageInfo(pageInfoResut);
	// } else {
	// LOGGER.error("操作员可赋角色查询失败：" + errorMsg);
	// }
	// return pageInfo;
	// }
	//
	// /**
	// * 通过操作员id获得角色id list
	// *
	// * @param operRoleParamsVO
	// */
	// private List<Long> getRoleListByOperId(GnOperRoleParamsVO
	// operRoleParamsVO) {
	// List<Long> roleIdList = new LinkedList<Long>();
	// // operRoleParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
	// List<GnOperRole> operRoleList =
	// operRoleService.queryRoleListByOperId(operRoleParamsVO);
	// if (operRoleList != null && operRoleList.size() > 0) {
	// for (GnOperRole operRole : operRoleList) {
	// Long roleId = operRole.getRoleId();
	// if (roleId != null) {
	// roleIdList.add(roleId);
	// }
	// }
	// }
	// return roleIdList;
	// }

	// /**
	// * 转换为返回对象的页面信息并返回
	// *
	// * @param pageInfo
	// * @return
	// */
	// private PageInfo<GnRoleVO> getRoleVOPageInfo(PageInfo<GnRole> pageInfo) {
	// PageInfo<GnRoleVO> resultPage = new PageInfo<GnRoleVO>();
	// if (pageInfo != null) {
	// resultPage.setPageNo(pageInfo.getPageNo());
	// resultPage.setPageSize(pageInfo.getPageSize());
	// resultPage.setCount(pageInfo.getCount());
	//
	// List<GnRoleVO> gnOperRoleVOList = new ArrayList<GnRoleVO>();
	// if (!CollectionUtil.isEmpty(pageInfo.getResult())) {
	// Gson gson = new Gson();
	// gnOperRoleVOList = gson.fromJson(gson.toJson(pageInfo.getResult()), new
	// TypeToken<List<GnRoleVO>>() {
	// }.getType());
	// }
	// resultPage.setResult(gnOperRoleVOList);
	// }
	// return resultPage;
	// }

	@Override
	public GnOperRoleResponseVO deleteOperRole(GnOperRoleParamsVO operRoleParamsVO) throws CallerException {
		LOGGER.info("操作员角色服务 deleteOperRole方法参数列表：" + JSONObject.fromObject(operRoleParamsVO));
		GnOperRoleResponseVO gnOperRoleResponseVO = new GnOperRoleResponseVO();
		String errorMsg = "";
		String tenantId = operRoleParamsVO.getTenantId();
		if (StringUtils.isEmpty(tenantId)) {
			errorMsg += "tenantId 不能为空！";
		}
		Long operRoleRelId = operRoleParamsVO.getOperRoleRelId();
		Long staffnoId = operRoleParamsVO.getStaffnoId();
		Long roleId = operRoleParamsVO.getRoleId();
		if (operRoleRelId == null && staffnoId == null && roleId == null) {
			errorMsg += "operRoleRelId、operId、roleId不能同时为null！";
		}
		if ("".equals(errorMsg)) {
			Integer result = operRoleService.deleteOperRole(operRoleParamsVO);
			if (result != null && result > 0) {
				gnOperRoleResponseVO.setResponseCode(ResponseState.SUCCESS);
				gnOperRoleResponseVO.setRespondeDesc("删除操作员角色关系成功！");
				LOGGER.info(" deleteOperRole操作成功！：" + errorMsg);
			} else {
				gnOperRoleResponseVO.setResponseCode(ResponseState.FAILED);
				gnOperRoleResponseVO.setRespondeDesc("删除操作员角色关系失败！");
				LOGGER.error(" deleteOperRole操作失败！");
			}
		} else {
			LOGGER.error(" deleteOperRole操作失败！：" + errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return gnOperRoleResponseVO;
	}

	@Override
	public List<GnOperRoleVO> queryOperRoleListByOperId(GnOperRoleParamsVO operRoleParamsVO) throws CallerException {
		LOGGER.info("操作员角色服务 queryOperRoleListByOperId方法参数列表：" + JSONObject.fromObject(operRoleParamsVO));
		List<GnOperRoleVO> operRoleVoList = new LinkedList<GnOperRoleVO>();
		String errorMsg = "";
		if (StringUtils.isEmpty(operRoleParamsVO.getTenantId())) {
			errorMsg += "GnOperRoleParamsVO ：tenantId 不能为空！";
		}
		if (operRoleParamsVO.getStaffnoId() == null) {
			errorMsg += "operRoleParamsVO ：staffnoId 不能为空！";
		}
		if (!"".equals(errorMsg)) {
			LOGGER.error("操作员可赋角色查询失败：" + errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		} else {
			if (operRoleParamsVO.getInactiveTime() == null) {
				operRoleParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
			}
			List<GnOperRole> operRoleList = operRoleService.queryRoleListByOperId(operRoleParamsVO);
			if (operRoleList != null && operRoleList.size() > 0) {
				for (GnOperRole gnOperRole : operRoleList) {
					GnOperRoleVO gnOperRoleVO = new GnOperRoleVO();
					BeanUtils.copyProperties(gnOperRoleVO, gnOperRole);
					operRoleVoList.add(gnOperRoleVO);
				}
			}
		}
		return operRoleVoList;
	}

}

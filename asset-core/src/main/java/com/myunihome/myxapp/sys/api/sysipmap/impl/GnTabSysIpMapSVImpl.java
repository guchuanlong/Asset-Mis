package com.myunihome.myxapp.sys.api.sysipmap.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.constants.Constants.ResponseState;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMap;
import com.myunihome.myxapp.sso.service.ITabSysIpMapService;
import com.myunihome.myxapp.sys.api.sysipmap.interfaces.IGnTabSysIpMapSV;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapParamVO;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapResponseVO;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapVO;

@Service
@Component
public class GnTabSysIpMapSVImpl implements IGnTabSysIpMapSV {

	@Autowired
	ITabSysIpMapService tabSysIpMapService;

	@Override
	public PageInfo<GnTabSysIpMapVO> queryTabSysIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO) throws CallerException {
		PageInfo<GnTabSysIpMapVO> pageInfo = null;
		checkBefQueryIpMapPageInfo(tabSysIpMapParamVO);
		PageInfo<GnTabSysIpMap> queryTabSysIpMapPageInfo = tabSysIpMapService.queryTabSysIpMapPageInfo(tabSysIpMapParamVO);
		if (queryTabSysIpMapPageInfo != null) {
			Integer pageNo = queryTabSysIpMapPageInfo.getPageNo();
			Integer pageSize = queryTabSysIpMapPageInfo.getPageSize();
			int count = queryTabSysIpMapPageInfo.getCount();
			List<GnTabSysIpMap> result = queryTabSysIpMapPageInfo.getResult();
			pageInfo = new PageInfo<GnTabSysIpMapVO>();
			if(result != null && result.size()>0){
				List<GnTabSysIpMapVO> IpMapList = new LinkedList<GnTabSysIpMapVO>();
				for(GnTabSysIpMap gnTabSysIpMap : result){
					GnTabSysIpMapVO tabSysIpMapVO = new GnTabSysIpMapVO();
					BeanUtils.copyProperties(tabSysIpMapVO, gnTabSysIpMap);
					IpMapList.add(tabSysIpMapVO);
				}
				pageInfo.setResult(IpMapList);
			}
			pageInfo.setPageNo(pageNo);
			pageInfo.setPageSize(pageSize);
			pageInfo.setCount(count);
		}
		return pageInfo;
	}

	/**
	 * 查询分页信息前检查
	 * 
	 * @param tabSysIpMapParamVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO) {
		String errorStr = "";
		if (tabSysIpMapParamVO == null) {
			errorStr += "查询条件参数对象不能为空!";
		} else {
			String tenantId = tabSysIpMapParamVO.getTenantId();
			if (StringUtils.isEmpty(tenantId)) {
				errorStr += "租户ID（tenantId）不能为空！";
			}
			PageInfo<GnTabSysIpMapVO> pageInfo = tabSysIpMapParamVO.getPageInfo();
			if (pageInfo == null) {
				errorStr += "分页信息（pageInfo）不能为空！";
			} else {
				Integer pageNo = pageInfo.getPageNo();
				if (pageNo == null) {
					errorStr += "页码（pageNo）不能为空！";
				}
			}
		}
		if (StringUtils.isNotEmpty(errorStr)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorStr);
		}
	}

	@Override
	public GnTabSysIpMapResponseVO addTabSysIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO) throws CallerException {
		checkBefAddIpMap(tabSysIpMapParamVO);
		GnTabSysIpMap tabSysIpMap = new GnTabSysIpMap();
		BeanUtils.copyProperties(tabSysIpMap, tabSysIpMapParamVO);
		int count = tabSysIpMapService.addTabSysIpMapPageInfo(tabSysIpMap );
		GnTabSysIpMapResponseVO tabSysIpMapResponseVO = new GnTabSysIpMapResponseVO();
		if(count > 0){
			tabSysIpMapResponseVO.setRespondeDesc("添加系统IP映射成功！");
			tabSysIpMapResponseVO.setResponseCode(ResponseState.SUCCESS);
		}else{
			tabSysIpMapResponseVO.setRespondeDesc("添加系统IP映射失败！");
			tabSysIpMapResponseVO.setResponseCode(ResponseState.FAILED);
		}
		return tabSysIpMapResponseVO;
	}

	/**
	 * 添加前检查
	 * 
	 * @param tabSysIpMapParamVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefAddIpMap(GnTabSysIpMapParamVO tabSysIpMapParamVO) {
		String errorStr = "";
		if (tabSysIpMapParamVO == null) {
			errorStr += "查询条件参数对象不能为空!";
		} else {
			String tenantId = tabSysIpMapParamVO.getTenantId();
			if (StringUtils.isEmpty(tenantId)) {
				errorStr += "租户ID（tenantId）不能为空！";
			}
			String connectIp = tabSysIpMapParamVO.getConnectIp();
			if (StringUtils.isEmpty(connectIp)) {
				errorStr += "接入IP（connectIp）不能为空！";
			}
			String connectPort = tabSysIpMapParamVO.getConnectPort();
			if (StringUtils.isEmpty(connectPort)) {
				errorStr += "接入端口（connectPort）不能为空！";
			}
			String systemId = tabSysIpMapParamVO.getSystemId();
			if (StringUtils.isEmpty(systemId)) {
				errorStr += "系统模块ID（systemId）不能为空！";
			}
			String mappedId = tabSysIpMapParamVO.getMappedId();
			if (StringUtils.isEmpty(mappedId)) {
				errorStr += "映射IP（mappedId）不能为空！";
			}
		}
		if (StringUtils.isNotEmpty(errorStr)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorStr);
		}
	}

	@Override
	public GnTabSysIpMapResponseVO updateTabSysIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO) throws CallerException {
		checkBefUpdateIpMap(tabSysIpMapParamVO);
		GnTabSysIpMap tabSysIpMap = new GnTabSysIpMap();
		BeanUtils.copyProperties(tabSysIpMap, tabSysIpMapParamVO);
		int count = tabSysIpMapService.updateTabSysIpMapPageInfo(tabSysIpMap );
		GnTabSysIpMapResponseVO tabSysIpMapResponseVO = new GnTabSysIpMapResponseVO();
		if(count > 0){
			tabSysIpMapResponseVO.setRespondeDesc("修改系统IP映射成功！");
			tabSysIpMapResponseVO.setResponseCode(ResponseState.SUCCESS);
		}else{
			tabSysIpMapResponseVO.setRespondeDesc("修改系统IP映射失败！");
			tabSysIpMapResponseVO.setResponseCode(ResponseState.FAILED);
		}
		return tabSysIpMapResponseVO;
	}

	/**
	 * 修改前检查
	 * 
	 * @param tabSysIpMapParamVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefUpdateIpMap(GnTabSysIpMapParamVO tabSysIpMapParamVO) {
		String errorStr = "";
		if (tabSysIpMapParamVO == null) {
			errorStr += "查询条件参数对象不能为空!";
		} else {
			String tenantId = tabSysIpMapParamVO.getTenantId();
			if (StringUtils.isEmpty(tenantId)) {
				errorStr += "租户ID（tenantId）不能为空！";
			}
			String connectIp = tabSysIpMapParamVO.getConnectIp();
			if (StringUtils.isEmpty(connectIp)) {
				errorStr += "接入IP（connectIp）不能为空！";
			}
			String connectPort = tabSysIpMapParamVO.getConnectPort();
			if (StringUtils.isEmpty(connectPort)) {
				errorStr += "接入端口（connectPort）不能为空！";
			}
			String systemId = tabSysIpMapParamVO.getSystemId();
			if (StringUtils.isEmpty(systemId)) {
				errorStr += "系统模块ID（systemId）不能为空！";
			}
			String mappedId = tabSysIpMapParamVO.getMappedId();
			String remark = tabSysIpMapParamVO.getRemark();
			if (StringUtils.isEmpty(mappedId) && StringUtils.isEmpty(remark)) {
				errorStr += "映射IP（mappedId）,备注（remark）不能同时为空！";
			}
		}
		if (StringUtils.isNotEmpty(errorStr)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorStr);
		}
	}

}

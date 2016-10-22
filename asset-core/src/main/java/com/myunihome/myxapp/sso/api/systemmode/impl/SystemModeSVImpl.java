package com.myunihome.myxapp.sso.api.systemmode.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.sso.api.systemmode.interfaces.ISystemModeSV;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeListQueryVO;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeQueryVO;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeVO;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemMode;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemModeKey;
import com.myunihome.myxapp.sso.service.ISystemModeService;

@Service
@Component
public class SystemModeSVImpl implements ISystemModeSV{
	
	@Autowired
	ISystemModeService iSystemModeService;

	@Override
	public SystemModeVO querySystemModeByID(SystemModeQueryVO systemModeQueryVO) throws CallerException {
		//查询前检查查询参数是否合法
		SystemModeVO systemModeVO = null;
		checkParamsBefQueryByID(systemModeQueryVO);
		GnSystemModeKey systemModeKey = new GnSystemModeKey();
		systemModeKey.setSystemModeId(systemModeQueryVO.getSystemModeId());
		systemModeKey.setTenantId(systemModeQueryVO.getTenantId());
		GnSystemMode gnSystemMode = iSystemModeService.queryGnSystemModeByKey(systemModeKey );
		if(gnSystemMode != null){
			systemModeVO = new SystemModeVO();
			BeanUtils.copyProperties(systemModeVO, gnSystemMode);
		}
		return systemModeVO;
	}

	/**
	 * 查询前检查查询参数是否合法
	 * @param systemModeQueryVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkParamsBefQueryByID(SystemModeQueryVO systemModeQueryVO) {
		String errorMsg = "";
		if(systemModeQueryVO == null){
			errorMsg += "查询参数对象不能为空！";
		}else if(StringUtils.isEmpty(systemModeQueryVO.getTenantId())){
			errorMsg += "租户id（tenantId）不能为空！";
		}else if(StringUtils.isEmpty(systemModeQueryVO.getSystemModeId())){
			errorMsg += "系统模块id（systemModeId）不能为空！";
		}
		if(StringUtils.isNotEmpty(errorMsg)){
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public List<SystemModeVO> querySystemModeList(SystemModeListQueryVO systemModeListQueryVO) throws CallerException {
		//查询前检查查询参数是否合法
		checkParamsBefQueryList(systemModeListQueryVO);
		List<SystemModeVO> systemModeList = null;
		GnSystemMode systemMode = new GnSystemMode();
		BeanUtils.copyProperties(systemMode, systemModeListQueryVO);
		List<GnSystemMode> gnSystemModeList = iSystemModeService.queryGnSystemModeList(systemMode );
		if(gnSystemModeList != null && gnSystemModeList.size() >0){
			systemModeList = new LinkedList<SystemModeVO>();
			for(GnSystemMode gnSystemMode : gnSystemModeList){
				SystemModeVO systemModeVO = new SystemModeVO();
				BeanUtils.copyProperties(systemModeVO, gnSystemMode);
				systemModeList.add(systemModeVO);
			}
		}
		return systemModeList;
	}
	
	/**
	 * 查询前检查查询参数是否合法
	 * @param systemModeQueryVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkParamsBefQueryList(SystemModeListQueryVO systemModeQueryVO) {
		String errorMsg = "";
		if(systemModeQueryVO == null){
			errorMsg += "查询参数对象不能为空！";
		}else if(StringUtils.isEmpty(systemModeQueryVO.getTenantId())){
			errorMsg += "租户id（tenantId）不能为空！";
		}
		if(StringUtils.isNotEmpty(errorMsg)){
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

}

package com.myunihome.myxapp.sso.api.ipmap.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.sso.api.ipmap.interfaces.ITabSysIpMapSV;
import com.myunihome.myxapp.sso.api.ipmap.param.TabSysIpMapQueryVO;
import com.myunihome.myxapp.sso.api.ipmap.param.TabSysIpMapVO;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMap;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMapKey;
import com.myunihome.myxapp.sso.service.ITabSysIpMapService;

@Service
@Component
public class TabSysIpMapSVImpl implements ITabSysIpMapSV{
	
	@Autowired
	ITabSysIpMapService tabSysIpMapService;

	@Override
	public TabSysIpMapVO queryTabSysIpMap(TabSysIpMapQueryVO tabSysIpMapKeyVO) throws CallerException {
		checkBefQueryTabSysIpMap(tabSysIpMapKeyVO);
		GnTabSysIpMapKey tabSysIpMapKey = new GnTabSysIpMapKey();
		BeanUtils.copyProperties(tabSysIpMapKey, tabSysIpMapKeyVO);
		GnTabSysIpMap queryTabSysIpMap = tabSysIpMapService.queryTabSysIpMap(tabSysIpMapKey );
		TabSysIpMapVO tabSysIpMapVO = new TabSysIpMapVO();
		BeanUtils.copyProperties(tabSysIpMapVO, queryTabSysIpMap);
		return tabSysIpMapVO;
	}

	/**
	 * 查询前检查
	 * @param tabSysIpMapKey
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryTabSysIpMap(TabSysIpMapQueryVO tabSysIpMapKey) {
		String errorStr = "";
		if(tabSysIpMapKey == null){
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, "查询条件参数不能为空！");
		}else{
			String tenantId = tabSysIpMapKey.getTenantId();
			if(StringUtils.isEmpty(tenantId)){
				errorStr += "租户ID（tenantId）不能为空！";
			}
			String connectIp = tabSysIpMapKey.getConnectIp();
			if(StringUtils.isEmpty(connectIp)){
				errorStr += "接入IP（connectIp）不能为空！";
			}
			String connectPort = tabSysIpMapKey.getConnectPort();
			if(StringUtils.isEmpty(connectPort)){
				errorStr += "接入端口（connectPort）不能为空！";
			}
			String systemId = tabSysIpMapKey.getSystemId();
			if(StringUtils.isEmpty(systemId)){
				errorStr += "系统模块ID（systemId）不能为空！";
			}
		}
		if(StringUtils.isNotEmpty(errorStr)){
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorStr);
		}
	}

}

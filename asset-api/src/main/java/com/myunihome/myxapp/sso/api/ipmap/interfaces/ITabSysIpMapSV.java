package com.myunihome.myxapp.sso.api.ipmap.interfaces;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.ipmap.param.TabSysIpMapQueryVO;
import com.myunihome.myxapp.sso.api.ipmap.param.TabSysIpMapVO;

public interface ITabSysIpMapSV {
	
	/**
	 * 查询系统IP映射
	 * @param tabSysIpMapKey
	 * @return GnTabSysIpMapVO
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0051
	 */
	TabSysIpMapVO queryTabSysIpMap(TabSysIpMapQueryVO tabSysIpMapKey) throws CallerException;

}

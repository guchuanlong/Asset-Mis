package com.myunihome.myxapp.sso.service;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMap;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMapKey;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapParamVO;

public interface ITabSysIpMapService {
	/**
	 * 查询系统IP映射信息
	 */
	GnTabSysIpMap queryTabSysIpMap(GnTabSysIpMapKey tabSysIpMapKey);
	/**
	 * 查询系统IP映射分页信息
	 */
	PageInfo<GnTabSysIpMap> queryTabSysIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO);
	
	/**
	 * 新增系统IP映射信息
	 */
	int addTabSysIpMapPageInfo(GnTabSysIpMap tabSysIpMap);
	
	/**
	 * 修改系统IP映射信息
	 */
	int updateTabSysIpMapPageInfo(GnTabSysIpMap tabSysIpMap);

}

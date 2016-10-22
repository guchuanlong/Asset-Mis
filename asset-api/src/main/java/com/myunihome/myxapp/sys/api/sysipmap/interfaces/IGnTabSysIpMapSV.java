package com.myunihome.myxapp.sys.api.sysipmap.interfaces;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapParamVO;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapResponseVO;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapVO;

public interface IGnTabSysIpMapSV {
	
	/**
	 * 查询系统IP映射分页信息
	 * @param tabSysIpMapParamVO
	 * @return PageInfo<GnTabSysIpMapVO>
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0052
	 */
	PageInfo<GnTabSysIpMapVO> queryTabSysIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO) throws CallerException;
	
	/**
	 * 新增系统IP映射信息
	 * @param tabSysIpMapParamVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0053
	 */
	GnTabSysIpMapResponseVO addTabSysIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO) throws CallerException;
	
	/**
	 * 修改系统IP映射信息
	 * @param tabSysIpMapParamVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0054
	 */
	GnTabSysIpMapResponseVO updateTabSysIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO) throws CallerException;

}

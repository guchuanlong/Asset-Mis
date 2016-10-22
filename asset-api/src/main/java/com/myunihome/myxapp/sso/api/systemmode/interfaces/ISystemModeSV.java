package com.myunihome.myxapp.sso.api.systemmode.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeListQueryVO;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeQueryVO;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeVO;

public interface ISystemModeSV {
	
	/**
	 * 根据系统模块id获得系统模块信息
	 * @param systemModeQueryVO
	 * @return SystemModeVO
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0061
	 */
	SystemModeVO querySystemModeByID(SystemModeQueryVO systemModeQueryVO) throws CallerException;
	
	/**
	 * 获得系统模块所有信息列表
	 * @param systemModeListQueryVO
	 * @return List<SystemModeVO>
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0062
	 */
	List<SystemModeVO> querySystemModeList(SystemModeListQueryVO systemModeListQueryVO) throws CallerException;
}

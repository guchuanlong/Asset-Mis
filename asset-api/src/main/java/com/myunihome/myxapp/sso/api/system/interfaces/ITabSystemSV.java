package com.myunihome.myxapp.sso.api.system.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.system.mapper.TabSystemQueryVO;
import com.myunihome.myxapp.sso.api.system.mapper.TabSystemVO;

public interface ITabSystemSV {
	/**
	 * 查询系统模块信息列表
	 * @param tabSystemQueryVO
	 * @return List<TabSystemVO>
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0056
	 */
	List<TabSystemVO> queryTabSystemList(TabSystemQueryVO tabSystemQueryVO) throws CallerException;
	
	/**
	 * 查询系统模块信息
	 * @param tabSystemQueryVO
	 * @return
	 * @author gucl
	 * @ApiDocMethod
	 * @ApiCode SYS_0065
	 */
	TabSystemVO getTabSystem(TabSystemQueryVO tabSystemQueryVO) throws CallerException;
}

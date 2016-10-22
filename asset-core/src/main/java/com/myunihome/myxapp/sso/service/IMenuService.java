package com.myunihome.myxapp.sso.service;

import java.sql.Timestamp;
import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByConditionVO;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByOperIDVO;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnMenu;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuParamsVO;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuVO;

public interface IMenuService {

	List<GetMenuByOperIDVO> getMenuByMenuId(List<Long> menuId, String tenantId);

	List<GetMenuByOperIDVO> getMenuByMenuId(List<Long> menuId, String tenantId, Timestamp activeTime, Timestamp inactiveTime);

	List<GetMenuByConditionVO> getMenuByConditon(List<Long> menuId, String tenantId);

	List<GetMenuByConditionVO> getMenuByConditon(List<Long> menuId, String tenantId, Timestamp activeTime, Timestamp inactiveTime);

	List<GetMenuByConditionVO> getMenuByConditon(List<Long> menuId, String tenantId, String systemModeId);
	
	List<GetMenuByConditionVO> getMenuByConditon(List<Long> menuId, String tenantId, String systemModeId, Timestamp activeTime, Timestamp inactiveTime);
	List<GnMenu> getFramePageMenuByConditon(List<Long> menuId, GnMenu gnMenu);
	Long addMenu(GnMenu gnMenu);

	Integer updateMenu(GnMenu gnMenu);

	Integer delMenuByID(GnMenu gnMenu);

	GnMenu queryMenuById(GnMenu gnMenu);

	PageInfo<GnMenu> queryMenu(GnMenuParamsVO menuParamsVO);

	/**
	 * 获得过滤菜单id集合的菜单列表信息
	 * 
	 * @param menuParamsVO
	 * @return
	 */
	PageInfo<GnMenuVO> getMenuFilterIds(GnMenuParamsVO menuParamsVO);
}

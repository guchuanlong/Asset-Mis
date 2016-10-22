package com.myunihome.myxapp.sso.service;

import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenu;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuParamsVO;

public interface IRoleMenuService {
	
    /**
     * 角色赋予菜单权限服务
     * @param gnRoleMenu
     * @return
     */
    Long addMenuToRole(GnRoleMenu gnRoleMenu);
    
    /**
     * 角色拥有菜单列表服务
     * @param gnRoleMenu
     * @return
     */
    PageInfo<GnRoleMenu> queryMenuByRole(GnRoleMenuParamsVO roleMenuParamsVO);
    
    /**
	 * 查询角色拥有所有菜单
	 * @param roleMenuParamsVO
	 * @return
	 */
    List<GnRoleMenu> queryMenuListByRoleId(GnRoleMenuParamsVO roleMenuParamsVO);
    
    /**
     * 更新角色菜单表
     * @param roleMenuParamsVO
     * @return
     */
    Integer updateRoleMenu(GnRoleMenuParamsVO roleMenuParamsVO); 
    
    /**
     * 删除角色菜单关系
     * @param roleMenuParamsVO
     * @return
     * @author jiaxs
     */
    Integer deleteRoleMenu(GnRoleMenuParamsVO roleMenuParamsVO);
    
}

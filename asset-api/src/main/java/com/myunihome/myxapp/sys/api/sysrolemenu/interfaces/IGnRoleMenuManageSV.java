package com.myunihome.myxapp.sys.api.sysrolemenu.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuParamsVO;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuResponseVO;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuVO;

public interface IGnRoleMenuManageSV {

	/**
	 * 角色赋予菜单权限服务
	 * 
	 * @param roleMenuParamsVO
	 *            待处理信息
	 *            <p/>
	 *            参数列表：<br>
	 *            租户编码<br>
	 *            角色id<br>
	 *            角色名称<br>
	 *            菜单id<br>
	 *            菜单名称<br>
	 *            生效时间<br>
	 *            失效时间<br>
	 *            创建操作员<br>
	 *            <p/>
	 * @return 序列主键id
	 * @author liangbs
	 * @ApiDocMethod
	 * @ApiCode SYS_0025
	 */
	Long addMenuToRole(GnRoleMenuParamsVO roleMenuParamsVO) throws CallerException;

	/**
	 * 角色拥有菜单列表服务
	 * 
	 * @param roleMenuParamsVO
	 *            操作员拥有角色操作参数
	 *            <p/>
	 *            参数列表：<br>
	 *            租户编码<br>
	 *            角色id<br>
	 *            角色名称<br>
	 *            分页参数<br>
	 *            <p/>
	 * @return 列表（角色id、角色名称、菜单id、菜单名称、生效时间、失效时间）
	 * @author liangbs
	 * @ApiDocMethod
	 * @ApiCode SYS_0026
	 */
	PageInfo<GnRoleMenuVO> queryMenuByRole(GnRoleMenuParamsVO roleMenuParamsVO) throws CallerException;

	// /**
	// * 查询角色可赋予的菜单(过滤已有菜单)
	// * @param roleMenuParamsVO (租户id、角色id)
	// * @param menuParamsVO (租户id、页面信息、查询条件)
	// * @return
	// * @author jiaxs
	// * @ApiDocMethod
	// * @ApiCode SYS_0039
	// */
	// PageInfo<GnMenuVO> queryMenuFilterIds(GnRoleMenuParamsVO
	// roleMenuParamsVO, GnMenuParamsVO menuParamsVO);

	/**
	 * 删除角色菜单关系
	 * @param roleMenuParamsVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0041
	 */
	GnRoleMenuResponseVO deleteRoleMenu(GnRoleMenuParamsVO roleMenuParamsVO) throws CallerException;
	
	/**
	 * 通过角色ID获得所有角色菜单列表
	 * @param roleMenuParamsVO (租户id、角色id)
	 * @param menuParamsVO (租户id、页面信息、查询条件)
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0059
	 */
	List<GnRoleMenuVO> queryRoleMenuListByRoleId(GnRoleMenuParamsVO roleMenuParamsVO) throws CallerException;

}

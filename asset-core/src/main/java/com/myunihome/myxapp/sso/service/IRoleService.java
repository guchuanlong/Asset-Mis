package com.myunihome.myxapp.sso.service;

import java.sql.Timestamp;
import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenu;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleParamsVO;

public interface IRoleService {
	/**
	 * 增加角色对象
	 * 
	 * @param gnRole
	 * @return
	 */
	Long addRole(GnRole gnRole);

	/**
	 * 更新角色信息
	 * 
	 * @param gnRole
	 * @return
	 */
	Integer updateRole(GnRole gnRole);

	/**
	 * 删除角色对象
	 * 
	 * @param gnRole
	 * @return
	 */
	Integer delRoleByID(GnRole gnRole);

	/**
	 * 根据员工工号、编码+租户编码 获取角色信息过滤失效时间
	 * 
	 * @param OperId
	 *            操作员Id
	 * @param tenantId
	 *            租户编码
	 * @return
	 */
	List<GnOperRole> getRolesByOperId(Long operId, String tenantId);

	/**
	 * 根据员工工号、编码+租户编码 获取角色信息 不过滤时间
	 * 
	 * @param OperId
	 *            操作员Id
	 * @param tenantId
	 *            租户编码
	 * @param activeTime
	 *            生效时间
	 * @param inactiveTime
	 *            失效时间
	 * @return
	 */
	List<GnOperRole> getRolesByOperId(Long operId, String tenantId, Timestamp activeTime, Timestamp inactiveTime);

	/**
	 * 根据操作员Id、租户编码、系统模块标识 获取角色信息过滤失效时间
	 * 
	 * @param operId
	 *            操作员Id
	 * @param tenantId
	 *            租户编码
	 * @param systemModeId
	 *            系统模块标识（渠道）
	 * @return
	 */
	List<GnOperRole> getRolesByOperId(Long operId, String tenantId, String systemModeId);

	/**
	 * 根据操作员Id、租户编码、系统模块标识 获取角色信息过滤失效时间
	 * 
	 * @param operId
	 *            操作员Id
	 * @param tenantId
	 *            租户编码
	 * @param systemModeId
	 *            系统模块标识（渠道）
	 * @param activeTime
	 *            生效时间
	 * @param inactiveTime
	 *            失效时间
	 * @return
	 */
	List<GnOperRole> getRolesByOperId(Long operId, String tenantId, String systemModeId, Timestamp activeTime, Timestamp inactiveTime);

	/**
	 * 根据角色获取菜单信息
	 * 
	 * @param roleId
	 *            角色标识
	 * @param tenantId
	 *            租户编码
	 * @return
	 */
	List<GnRoleMenu> getMenuByRole(List<Long> roleId, String tenantId);

	/**
	 * 根据角色获取菜单信息
	 * 
	 * @param roleId
	 *            角色标识
	 * @param tenantId
	 *            租户编码
	 * @param inactiveTime
	 *            失效时间（为空时默认不过滤 非空时查失效时间之前的数据）
	 * @return
	 */
	List<GnRoleMenu> getMenuByRole(List<Long> roleId, String tenantId, Timestamp activeTime, Timestamp inactiveTime);

	/**
	 * 
	 * @param gnRole
	 * @return
	 */
	GnRole queryRoleById(GnRole gnRole);

	/**
	 * 
	 * @param roleParamsVO
	 * @return
	 */
	PageInfo<GnRole> queryRole(GnRoleParamsVO roleParamsVO);

	/**
	 * 获得过滤角色id集合的角色列表信息
	 * 
	 * @param roleParamsVO
	 * @return
	 */
	PageInfo<GnRole> getRolesFilterIds(GnRoleParamsVO roleParamsVO);
	
	/**
	 * FramePage获取操作员的角色列表
	 * @param operId
	 * @param tenantId
	 * @param systemId
	 * @param systemModeId
	 * @return
	 * @author gucl
	 */
	List<GnOperRole> getRolesByOperId4FramePage(Long operId, String tenantId, String systemId, String systemModeId);
	
}

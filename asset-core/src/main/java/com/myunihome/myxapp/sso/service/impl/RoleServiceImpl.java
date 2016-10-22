package com.myunihome.myxapp.sso.service.impl;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.sequence.SeqUtil;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRoleCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenu;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenuCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnRoleMapper;
import com.myunihome.myxapp.sso.service.IRoleService;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleParamsVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class RoleServiceImpl implements IRoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
	private static final int PAGESIZE = 5;

	@Override
	public List<GnOperRole> getRolesByOperId(Long staffnoId, String tenantId) {
		String message = "Parameters into getRolesByOperId : operId = " + staffnoId + "tenantId = " + tenantId;
		LOGGER.info(message);
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		List<GnOperRole> gnOperRoles = getRoleList(staffnoId, tenantId, null, currTimestamp, currTimestamp);
		if (gnOperRoles != null && gnOperRoles.size() > 0) {
			JSONArray returnVo = JSONArray.fromObject(gnOperRoles);
			message = "Result from getRolesByOperId :" + returnVo.toString();
			LOGGER.info(message);
		} else {
			message = "Result from getRolesByOperId : operId " + staffnoId + " not exist.";
			LOGGER.error(message);
		}
		return gnOperRoles;
	}

	@Override
	public List<GnOperRole> getRolesByOperId(Long operId, String tenantId, Timestamp activeTime, Timestamp inactiveTime) {
		String message = "Parameters into getRolesNotFilterTime : operId = " + operId + "tenantId = " + tenantId;
		LOGGER.info(message);
		List<GnOperRole> gnOperRoles = getRoleList(operId, tenantId, null, activeTime, inactiveTime);
		if (gnOperRoles != null && gnOperRoles.size() > 0) {
			JSONArray returnVo = JSONArray.fromObject(gnOperRoles);
			message = "Result from getRolesNotFilterTime :" + returnVo.toString();
			LOGGER.info(message);
		} else {
			message = "Result from getRolesNotFilterTime : operId " + operId + " not exist.";
			LOGGER.error(message);
		}
		return gnOperRoles;
	}

	@Override
	public List<GnOperRole> getRolesByOperId(Long operId, String tenantId, String systemModeId) {
		String message = "Parameters into getRolesFilterTime : operId = " + operId + "tenantId = " + tenantId;
		LOGGER.info(message);
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		List<GnOperRole> gnOperRoles = getRoleList(operId, tenantId, systemModeId, currTimestamp, currTimestamp);
		if (gnOperRoles != null && gnOperRoles.size() > 0) {
			JSONArray returnVo = JSONArray.fromObject(gnOperRoles);
			message = "Result from getRolesFilterTime :" + returnVo.toString();
			LOGGER.info(message);
		} else {
			message = "Result from getRolesFilterTime : operId " + operId + " not exist.";
			LOGGER.error(message);
		}
		return gnOperRoles;
	}

	@Override
	public List<GnOperRole> getRolesByOperId(Long operId, String tenantId, String systemModeId, Timestamp activeTime, Timestamp inactiveTime) {
		String message = "Parameters into getRolesNotFilterTime : operId = " + operId + "tenantId = " + tenantId;
		LOGGER.info(message);
		List<GnOperRole> gnOperRoles = getRoleList(operId, tenantId, systemModeId, activeTime, inactiveTime);
		if (gnOperRoles != null && gnOperRoles.size() > 0) {
			JSONArray returnVo = JSONArray.fromObject(gnOperRoles);
			message = "Result from getRolesNotFilterTime :" + returnVo.toString();
			LOGGER.info(message);
		} else {
			message = "Result from getRolesNotFilterTime : operId " + operId + " not exist.";
			LOGGER.error(message);
		}
		return gnOperRoles;
	}

	private List<GnOperRole> getRoleList(Long staffnoId, String tenantId, String systemModeId, Timestamp activeTime, Timestamp inactiveTime) {
		GnOperRoleCriteria gnOperRoleCriteria = new GnOperRoleCriteria();
		GnOperRoleCriteria.Criteria criteria = gnOperRoleCriteria.createCriteria();
		criteria.andStaffnoIdEqualTo(staffnoId);
		if (StringUtils.isNotEmpty(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		if (inactiveTime != null) {
			// 查询未过期的数据
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}
		if (systemModeId != null) {
			// 通过系统模块id获得对应的角色id集
			List<Long> roleIdList = getRoleIdListBySysModeId(systemModeId, tenantId, activeTime, inactiveTime);
			if (roleIdList != null && roleIdList.size() > 0) {
				criteria.andRoleIdIn(roleIdList);
			}
		}
		return MapperFactory.getGnOperRoleMapper().selectByExample(gnOperRoleCriteria);
	}

	/**
	 * 通过系统模块id获得对应的角色id集
	 * 
	 * @param systemModeId
	 * @return
	 */
	private List<Long> getRoleIdListBySysModeId(String systemModeId, String tenantId, Timestamp activeTime, Timestamp inactiveTime) {
		List<Long> roleIdList = null;
		if (StringUtils.isNoneEmpty(systemModeId)) {
			// 获取角色相关信息
			GnRoleMapper gnRoleMapper = MapperFactory.getGnRoleMapper();
			GnRoleCriteria roleExample = new GnRoleCriteria();
			GnRoleCriteria.Criteria roleCriteria = roleExample.createCriteria();
			roleCriteria.andSystemModeIdEqualTo(systemModeId);
			roleCriteria.andTenantIdEqualTo(tenantId);
			if (inactiveTime != null) {
				roleCriteria.andInactiveTimeGreaterThan(inactiveTime);
			}
			if (activeTime != null) {
				roleCriteria.andActiveTimeLessThanOrEqualTo(activeTime);
			}
			List<GnRole> gnRoleList = gnRoleMapper.selectByExample(roleExample);
			if (gnRoleList != null && gnRoleList.size() > 0) {
				roleIdList = new LinkedList<Long>();
				for (GnRole gnRole : gnRoleList) {
					Long roleId = gnRole.getRoleId();
					if (roleId != null) {
						roleIdList.add(roleId);
					}
				}
			}
		}
		return roleIdList;
	}

	@Override
	public List<GnRoleMenu> getMenuByRole(List<Long> roleId, String tenantId) {
		String message = "Parameters into getMenuByRole : roleId = " + roleId.toString() + "tenantId = " + tenantId;
		LOGGER.info(message);
		List<GnRoleMenu> gnRoleMenus = null;
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		gnRoleMenus = checkMenuByRoles(roleId, tenantId, currTimestamp, currTimestamp);
		if (gnRoleMenus != null && gnRoleMenus.size() > 0) {
			JSONArray returnVo = JSONArray.fromObject(gnRoleMenus);
			message = "Result from getMenuByRole :" + returnVo.toString();
			LOGGER.info(message);
		} else {
			message = "Result from getMenuByRole : roleId " + roleId + " not exist.";
			LOGGER.info(message);
		}
		return gnRoleMenus;
	}

	@Override
	public List<GnRoleMenu> getMenuByRole(List<Long> roleId, String tenantId, Timestamp activeTime, Timestamp inactiveTime) {
		String message = "Parameters into getMenuByRole : roleId = " + roleId.toString() + "tenantId = " + tenantId + "inactiveTime=" + inactiveTime;
		LOGGER.info(message);
		List<GnRoleMenu> gnRoleMenus = null;
		gnRoleMenus = checkMenuByRoles(roleId, tenantId, activeTime, inactiveTime);
		if (gnRoleMenus != null && gnRoleMenus.size() > 0) {
			JSONArray returnVo = JSONArray.fromObject(gnRoleMenus);
			message = "Result from getMenuByRole :" + returnVo.toString();
			LOGGER.info(message);
		} else {
			message = "Result from getMenuByRole : roleId " + roleId + " not exist.";
			LOGGER.info(message);
		}
		return gnRoleMenus;
	}

	/**
	 * 通过角色获取菜单信息
	 * 
	 * @param roleId
	 * @param tenantId
	 * @param activeTime
	 * @param inactiveTime
	 * @return
	 */
	private List<GnRoleMenu> checkMenuByRoles(List<Long> roleId, String tenantId, Timestamp activeTime, Timestamp inactiveTime) {
		List<GnRoleMenu> gnRoleMenus = null;
		if (roleId != null && roleId.size() > 0 && StringUtils.isNotEmpty(tenantId)) {
			GnRoleMenuCriteria gnRoleMenuCriteria = new GnRoleMenuCriteria();
			GnRoleMenuCriteria.Criteria criteria = gnRoleMenuCriteria.createCriteria();
			criteria.andRoleIdIn(roleId);
			criteria.andTenantIdEqualTo(tenantId);
			if (inactiveTime != null) {
				criteria.andInactiveTimeGreaterThan(inactiveTime);
			}
			if (activeTime != null) {
				criteria.andActiveTimeLessThanOrEqualTo(activeTime);
			}
			gnRoleMenuCriteria.setOrderByClause("MENU_ID asc, ROLE_MENU_REL_ID desc");
			gnRoleMenus = MapperFactory.getGnRoleMenuMapper().selectByExample(gnRoleMenuCriteria);
		}
		return gnRoleMenus;
	}

	@Override
	public GnRole queryRoleById(GnRole gnRole) {
		GnRole result = null;
		if (gnRole != null) {
			long roleId = gnRole.getRoleId();
			String tenantId = gnRole.getTenantId();
			if (StringUtils.isEmpty(roleId + "")) {
				LOGGER.error("roleId不能为空！");
			} else if (StringUtils.isEmpty(tenantId)) {
				LOGGER.error("tenantId不能为空！");
			} else {
				// 设置查询条件
				GnRoleMapper gnRoleMapper = MapperFactory.getGnRoleMapper();
				GnRoleCriteria example = new GnRoleCriteria();
				Criteria roleCriteria = example.createCriteria();
				roleCriteria.andRoleIdEqualTo(roleId);
				roleCriteria.andTenantIdEqualTo(tenantId);
				Timestamp inactiveTime = gnRole.getInactiveTime();
				if (inactiveTime != null) {
					roleCriteria.andInactiveTimeGreaterThan(inactiveTime);
				}
				Timestamp activeTime = gnRole.getActiveTime();
				if (activeTime != null) {
					roleCriteria.andActiveTimeLessThanOrEqualTo(activeTime);
				}
				// 查询Role
				List<GnRole> gnRoleList = gnRoleMapper.selectByExample(example);
				if (gnRoleList != null && gnRoleList.size() > 0) {
					result = gnRoleList.get(0);
				}
			}
		}
		return result;
	}

	@Override
	public PageInfo<GnRole> queryRole(GnRoleParamsVO gnRoleParamsVO) {
		PageInfo<GnRole> resultPage = new PageInfo<GnRole>();

		List<GnRole> gnRoleList = null;
		int count = 0;
		Integer pageSize = PAGESIZE;

		if (gnRoleParamsVO != null) {

			if (StringUtils.isEmpty(gnRoleParamsVO.getTenantId())) {
				LOGGER.error("tenantId不能为空！");
			} else {
				GnRoleCriteria gnRoleCriteria = new GnRoleCriteria();
				GnRoleCriteria.Criteria criteria = gnRoleCriteria.createCriteria();
				criteria.andTenantIdEqualTo(gnRoleParamsVO.getTenantId());

				Timestamp inactiveTime = gnRoleParamsVO.getInactiveTime();
				if (inactiveTime != null) {
					// 查询未过期的数据
					criteria.andInactiveTimeGreaterThan(inactiveTime);
				}
				Timestamp activeTime = gnRoleParamsVO.getActiveTime();
				if (activeTime != null) {
					criteria.andActiveTimeLessThanOrEqualTo(activeTime);
				}
				if (!StringUtils.isEmpty(gnRoleParamsVO.getRoleName())) {
					criteria.andRoleNameLike("%" + gnRoleParamsVO.getRoleName() + "%");
				}
				Integer pageNumber = gnRoleParamsVO.getPageInfo().getPageNo();
				pageSize = gnRoleParamsVO.getPageInfo().getPageSize();

				// 分页计算出分页的开始条数和结束条数
				int startNum = 0;
				int endNum = 0;
				if (pageNumber <= 0 || pageSize <= 0) {
					startNum = 0;
					endNum = 0;
				} else {
					startNum = (pageNumber * pageSize - pageSize);
					if (startNum < 0) {
						startNum = 0;
					}
					endNum = pageSize;
					if (endNum < 0) {
						endNum = 0;
					}
				}
				gnRoleCriteria.setLimitStart(startNum);
				gnRoleCriteria.setLimitEnd(endNum);
				gnRoleCriteria.setOrderByClause("CREATE_TIME desc,ROLE_ID desc");

				gnRoleList = MapperFactory.getGnRoleMapper().selectByExample(gnRoleCriteria);
				count = MapperFactory.getGnRoleMapper().countByExample(gnRoleCriteria);
			}
		}

		if (gnRoleList != null) {
			resultPage.setCount(count);
			resultPage.setResult(gnRoleList);
			resultPage.setPageSize(pageSize);
		} else {
			resultPage = null;
		}

		return resultPage;
	}

	@Override
	public Long addRole(GnRole gnRole) {
		Long roleId = null;
		// 设置对象默认值
		gnRole.setRoleId(SeqUtil.getNewId("RUNNER_SYS_ROLE_PAYMENT$ID$SEQ"));
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		gnRole.setCreateTime(currTimestamp);
		long i = MapperFactory.getGnRoleMapper().insertSelective(gnRole);
		if (i > 0) {
			roleId = gnRole.getRoleId();
		}
		return roleId;
	}

	@Override
	public Integer updateRole(GnRole gnRole) {
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		gnRole.setUpdateTime(currTimestamp);
		GnRoleCriteria example=new GnRoleCriteria();
		Criteria createCriteria=example.createCriteria();
		createCriteria.andTenantIdEqualTo(gnRole.getTenantId());
		createCriteria.andRoleIdEqualTo(gnRole.getRoleId());
		Integer i = MapperFactory.getGnRoleMapper().updateByExampleSelective(gnRole, example);
		if (i > 0) {
			LOGGER.info("update role data success");
		} else {
			LOGGER.info("update role data failed");
		}
		return i;
	}

	@Override
	public Integer delRoleByID(GnRole gnRole) {
		Integer i = null;
		if (gnRole != null) {
			// 设置对象默认值
			Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
			gnRole.setUpdateTime(currTimestamp);
			String currStartTimeStr = DateTimeUtil.timstamp2String(currTimestamp);
			Timestamp currData = DateTimeUtil.stringToTimstamp(2,currStartTimeStr);//时分秒为0
			gnRole.setInactiveTime(currData);
			i = MapperFactory.getGnRoleMapper().updateByPrimaryKeySelective(gnRole);
		}
		return i;
	}

	@Override
	public PageInfo<GnRole> getRolesFilterIds(GnRoleParamsVO roleParamsVO) {
		LOGGER.info("Pameter into getRolesFilterIds GnRoleParamsVO:" + JSONObject.fromObject(roleParamsVO));
		PageInfo<GnRole> resultPage = null;
		List<GnRole> gnRoleList = null;
		int count = 0;
		if (roleParamsVO != null) {
			if (StringUtils.isEmpty(roleParamsVO.getTenantId())) {
				LOGGER.error("tenantId不能为空！");
			} else {
				Integer pageSize = roleParamsVO.getPageInfo().getPageSize();
				if (pageSize == null || pageSize == 0) {
					pageSize = PAGESIZE;
				}
				// 获得查询not in roleids的sql条件
				GnRoleCriteria gnRoleCriteria = getQueryNotInCriteria(roleParamsVO, pageSize);
				gnRoleList = MapperFactory.getGnRoleMapper().selectByExample(gnRoleCriteria);
				count = MapperFactory.getGnRoleMapper().countByExample(gnRoleCriteria);
				if (gnRoleList != null && gnRoleList.size() > 0) {
					resultPage = new PageInfo<GnRole>();
					resultPage.setCount(count);
					resultPage.setResult(gnRoleList);
					resultPage.setPageSize(pageSize);
				}
			}
		}
		return resultPage;
	}

	/**
	 * 获得查询not in roleids的sql条件
	 * 
	 * @param roleParamsVO
	 * @param pageSize
	 * @return
	 */
	private GnRoleCriteria getQueryNotInCriteria(GnRoleParamsVO roleParamsVO, Integer pageSize) {
		GnRoleCriteria gnRoleCriteria = new GnRoleCriteria();
		GnRoleCriteria.Criteria criteria = gnRoleCriteria.createCriteria();
		String roleName = roleParamsVO.getRoleName();
		if(StringUtils.isNotEmpty(roleName)){
			criteria.andRoleNameLike("%"+roleName+"%");
		}
		Timestamp inactiveTime = roleParamsVO.getInactiveTime();
		if (inactiveTime != null) {
			// 查询未过期的数据
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		Timestamp activeTime = roleParamsVO.getActiveTime();
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}
		criteria.andTenantIdEqualTo(roleParamsVO.getTenantId());
		List<Long> filterRoleIdList = roleParamsVO.getFilterRoleIdList();
		if (filterRoleIdList != null && filterRoleIdList.size() > 0) {
			criteria.andRoleIdNotIn(filterRoleIdList);
		}
		Integer pageNumber = roleParamsVO.getPageInfo().getPageNo();
		// 分页计算出分页的开始条数和结束条数
		int startNum = 0;
		int endNum = 0;
		if (pageNumber <= 0 || pageSize <= 0) {
			startNum = 0;
			endNum = 0;
		} else {
			startNum = (pageNumber * pageSize - pageSize);
			if (startNum < 0) {
				startNum = 0;
			}
			endNum = pageSize;
			if (endNum < 0) {
				endNum = 0;
			}
		}
		gnRoleCriteria.setLimitStart(startNum);
		gnRoleCriteria.setLimitEnd(endNum);
		gnRoleCriteria.setOrderByClause("CREATE_TIME desc,ROLE_ID desc");
		return gnRoleCriteria;
	}

	@Override
	public List<GnOperRole> getRolesByOperId4FramePage(Long operId,
			String tenantId, String systemId, String systemModeId) {
		GnOperRoleCriteria gnOperRoleCriteria = new GnOperRoleCriteria();
		GnOperRoleCriteria.Criteria criteria = gnOperRoleCriteria.createCriteria();
		criteria.andOperIdEqualTo(operId);
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		criteria.andTenantIdEqualTo(tenantId);
		criteria.andInactiveTimeGreaterThan(currTimestamp);
		criteria.andActiveTimeLessThanOrEqualTo(currTimestamp);
		/*List<Long> roleIdList =getRoleIdList4FramePage(tenantId,systemId,systemModeId);
		if (roleIdList != null && roleIdList.size() > 0) {
			criteria.andRoleIdIn(roleIdList);
		}*/
		return MapperFactory.getGnOperRoleMapper().selectByExample(gnOperRoleCriteria);
	}

	
	// private List<Long> getRoleIdList4FramePage(String tenantId,String
	// systemId,String systemModeId) {
	// List<Long> roleIdList = null;
	// // 获取角色相关信息
	// GnRoleMapper gnRoleMapper = MapperFactory.getGnRoleMapper();
	// GnRoleCriteria roleExample = new GnRoleCriteria();
	// GnRoleCriteria.Criteria roleCriteria = roleExample.createCriteria();
	// roleCriteria.andTenantIdEqualTo(tenantId);
	// if(!StringUtil.isBlank(systemId)){
	// roleCriteria.andSystemIdEqualTo(systemId);
	// }
	// if(!StringUtil.isBlank(systemModeId)){
	// roleCriteria.andSystemModeIdEqualTo(systemModeId);
	// }
	// Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
	// roleCriteria.andInactiveTimeGreaterThan(currTimestamp);
	// roleCriteria.andActiveTimeLessThanOrEqualTo(currTimestamp);
	// List<GnRole> gnRoleList = gnRoleMapper.selectByExample(roleExample);
	// if (gnRoleList != null && gnRoleList.size() > 0) {
	// roleIdList = new LinkedList<Long>();
	// for (GnRole gnRole : gnRoleList) {
	// Long roleId = gnRole.getRoleId();
	// if (roleId != null) {
	// roleIdList.add(roleId);
	// }
	// }
	// }
	// return roleIdList;
	// }

}

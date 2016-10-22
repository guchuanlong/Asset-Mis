package com.myunihome.myxapp.sso.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.sequence.SeqUtil;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.DateUtil;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenu;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenuCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnRoleMenuCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnRoleMenuMapper;
import com.myunihome.myxapp.sso.service.IRoleMenuService;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuParamsVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Component
public class RoleMenuServiceImpl implements IRoleMenuService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleMenuServiceImpl.class);

	@Override
	public Long addMenuToRole(GnRoleMenu gnRoleMenu) {
		Long roleMenuRelId = null;
		if (gnRoleMenu != null) {
			gnRoleMenu.setRoleMenuRelId(SeqUtil.getNewId("RUNNER_SYS_ROLE_MENU_PAYMENT$ID$SEQ"));
			Timestamp currTime = DateTimeUtil.getCurrTimestamp();
			gnRoleMenu.setCreateTime(currTime);
			Timestamp activeTime = gnRoleMenu.getActiveTime();
			if(activeTime == null){
				String currStartTimeStr = DateTimeUtil.timstamp2String(currTime);
				Timestamp currData = DateTimeUtil.stringToTimstamp(2,currStartTimeStr);//时分秒为0
				gnRoleMenu.setActiveTime(currData);
			}
			long i = MapperFactory.getGnRoleMenuMapper().insertSelective(gnRoleMenu);
			if (i > 0) {
				roleMenuRelId = gnRoleMenu.getRoleMenuRelId();
			}
		}
		return roleMenuRelId;
	}

	@Override
	public PageInfo<GnRoleMenu> queryMenuByRole(GnRoleMenuParamsVO roleMenuParamsVO) {
		PageInfo<GnRoleMenu> resultPage = new PageInfo<GnRoleMenu>();

		int count = 0;
		Integer pageSize = 5;
		List<GnRoleMenu> roleMenuList = null;

		if (roleMenuParamsVO != null) {
			GnRoleMenuCriteria gnRoleMenuCriteria = new GnRoleMenuCriteria();
			GnRoleMenuCriteria.Criteria criteria = gnRoleMenuCriteria.createCriteria();
			Timestamp inactiveTime = roleMenuParamsVO.getInactiveTime();
			if (!StringUtils.isEmpty(roleMenuParamsVO.getTenantId())) {
				criteria.andTenantIdEqualTo(roleMenuParamsVO.getTenantId());
			}
			if (roleMenuParamsVO.getRoleId() != null) {
				criteria.andRoleIdEqualTo(roleMenuParamsVO.getRoleId());
			}
			if (!StringUtils.isEmpty(roleMenuParamsVO.getRoleName())) {
				criteria.andRoleNameLike("%" + roleMenuParamsVO.getRoleName() + "%");
			}
			if (inactiveTime != null) {
				criteria.andInactiveTimeGreaterThan(inactiveTime);
			}
			Timestamp activeTime = roleMenuParamsVO.getActiveTime();
			if (activeTime != null) {
				criteria.andActiveTimeLessThanOrEqualTo(activeTime);
			}
			Integer pageNumber = roleMenuParamsVO.getPageInfo().getPageNo();
			pageSize = roleMenuParamsVO.getPageInfo().getPageSize();

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
			gnRoleMenuCriteria.setLimitStart(startNum);
			gnRoleMenuCriteria.setLimitEnd(endNum);

			gnRoleMenuCriteria.setOrderByClause("CREATE_TIME desc,ROLE_MENU_REL_ID desc");

			LOGGER.info("数据库查询条件：" + gnRoleMenuCriteria.toString());
			roleMenuList = MapperFactory.getGnRoleMenuMapper().selectByExample(gnRoleMenuCriteria);
			count = MapperFactory.getGnRoleMenuMapper().countByExample(gnRoleMenuCriteria);
		}

		if (roleMenuList != null) {
			resultPage.setCount(count);
			resultPage.setResult(roleMenuList);
			resultPage.setPageSize(pageSize);
		} else {
			resultPage = null;
		}

		return resultPage;
	}

	@Override
	public Integer updateRoleMenu(GnRoleMenuParamsVO roleMenuParamsVO) {
		LOGGER.info("Parameters into updateRoleMenu  GnRoleMenuParamsVO :" + JSONObject.fromObject(roleMenuParamsVO));
		GnRoleMenuMapper roleMenuMapper = MapperFactory.getGnRoleMenuMapper();
		GnRoleMenu roleMenuVO = new GnRoleMenu();
		GnRoleMenuCriteria operRoleCriteria = getUpdateRoleMenuCriteria(roleMenuParamsVO);
		BeanUtils.copyProperties(roleMenuVO, roleMenuParamsVO);
		roleMenuVO.setUpdateTime(DateUtil.getSysDate());
		return roleMenuMapper.updateByExampleSelective(roleMenuVO, operRoleCriteria);
	}

	/**
	 * 获得更新角色菜单信息的条件
	 * 
	 * @param operRoleParamsVO
	 * @return
	 */
	private GnRoleMenuCriteria getUpdateRoleMenuCriteria(GnRoleMenuParamsVO roleMenuParamsVO) {
		GnRoleMenuCriteria roleMenuCriteria = new GnRoleMenuCriteria();
		Criteria criteria = roleMenuCriteria.createCriteria();
		String tenantId = roleMenuParamsVO.getTenantId();
		if (StringUtils.isNoneEmpty(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		Long roleMenuRelId = roleMenuParamsVO.getRoleMenuRelId();
		if (roleMenuRelId != null) {
			criteria.andRoleMenuRelIdEqualTo(roleMenuRelId);
		}
		Long menuId = roleMenuParamsVO.getMenuId();
		if (menuId != null) {
			criteria.andMenuIdEqualTo(menuId);
		}
		Long roleId = roleMenuParamsVO.getRoleId();
		if (roleId != null) {
			criteria.andRoleIdEqualTo(roleId);
		}
		return roleMenuCriteria;
	}

	@Override
	public List<GnRoleMenu> queryMenuListByRoleId(GnRoleMenuParamsVO roleMenuParamsVO) {
		LOGGER.info("Pamater into queryMenuListByRoleId GnRoleMenuParamsVO:" + JSONObject.fromObject(roleMenuParamsVO));
		GnRoleMenuMapper gnRoleMenuMapper = MapperFactory.getGnRoleMenuMapper();
		// 获取角色含有的菜单的sql条件
		GnRoleMenuCriteria roleMenuCriteria = getQueryMenuListCriteria(roleMenuParamsVO);
		return gnRoleMenuMapper.selectByExample(roleMenuCriteria);
	}

	/**
	 * 获取角色含有的菜单的sql条件
	 * 
	 * @param operRoleParamsVO
	 * @return
	 */
	private GnRoleMenuCriteria getQueryMenuListCriteria(GnRoleMenuParamsVO roleMenuParamsVO) {
		GnRoleMenuCriteria roleMenuCriteria = new GnRoleMenuCriteria();
		Criteria criteria = roleMenuCriteria.createCriteria();
		String tenantId = roleMenuParamsVO.getTenantId();
		if (StringUtils.isNoneEmpty(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		Long roleId = roleMenuParamsVO.getRoleId();
		if (roleId != null) {
			criteria.andRoleIdEqualTo(roleId);
		}
		Timestamp inactiveTime = roleMenuParamsVO.getInactiveTime();
		if (inactiveTime != null) {
			// 查询未过期的数据
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		Timestamp activeTime = roleMenuParamsVO.getActiveTime();
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}
		roleMenuCriteria.setOrderByClause("CREATE_TIME desc,ROLE_MENU_REL_ID desc");
		return roleMenuCriteria;
	}

	@Override
	public Integer deleteRoleMenu(GnRoleMenuParamsVO roleMenuParamsVO) {
		GnRoleMenuCriteria roleMenuCriteria = getDelRoleMenuCriteria(roleMenuParamsVO);
		GnRoleMenu gnRoleMenu = new GnRoleMenu();
		BeanUtils.copyProperties(gnRoleMenu, roleMenuParamsVO);
		//设置失效日期为当前
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		String currStartTimeStr = DateTimeUtil.timstamp2String(currTimestamp);
		Timestamp currData = DateTimeUtil.stringToTimstamp(2,currStartTimeStr);//时分秒为0
		gnRoleMenu.setInactiveTime(currData);
		GnRoleMenuMapper gnRoleMenuMapper = MapperFactory.getGnRoleMenuMapper();
		return gnRoleMenuMapper.updateByExampleSelective(gnRoleMenu, roleMenuCriteria);
	}

	/**
	 * 获取删除条件
	 * @param roleMenuParamsVO
	 * @return
	 * @author jiaxs
	 */
	private GnRoleMenuCriteria getDelRoleMenuCriteria(GnRoleMenuParamsVO roleMenuParamsVO) {
		GnRoleMenuCriteria roleMenuCriteria = new GnRoleMenuCriteria();
		Criteria createCriteria = roleMenuCriteria.createCriteria();
		String tenantId = roleMenuParamsVO.getTenantId();
		if(StringUtils.isNotEmpty(tenantId)){
			createCriteria.andTenantIdEqualTo(tenantId);
		}
		Long roleMenuRelId = roleMenuParamsVO.getRoleMenuRelId();
		if(roleMenuRelId != null){
			createCriteria.andRoleMenuRelIdEqualTo(roleMenuRelId);
		}
		Long menuId = roleMenuParamsVO.getMenuId();
		if(menuId != null){
			createCriteria.andMenuIdEqualTo(menuId);
		}
		Long roleId = roleMenuParamsVO.getRoleId();
		if(roleId != null){
			createCriteria.andRoleIdEqualTo(roleId);
		}
		return roleMenuCriteria;
	}

}

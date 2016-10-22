package com.myunihome.myxapp.sso.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.sequence.SeqUtil;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.StringUtil;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByConditionVO;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByOperIDVO;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnMenu;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnMenuCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnMenuCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.service.IMenuService;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuParamsVO;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class MenuServiceImpl implements IMenuService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
	private static final int PAGESIZE = 5;

	@Override
	public List<GetMenuByOperIDVO> getMenuByMenuId(List<Long> menuId, String tenantId) {
		String message = "Parameters into getMenuByMenuId : menuId = " + menuId.toString() + "tenantId = " + tenantId;
		LOGGER.info(message);
		List<GetMenuByOperIDVO> getMenuByOpervos = null;
		if (menuId.size() > 0 && !tenantId.isEmpty()) {
			Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
			getMenuByOpervos = checkMenusByMenuId(menuId, tenantId, currTimestamp, currTimestamp);
			if (getMenuByOpervos != null && getMenuByOpervos.size() > 0) {
				JSONArray returnVo = JSONArray.fromObject(getMenuByOpervos);
				message = "Result from getMenuByMenuId :" + returnVo.toString();
				LOGGER.info(message);
			} else {
				message = "Result from getMenuByMenuId : menuId " + menuId + " not exist.";
				LOGGER.info(message);
			}
		} else {
			message = "Result from getMenuByMenuId : No values for input parameters. ";
			LOGGER.info(message);
		}
		return getMenuByOpervos;

	}

	@Override
	public List<GetMenuByOperIDVO> getMenuByMenuId(List<Long> menuId, String tenantId, Timestamp activeTime, Timestamp inactiveTime) {
		String message = "Parameters into getMenuByMenuId : menuId = " + menuId.toString() + "tenantId = " + tenantId + "inactiveTime=" + inactiveTime;
		LOGGER.info(message);
		List<GetMenuByOperIDVO> getMenuByOpervos = null;
		if (menuId.size() > 0 && !tenantId.isEmpty()) {
			getMenuByOpervos = checkMenusByMenuId(menuId, tenantId, activeTime, inactiveTime);
			if (getMenuByOpervos != null && getMenuByOpervos.size() > 0) {
				JSONArray returnVo = JSONArray.fromObject(getMenuByOpervos);
				message = "Result from getMenuByMenuId :" + returnVo.toString();
				LOGGER.info(message);
			} else {
				message = "Result from getMenuByMenuId : menuId " + menuId + " not exist.";
				LOGGER.info(message);
			}
		} else {
			message = "Result from getMenuByMenuId : No values for input parameters. ";
			LOGGER.info(message);
		}
		return getMenuByOpervos;

	}

	/**
	 * 通过菜单id获得菜单信息
	 * 
	 * @param menuIdList
	 * @param tenantId
	 * @param inactiveTime
	 * @return
	 */
	private List<GetMenuByOperIDVO> checkMenusByMenuId(List<Long> menuIdList, String tenantId, Timestamp activeTime, Timestamp inactiveTime) {
		List<GetMenuByOperIDVO> getMenuByOpervos = null;
		GnMenuCriteria gnMenuCriteria = new GnMenuCriteria();
		GnMenuCriteria.Criteria criteria = gnMenuCriteria.createCriteria();
		if (menuIdList != null && menuIdList.size() > 0) {
			criteria.andMenuIdIn(menuIdList);
		}
		if (StringUtils.isNotEmpty(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}
		if (inactiveTime != null) {
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		List<GnMenu> gnMenus = MapperFactory.getGnMenuMapper().selectByExample(gnMenuCriteria);
		if (gnMenus.size() > 0) {
			getMenuByOpervos = new ArrayList<GetMenuByOperIDVO>();
			for (int i = 0; i < gnMenus.size(); i++) {
				GetMenuByOperIDVO getMenuByOpervo = new GetMenuByOperIDVO();
				BeanUtils.copyProperties(getMenuByOpervo, gnMenus.get(i));
				getMenuByOpervos.add(getMenuByOpervo);
			}
		}
		return getMenuByOpervos;
	}

	@Override
	public List<GetMenuByConditionVO> getMenuByConditon(List<Long> menuId, String tenantId) {
		String message = "Parameters into getMenuByMenuId : menuId = " + menuId.toString() + "tenantId = " + tenantId;
		LOGGER.info(message);
		List<GetMenuByConditionVO> getMenuByConditionVos = null;
		if (menuId.size() > 0 && !tenantId.isEmpty()) {
			Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
			getMenuByConditionVos = checkMenusByConditon(menuId, tenantId, null, currTimestamp, currTimestamp);
			if (getMenuByConditionVos != null && getMenuByConditionVos.size() > 0) {
				JSONArray returnVo = JSONArray.fromObject(getMenuByConditionVos);
				message = "Result from getMenuByMenuId :" + returnVo.toString();
				LOGGER.info(message);
			} else {
				message = "Result from getMenuByMenuId : menuId " + menuId + " not exist.";
				LOGGER.info(message);
			}
		} else {
			message = "Result from getMenuByMenuId : No values for input parameters. ";
			LOGGER.info(message);
		}
		return getMenuByConditionVos;
	}

	@Override
	public List<GetMenuByConditionVO> getMenuByConditon(List<Long> menuId, String tenantId, Timestamp activeTime, Timestamp inactiveTime) {
		String message = "Parameters into getMenuByMenuId : menuId = " + menuId.toString() + "tenantId = " + tenantId + "inactiveTime=" + inactiveTime;
		LOGGER.info(message);
		List<GetMenuByConditionVO> getMenuByConditionVos = null;
		if (menuId.size() > 0 && !tenantId.isEmpty()) {
			getMenuByConditionVos = checkMenusByConditon(menuId, tenantId, null, activeTime, inactiveTime);
			if (getMenuByConditionVos != null && getMenuByConditionVos.size() > 0) {
				JSONArray returnVo = JSONArray.fromObject(getMenuByConditionVos);
				message = "Result from getMenuByMenuId :" + returnVo.toString();
				LOGGER.info(message);
			} else {
				message = "Result from getMenuByMenuId : menuId " + menuId + " not exist.";
				LOGGER.info(message);
			}
		} else {
			message = "Result from getMenuByMenuId : No values for input parameters. ";
			LOGGER.info(message);
		}
		return getMenuByConditionVos;
	}

	@Override
	public List<GetMenuByConditionVO> getMenuByConditon(List<Long> menuId, String tenantId, String systemModeId) {
		String message = "Parameters into getMenuByMenuId : menuId = " + menuId.toString() + "tenantId = " + tenantId;
		LOGGER.info(message);
		List<GetMenuByConditionVO> getMenuByConditionVos = null;
		if (menuId.size() > 0 && !tenantId.isEmpty()) {
			Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
			getMenuByConditionVos = checkMenusByConditon(menuId, tenantId, systemModeId,currTimestamp, currTimestamp);
			if (getMenuByConditionVos != null && getMenuByConditionVos.size() > 0) {
				JSONArray returnVo = JSONArray.fromObject(getMenuByConditionVos);
				message = "Result from getMenuByMenuId :" + returnVo.toString();
				LOGGER.info(message);
			} else {
				message = "Result from getMenuByMenuId : menuId " + menuId + " not exist.";
				LOGGER.info(message);
			}
		} else {
			message = "Result from getMenuByMenuId : No values for input parameters. ";
			LOGGER.info(message);
		}
		return getMenuByConditionVos;
	}

	@Override
	public List<GetMenuByConditionVO> getMenuByConditon(List<Long> menuId, String tenantId, String systemModeId,Timestamp activeTime, Timestamp inactiveTime) {
		String message = "Parameters into getMenuByMenuId : menuId = " + menuId.toString() + "tenantId = " + tenantId + "inactiveTime=" + inactiveTime;
		LOGGER.info(message);
		List<GetMenuByConditionVO> getMenuByConditionVos = null;
		if (menuId.size() > 0 && !tenantId.isEmpty()) {
			getMenuByConditionVos = checkMenusByConditon(menuId, tenantId, systemModeId,activeTime, inactiveTime);
			if (getMenuByConditionVos != null && getMenuByConditionVos.size() > 0) {
				JSONArray returnVo = JSONArray.fromObject(getMenuByConditionVos);
				message = "Result from getMenuByMenuId :" + returnVo.toString();
				LOGGER.info(message);
			} else {
				message = "Result from getMenuByMenuId : menuId " + menuId + " not exist.";
				LOGGER.info(message);
			}
		} else {
			message = "Result from getMenuByMenuId : No values for input parameters. ";
			LOGGER.info(message);
		}
		return getMenuByConditionVos;
	}

	
	private List<GetMenuByConditionVO> checkMenusByConditon(List<Long> menuId, String tenantId, String systemModeId,Timestamp activeTime, Timestamp inactiveTime) {
		List<GetMenuByConditionVO> getMenuByConditionVos = null;
		GnMenuCriteria gnMenuCriteria = new GnMenuCriteria();
		GnMenuCriteria.Criteria criteria = gnMenuCriteria.createCriteria();
		if (menuId != null && menuId.size() > 0) {
			criteria.andMenuIdIn(menuId);
		}
		if (StringUtils.isNotEmpty(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		if(StringUtils.isNotEmpty(systemModeId)){
			criteria.andSystemModeIdEqualTo(systemModeId);
		}
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}
		if (inactiveTime != null) {
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}

		List<GnMenu> gnMenus = MapperFactory.getGnMenuMapper().selectByExample(gnMenuCriteria);
		if (gnMenus.size() > 0) {
			getMenuByConditionVos = new ArrayList<GetMenuByConditionVO>();
			for (int i = 0; i < gnMenus.size(); i++) {
				GetMenuByConditionVO getMenuByConditionVO = new GetMenuByConditionVO();

				BeanUtils.copyProperties(getMenuByConditionVO, gnMenus.get(i));

				getMenuByConditionVos.add(getMenuByConditionVO);
			}
		}
		return getMenuByConditionVos;
	}

	@Override
	public Long addMenu(GnMenu gnMenu) {
		Long menuId = null;
		if (gnMenu != null) {
			gnMenu.setMenuId(SeqUtil.getNewId("RUNNER_SYS_MENU_PAYMENT$ID$SEQ"));
			Timestamp currTime = DateTimeUtil.getCurrTimestamp();
			gnMenu.setCreateTime(currTime);
			long i = MapperFactory.getGnMenuMapper().insertSelective(gnMenu);
			if (i > 0) {
				menuId = gnMenu.getMenuId();
			}
		}

		return menuId;
	}

	@Override
	public Integer updateMenu(GnMenu gnMenu) {

		Integer i = null;
		if (gnMenu != null) {
			gnMenu.setUpdateTime(DateTimeUtil.getCurrTimestamp());
			i = MapperFactory.getGnMenuMapper().updateByPrimaryKeySelective(gnMenu);
		}

		return i;
	}

	@Override
	public Integer delMenuByID(GnMenu gnMenu) {
		Integer i = null;
		if (gnMenu != null) {
			// i = MapperFactory.getGnMenuMapper().updateByMenuId(gnMenu);
			GnMenu updateMenu = new GnMenu();// 设置更新对象 失效日期为当前
			Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
			updateMenu.setUpdateTime(currTimestamp);
			String currStartTimeStr = DateTimeUtil.timstamp2String(currTimestamp);
			Timestamp inactiveTime = DateTimeUtil.stringToTimstamp(2,currStartTimeStr);
			updateMenu.setInactiveTime(inactiveTime);
			GnMenuCriteria example = new GnMenuCriteria();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andMenuIdEqualTo(gnMenu.getMenuId());
			i = MapperFactory.getGnMenuMapper().updateByExampleSelective(updateMenu, example);
		}
		return i;
	}

	@Override
	public GnMenu queryMenuById(GnMenu gnMenu) {

		GnMenu result = null;
		if (gnMenu != null) {
			GnMenuCriteria example = new GnMenuCriteria();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andMenuIdEqualTo(gnMenu.getMenuId());
			createCriteria.andTenantIdEqualTo(gnMenu.getTenantId());
			Timestamp inactiveTime = gnMenu.getInactiveTime();
			if (inactiveTime != null) {
				createCriteria.andInactiveTimeGreaterThan(inactiveTime);
			}
			Timestamp activeTime = gnMenu.getActiveTime();
			if (activeTime != null) {
				createCriteria.andActiveTimeLessThanOrEqualTo(activeTime);
			}
			List<GnMenu> menuList = MapperFactory.getGnMenuMapper().selectByExample(example);
			if (menuList != null && menuList.size() > 0) {
				result = menuList.get(0);
			}
		}
		return result;
	}

	@Override
	public PageInfo<GnMenu> queryMenu(GnMenuParamsVO gnMenuParamsVO) {

		PageInfo<GnMenu> resultPage = new PageInfo<GnMenu>();

		int count = 0;
		Integer pageSize = PAGESIZE;
		List<GnMenu> gnMenuList = null;

		if (gnMenuParamsVO != null) {
			GnMenuCriteria gnMenuCriteria = new GnMenuCriteria();
			GnMenuCriteria.Criteria criteria = gnMenuCriteria.createCriteria();

			if (!StringUtils.isEmpty(gnMenuParamsVO.getTenantId())) {
				criteria.andTenantIdEqualTo(gnMenuParamsVO.getTenantId());
			}
			if (!StringUtils.isEmpty(gnMenuParamsVO.getMenuName())) {
				criteria.andMenuNameLike("%" + gnMenuParamsVO.getMenuName() + "%");
			}
			Timestamp inactiveTime = gnMenuParamsVO.getInactiveTime();
			if (inactiveTime != null) {
				criteria.andInactiveTimeGreaterThan(inactiveTime);
			}
			Timestamp activeTime = gnMenuParamsVO.getActiveTime();
			if (activeTime != null) {
				criteria.andActiveTimeLessThanOrEqualTo(activeTime);
			}
			Integer pageNumber = gnMenuParamsVO.getPageInfo().getPageNo();
			pageSize = gnMenuParamsVO.getPageInfo().getPageSize();

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
			gnMenuCriteria.setLimitStart(startNum);
			gnMenuCriteria.setLimitEnd(endNum);
			gnMenuCriteria.setOrderByClause("CREATE_TIME desc,MENU_ID desc");

			gnMenuList = MapperFactory.getGnMenuMapper().selectByExample(gnMenuCriteria);
			count = MapperFactory.getGnMenuMapper().countByExample(gnMenuCriteria);
		}

		if (gnMenuList != null) {
			resultPage.setCount(count);
			resultPage.setResult(gnMenuList);
			resultPage.setPageSize(pageSize);
		} else {
			resultPage = null;
		}

		return resultPage;
	}

	@Override
	public PageInfo<GnMenuVO> getMenuFilterIds(GnMenuParamsVO menuParamsVO) {
		LOGGER.info("Pameter into getMenuFilterIds GnMenuParamsVO:" + JSONObject.fromObject(menuParamsVO));
		PageInfo<GnMenuVO> resultPage = null;
		List<GnMenu> gnMenuList = null;
		int count = 0;
		if (menuParamsVO != null) {
			if (StringUtils.isEmpty(menuParamsVO.getTenantId())) {
				LOGGER.error("tenantId不能为空！");
			} else {
				Integer pageSize = menuParamsVO.getPageInfo().getPageSize();
				if (pageSize == null || pageSize == 0) {
					pageSize = PAGESIZE;
				}
				// 获得查询not in menuids的sql条件
				GnMenuCriteria gnMenuCriteria = getQueryNotInCriteria(menuParamsVO, pageSize);
				gnMenuList = MapperFactory.getGnMenuMapper().selectByExample(gnMenuCriteria);
				count = MapperFactory.getGnMenuMapper().countByExample(gnMenuCriteria);
				if (gnMenuList != null && gnMenuList.size() > 0) {
					Gson gson = new Gson();
					List<GnMenuVO> gnMenuVOList = gson.fromJson(gson.toJson(gnMenuList), new TypeToken<List<GnMenuVO>>() {
					}.getType());
					resultPage = new PageInfo<GnMenuVO>();
					resultPage.setCount(count);
					resultPage.setResult(gnMenuVOList);
					resultPage.setPageSize(pageSize);
				}
			}
		}
		return resultPage;
	}

	/**
	 * 获得查询not in roleids的sql条件
	 * 
	 * @param menuParamsVO
	 * @param pageSize
	 * @return
	 */
	private GnMenuCriteria getQueryNotInCriteria(GnMenuParamsVO menuParamsVO, Integer pageSize) {
		GnMenuCriteria gnMenuCriteria = new GnMenuCriteria();
		GnMenuCriteria.Criteria criteria = gnMenuCriteria.createCriteria();
		criteria.andTenantIdEqualTo(menuParamsVO.getTenantId());
		List<Long> filterMenuIdList = menuParamsVO.getFilterMenuIdList();
		if (filterMenuIdList != null && filterMenuIdList.size() > 0) {
			criteria.andMenuIdNotIn(filterMenuIdList);
		}
		String menuName = menuParamsVO.getMenuName();
		if (StringUtils.isNotEmpty(menuName)) {
			criteria.andMenuNameLike("%" + menuName + "%");
		}
		String systemModeId = menuParamsVO.getSystemModeId();
		if(StringUtils.isNotEmpty(systemModeId)){
			criteria.andSystemModeIdEqualTo(systemModeId);
		}
		Timestamp inactiveTime = menuParamsVO.getInactiveTime();
		if (inactiveTime != null) {
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		Timestamp activeTime = menuParamsVO.getActiveTime();
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}
		Integer pageNumber = menuParamsVO.getPageInfo().getPageNo();
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
		gnMenuCriteria.setLimitStart(startNum);
		gnMenuCriteria.setLimitEnd(endNum);
		gnMenuCriteria.setOrderByClause("CREATE_TIME desc,MENU_ID desc");
		return gnMenuCriteria;
	}

	@Override
	public List<GnMenu> getFramePageMenuByConditon(List<Long> menuIdList,GnMenu gnMenu) {
		String message = "Parameters into getFramePageMenuByConditon : menuId = " + menuIdList.toString() + ",gnMenu = " + JSON.toJSONString(gnMenu);
		LOGGER.info(message);
		List<GnMenu> menus = null;
		if (menuIdList.size() > 0 && !StringUtil.isBlank(gnMenu.getTenantId())) {
			menus = checkFramePageMenusByConditon(menuIdList, gnMenu);
			if (menus != null && menus.size() > 0) {
				JSONArray returnVo = JSONArray.fromObject(menus);
				message = "Result from getFramePageMenuByConditon :" + returnVo.toString();
				LOGGER.info(message);
			} else {
				message = "Result from getFramePageMenuByConditon : menuId " + menuIdList + " not exist.";
				LOGGER.info(message);
			}
		} else {
			message = "Result from getFramePageMenuByConditon : No values for input parameters. ";
			LOGGER.info(message);
		}
		return menus;
	}
	
	private List<GnMenu> checkFramePageMenusByConditon(List<Long> menuIdList, GnMenu gnMenu) {
		GnMenuCriteria gnMenuCriteria = new GnMenuCriteria();
		GnMenuCriteria.Criteria criteria = gnMenuCriteria.createCriteria();
		if (menuIdList != null && menuIdList.size() > 0) {
			criteria.andMenuIdIn(menuIdList);
		}
		if (StringUtils.isNotEmpty(gnMenu.getTenantId())) {
			criteria.andTenantIdEqualTo(gnMenu.getTenantId());
		}
		if(StringUtils.isNotEmpty(gnMenu.getSystemId())){
			criteria.andSystemIdEqualTo(gnMenu.getSystemId());
		}
		if(StringUtils.isNotEmpty(gnMenu.getSystemModeId())){
			criteria.andSystemModeIdEqualTo(gnMenu.getSystemModeId());
		}
		if (gnMenu.getActiveTime() != null) {
			criteria.andActiveTimeLessThanOrEqualTo(gnMenu.getActiveTime());
		}
		if (gnMenu.getInactiveTime() != null) {
			criteria.andInactiveTimeGreaterThan(gnMenu.getInactiveTime());
		}

		return MapperFactory.getGnMenuMapper().selectByExample(gnMenuCriteria);
	}

}

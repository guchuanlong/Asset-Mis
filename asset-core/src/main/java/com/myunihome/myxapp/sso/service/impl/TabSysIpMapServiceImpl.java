package com.myunihome.myxapp.sso.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMap;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMapCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMapKey;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSysIpMapCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnTabSysIpMapMapper;
import com.myunihome.myxapp.sso.service.ITabSysIpMapService;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapParamVO;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapVO;

@Component
public class TabSysIpMapServiceImpl implements ITabSysIpMapService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TabSysIpMapServiceImpl.class);

	private static final int PAGESIZE = 5;

	@Override
	public GnTabSysIpMap queryTabSysIpMap(GnTabSysIpMapKey tabSysIpMapKey) {
		String message = "Parameters into queryTabSysIpMap :" + JSON.toJSONString(tabSysIpMapKey);
		LOGGER.info(message);
		GnTabSysIpMapMapper gnTabSysIpMapMapper = MapperFactory.getGnTabSysIpMapMapper();
		return gnTabSysIpMapMapper.selectByPrimaryKey(tabSysIpMapKey);
	}

	@Override
	public PageInfo<GnTabSysIpMap> queryTabSysIpMapPageInfo(GnTabSysIpMapParamVO tabSysIpMapParamVO) {
		String message = "Parameters into queryTabSysIpMapPageInfo :" + JSON.toJSONString(tabSysIpMapParamVO);
		LOGGER.info(message);
		// 设置条件
		GnTabSysIpMapCriteria example = new GnTabSysIpMapCriteria();
		Criteria createCriteria = example.createCriteria();
		String tenantId = tabSysIpMapParamVO.getTenantId();
		if (StringUtils.isNotEmpty(tenantId)) {
			createCriteria.andTenantIdEqualTo(tenantId);
		}
		String connectIp = tabSysIpMapParamVO.getConnectIp();
		if (StringUtils.isNotEmpty(connectIp)) {
			createCriteria.andConnectIpEqualTo(connectIp);
		}
		String connectPort = tabSysIpMapParamVO.getConnectPort();
		if (StringUtils.isNotEmpty(connectPort)) {
			createCriteria.andConnectPortEqualTo(connectPort);
		}
		String systemId = tabSysIpMapParamVO.getSystemId();
		if (StringUtils.isNotEmpty(systemId)) {
			createCriteria.andSystemIdEqualTo(systemId);
		}
		PageInfo<GnTabSysIpMapVO> pageInfo = tabSysIpMapParamVO.getPageInfo();
		Integer pageSize = pageInfo.getPageSize();
		pageSize = pageSize == null || pageSize == 0 ? PAGESIZE : pageSize;
		Integer pageNo = pageInfo.getPageNo();
		example.setLimitStart((pageNo - 1) * pageSize);
		example.setLimitEnd(pageSize);
		// 查询
		GnTabSysIpMapMapper gnTabSysIpMapMapper = MapperFactory.getGnTabSysIpMapMapper();
		List<GnTabSysIpMap> selectByExample = gnTabSysIpMapMapper.selectByExample(example);
		int count = gnTabSysIpMapMapper.countByExample(example);
		PageInfo<GnTabSysIpMap> ipMapPageInfo = new PageInfo<GnTabSysIpMap>();
		ipMapPageInfo.setCount(count);
		ipMapPageInfo.setPageNo(pageNo);
		ipMapPageInfo.setPageSize(pageSize);
		ipMapPageInfo.setResult(selectByExample);
		return ipMapPageInfo;
	}

	@Override
	public int addTabSysIpMapPageInfo(GnTabSysIpMap tabSysIpMap) {
		String message = "Parameters into addTabSysIpMapPageInfo :" + JSON.toJSONString(tabSysIpMap);
		LOGGER.info(message);
		GnTabSysIpMapMapper gnTabSysIpMapMapper = MapperFactory.getGnTabSysIpMapMapper();
		return gnTabSysIpMapMapper.insertSelective(tabSysIpMap);
	}

	@Override
	public int updateTabSysIpMapPageInfo(GnTabSysIpMap tabSysIpMap) {
		String message = "Parameters into updateTabSysIpMapPageInfo :" + JSON.toJSONString(tabSysIpMap);
		LOGGER.info(message);
		GnTabSysIpMapMapper gnTabSysIpMapMapper = MapperFactory.getGnTabSysIpMapMapper();
		GnTabSysIpMapCriteria example = new GnTabSysIpMapCriteria();
		Criteria createCriteria = example.createCriteria();
		String tenantId = tabSysIpMap.getTenantId();
		createCriteria.andTenantIdEqualTo(tenantId);
		String connectIp = tabSysIpMap.getConnectIp();
		createCriteria.andConnectIpEqualTo(connectIp);
		String connectPort = tabSysIpMap.getConnectPort();
		createCriteria.andConnectPortEqualTo(connectPort);
		String systemId = tabSysIpMap.getSystemId();
		createCriteria.andSystemIdEqualTo(systemId);
		return gnTabSysIpMapMapper.updateByExampleSelective(tabSysIpMap, example);
	}
}

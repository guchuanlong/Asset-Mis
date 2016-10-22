package com.myunihome.myxapp.sso.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystem;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystemCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystemKey;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystemCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnTabSystemMapper;
import com.myunihome.myxapp.sso.service.ITabSystemService;

@Component
public class TabSystemServiceImpl implements ITabSystemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TabSystemServiceImpl.class);

	@Override
	public List<GnTabSystem> queryGnTabSystemList(GnTabSystemKey tabSystemKey) {
		String message = "Parameters into queryGnTabSystem :" + JSON.toJSONString(tabSystemKey);
		LOGGER.info(message);
		GnTabSystemMapper gnTabSystemMapper = MapperFactory.getGnTabSystemMapper();
		GnTabSystemCriteria example = new GnTabSystemCriteria();
		Criteria createCriteria = example.createCriteria();
		String tenantId = tabSystemKey.getTenantId();
		if (StringUtils.isNotEmpty(tenantId)) {
			createCriteria.andTenantIdEqualTo(tenantId);
		}
		String systemId = tabSystemKey.getSystemId();
		if (StringUtils.isNoneEmpty(systemId)) {
			createCriteria.andSystemIdEqualTo(systemId);
		}
		return gnTabSystemMapper.selectByExample(example);
	}

	@Override
	public GnTabSystem getGnTabSystem(GnTabSystemKey tabSystemKey) {
		return MapperFactory.getGnTabSystemMapper().selectByPrimaryKey(tabSystemKey);
	}

}

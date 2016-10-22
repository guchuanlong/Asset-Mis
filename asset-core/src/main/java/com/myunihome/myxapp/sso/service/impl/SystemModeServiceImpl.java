package com.myunihome.myxapp.sso.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemMode;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemModeCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemModeKey;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnSystemModeCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnSystemModeMapper;
import com.myunihome.myxapp.sso.service.ISystemModeService;

@Component
public class SystemModeServiceImpl implements ISystemModeService {
	@Override
	public GnSystemMode queryGnSystemModeByKey(GnSystemModeKey systemModeKey) {
		GnSystemModeMapper gnSystemModeMapper = MapperFactory.getGnSystemModeMapper();
		return gnSystemModeMapper.selectByPrimaryKey(systemModeKey);
	}

	@Override
	public List<GnSystemMode> queryGnSystemModeList(GnSystemMode systemMode) {
		GnSystemModeMapper gnSystemModeMapper = MapperFactory.getGnSystemModeMapper();
		GnSystemModeCriteria gnSystemModeCriteria = new GnSystemModeCriteria();
		Criteria criteria = gnSystemModeCriteria.createCriteria();
		criteria.andTenantIdEqualTo(systemMode.getTenantId());
		return gnSystemModeMapper.selectByExample(gnSystemModeCriteria);
	}

}

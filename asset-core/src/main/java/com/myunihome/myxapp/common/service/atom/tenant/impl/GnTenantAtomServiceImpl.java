package com.myunihome.myxapp.common.service.atom.tenant.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.dao.mapper.bo.GnTenant;
import com.myunihome.myxapp.common.service.atom.tenant.IGnTenantAtomService;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;

@Component
public class GnTenantAtomServiceImpl implements IGnTenantAtomService {

    @Override
    public GnTenant selectTenantById(String tenantId) {
        return MapperFactory.getGnTenantMapper().selectByPrimaryKey(tenantId);
    }

	@Override
	public List<GnTenant> selectAllTenant() throws CallerException {
		return MapperFactory.getGnTenantMapper().selectByExample(null);
	}
}

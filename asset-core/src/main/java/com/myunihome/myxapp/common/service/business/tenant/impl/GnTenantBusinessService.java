package com.myunihome.myxapp.common.service.business.tenant.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myunihome.myxapp.common.api.tenant.param.GnTenantConditon;
import com.myunihome.myxapp.common.api.tenant.param.GnTenantVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnTenant;
import com.myunihome.myxapp.common.service.atom.tenant.IGnTenantAtomService;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.CollectionUtil;

@Component
@Transactional
public class GnTenantBusinessService implements IGnTenantBusinessService {

    @Autowired
    private IGnTenantAtomService gnTenantAtomService;

    @Override
    public GnTenant selectTenantById(String tenantId) {
        return gnTenantAtomService.selectTenantById(tenantId);
    }

	@Override
	public GnTenant selectTenantById(GnTenantConditon gnTennatConditon) {
		 return gnTenantAtomService.selectTenantById(gnTennatConditon.getTenantId());
	}

	@Override
	public List<GnTenantVo> selectAllTenant() {
		List<GnTenantVo> resultList = new ArrayList<GnTenantVo>();
		List<GnTenant> dbList = gnTenantAtomService.selectAllTenant();
		if(!CollectionUtil.isEmpty(dbList)){
			for(GnTenant dbObj:dbList ){
				GnTenantVo vo=new GnTenantVo();
				BeanUtils.copyProperties(vo, dbObj);
				resultList.add(vo);
			}
		}
		
		return resultList;
	}

}

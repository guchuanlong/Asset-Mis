package com.myunihome.myxapp.common.api.tenant.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.tenant.interfaces.IGnTenantQuerySV;
import com.myunihome.myxapp.common.api.tenant.param.GnTenantConditon;
import com.myunihome.myxapp.common.api.tenant.param.GnTenantVo;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;

@Service
@Component
public class GnTenantQuerySVImpl implements IGnTenantQuerySV {
    @Autowired
    private IGnTenantBusinessService gnTenantBusinessService;

    @Override
    public GnTenantVo getTenant(GnTenantConditon gnTennatConditon) throws CallerException {
        if (StringUtils.isEmpty(gnTennatConditon.getTenantId())) {
            throw new BusinessException(Constants.ErrorCode.RESULT_ERROR, "ID不能为空");
        }
        Gson gson = new Gson();
        GnTenantVo result = gson.fromJson(
                gson.toJson(
                        gnTenantBusinessService.selectTenantById(gnTennatConditon.getTenantId())),
                GnTenantVo.class);
        return result;
    }

    @Override
    public List<GnTenantVo> getTenants() throws CallerException {
        return gnTenantBusinessService.selectAllTenant();
    }

}

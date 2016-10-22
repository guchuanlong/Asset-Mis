package com.myunihome.myxapp.common.service.business.tenant;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.tenant.param.GnTenantConditon;
import com.myunihome.myxapp.common.api.tenant.param.GnTenantVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnTenant;

public interface IGnTenantBusinessService {

    GnTenant selectTenantById(String tenantId);

    /**
     * 获取单个租户信息
     * 
     * @param gnTennatConditon
     *            租户ID必填
     * @return 租户信息
     * @throws CallerException
     * @author zhanglh
     * @ApiCode GN_0335
     */
    GnTenant selectTenantById(GnTenantConditon gnTennatConditon);

    /**
     * 查询所有租户信息
     * 
     * @return 所有租户信息
     * @throws CallerException
     * @author zhanglh
     * @ApiCode GN_0336
     */
    List<GnTenantVo> selectAllTenant();
}
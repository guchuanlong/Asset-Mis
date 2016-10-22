package com.myunihome.myxapp.common.api.depart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.depart.interfaces.IGnDepartMaintainSV;
import com.myunihome.myxapp.common.api.depart.param.GnDepartCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartVo;
import com.myunihome.myxapp.common.service.business.depart.IGnDepartBusinessService;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;
import com.myunihome.myxapp.common.util.VoValidateUtils;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;
import com.myunihome.myxapp.paas.util.CollectionUtil;

@Service
@Component
public class GnGnDepartMaintainSVImpl implements IGnDepartMaintainSV {

    @Autowired
    private IGnDepartBusinessService gnDepartBusinessService;

    @Autowired
    private IGnTenantBusinessService gnTenantBusinessService;

    @Override
    public void addDepart(GnDepartVo depart) throws CallerException {
        VoValidateUtils.validateTenantId(depart.getTenantId(), gnTenantBusinessService);

        if (StringUtils.isEmpty(depart.getCityCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门的地市编码不能为空");
        }
        if (StringUtils.isEmpty(depart.getProvinceCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门的省份编码不能为空");
        }
        if (StringUtils.isEmpty(depart.getAreaCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门的区域编码不能为空");
        }
        if (StringUtils.isEmpty(depart.getDepartKindType())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门的部门性质不能为空");
        }
        if (StringUtils.isEmpty(depart.getDepartName())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门的部门名称不能为空");
        }

        gnDepartBusinessService.addDepart(depart);
    }

    @Override
    public void modifyDepart(GnDepartVo depart) throws CallerException {
        VoValidateUtils.validateTenantId(depart.getTenantId(), gnTenantBusinessService);
        if (StringUtils.isEmpty(depart.getDepartId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门Id不能为空");
        }
        /*
         * if(!StringUtils.isEmpty(depart.getParentDepartId())){
         * depart.setParentDepartName(DepartCacheUtil.getDepartName(depart.getParentDepartId())); }
         */
        gnDepartBusinessService.modifyDepart(depart);

    }

    @Override
    public void deleteDepart(GnDepartCondition gnDepartCondition) throws CallerException {
        VoValidateUtils.validateTenantId(gnDepartCondition.getTenantId(), gnTenantBusinessService);
        if (StringUtils.isEmpty(gnDepartCondition.getDepartId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门Id不能为空");
        }
        gnDepartBusinessService.deleteDepart(gnDepartCondition.getTenantId(),
                gnDepartCondition.getDepartId());
    }

    @Override
    public void deleteDeparts(List<GnDepartCondition> gnDepartCondition) throws CallerException {

        if (CollectionUtil.isEmpty(gnDepartCondition)) {
            return;
        }
        for (GnDepartCondition condition : gnDepartCondition) {
            if (StringUtils.isEmpty(condition.getDepartId())) {
                throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门Id不能为空");
            }
            VoValidateUtils.validateTenantId(condition.getTenantId(), gnTenantBusinessService);
        }
        gnDepartBusinessService.deleteDeparts(gnDepartCondition);
    }

}

package com.myunihome.myxapp.common.api.staff.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.common.api.staff.interfaces.IGnStaffMaintainSV;
import com.myunihome.myxapp.common.api.staff.param.GnStaffCondition;
import com.myunihome.myxapp.common.api.staff.param.GnStaffVo;
import com.myunihome.myxapp.common.service.business.depart.IGnDepartBusinessService;
import com.myunihome.myxapp.common.service.business.staff.IGnStaffBusinessService;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;
import com.myunihome.myxapp.common.util.VoValidateUtils;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;
import com.myunihome.myxapp.paas.util.CollectionUtil;

@Service
@Component
public class GnStaffMaintainSVImpl implements IGnStaffMaintainSV {

    @Autowired
    private IGnStaffBusinessService gnStaffBusinessService;

    @Autowired
    private IGnTenantBusinessService gnTenantBusinessService;

    @Autowired
    private IGnDepartBusinessService gnDepartBusinessService;

    @Override
    public void addStaff(GnStaffVo staff) throws BusinessException {
        validateGnStaff(staff);
        gnStaffBusinessService.addStaff(staff);
    }

    private void validateGnStaff(GnStaffVo staff) {
        VoValidateUtils.validateTenantId(staff.getTenantId(), gnTenantBusinessService);
        validateStaffName(staff);
        validateStaffClass(staff);
        validateStaffNo(staff);
        VoValidateUtils.validateDepartId(staff.getTenantId(), staff.getDepartId(),
                gnDepartBusinessService);
    }

    private void validateStaffNo(GnStaffVo staff) {
        if (StringUtils.isEmpty(staff.getStaffNo())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "员工工号不能为空");
        }
    }

    private void validateStaffClass(GnStaffVo staff) {
        if (StringUtils.isEmpty(staff.getStaffClass())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "员工类型不能为空");
        }
    }

    private void validateStaffName(GnStaffVo staff) {
        if (StringUtils.isEmpty(staff.getStaffName())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "员工姓名不能为空");
        }
    }

    @Override
    public void modifyStaff(GnStaffVo staff) throws BusinessException {
        VoValidateUtils.validateTenantId(staff.getTenantId(), gnTenantBusinessService);
        if (StringUtils.isEmpty(staff.getStaffId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "员工Id不能为空");
        }

        if (gnStaffBusinessService.selectStaffById(staff.getTenantId(),
                staff.getStaffId()) == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.NO_RESULT, "员工信息不存在");
        }

        if (StringUtils.isEmpty(staff.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.NO_RESULT, "不允许修改员工的租户信息");
        }
        gnStaffBusinessService.updateStaff(staff);
    }

    @Override
    public void deleteStaffById(GnStaffCondition condition) {
        VoValidateUtils.validateTenantId(condition.getTenantId(), gnTenantBusinessService);
        if (!StringUtils.isEmpty(condition.getStaffId())) {
            gnStaffBusinessService.deleteStaff(condition.getTenantId(), condition.getStaffId());
        } else {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "StaffID不允许为空");
        }
    }

    @Override
    public void deleteStaffsByIds(List<GnStaffCondition> conditions) {
        if (CollectionUtil.isEmpty(conditions)) {
            return;
        }
        for (GnStaffCondition condition : conditions) {
            VoValidateUtils.validateTenantId(condition.getTenantId(), gnTenantBusinessService);
            if (StringUtils.isEmpty(condition.getStaffId())) {
                throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL,
                        "StaffID不允许为空");
            }
        }
        gnStaffBusinessService.deleteStaff(conditions);
    }

}

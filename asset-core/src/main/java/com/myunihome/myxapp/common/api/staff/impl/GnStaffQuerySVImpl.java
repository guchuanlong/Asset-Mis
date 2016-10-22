package com.myunihome.myxapp.common.api.staff.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.cache.param.SysParam;
import com.myunihome.myxapp.common.api.staff.interfaces.IGnStaffQuerySV;
import com.myunihome.myxapp.common.api.staff.param.GnStaffAreaQuery;
import com.myunihome.myxapp.common.api.staff.param.GnStaffCondition;
import com.myunihome.myxapp.common.api.staff.param.GnStaffInfo;
import com.myunihome.myxapp.common.api.staff.param.GnStaffVo;
import com.myunihome.myxapp.common.api.staff.param.StaffPaginationResult;
import com.myunihome.myxapp.common.service.business.depart.IGnDepartBusinessService;
import com.myunihome.myxapp.common.service.business.staff.IGnStaffBusinessService;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;
import com.myunihome.myxapp.common.util.DepartCacheUtil;
import com.myunihome.myxapp.common.util.SysParamUtil;
import com.myunihome.myxapp.common.util.VoValidateUtils;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;

@Service
@Component
public class GnStaffQuerySVImpl implements IGnStaffQuerySV {

    @Autowired
    private IGnStaffBusinessService gnStaffBusinessService;

    @Autowired
    private IGnDepartBusinessService gnDepartBusinessService;

    @Autowired
    private IGnTenantBusinessService gnTenantBusinessService;

    @Override
    public List<GnStaffVo> queryStaffsByDepartId(GnStaffCondition condition)
            throws CallerException {

        if (condition == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "查询参数为空");
        }
        String departId = condition.getDepartId();
        String tenantId = condition.getTenantId();
        if (StringUtils.isEmpty(tenantId)) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户信息不存在");
        }
        if (gnTenantBusinessService.selectTenantById(tenantId) == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.NO_RESULT, "租户Id不存在");
        }
        if (StringUtils.isEmpty(departId)) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门ID不能为null");
        }
        if (gnDepartBusinessService.selectById(tenantId, departId) == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.NO_RESULT, "部门已失效或者不存在");
        }

        Gson gson = new Gson();
        List<GnStaffVo> result = gson
                .fromJson(
                        gson.toJson(gnStaffBusinessService
                                .selectStaffByDepart(condition.getTenantId(), departId)),
                new TypeToken<List<GnStaffVo>>() {
                }.getType());

        for (GnStaffVo staff : result) {
            staff.setDepartName(DepartCacheUtil.getDepartName(staff.getDepartId()));
        }

        return result;
    }

    @Override
    public StaffPaginationResult selectByPage(GnStaffCondition condition, int start, int end)
            throws CallerException {
        VoValidateUtils.validateTenantId(condition.getTenantId(), gnTenantBusinessService);
        StaffPaginationResult result = new StaffPaginationResult();
        Gson gson = new Gson();

        List<GnStaffVo> searchResult = gson.fromJson(
                gson.toJson(gnStaffBusinessService.selectByPage(condition, start, end)),
                new TypeToken<List<GnStaffVo>>() {
                }.getType());
        for (GnStaffVo vo : searchResult) {
            SysParam syspara = SysParamUtil.getSysParam(condition.getTenantId(), "GN_STAFF",
                    "STAFF_CLASS", vo.getStaffClass());
            String colDesc = (syspara == null ? "" : syspara.getColumnDesc());
            vo.setStaffClass(colDesc);
            vo.setDepartName(DepartCacheUtil.getDepartName(vo.getDepartId()));
        }
        result.setResult(searchResult);
        result.setTotal(gnStaffBusinessService.count(condition));
        return result;
    }

    @Override
    public GnStaffVo selectById(GnStaffCondition condition) throws CallerException {
        VoValidateUtils.validateTenantId(condition.getTenantId(), gnTenantBusinessService);
        if (StringUtils.isEmpty(condition.getStaffId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "员工ID不能为null");
        }
        Gson gson = new Gson();
        GnStaffVo result = gson.fromJson(gson.toJson(gnStaffBusinessService
                .selectStaffById(condition.getTenantId(), condition.getStaffId())),
                GnStaffVo.class);
        if (result != null) {
            result.setDepartName(DepartCacheUtil.getDepartName(result.getDepartId()));
        }

        return result;
    }

    @Override
    public List<GnStaffInfo> selectByArea(GnStaffAreaQuery condition) throws CallerException {
        VoValidateUtils.validateGetStaffByAreaCode(condition);
        Gson gson = new Gson();
        List<GnStaffInfo> result = gson.fromJson(
                        gson.toJson(gnStaffBusinessService.selectStaffByAreaCode(condition)),
                new TypeToken<List<GnStaffInfo>>() {
                }.getType());

        for (GnStaffInfo staff : result) {
            staff.setDepartName(DepartCacheUtil.getDepartName(staff.getDepartId()));
        }
        return result;
    }

}

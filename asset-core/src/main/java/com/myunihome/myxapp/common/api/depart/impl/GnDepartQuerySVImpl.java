package com.myunihome.myxapp.common.api.depart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.depart.interfaces.IGnDepartQuerySV;
import com.myunihome.myxapp.common.api.depart.param.DepartPaginationResult;
import com.myunihome.myxapp.common.api.depart.param.GnDepartCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartIdsCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartVo;
import com.myunihome.myxapp.common.service.business.depart.IGnDepartBusinessService;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;
import com.myunihome.myxapp.common.util.DepartCacheUtil;
import com.myunihome.myxapp.common.util.SysParamUtil;
import com.myunihome.myxapp.common.util.VoValidateUtils;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;

@Service
@Component
public class GnDepartQuerySVImpl implements IGnDepartQuerySV {

    @Autowired
    private IGnDepartBusinessService gnDepartBusinessService;

    @Autowired
    private IGnTenantBusinessService gnTenantBusinessService;

    @Override
    public GnDepartVo selectById(GnDepartCondition gnDepartCondition) throws CallerException {
        VoValidateUtils.validateTenantId(gnDepartCondition.getTenantId(), gnTenantBusinessService);
        if (StringUtils.isEmpty(gnDepartCondition.getDepartId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门Id不能为空");
        }
        Gson gson = new Gson();
        GnDepartVo result = gson
                .fromJson(
                        gson.toJson(gnDepartBusinessService.selectById(
                                gnDepartCondition.getTenantId(), gnDepartCondition.getDepartId())),
                GnDepartVo.class);
        if ("0".equals(result.getParentDepartId())) {

            result.setParentDepartName("");
        } else {
            result.setParentDepartName(DepartCacheUtil.getDepartName(result.getParentDepartId()));
        }

        /*
         * String level = gnAreaBusinessService.selectByID(result.getAreaCode()).getAreaLevel();
         * if(level.equals("1")){
         * result.setProvinceCode(gnAreaBusinessService.selectByID(result.getAreaCode()).getAreaName
         * ()); }else{
         * result.setCityCode(gnAreaBusinessService.selectByID(result.getAreaCode()).getAreaName());
         * }
         */

        return result;
    }

    @Override
    public List<GnDepartVo> select(GnDepartCondition gnDepartCondition) throws CallerException {
        VoValidateUtils.validateTenantId(gnDepartCondition.getTenantId(), gnTenantBusinessService);
        Gson gson = new Gson();
        List<GnDepartVo> departVos = gson
                .fromJson(
                        gson.toJson(gnDepartBusinessService.select(gnDepartCondition.getTenantId(),
                                gnDepartCondition.getDepartId())),
                new TypeToken<List<GnDepartVo>>() {
                }.getType());

        for (GnDepartVo departVo : departVos) {
            departVo.setDepartKindType(SysParamUtil.getSysParamDesc(departVo.getTenantId(),
                    "GN_DEPART", "DEPART_KIND_TYPE", departVo.getDepartKindType()));
            departVo.setDepartLevel(SysParamUtil.getSysParamDesc(departVo.getTenantId(),
                    "GN_DEPART", "DEPART_LEVEL", departVo.getDepartLevel()));
            if ("0".equals(departVo.getParentDepartId())) {

                departVo.setParentDepartName("");
            } else {
                departVo.setParentDepartName(
                        DepartCacheUtil.getDepartName(departVo.getParentDepartId()));
            }

        }

        return departVos;
    }

    @Override
    public DepartPaginationResult selectByPage(GnDepartCondition gnDepartCondition, int start,
            int end) throws CallerException {
        VoValidateUtils.validateTenantId(gnDepartCondition.getTenantId(), gnTenantBusinessService);
        Gson gson = new Gson();
        DepartPaginationResult result = new DepartPaginationResult();

        List<GnDepartVo> departVos = gson.fromJson(
                gson.toJson(gnDepartBusinessService.selectByPage(gnDepartCondition, start, end)),
                new TypeToken<List<GnDepartVo>>() {
                }.getType());

        for (GnDepartVo departVo : departVos) {
            departVo.setDepartKindType(SysParamUtil.getSysParamDesc(departVo.getTenantId(),
                    "GN_DEPART", "DEPART_KIND_TYPE", departVo.getDepartKindType()));
            departVo.setDepartLevel(SysParamUtil.getSysParamDesc(departVo.getTenantId(),
                    "GN_DEPART", "DEPART_LEVEL", departVo.getDepartLevel()));
            if ("0".equals(departVo.getParentDepartId())) {
                departVo.setParentDepartName("");
            } else {
                departVo.setParentDepartName(
                        DepartCacheUtil.getDepartName(departVo.getParentDepartId()));
            }

        }

        result.setResult(departVos);
        result.setTotal(gnDepartBusinessService.count(gnDepartCondition));
        return result;
    }

    @Override
    public List<GnDepartVo> selectAllById(GnDepartIdsCondition gnDepartIdsCondition)
            throws CallerException {
        VoValidateUtils.validateTenantId(gnDepartIdsCondition.getTenantId(),
                gnTenantBusinessService);
        if (StringUtils.isEmpty(gnDepartIdsCondition.getDepartId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门Id不能为空");
        }

        Gson gson = new Gson();
        List<GnDepartVo> departVos = gson.fromJson(
                gson.toJson(gnDepartBusinessService.selectALLById(
                        gnDepartIdsCondition.getTenantId(), gnDepartIdsCondition.getDepartId())),
                new TypeToken<List<GnDepartVo>>() {
                }.getType());

        for (GnDepartVo departVo : departVos) {
            departVo.setDepartKindType(SysParamUtil.getSysParamDesc(departVo.getTenantId(),
                    "GN_DEPART", "DEPART_KIND_TYPE", departVo.getDepartKindType()));
            departVo.setDepartLevel(SysParamUtil.getSysParamDesc(departVo.getTenantId(),
                    "GN_DEPART", "DEPART_LEVEL", departVo.getDepartLevel()));
            if ("0".equals(departVo.getParentDepartId())) {

                departVo.setParentDepartName("");
            } else {
                departVo.setParentDepartName(
                        DepartCacheUtil.getDepartName(departVo.getParentDepartId()));
            }

        }
        return departVos;
    }

    @Override
    public List<GnDepartVo> selectParentById(GnDepartIdsCondition gnDepartIdsCondition)
            throws CallerException {
        VoValidateUtils.validateTenantId(gnDepartIdsCondition.getTenantId(),
                gnTenantBusinessService);
        if (StringUtils.isEmpty(gnDepartIdsCondition.getDepartId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "部门Id不能为空");
        }

        Gson gson = new Gson();
        List<GnDepartVo> departVos = gson.fromJson(
                gson.toJson(gnDepartBusinessService.selectParentById(
                        gnDepartIdsCondition.getTenantId(), gnDepartIdsCondition.getDepartId())),
                new TypeToken<List<GnDepartVo>>() {
                }.getType());

        for (GnDepartVo departVo : departVos) {
            departVo.setDepartKindType(SysParamUtil.getSysParamDesc(departVo.getTenantId(),
                    "GN_DEPART", "DEPART_KIND_TYPE", departVo.getDepartKindType()));
            departVo.setDepartLevel(SysParamUtil.getSysParamDesc(departVo.getTenantId(),
                    "GN_DEPART", "DEPART_LEVEL", departVo.getDepartLevel()));
            if ("0".equals(departVo.getParentDepartId())) {

                departVo.setParentDepartName("");
            } else {
                departVo.setParentDepartName(
                        DepartCacheUtil.getDepartName(departVo.getParentDepartId()));
            }
        }
        return departVos;
    }
}

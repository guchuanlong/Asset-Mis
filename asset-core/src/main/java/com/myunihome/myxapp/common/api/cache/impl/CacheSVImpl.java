package com.myunihome.myxapp.common.api.cache.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.cache.interfaces.ICacheSV;
import com.myunihome.myxapp.common.api.cache.param.Area;
import com.myunihome.myxapp.common.api.cache.param.CfgProperties;
import com.myunihome.myxapp.common.api.cache.param.Depart;
import com.myunihome.myxapp.common.api.cache.param.SysParam;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;
import com.myunihome.myxapp.common.util.AreaCacheUtil;
import com.myunihome.myxapp.common.util.CfgPropertiesUtil;
import com.myunihome.myxapp.common.util.DepartCacheUtil;
import com.myunihome.myxapp.common.util.SysParamUtil;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.paas.util.StringUtil;

@Service
@Component
public class CacheSVImpl implements ICacheSV {

    @Override
    public List<SysParam> getSysParams(String tenantId, String typeCode, String paramCode)
            throws CallerException {
        if (StringUtil.isBlank(tenantId)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(typeCode)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:参数类型不能为空");
        }
        if (StringUtil.isBlank(paramCode)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:参数编码不能为空");
        }
        
        List<SysParam> listParam=SysParamUtil.getSysParams(tenantId, typeCode, paramCode);
        if(CollectionUtil.isEmpty(listParam)){
        	listParam=SysParamUtil.getSysParams(Constants.TenantId.ALL_TENANT, typeCode, paramCode);
        }
        return listParam;
    }

    @Override
    public SysParam getSysParam(String tenantId, String typeCode, String paramCode,
            String columnValue) throws CallerException {
        if (StringUtil.isBlank(tenantId)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(typeCode)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:参数类型不能为空");
        }
        if (StringUtil.isBlank(paramCode)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:参数编码不能为空");
        }
        if (StringUtil.isBlank(columnValue)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:参数取值不能为空");
        }
        
        SysParam param=SysParamUtil.getSysParam(tenantId, typeCode, paramCode, columnValue);
        if(param==null){
        	param=SysParamUtil.getSysParam(Constants.TenantId.ALL_TENANT, typeCode, paramCode, columnValue);
        }
        
        return param;
    }

    @Override
    public CfgProperties getCfgProperties(String tenantId, String cfgType, String cfgProperty) throws CallerException {
        if (StringUtil.isBlank(tenantId)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(cfgType)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:参数类型不能为空");
        }
        if (StringUtil.isBlank(cfgProperty)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:参数属性不能为空");
        }
        
        CfgProperties cfg=CfgPropertiesUtil.getCfgProperties(tenantId, cfgType, cfgProperty);
        if(cfg==null){
        	cfg=CfgPropertiesUtil.getCfgProperties(Constants.TenantId.ALL_TENANT, cfgType, cfgProperty);
        }
        
        return cfg;
    }

	@Override
	public String getAreaName(String tenantId, String areaCode)
			throws CallerException {
		if (StringUtil.isBlank(tenantId)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(areaCode)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:区域编码不能为空");
        }
        
		return AreaCacheUtil.getAreaName(tenantId, areaCode);
	}

	@Override
	public Area getArea(String tenantId, String areaCode)
			throws CallerException {
		if (StringUtil.isBlank(tenantId)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(areaCode)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:区域编码不能为空");
        }
        
        
		return AreaCacheUtil.getArea(tenantId, areaCode);
	}

	@Override
	public String getDepartName(String tenantId, String departId)
			throws CallerException {
		if (StringUtil.isBlank(tenantId)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
        if (StringUtil.isBlank(departId)) {
            throw new CallerException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "获取参数失败:部门ID不能为空");
        }
		return DepartCacheUtil.getDepartName(tenantId, departId);
	}

	@Override
	public Depart getDepart(String tenantId, String departId)
			throws CallerException {
		Depart depart=null;
		GnDepart cacheDepart=DepartCacheUtil.getDepart(tenantId, departId);
		if(cacheDepart!=null){
			depart=new Depart();
			BeanUtils.copyProperties(depart, cacheDepart);
			Area area=AreaCacheUtil.getArea(tenantId, cacheDepart.getAreaCode());
			if(area!=null){
				depart.setAreaLevel(area.getAreaLevel());
				depart.setAreaName(area.getAreaName());
			}
		}
		return depart;
	}

}

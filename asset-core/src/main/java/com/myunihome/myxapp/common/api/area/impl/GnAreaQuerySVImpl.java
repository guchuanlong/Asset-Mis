package com.myunihome.myxapp.common.api.area.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.area.interfaces.IGnAreaQuerySV;
import com.myunihome.myxapp.common.api.area.param.GnAreaCodeCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaPageCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaPageFilterCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnArea;
import com.myunihome.myxapp.common.service.business.area.IGnAreaBusinessService;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;
import com.myunihome.myxapp.common.util.VoValidateUtils;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.CollectionUtil;

@Service
@Component
public class GnAreaQuerySVImpl implements IGnAreaQuerySV {

    @Autowired
    private IGnAreaBusinessService iGnAreaBusinessService;
    @Autowired
    private IGnTenantBusinessService gnTenantBusinessService;

    @Override
    public GnAreaVo selectByID(GnAreaCondition condition) throws CallerException {
        VoValidateUtils.validateTenantId(condition.getTenantId(), gnTenantBusinessService);
        if (StringUtils.isEmpty(condition.getAreaCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区域编码不能为空");
        }
        Gson gson = new Gson();
        return gson.fromJson(
                gson.toJson(iGnAreaBusinessService.selectByID(condition.getTenantId(),condition.getAreaCode())),
                GnAreaVo.class);
    }

    @Override
    public GnAreaVo queryGnArea(String tenantId,String areaCode) throws CallerException {
        VoValidateUtils.validateTenantId(tenantId, gnTenantBusinessService);
        if (StringUtils.isEmpty(areaCode)) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区域编码不能为空");
        }
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(iGnAreaBusinessService.selectByID(tenantId,areaCode)),
                GnAreaVo.class);
    }

	@Override
	public List<GnAreaVo> getProvinceList() throws CallerException {
		List<GnArea> dbList=iGnAreaBusinessService.getProvinceList();
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public List<GnAreaVo> getParentAreaListByAreaCode(GnAreaCodeCondition condition)
			throws CallerException {
		VoValidateUtils.validateGetParentAreaListByAreaCode(condition);
		List<GnArea> dbList=iGnAreaBusinessService.getParentAreaListByAreaCode(condition);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		return resultList;
	}

	
	@Override
	public List<GnAreaVo> getCityListByProviceCode(String provinceCode){
		VoValidateUtils.validateGetCityListByProviceCode(provinceCode);
		List<GnArea> dbList=iGnAreaBusinessService.getCityListByProviceCode(provinceCode);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public List<GnAreaVo> getCountyListByCityCode(String cityCode)
			throws CallerException {
		VoValidateUtils.validateGetCountyListByCityCode(cityCode);
		List<GnArea> dbList=iGnAreaBusinessService.getCountyListByCityCode(cityCode);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public List<GnAreaVo> getStreetListByCountyCode(String countyCode)
			throws CallerException {
		VoValidateUtils.validateGetStreetListByCountyCode(countyCode);
		List<GnArea> dbList=iGnAreaBusinessService.getStreetListByCountyCode(countyCode);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public List<GnAreaVo> getAreaListByStreetCode(String tenantId,
			String streetCode) throws CallerException {
		VoValidateUtils.validateGetAreaListByStreetCode(tenantId,streetCode);
		List<GnArea> dbList=iGnAreaBusinessService.getAreaListByStreetCode(tenantId, streetCode);
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		return resultList;
	}

	@Override
	public PageInfo<GnAreaVo> getAreaListByPage(GnAreaPageCondition areaPage)
			throws CallerException {
		VoValidateUtils.validateGetAreaListByPage(areaPage);
		return iGnAreaBusinessService.getAreaListByPage(areaPage);
	}

	@Override
	public List<GnAreaVo> getNationList() throws CallerException {
		List<GnArea> dbList=iGnAreaBusinessService.getNationList();
		List<GnAreaVo> resultList=null;
		if(!CollectionUtil.isEmpty(dbList)){
			resultList=new ArrayList<GnAreaVo>();
			for(GnArea area : dbList){
				GnAreaVo areavo=new GnAreaVo();
				BeanUtils.copyProperties(areavo, area);
				resultList.add(areavo);
			}
		}
		
		return resultList;
	}

	@Override
	public PageInfo<GnAreaVo> getFilterAreaListByPage(GnAreaPageFilterCondition areaPage) throws CallerException {
		VoValidateUtils.validateGetFilterAreaListByPage(areaPage);
		return iGnAreaBusinessService.getFilterAreaListByPage(areaPage);
	}
}

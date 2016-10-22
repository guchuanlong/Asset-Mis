package com.myunihome.myxapp.common.util;

import java.util.List;

import org.springframework.util.StringUtils;

import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.common.api.area.param.AreaLevel;
import com.myunihome.myxapp.common.api.area.param.GnAreaCodeCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaPageCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaPageFilterCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaVo;
import com.myunihome.myxapp.common.api.channel.param.ChlQueryCond;
import com.myunihome.myxapp.common.api.staff.param.GnStaffAreaQuery;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.service.business.channel.IGnChannelBusinessService;
import com.myunihome.myxapp.common.service.business.depart.IGnDepartBusinessService;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;
import com.myunihome.myxapp.paas.util.CollectionUtil;


public final class VoValidateUtils {

    private VoValidateUtils() {
    }
   
    public static void validateTenantId(String tenantId, IGnTenantBusinessService gnTenantService) {
        if (StringUtils.isEmpty(tenantId)) {
            throw new BusinessException("10001", "租户ID不能为空");
        }
        if (gnTenantService.selectTenantById(tenantId) == null) {
            throw new BusinessException("10002", "租户信息不存在");
        }
    }

    public static void validateDepartId(String tenantId,String departID, IGnDepartBusinessService gnDepartService) {
        if (StringUtils.isEmpty(departID)) {
            throw new BusinessException("10001", "部门编码不能为空");
        }

        if (gnDepartService.selectById(tenantId,departID) == null) {
            throw new BusinessException("10002", "归属的组织结构不存在");
        }
    }
    public static void validateGetStaffByAreaCode(
            GnStaffAreaQuery condition) {
        if (condition==null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "参数对象不能为空");
        }
        if (StringUtils.isEmpty(condition.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtils.isEmpty(condition.getAreaCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区域编码不能为空");
        }
    }
    public static void validateChannelId(String tenantId,String channelID, IGnChannelBusinessService gnChannelService) {
        if (StringUtils.isEmpty(channelID)) {
            throw new BusinessException("10001", "渠道不能为空");
        }

        if (gnChannelService.selectById(tenantId,channelID) == null) {
            throw new BusinessException("10002", "渠道不存在");
        }
        
    }

	public static void valaidateQueryChannelsByPage(ChlQueryCond cond) {
		if (cond==null) {
            throw new BusinessException(Constants.ErrorCode.RESULT_NULL_ERROR, "参数对象不能为空");
        }
		if (StringUtils.isEmpty(cond.getTenantId())) {
			throw new BusinessException(Constants.ErrorCode.RESULT_NULL_ERROR, "租户ID不能为空");
        }
		if(StringUtils.isEmpty(cond.getPageInfo())){
			//throw new BusinessException(Constants.ErrorCode.RESULT_NULL_ERROR, "分页参数不能为空");
		}else{
			 if(StringUtils.isEmpty(cond.getPageInfo().getPageNo())){
				 throw new BusinessException(Constants.ErrorCode.RESULT_NULL_ERROR, "页码不能为空");
			}else if(StringUtils.isEmpty(cond.getPageInfo().getPageSize())){
				throw new BusinessException(Constants.ErrorCode.RESULT_NULL_ERROR, "页面大小不能为空");
			}
		}
	}
	
	public static void validateGetParentAreaListByAreaCode(
			GnAreaCodeCondition condition) {
		if (condition==null) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(condition.getTenantId())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(condition.getAreaCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区域编码不能为空");
        }
	}

	public static void validateGetCityListByProviceCode(String provinceCode) {
		if (StringUtils.isEmpty(provinceCode)) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "省份code不能为空");
		}
	}
	public static void validateGetCountyListByCityCode(String cityCode) {
		if (StringUtils.isEmpty(cityCode)) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "地市code不能为空");
		}
	}
	public static void validateGetStreetListByCountyCode(String countyCode) {
		if (StringUtils.isEmpty(countyCode)) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区县code不能为空");
		}
	}

	public static void validateGetAreaListByStreetCode(String tenantId,
			String streetCode) {
		if (StringUtils.isEmpty(tenantId)) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(streetCode)) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "街道code不能为空");
		}
		
	}
	public static void validateAddArea(GnAreaVo area){
		if(area==null){
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(area.getTenantId())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaName())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区名称不能为空");
		}
		if (StringUtils.isEmpty(area.getProvinceCode())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "省份编码不能为空");
		}
		if (StringUtils.isEmpty(area.getCityCode())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "地市编码不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaLevel())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区域级别不能为空");
		}
		if (!AreaLevel.AREA_LEVEL.getLevelValue().equals(area.getAreaLevel())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区级别必须为5");
		}
		
	}
	public static void validateModifyArea(GnAreaVo area){
		if(area==null){
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(area.getTenantId())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaCode())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区编码不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaName())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区名称不能为空");
		}
		if (StringUtils.isEmpty(area.getProvinceCode())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "省份编码不能为空");
		}
		if (StringUtils.isEmpty(area.getCityCode())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "地市编码不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaLevel())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区域级别不能为空");
		}
		if (!AreaLevel.AREA_LEVEL.getLevelValue().equals(area.getAreaLevel())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区级别必须为5");
		}
		
	}
	public static void validateDeleteArea(GnAreaCondition area){
		if(area==null){
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(area.getTenantId())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (StringUtils.isEmpty(area.getAreaCode())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区编码不能为空");
		}		
		if (StringUtils.isEmpty(area.getAreaLevel())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区域级别不能为空");
		}
		if (!AreaLevel.AREA_LEVEL.getLevelValue().equals(area.getAreaLevel().getLevelValue())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区级别必须为5");
		}
		
	}
	public static void validateDeleteAreas(List<GnAreaCondition> areaList){
		if(areaList==null){
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "参数对象不能为空");
		}
		if(!CollectionUtil.isEmpty(areaList)){
			for(GnAreaCondition area:areaList){
				if (StringUtils.isEmpty(area.getTenantId())) {
					throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
				}
				if (StringUtils.isEmpty(area.getAreaCode())) {
					throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区编码不能为空");
				}		
				if (StringUtils.isEmpty(area.getAreaLevel())) {
					throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "区域级别不能为空");
				}
				if (!AreaLevel.AREA_LEVEL.getLevelValue().equals(area.getAreaLevel().getLevelValue())) {
					throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "小区级别必须为5");
				}				
			}
		}
		
	}
	
	public static void validateGetAreaListByPage(GnAreaPageCondition areaPage) {
		if(areaPage==null){
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(areaPage.getTenantId())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (areaPage.getPageNo()<1) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_TYPE_NOT_RIGHT, "查询页面pageNo必须大于0");
		}
		if (areaPage.getPageSize()<1) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_TYPE_NOT_RIGHT, "查询页面pageSize必须大于0");
		}
		
	}

	public static void validateGetFilterAreaListByPage(GnAreaPageFilterCondition areaPage) {
		if(areaPage==null){
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "参数对象不能为空");
		}
		if (StringUtils.isEmpty(areaPage.getTenantId())) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
		}
		if (areaPage.getPageNo()<1) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_TYPE_NOT_RIGHT, "查询页面pageNo必须大于0");
		}
		if (areaPage.getPageSize()<1) {
			throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_TYPE_NOT_RIGHT, "查询页面pageSize必须大于0");
		}
	}


}

package com.myunihome.myxapp.common.service.atom.area.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.area.param.AreaLevel;
import com.myunihome.myxapp.common.api.area.param.GnAreaCodeCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaPageCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaPageFilterCondition;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.dao.mapper.bo.GnArea;
import com.myunihome.myxapp.common.dao.mapper.bo.GnAreaCriteria;
import com.myunihome.myxapp.common.dao.mapper.bo.GnAreaCriteria.Criteria;
import com.myunihome.myxapp.common.dao.mapper.interfaces.GnAreaMapper;
import com.myunihome.myxapp.common.service.atom.area.IGnAreaAtomService;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.paas.util.StringUtil;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;

@Component
public class GnAreaAtomServiceImpl implements IGnAreaAtomService {

	@Override
	public List<GnArea> select(GnAreaCondition condition) {
		List<GnArea> result = new ArrayList<GnArea>();
		GnAreaCriteria gnAreaCriteria = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = gnAreaCriteria.createCriteria();

		if (!StringUtils.isEmpty(condition.getAreaCode())) {
			criteria.andParentAreaCodeEqualTo(condition.getAreaCode());
		}

		if (condition.getAreaLevel() != null) {
			criteria.andAreaLevelEqualTo(condition.getAreaLevel().getLevelValue());
		}
		criteria.andStateEqualTo(Constants.AreaState.ACTIVITY);
		criteria.andTenantIdEqualTo(condition.getTenantId());
		List<GnArea> gnAreas = MapperFactory.getGnAreaMapper().selectByExample(gnAreaCriteria);
		result.addAll(gnAreas);
		return result;
	}

	@Override
	public GnArea selectByID(String tenantId, String areaCode) {
		GnAreaCriteria gnAreaCriteria = new GnAreaCriteria();
		gnAreaCriteria.createCriteria().andStateEqualTo(Constants.AreaState.ACTIVITY).andAreaCodeEqualTo(areaCode).andTenantIdEqualTo(tenantId);
		List<GnArea> result = MapperFactory.getGnAreaMapper().selectByExample(gnAreaCriteria);
		if (CollectionUtil.isEmpty(result)) {
			gnAreaCriteria = new GnAreaCriteria();
			gnAreaCriteria.createCriteria().andStateEqualTo(Constants.AreaState.ACTIVITY).andAreaCodeEqualTo(areaCode)
					.andTenantIdEqualTo(Constants.TenantId.ALL_TENANT);
			result = MapperFactory.getGnAreaMapper().selectByExample(gnAreaCriteria);
		}
		if (CollectionUtil.isEmpty(result)) {
			return null;
		}

		return result.get(0);
	}

	@Override
	public List<GnArea> getProvinceList() throws CallerException {
		GnAreaCriteria sql = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andAreaLevelEqualTo(AreaLevel.PROVINCE_LEVEL.getLevelValue());
		criteria.andStateEqualTo(Constants.AreaState.ACTIVITY);
		criteria.andTenantIdEqualTo(Constants.TenantId.ALL_TENANT);
		return MapperFactory.getGnAreaMapper().selectByExample(sql);
	}

	@Override
	public List<GnArea> getParentAreaListByAreaCode(GnAreaCodeCondition condition) throws CallerException {
		List<GnArea> resultList = null;
		GnAreaMapper mapper = MapperFactory.getGnAreaMapper();
		GnArea currArea = mapper.selectByPrimaryKey(condition.getAreaCode());
		if (currArea != null) {
			resultList = new ArrayList<GnArea>();
			String tenantId = currArea.getTenantId();
			if (tenantId.equalsIgnoreCase(Constants.TenantId.ALL_TENANT) || tenantId.equalsIgnoreCase(condition.getTenantId())) {
				getParentAreaList(resultList, currArea.getParentAreaCode());
			}
		}
		return resultList;
	}

	private void getParentAreaList(List<GnArea> resultList, String parentAreaCode) {
		if (!StringUtil.isBlank(parentAreaCode)) {
			GnAreaMapper mapper = MapperFactory.getGnAreaMapper();
			GnArea parentArea = mapper.selectByPrimaryKey(parentAreaCode);
			if (parentArea != null) {
				resultList.add(parentArea);
				getParentAreaList(resultList, parentArea.getParentAreaCode());
			}
		}
	}

	@Override
	public List<GnArea> getCityListByProviceCode(String provinceCode) {
		GnAreaCriteria sql = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andParentAreaCodeEqualTo(provinceCode);
		criteria.andAreaLevelEqualTo(AreaLevel.CITY_LEVEL.getLevelValue());
		criteria.andStateEqualTo(Constants.AreaState.ACTIVITY);
		criteria.andTenantIdEqualTo(Constants.TenantId.ALL_TENANT);
		return MapperFactory.getGnAreaMapper().selectByExample(sql);
	}

	@Override
	public List<GnArea> getCountyListByCityCode(String cityCode) {
		GnAreaCriteria sql = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andParentAreaCodeEqualTo(cityCode);
		criteria.andAreaLevelEqualTo(AreaLevel.COUNTY_LEVEL.getLevelValue());
		criteria.andStateEqualTo(Constants.AreaState.ACTIVITY);
		criteria.andTenantIdEqualTo(Constants.TenantId.ALL_TENANT);
		return MapperFactory.getGnAreaMapper().selectByExample(sql);
	}

	@Override
	public List<GnArea> getStreetListByCountyCode(String countyCode) {
		GnAreaCriteria sql = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andParentAreaCodeEqualTo(countyCode);
		criteria.andAreaLevelEqualTo(AreaLevel.STREET_LEVEL.getLevelValue());
		criteria.andStateEqualTo(Constants.AreaState.ACTIVITY);
		criteria.andTenantIdEqualTo(Constants.TenantId.ALL_TENANT);
		return MapperFactory.getGnAreaMapper().selectByExample(sql);
	}

	@Override
	public List<GnArea> getAreaListByStreetCode(String tenantId, String streetCode) {
		GnAreaCriteria sql = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andParentAreaCodeEqualTo(streetCode);
		criteria.andAreaLevelEqualTo(AreaLevel.AREA_LEVEL.getLevelValue());
		criteria.andStateEqualTo(Constants.AreaState.ACTIVITY);
		criteria.andTenantIdEqualTo(tenantId);
		return MapperFactory.getGnAreaMapper().selectByExample(sql);
	}

	@Override
	public String addArea(GnArea area) {
		MapperFactory.getGnAreaMapper().insert(area);
		return area.getAreaCode();
	}

	@Override
	public void modifyArea(GnArea area) {
		GnAreaCriteria sql = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andTenantIdEqualTo(area.getTenantId());
		criteria.andAreaCodeEqualTo(area.getAreaCode());
		MapperFactory.getGnAreaMapper().updateByExampleSelective(area, sql);
	}

	@Override
	public void deleteArea(GnAreaCondition gnAreaCondition) {
		GnAreaCriteria sql = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andTenantIdEqualTo(gnAreaCondition.getTenantId());
		criteria.andAreaCodeEqualTo(gnAreaCondition.getAreaCode());
		// 判断是否有子结点
		GnAreaCondition childCond = new GnAreaCondition();
		childCond.setTenantId(gnAreaCondition.getTenantId());
		childCond.setAreaCode(gnAreaCondition.getAreaCode());
		List<GnArea> childAreas = select(childCond);
		if (!CollectionUtil.isEmpty(childAreas)) {
			throw new BusinessException("10004", "该小区底下存在子小区,不能被删除");
		}
		GnArea area = new GnArea();
		area.setTenantId(gnAreaCondition.getTenantId());
		area.setAreaCode(gnAreaCondition.getAreaCode());
		area.setState(Constants.AreaState.INACTIVITY);
		MapperFactory.getGnAreaMapper().updateByExampleSelective(area, sql);

	}

	@Override
	public void deleteAreas(List<GnAreaCondition> gnAreaCondition) {
		if (!CollectionUtil.isEmpty(gnAreaCondition)) {
			for (GnAreaCondition cond : gnAreaCondition) {
				deleteArea(cond);
			}
		}

	}

	@Override
	public PageInfo<GnArea> getAreaListByPage(GnAreaPageCondition areaPage) {
		PageInfo<GnArea> pageInfo = new PageInfo<GnArea>();
		GnAreaCriteria sql = getQueryAreaListCriteria(areaPage);

		GnAreaMapper mapper = MapperFactory.getGnAreaMapper();
		// 数据列表
		List<GnArea> dblist = mapper.selectByExample(sql);
		// 总记录数
		int totalCount = mapper.countByExample(sql);
		pageInfo.setCount(totalCount);
		pageInfo.setPageNo(areaPage.getPageNo());
		pageInfo.setPageSize(areaPage.getPageSize());
		pageInfo.setResult(dblist);

		return pageInfo;
	}

	/**
	 * 获取查询区域信息的条件
	 * 
	 * @param areaPage
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private GnAreaCriteria getQueryAreaListCriteria(GnAreaPageCondition areaPage) {
		GnAreaCriteria sql = new GnAreaCriteria();
		int limitStart = (areaPage.getPageNo() - 1) * areaPage.getPageSize();
		int limitEnd = areaPage.getPageSize();
		sql.setLimitStart(limitStart);
		sql.setLimitEnd(limitEnd);
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andTenantIdEqualTo(areaPage.getTenantId());
		criteria.andStateEqualTo(Constants.AreaState.ACTIVITY);
		criteria.andAreaLevelEqualTo(AreaLevel.AREA_LEVEL.getLevelValue());
		if (!StringUtil.isBlank(areaPage.getProvinceCode())) {
			criteria.andProvinceCodeEqualTo(areaPage.getProvinceCode());
		}
		if (!StringUtil.isBlank(areaPage.getCityCode())) {
			criteria.andCityCodeEqualTo(areaPage.getCityCode());
		}
		if (!StringUtil.isBlank(areaPage.getStreetCode())) {
			criteria.andParentAreaCodeEqualTo(areaPage.getStreetCode());
		}
		if (!StringUtil.isBlank(areaPage.getParentAreaCode())) {
			criteria.andParentAreaCodeEqualTo(areaPage.getParentAreaCode());
		}
		if (!StringUtil.isBlank(areaPage.getAreaCode())) {
			criteria.andAreaCodeEqualTo(areaPage.getAreaCode());
		}
		if (!StringUtil.isBlank(areaPage.getAreaName())) {
			criteria.andAreaNameLike("%" + areaPage.getAreaName() + "%");
		}
		return sql;
	}

	@Override
	public List<GnArea> getNationList() {
		GnAreaCriteria sql = new GnAreaCriteria();
		GnAreaCriteria.Criteria criteria = sql.or();
		criteria.andAreaLevelEqualTo(AreaLevel.NATION_LEVEL.getLevelValue());
		criteria.andStateEqualTo(Constants.AreaState.ACTIVITY);
		criteria.andTenantIdEqualTo(Constants.TenantId.ALL_TENANT);
		return MapperFactory.getGnAreaMapper().selectByExample(sql);
	}

	@Override
	public PageInfo<GnArea> getFilterAreaListByPage(GnAreaPageFilterCondition areaPage) {
		PageInfo<GnArea> pageInfo = new PageInfo<GnArea>();
		GnAreaCriteria gnAreaCriteria = getQueryAreaListCriteria(areaPage);
		List<String> filterAreaCodeList = areaPage.getFilterAreaCodeList();
		// 添加过滤的areacode条件
		if (filterAreaCodeList != null && filterAreaCodeList.size() > 0) {
			List<Criteria> oredCriteria = gnAreaCriteria.getOredCriteria();
			for (Criteria criteria : oredCriteria) {
				criteria.andAreaCodeNotIn(filterAreaCodeList);
			}
		}
		GnAreaMapper mapper = MapperFactory.getGnAreaMapper();
		// 数据列表
		List<GnArea> dblist = mapper.selectByExample(gnAreaCriteria);
		// 总记录数
		int totalCount = mapper.countByExample(gnAreaCriteria);
		pageInfo.setCount(totalCount);
		pageInfo.setPageNo(areaPage.getPageNo());
		pageInfo.setPageSize(areaPage.getPageSize());
		pageInfo.setResult(dblist);

		return pageInfo;
	}

    @Override
    public Integer getAreaCount() {
        GnAreaCriteria sql = new GnAreaCriteria();
        sql.createCriteria().andStateEqualTo(Constants.AreaState.ACTIVITY);
        return MapperFactory.getGnAreaMapper().countByExample(sql);
    }

    @Override
    public List<GnArea> getAreaList(int start, int pageSize) {
        GnAreaCriteria sql = new GnAreaCriteria();
        sql.createCriteria().andStateEqualTo(Constants.AreaState.ACTIVITY);
        sql.setLimitStart(start);
        sql.setLimitEnd(pageSize);
        return MapperFactory.getGnAreaMapper().selectByExample(sql);
    }
}

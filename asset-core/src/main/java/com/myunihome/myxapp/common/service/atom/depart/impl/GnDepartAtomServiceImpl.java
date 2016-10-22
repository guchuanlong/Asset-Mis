package com.myunihome.myxapp.common.service.atom.depart.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.common.api.depart.param.GnDepartCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartVo;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepartCriteria;
import com.myunihome.myxapp.common.service.atom.depart.IGnDepartAtomService;
import com.myunihome.myxapp.common.util.CommonSeqUtil;
import com.myunihome.myxapp.common.util.DepartCacheUtil;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.paas.util.StringUtil;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;

@Component
public class GnDepartAtomServiceImpl implements IGnDepartAtomService {

    @Override
    public void addDepart(GnDepartVo gnDepartVo) {
        Gson gson = new Gson();
        GnDepart depart = gson.fromJson(gson.toJson(gnDepartVo), GnDepart.class);
        if (Constants.DepartLevel.NATION_CODE.equals(depart.getProvinceCode())) {
            depart.setDepartLevel(Constants.DepartLevel.NATION);
        } else if (Constants.DepartLevel.PROVINCE_CODE.equals(depart.getCityCode())) {
            depart.setDepartLevel(Constants.DepartLevel.PROVINCE);
        } else if (depart.getAreaCode().equals(depart.getCityCode())) {
            depart.setDepartLevel(Constants.DepartLevel.CITY);
        } else {
            depart.setDepartLevel(Constants.DepartLevel.AREA);
        }
        /*
         * if(depart.getParentDepartId().isEmpty()){ depart.setParentDepartId("0"); }
         */
        if (StringUtils.isEmpty(depart.getParentDepartId())) {
            depart.setParentDepartId("0");
        }
        depart.setDepartId(CommonSeqUtil.getDepartId(depart.getProvinceCode()));
        depart.setState(Constants.DepartState.ACTIVITY);
        depart.setCreateTime(new Timestamp(new Date().getTime()));
        MapperFactory.getGnDepartMapper().insert(depart);

        DepartCacheUtil.updateDepartCacheData(depart);
    }

    @Override
    public void modifyDepart(GnDepartVo gnDepartVo) {
        /*
         * Gson gson = new Gson(); GnDepart depart = gson.fromJson(gson.toJson(gnDepartVo),
         * GnDepart.class); depart.setCreateTime(DateUtil.getSysDate());
         * MapperFactory.getGnDepartMapper().updateByPrimaryKeySelective(depart);
         * DepartCacheUtil.updateDepartCacheData(depart);
         */
        if (selectById(gnDepartVo.getTenantId(), gnDepartVo.getDepartId()) != null) {
            Gson gson = new Gson();
            GnDepart depart = gson.fromJson(gson.toJson(gnDepartVo), GnDepart.class);
            if (Constants.DepartLevel.NATION_CODE.equals(depart.getProvinceCode())) {
                depart.setDepartLevel(Constants.DepartLevel.NATION);
            } else if (Constants.DepartLevel.PROVINCE_CODE.equals(depart.getCityCode())) {
                depart.setDepartLevel(Constants.DepartLevel.PROVINCE);
            } else if (depart.getAreaCode().equals(depart.getCityCode())) {
                depart.setDepartLevel(Constants.DepartLevel.CITY);
            } else {
                depart.setDepartLevel(Constants.DepartLevel.AREA);
            }
            if (StringUtils.isEmpty(depart.getParentDepartId())) {
                depart.setParentDepartId("0");
            }
            depart.setUpdateTime(new Timestamp(new Date().getTime()));
            MapperFactory.getGnDepartMapper().updateByPrimaryKeySelective(depart);
        }
    }

    @Override
    public void deleteDepart(String tenantId, String gnDepartId) {
        GnDepart depart = selectById(tenantId, gnDepartId);
        if (depart == null) {
            return;
        }
        List<GnDepart> gnDeparts = select(depart.getTenantId(), gnDepartId);
        if (!CollectionUtil.isEmpty(gnDeparts)) {
            throw new BusinessException("10004", "该部门底下存在子部门,不能被删除");
        }
        GnDepart gnDepart = new GnDepart();
        gnDepart.setDepartId(gnDepartId);

        gnDepart.setState(Constants.DepartState.INACTIVITY);
        MapperFactory.getGnDepartMapper().updateByPrimaryKeySelective(gnDepart);
    }

    @Override
    public GnDepart selectById(String tenantId, String departId) {
        GnDepartCriteria criteria = new GnDepartCriteria();
        criteria.createCriteria().andStateEqualTo("1").andDepartIdEqualTo(departId)
                .andTenantIdEqualTo(tenantId);
        List<GnDepart> departs = MapperFactory.getGnDepartMapper().selectByExample(criteria);
        if (CollectionUtil.isEmpty(departs)) {
            return null;
        }
        return departs.get(0);
    }

    @Override
    public List<GnDepart> select(String tenantId, String departId) {
        List<GnDepart> result = new ArrayList<GnDepart>();
        GnDepartCondition condition = new GnDepartCondition();
        condition.setDepartId(departId);
        condition.setTenantId(tenantId);
        GnDepartCriteria gnDepartCriteria = buildDepartCriteria(condition);
        List<GnDepart> gnAreas = MapperFactory.getGnDepartMapper()
                .selectByExample(gnDepartCriteria);
        result.addAll(gnAreas);
        return result;
    }

    @Override
    public List<GnDepart> selectByPage(GnDepartCondition condition, int start, int end) {
        List<GnDepart> result = new ArrayList<GnDepart>();
        GnDepartCriteria gnDepartCriteria = new GnDepartCriteria();
        GnDepartCriteria.Criteria criteria = gnDepartCriteria.createCriteria();
        if (!StringUtils.isEmpty(condition.getTenantId())) {
            criteria.andTenantIdEqualTo(condition.getTenantId());
        }
        if (!StringUtils.isEmpty(condition.getDepartId())) {
            criteria.andParentDepartIdEqualTo(condition.getDepartId());
        }

        if (!StringUtils.isEmpty(condition.getDepartName())) {
            criteria.andDepartNameLike("%" + condition.getDepartName() + "%");
        }

        criteria.andStateEqualTo(Constants.DepartState.ACTIVITY);
        gnDepartCriteria.setLimitStart(start);
        gnDepartCriteria.setLimitEnd(end);
        List<GnDepart> gnAreas = MapperFactory.getGnDepartMapper()
                .selectByExample(gnDepartCriteria);
        result.addAll(gnAreas);
        return result;
    }

    @Override
    public int count(GnDepartCondition gnDepartCondition) {
        GnDepartCriteria gnDepartCriteria = buildDepartCriteria(gnDepartCondition);
        return MapperFactory.getGnDepartMapper().countByExample(gnDepartCriteria);
    }

    @Override
    public void deleteDepart(List<GnDepartCondition> gnDepartCondition) {
        for (GnDepartCondition condition : gnDepartCondition) {
            if (StringUtil.isBlank(condition.getDepartId())) {
                continue;
            }
            deleteDepart(condition.getTenantId(), condition.getDepartId());
        }
    }

    private GnDepartCriteria buildDepartCriteria(GnDepartCondition condition) {
        GnDepartCriteria gnDepartCriteria = new GnDepartCriteria();
        GnDepartCriteria.Criteria criteria = gnDepartCriteria.createCriteria();
        criteria.andStateEqualTo("1").andTenantIdEqualTo(condition.getTenantId());
        if (!StringUtils.isEmpty(condition.getDepartId())) {
            criteria.andParentDepartIdEqualTo(condition.getDepartId());
        }

        if (!StringUtils.isEmpty(condition.getDepartName())) {
            criteria.andDepartNameLike("%" + condition.getDepartName() + "%");
        }

        return gnDepartCriteria;
    }

    @Override
    public List<GnDepart> selectAllById(String tenantId, String departId) {
        List<GnDepart> result = new ArrayList<GnDepart>();
        GnDepartCriteria gnDepartCriteria = new GnDepartCriteria();
        GnDepartCriteria.Criteria criteria = gnDepartCriteria.createCriteria();
        criteria.andStateEqualTo("1").andTenantIdEqualTo(tenantId);
        if (!StringUtils.isEmpty(departId)) {
            criteria.andDepartIdEqualTo(departId);

        }
        List<GnDepart> gnAreas = MapperFactory.getGnDepartMapper()
                .selectByExample(gnDepartCriteria);
        if (gnAreas != null && gnAreas.size() > 0) {
            GnDepart gnDepart = gnAreas.get(0);
            recursiveGnDepart(result, departId, tenantId);
            result.add(gnDepart);

        }
        return result;
    }

    private void recursiveGnDepart(List<GnDepart> listGnDepart, String departId, String tenantId) {
        GnDepartCriteria gnDepartCriteria = new GnDepartCriteria();
        GnDepartCriteria.Criteria criteria = gnDepartCriteria.createCriteria();
        criteria.andStateEqualTo("1").andTenantIdEqualTo(tenantId);
        if (!StringUtils.isEmpty(departId)) {
            criteria.andParentDepartIdEqualTo(departId);
        }
        List<GnDepart> gnAreas = MapperFactory.getGnDepartMapper()
                .selectByExample(gnDepartCriteria);
        listGnDepart.addAll(gnAreas);
        // 查询出下级机构的情况
        if (null != gnAreas && 0 < gnAreas.size()) {
            // 取出 所有下级机构 并 查出每个下级机构 的下级机构
            for (GnDepart gnDepart : gnAreas) {
                if (null != gnDepart) {
                    // 添加下级机构
                    this.recursiveGnDepart(listGnDepart, gnDepart.getDepartId(), tenantId);
                }
            }
        }
    }

    @Override
    public List<GnDepart> selectParentById(String tenantId, String departId) {
        List<GnDepart> result = new ArrayList<GnDepart>();
        GnDepartCriteria gnDepartCriteria = new GnDepartCriteria();
        GnDepartCriteria.Criteria criteria = gnDepartCriteria.createCriteria();
        criteria.andStateEqualTo("1").andTenantIdEqualTo(tenantId);
        if (!StringUtils.isEmpty(departId)) {
            criteria.andDepartIdEqualTo(departId);
        }
        List<GnDepart> gnAreas = MapperFactory.getGnDepartMapper()
                .selectByExample(gnDepartCriteria);
        if (gnAreas != null && gnAreas.size() > 0) {
            recursiveParentGnDepart(result, departId, tenantId);
        }
        return result;
    }

    private void recursiveParentGnDepart(List<GnDepart> listGnDepart, String departId,
            String tenantId) {
        GnDepartCriteria gnDepartCriteria = new GnDepartCriteria();
        GnDepartCriteria.Criteria criteria = gnDepartCriteria.createCriteria();
        criteria.andStateEqualTo("1").andTenantIdEqualTo(tenantId);
        if (!StringUtils.isEmpty(departId)) {
            criteria.andDepartIdEqualTo(departId);
        }
        List<GnDepart> gnAreas = MapperFactory.getGnDepartMapper()
                .selectByExample(gnDepartCriteria);
        listGnDepart.addAll(gnAreas);
        // 查询出上级级机构的情况
        if (null != gnAreas && gnAreas.size()>0) {
            // 取出 上级机构 并 查出每个上级机构 的上级机构
            for (GnDepart gnDepart : gnAreas) {
                if (null != gnDepart) {
                    // 添加上级机构
                    this.recursiveParentGnDepart(listGnDepart, gnDepart.getParentDepartId(), tenantId);
                }
            }
        }
    }
}

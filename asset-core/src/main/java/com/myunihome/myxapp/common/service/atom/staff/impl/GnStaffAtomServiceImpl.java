package com.myunihome.myxapp.common.service.atom.staff.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.google.gson.Gson;
import com.myunihome.myxapp.common.api.staff.param.GnStaffAreaQuery;
import com.myunihome.myxapp.common.api.staff.param.GnStaffCondition;
import com.myunihome.myxapp.common.api.staff.param.GnStaffVo;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepartCriteria;
import com.myunihome.myxapp.common.dao.mapper.bo.GnStaff;
import com.myunihome.myxapp.common.dao.mapper.bo.GnStaffCriteria;
import com.myunihome.myxapp.common.service.atom.staff.IGnStaffAtomService;
import com.myunihome.myxapp.common.util.CommonSeqUtil;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.paas.util.DateUtil;
import com.myunihome.myxapp.paas.util.StringUtil;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;

@Component
public class GnStaffAtomServiceImpl implements IGnStaffAtomService {

    @Override
    public void insertStaff(GnStaffVo gnStaffVo) {
        GnStaff gnStaff = convertGnStaff(gnStaffVo);
        // 设置StaffId
        gnStaff.setStaffId(CommonSeqUtil.getStaffId());
        gnStaff.setActiveTime(new Timestamp(new Date().getTime()));
        gnStaff.setUpdateTime(new Timestamp(new Date().getTime()));
        gnStaff.setCreateTime(new Timestamp(new Date().getTime()));
        gnStaff.setState(Constants.StaffState.ONLINE);
        MapperFactory.getGnStaffMapper().insertSelective(gnStaff);
    }

    @Override
    public void updateStaff(GnStaffVo gnStaffVo) {
        if (selectStaffById(gnStaffVo.getTenantId(), gnStaffVo.getStaffId()) != null) {
            GnStaff gnStaff = convertGnStaff(gnStaffVo);
            MapperFactory.getGnStaffMapper().updateByPrimaryKeySelective(gnStaff);
        }
    }

    private GnStaff convertGnStaff(GnStaffVo gnStaffVo) {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(gnStaffVo), GnStaff.class);
    }

    @Override
    public void deleteStaff(String tenantId, String staffId) {
        if (selectStaffById(tenantId, staffId) != null) {
            GnStaff gnStaff = new GnStaff();
            gnStaff.setStaffId(staffId);
            gnStaff.setState(Constants.StaffState.OFFLINE);
            MapperFactory.getGnStaffMapper().updateByPrimaryKeySelective(gnStaff);
        }
    }

    @Override
    public void deleteStaff(List<GnStaffCondition> gnStaffCondition) {
        for (GnStaffCondition condition : gnStaffCondition) {
            deleteStaff(condition.getTenantId(), condition.getStaffId());
        }
    }

    @Override
    public GnStaff selectStaffById(String tenantId, String staffId) {
        GnStaffCriteria criteria = new GnStaffCriteria();
        criteria.createCriteria().andStateEqualTo(Constants.StaffState.ONLINE)
                .andStaffIdEqualTo(staffId).andTenantIdEqualTo(tenantId);
        List<GnStaff> staffs = MapperFactory.getGnStaffMapper().selectByExample(criteria);
        if (CollectionUtil.isEmpty(staffs)) {
            return null;
        }
        return staffs.get(0);
    }

    @Override
    public List<GnStaff> selectStaffByDepart(String tenantId, String departId) {
        GnStaffCriteria criteria = new GnStaffCriteria();
        criteria.createCriteria().andStateEqualTo(Constants.StaffState.ONLINE)
                .andDepartIdEqualTo(departId).andTenantIdEqualTo(tenantId);
        return MapperFactory.getGnStaffMapper().selectByExample(criteria);
    }

    @Override
    public List<GnStaff> selectByPage(GnStaffCondition condition, int start, int end) {
        GnStaffCriteria gnStaffCriteria = buildConditionCriteria(condition);
        gnStaffCriteria.setLimitEnd(end);
        gnStaffCriteria.setLimitStart(start);
        return MapperFactory.getGnStaffMapper().selectByExample(gnStaffCriteria);
    }

    @Override
    public int count(GnStaffCondition condition) {
        GnStaffCriteria gnStaffCriteria = buildConditionCriteria(condition);
        return MapperFactory.getGnStaffMapper().countByExample(gnStaffCriteria);
    }

    private GnStaffCriteria buildConditionCriteria(GnStaffCondition condition) {
        GnStaffCriteria gnStaffCriteria = new GnStaffCriteria();
        GnStaffCriteria.Criteria criteria = gnStaffCriteria.createCriteria();
       
        if(!StringUtil.isBlank(condition.getPositionCode())){
            criteria.andPositionCodeEqualTo(condition.getPositionCode());
        }
        if(!StringUtil.isBlank(condition.getTenantId())){
            criteria.andTenantIdEqualTo(condition.getTenantId());
        }
        if (!StringUtil.isBlank(condition.getStaffName())) {
            criteria.andStaffNameLike("%" + condition.getStaffName() + "%");
        }

        if (!StringUtil.isBlank(condition.getStaffNo())) {
            criteria.andStaffNoEqualTo(condition.getStaffNo());
        }

        if (!StringUtil.isBlank(condition.getDepartId())) {
            criteria.andDepartIdEqualTo(condition.getDepartId());
        }
        if (!StringUtil.isBlank(condition.getStaffId())) {
            criteria.andStaffIdEqualTo(condition.getStaffId());
        }
        
        criteria.andStateEqualTo(Constants.StaffState.ONLINE);
        Date crruntDate = DateUtil.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(crruntDate);
        Timestamp crurentTs = Timestamp.valueOf(dateStr);  
        //添加有效时间限制
        criteria.andActiveTimeLessThanOrEqualTo(crurentTs);
        criteria.andInactiveTimeGreaterThanOrEqualTo(crurentTs);
        return gnStaffCriteria;
    }

    @Override
    public List<GnStaff> selectStaffByAreaCode(GnStaffAreaQuery query) {
        GnStaffCriteria gnStaffCriteria = new GnStaffCriteria();
        GnStaffCriteria.Criteria criteria = gnStaffCriteria.createCriteria();
        criteria.andStateEqualTo(Constants.StaffState.ONLINE)
        .andTenantIdEqualTo(query.getTenantId());
        if(!StringUtils.isEmpty(query.getStaffName())){
            criteria.andStaffNameLike("%" + query.getStaffName() + "%");
        }
        if (!StringUtil.isBlank(query.getStaffNo())) {
            criteria.andStaffNoEqualTo(query.getStaffNo());
        }
        List <String> departIds = selectDepartId(query.getTenantId(),query.getAreaCode());
        if(departIds!=null && departIds.size()>0){
            criteria.andDepartIdIn(departIds);
        }
        return MapperFactory.getGnStaffMapper().selectByExample(gnStaffCriteria);
    }

    @Override
    public List<String> selectDepartId(String tenantId, String areaCode) {
            GnDepartCriteria gnDepartCriteria = new GnDepartCriteria();
            GnDepartCriteria.Criteria criteria = gnDepartCriteria.createCriteria();
            criteria.andStateEqualTo(Constants.DepartState.ACTIVITY).andTenantIdEqualTo(tenantId);
            if (!StringUtils.isEmpty(areaCode)) {
                criteria.andAreaCodeEqualTo(areaCode);
            }
            List<GnDepart> gndeparts = MapperFactory.getGnDepartMapper().selectByExample(gnDepartCriteria);
            List<String> departs = new ArrayList<String>();
            if(gndeparts!=null && gndeparts.size()>0){
                for(GnDepart depart: gndeparts){
                    departs.add(depart.getDepartId());
                } 
            }
            return departs;
        }
}

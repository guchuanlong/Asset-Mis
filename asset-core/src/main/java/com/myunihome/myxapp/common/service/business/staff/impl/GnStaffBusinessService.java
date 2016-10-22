package com.myunihome.myxapp.common.service.business.staff.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myunihome.myxapp.common.api.staff.param.GnStaffAreaQuery;
import com.myunihome.myxapp.common.api.staff.param.GnStaffCondition;
import com.myunihome.myxapp.common.api.staff.param.GnStaffVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnStaff;
import com.myunihome.myxapp.common.service.atom.staff.IGnStaffAtomService;
import com.myunihome.myxapp.common.service.business.staff.IGnStaffBusinessService;

@Component
@Transactional
public class GnStaffBusinessService implements IGnStaffBusinessService {

    @Autowired
    private IGnStaffAtomService gnStaffAtomService;
  

    @Override
    public void addStaff(GnStaffVo gnStaffVo) {
        gnStaffAtomService.insertStaff(gnStaffVo);
    }

    @Override
    public void updateStaff(GnStaffVo gnStaffVo) {
        gnStaffAtomService.updateStaff(gnStaffVo);
    }

    @Override
    public void deleteStaff(String tenantId,String staffId) {
        gnStaffAtomService.deleteStaff(tenantId,staffId);
    }

    @Override
    public void deleteStaff(List<GnStaffCondition> gnStaffCondition) {
        gnStaffAtomService.deleteStaff(gnStaffCondition);
    }

    @Override
    public GnStaff selectStaffById(String tenantId,String staffId) {
        return gnStaffAtomService.selectStaffById(tenantId,staffId);
    }

    @Override
    public List<GnStaff> selectStaffByDepart(String tenantId,String departId) {
        return gnStaffAtomService.selectStaffByDepart(tenantId,departId);
    }

    @Override
    public List<GnStaff> selectByPage(GnStaffCondition condition, int start, int end) {
       return  gnStaffAtomService.selectByPage(condition, start, end);
    }

    @Override
    public int count(GnStaffCondition condition) {
        return gnStaffAtomService.count(condition);
    }

    @Override
    public List<GnStaff> selectStaffByAreaCode(GnStaffAreaQuery query) {
        return  gnStaffAtomService.selectStaffByAreaCode(query);
    }
}

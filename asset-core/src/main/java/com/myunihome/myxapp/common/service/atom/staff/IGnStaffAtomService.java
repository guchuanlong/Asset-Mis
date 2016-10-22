package com.myunihome.myxapp.common.service.atom.staff;

import java.util.List;

import com.myunihome.myxapp.common.api.staff.param.GnStaffAreaQuery;
import com.myunihome.myxapp.common.api.staff.param.GnStaffCondition;
import com.myunihome.myxapp.common.api.staff.param.GnStaffVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnStaff;

public interface IGnStaffAtomService {

    void insertStaff(GnStaffVo gnStaffVo);

    void updateStaff(GnStaffVo gnStaffVo);

    void deleteStaff(String tenantId,String staffId);

    void deleteStaff(List<GnStaffCondition> gnStaffCondition);

    GnStaff selectStaffById(String tenantId,String staffId);

    List<GnStaff> selectStaffByDepart(String tenantId,String departId);

    List<GnStaff> selectByPage(GnStaffCondition condition, int start, int end);

    int count(GnStaffCondition condition);
    
    List<GnStaff> selectStaffByAreaCode(GnStaffAreaQuery query);
    
    List<String> selectDepartId(String tenantId,String areaCode);
}

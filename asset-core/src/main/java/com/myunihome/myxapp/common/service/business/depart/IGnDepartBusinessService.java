package com.myunihome.myxapp.common.service.business.depart;

import java.util.List;

import com.myunihome.myxapp.common.api.depart.param.GnDepartCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;

public interface IGnDepartBusinessService {
    void addDepart(GnDepartVo gnDepartVo);

    void modifyDepart(GnDepartVo gnDepartVo);

    void deleteDepart(String tenantId,String gnDepartId);

    GnDepart selectById(String tenantId,String departId);

    List<GnDepart> select(String tenantId,String departId);

    List<GnDepart> selectByPage(GnDepartCondition condition, int start, int end);

    int count(GnDepartCondition gnDepartCondition);

    void deleteDeparts(List<GnDepartCondition> gnDepartCondition);
    
    List<GnDepart> selectALLById(String tenantId,String departId);
    
    List<GnDepart> selectParentById(String tenantId,String departId);
}

package com.myunihome.myxapp.common.service.atom.depart;

import java.util.List;

import com.myunihome.myxapp.common.api.depart.param.GnDepartCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;

public interface IGnDepartAtomService {
    void addDepart(GnDepartVo gnDepartVo);

    void modifyDepart(GnDepartVo gnDepartVo);

    void deleteDepart(String tenantId,String gnDepartId);

    GnDepart selectById(String tenantId,String departId);

    List<GnDepart> select(String tenantId,String departId);

    List<GnDepart> selectByPage(GnDepartCondition condition, int start, int end);

    int count(GnDepartCondition gnDepartCondition);

    void deleteDepart(List<GnDepartCondition> gnDepartCondition);
    
    List<GnDepart> selectAllById(String tenantId,String departId);
    
    List<GnDepart> selectParentById(String tenantId,String departId);
}

package com.myunihome.myxapp.common.service.business.depart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myunihome.myxapp.common.api.depart.param.GnDepartCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;
import com.myunihome.myxapp.common.service.atom.depart.IGnDepartAtomService;
import com.myunihome.myxapp.common.service.business.depart.IGnDepartBusinessService;
import com.myunihome.myxapp.common.util.DepartCacheUtil;
import com.myunihome.myxapp.paas.util.BeanUtils;

@Component
@Transactional
public class GnDepartBusinessService implements IGnDepartBusinessService {

    @Autowired
    private IGnDepartAtomService gnDepartAtomService;

    @Override
    public void addDepart(GnDepartVo gnDepartVo) {
        gnDepartAtomService.addDepart(gnDepartVo);
        if (!"0".equals(gnDepartVo.getParentDepartId())) {
            GnDepart depart = new GnDepart();
            BeanUtils.copyProperties(depart, gnDepartVo);
            DepartCacheUtil.updateDepartCacheData(depart);
        } else {
            gnDepartVo.setParentDepartId("");
            GnDepart depart = new GnDepart();
            BeanUtils.copyProperties(depart, gnDepartVo);
            DepartCacheUtil.updateDepartCacheData(depart);
        }
    }

    @Override
    public void modifyDepart(GnDepartVo gnDepartVo) {
        gnDepartAtomService.modifyDepart(gnDepartVo);
        if (!"0".equals(gnDepartVo.getParentDepartId())) {
            GnDepart depart = new GnDepart();
            BeanUtils.copyProperties(depart, gnDepartVo);
            DepartCacheUtil.updateDepartCacheData(depart);
        } else {
            gnDepartVo.setParentDepartId("");
            GnDepart depart = new GnDepart();
            BeanUtils.copyProperties(depart, gnDepartVo);
            DepartCacheUtil.updateDepartCacheData(depart);
        }

    }

    @Override
    public void deleteDepart(String tenantId, String gnDepartId) {
        gnDepartAtomService.deleteDepart(tenantId, gnDepartId);
    }

    @Override
    public GnDepart selectById(String tenantId, String departId) {
        return gnDepartAtomService.selectById(tenantId, departId);
    }

    @Override
    public List<GnDepart> select(String tenantId, String departId) {
        return gnDepartAtomService.select(tenantId, departId);
    }

    @Override
    public List<GnDepart> selectByPage(GnDepartCondition condition, int start, int end) {
        return gnDepartAtomService.selectByPage(condition, start, end);
    }

    @Override
    public int count(GnDepartCondition gnDepartCondition) {
        return gnDepartAtomService.count(gnDepartCondition);
    }

    @Override
    public void deleteDeparts(List<GnDepartCondition> gnDepartCondition) {
        gnDepartAtomService.deleteDepart(gnDepartCondition);
    }

    @Override
    public List<GnDepart> selectALLById(String tenantId, String departId) {
        return gnDepartAtomService.selectAllById(tenantId, departId);
    }

    @Override
    public List<GnDepart> selectParentById(String tenantId, String departId) {
        return gnDepartAtomService.selectParentById(tenantId, departId);
    }
}

package com.myunihome.myxapp.common.service.atom.subject.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSubjectFund;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSubjectFundCriteria;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSubjectFundKey;
import com.myunihome.myxapp.common.service.atom.subject.IGnSubjectFundAtomSV;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;

@Component
public class GnSubjectFundAtomSVImpl implements IGnSubjectFundAtomSV {

    @Override
    public GnSubjectFund queryGnSubjectFund(String tenantId,String industryCode,long subjectId) {
        GnSubjectFundKey key = new GnSubjectFundKey();
        key.setIndustryCode(industryCode);
        key.setSubjectId(subjectId);
        key.setTenantId(tenantId);
        return MapperFactory.getGnSubjectFundMapper().selectByPrimaryKey(key);
    }

    @Override
    public List<GnSubjectFund> queryGnSubjectFund() {
        return MapperFactory.getGnSubjectFundMapper().selectByExample(new GnSubjectFundCriteria());
    }

    @Override
    public void addSubjectFund(GnSubjectFund vo) throws BusinessException {
        MapperFactory.getGnSubjectFundMapper().insertSelective(vo);
    }

    @Override
    public void delSubjectFund(GnSubjectFundKey key) throws BusinessException {
        MapperFactory.getGnSubjectFundMapper().deleteByPrimaryKey(key);
    }

    @Override
    public void modSubjectFund(GnSubjectFund vo, GnSubjectFundKey key) throws BusinessException {
        GnSubjectFundCriteria example = new GnSubjectFundCriteria();
        example.createCriteria().andTenantIdEqualTo(key.getTenantId())
                .andIndustryCodeEqualTo(key.getIndustryCode())
                .andSubjectIdEqualTo(key.getSubjectId());
        MapperFactory.getGnSubjectFundMapper().updateByExampleSelective(vo, example);
    }
}

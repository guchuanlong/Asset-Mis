package com.myunihome.myxapp.common.service.atom.subject.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSettleRuleCriteria;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSettleRuleKey;
import com.myunihome.myxapp.common.service.atom.subject.IGnSettleRuleAtomSV;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;

@Component
public class GnSettleRuleAtomSVImpl implements IGnSettleRuleAtomSV {

    @Override
    public List<GnSettleRuleKey> queryGnSettleRule(String tenantId, String industryCode,
            long subjectId) throws BusinessException {
        GnSettleRuleCriteria example = new GnSettleRuleCriteria();
        example.createCriteria().andTenantIdEqualTo(tenantId).andIndustryCodeEqualTo(industryCode)
                .andSubjectIdEqualTo(subjectId);
        return MapperFactory.getGnSettleRuleMapper().selectByExample(example);
    }

    @Override
    public List<GnSettleRuleKey> queryGnSettleRule() throws BusinessException {
        return MapperFactory.getGnSettleRuleMapper().selectByExample(new GnSettleRuleCriteria());
    }

    @Override
    public void addSubjectRule(GnSettleRuleKey vo) throws BusinessException {
        MapperFactory.getGnSettleRuleMapper().insertSelective(vo);
    }

    @Override
    public void delSubjectRule(GnSettleRuleKey key) throws BusinessException {
        MapperFactory.getGnSettleRuleMapper().deleteByPrimaryKey(key);
    }

    @Override
    public void modSubjectRule(GnSettleRuleKey vo, GnSettleRuleKey key) throws BusinessException {
        GnSettleRuleCriteria example = new GnSettleRuleCriteria();
        example.createCriteria().andTenantIdEqualTo(key.getTenantId())
                .andIndustryCodeEqualTo(key.getIndustryCode())
                .andSubjectIdEqualTo(key.getSubjectId())
                .andFeeSubjectIdEqualTo(key.getFeeSubjectId());

        int result = MapperFactory.getGnSettleRuleMapper().updateByExampleSelective(vo, example);

        if (result != 1) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.SYSTEM_ERROR, "修改销账规则异常:原纪录不存在");
        }
    }
}

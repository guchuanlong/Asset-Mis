package com.myunihome.myxapp.common.api.subjectmaintain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.subjectmaintain.interfaces.IGnSubjectMaintainSV;
import com.myunihome.myxapp.common.api.subjectmaintain.param.GnSubjectCondition;
import com.myunihome.myxapp.common.api.subjectmaintain.param.GnSubjectFundVo;
import com.myunihome.myxapp.common.api.subjectmaintain.param.GnSubjectKeyParam;
import com.myunihome.myxapp.common.api.subjectmaintain.param.GnSubjectVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSubject;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSubjectFund;
import com.myunihome.myxapp.common.service.business.subject.IGnSubjectBusiSV;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.StringUtil;

@Service
@Component
public class GnSubjectMaintainSVImpl implements IGnSubjectMaintainSV {

    @Autowired
    private IGnSubjectBusiSV gnSubjectBusiSV;

    @Override
    public PageInfo<GnSubjectVo> querySubejct(GnSubjectCondition cond) throws CallerException {
        if (cond == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(cond.getIndustryCode())) {
            cond.setIndustryCode(null);
        }
        if (StringUtil.isBlank(cond.getTenantId())) {
            cond.setTenantId(null);
        }
        if (StringUtil.isBlank(cond.getSubjectType())) {
            cond.setSubjectType(null);
        }
        if (StringUtil.isBlank(cond.getSubjectName())) {
            cond.setSubjectName(null);
        }
        if (cond.getPageNo() != null && cond.getPageNo() < 1) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_TYPE_NOT_RIGHT,
                    "查询页面pageNo必须大于0");
        }
        if (cond.getPageSize() != null && cond.getPageSize() < 1) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_TYPE_NOT_RIGHT,
                    "查询页面pageSize必须大于0");
        }
        return gnSubjectBusiSV.queryGnSubject(cond);
    }

    @Override
    public GnSubjectVo querySubject(GnSubjectKeyParam key) throws CallerException {
        if (key == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(key.getIndustryCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "行业编码不能为空");
        }
        if (StringUtil.isBlank(key.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (key.getSubjectId() == null || key.getSubjectId() == 0) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目ID不能为空");
        }
        GnSubject subject = gnSubjectBusiSV.queryGnSubject(key.getTenantId(),
                key.getIndustryCode(), key.getSubjectId());
        GnSubjectVo vo = null;
        if (subject != null) {
            vo = new GnSubjectVo();
            BeanUtils.copyProperties(vo, subject);
        }
        return vo;
    }

    @Override
    public void addSubject(GnSubjectVo vo) throws CallerException {
        if (vo == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(vo.getIndustryCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "行业编码不能为空");
        }
        if (StringUtil.isBlank(vo.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(vo.getSubjectType())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目类型不能为空");
        }
        if (vo.getSubjectId() == 0) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目ID不能为空");
        }
        if (StringUtil.isBlank(vo.getSubjectName())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目名称不能为空");
        }
        if (StringUtil.isBlank(vo.getUnitName())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "单位名称不能为空");
        }
        gnSubjectBusiSV.addSubject(vo);
    }

    @Override
    public void deleteSubject(GnSubjectKeyParam key) throws CallerException {

        if (key == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(key.getIndustryCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "行业编码不能为空");
        }
        if (StringUtil.isBlank(key.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (key.getSubjectId() == null || key.getSubjectId() == 0) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目ID不能为空");
        }
        gnSubjectBusiSV.delSubject(key);
    }

    @Override
    public void modifySubject(GnSubjectVo vo) throws CallerException {
        if (vo == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(vo.getIndustryCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "行业编码不能为空");
        }
        if (StringUtil.isBlank(vo.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(vo.getSubjectType())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目类型不能为空");
        }
        if (vo.getSubjectId() == 0) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目ID不能为空");
        }
        if (StringUtil.isBlank(vo.getSubjectName())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目名称不能为空");
        }
        if (StringUtil.isBlank(vo.getUnitName())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "单位名称不能为空");
        }
        gnSubjectBusiSV.modSubject(vo);
    }

    @Override
    public GnSubjectFundVo querySubjectFund(GnSubjectKeyParam key) throws CallerException {
        if (key == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(key.getIndustryCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "行业编码不能为空");
        }
        if (StringUtil.isBlank(key.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (key.getSubjectId() == null || key.getSubjectId() == 0) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目ID不能为空");
        }
        GnSubjectFund subject = gnSubjectBusiSV.queryGnSubjectFund(key.getTenantId(),
                key.getIndustryCode(), key.getSubjectId());
        GnSubjectFundVo vo = null;
        if (subject != null) {
            vo = new GnSubjectFundVo();
            BeanUtils.copyProperties(vo, subject);
        }
        return vo;
    }

    @Override
    public void addSubjectFund(GnSubjectFundVo vo) throws CallerException {

        if (vo == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(vo.getIndustryCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "行业编码不能为空");
        }
        if (StringUtil.isBlank(vo.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(vo.getFundType())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "资金类型不能为空");
        }
        if (StringUtil.isBlank(vo.getIsCash())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "是否现金不能为空");
        }
        if (StringUtil.isBlank(vo.getUseMode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "使用模式不能为空");
        }
        if (StringUtil.isBlank(vo.getCanSettleAll())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "是否专用不能为空");
        }
        if (StringUtil.isBlank(vo.getValidType())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "账本叠加方式不能为空");
        }
        if (vo.getUsePri() == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "使用优先级不能为空");
        }
        if (vo.getRefundRate() == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "退费属性不能为空");
        }
        if (StringUtil.isBlank(vo.getCanTrans())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "转账属性不能为空");
        }
        if (StringUtil.isBlank(vo.getCanCleanFund())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "清理属性不能为空");
        }
        if (StringUtil.isBlank(vo.getCanDelBook())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "账本删除属性不能为空");
        }
        if (StringUtil.isBlank(vo.getCalScore())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "是否计算积分不能为空");
        }
        if (StringUtil.isBlank(vo.getPrintMode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "资金类型不能为空");
        }
        gnSubjectBusiSV.addSubjectFund(vo);
    }

    @Override
    public void deleteSubjectFund(GnSubjectKeyParam key) throws CallerException {
        if (key == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(key.getIndustryCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "行业编码不能为空");
        }
        if (StringUtil.isBlank(key.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (key.getSubjectId() == null || key.getSubjectId() == 0) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "科目ID不能为空");
        }
        gnSubjectBusiSV.delSubjectFund(key);
    }

    @Override
    public void modifySubjectFund(GnSubjectFundVo vo) throws CallerException {

        if (vo == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(vo.getIndustryCode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "行业编码不能为空");
        }
        if (StringUtil.isBlank(vo.getTenantId())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(vo.getFundType())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "资金类型不能为空");
        }
        if (StringUtil.isBlank(vo.getIsCash())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "是否现金不能为空");
        }
        if (StringUtil.isBlank(vo.getUseMode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "使用模式不能为空");
        }
        if (StringUtil.isBlank(vo.getCanSettleAll())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "是否专用不能为空");
        }
        if (StringUtil.isBlank(vo.getValidType())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "账本叠加方式不能为空");
        }
        if (vo.getUsePri() == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "使用优先级不能为空");
        }
        if (vo.getRefundRate() == null) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "退费属性不能为空");
        }
        if (StringUtil.isBlank(vo.getCanTrans())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "转账属性不能为空");
        }
        if (StringUtil.isBlank(vo.getCanCleanFund())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "清理属性不能为空");
        }
        if (StringUtil.isBlank(vo.getCanDelBook())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "账本删除属性不能为空");
        }
        if (StringUtil.isBlank(vo.getCalScore())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "是否计算积分不能为空");
        }
        if (StringUtil.isBlank(vo.getPrintMode())) {
            throw new BusinessException(MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "资金类型不能为空");
        }
        gnSubjectBusiSV.modSubjectFund(vo);
    }

}

package com.myunihome.myxapp.common.api.subjectmaintain.interfaces;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.subjectmaintain.param.GnSubjectCondition;
import com.myunihome.myxapp.common.api.subjectmaintain.param.GnSubjectFundVo;
import com.myunihome.myxapp.common.api.subjectmaintain.param.GnSubjectKeyParam;
import com.myunihome.myxapp.common.api.subjectmaintain.param.GnSubjectVo;

public interface IGnSubjectMaintainSV {

    /**
     * 科目ID，类型，名称－多条件分页查询
     * 
     * @param condition
     * @return
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    PageInfo<GnSubjectVo> querySubejct(GnSubjectCondition condition) throws CallerException;

    /**
     * 行业、租户、科目ID－主键查询
     * 
     * @return
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    GnSubjectVo querySubject(GnSubjectKeyParam key) throws CallerException;

    /**
     * 增加科目
     * 
     * @param vo
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    void addSubject(GnSubjectVo vo) throws CallerException;

    /**
     * 删除科目
     * 
     * @param vo
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    void deleteSubject(GnSubjectKeyParam key) throws CallerException;

    /**
     * 修改科目
     * 
     * @param vo
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    void modifySubject(GnSubjectVo vo) throws CallerException;

    /**
     * 
     * @param key
     * @return
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    GnSubjectFundVo querySubjectFund(GnSubjectKeyParam key) throws CallerException;

    /**
     * 增加科目资金属性
     * 
     * @param vo
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    void addSubjectFund(GnSubjectFundVo vo) throws CallerException;

    /**
     * 删除科目资金属性
     * 
     * @param vo
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    void deleteSubjectFund(GnSubjectKeyParam key) throws CallerException;

    /**
     * 修改科目资金属性
     * 
     * @param vo
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    void modifySubjectFund(GnSubjectFundVo vo) throws CallerException;
}

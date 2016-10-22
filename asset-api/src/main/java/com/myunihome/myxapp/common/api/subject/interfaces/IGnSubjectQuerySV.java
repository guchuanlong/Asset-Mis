package com.myunihome.myxapp.common.api.subject.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.subject.param.Subject;
import com.myunihome.myxapp.common.api.subject.param.SubjectFund;
import com.myunihome.myxapp.common.api.subject.param.SubjectIdParam;
import com.myunihome.myxapp.common.api.subject.param.SubjectTypeParam;

public interface IGnSubjectQuerySV {

    /**
     * 
     * 查询科目名称，翻译科目ID[全部科目] <br>
     * 
     * @param subjectId
     * @return 科目名称
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0038
     */
    public String getSubjectName(SubjectIdParam subjectId) throws CallerException;

    /**
     * 查询科目定义[全部科目] <br>
     * 
     * @return 科目结果对象
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0040
     */
    public Subject getSubject(SubjectIdParam subjectId) throws CallerException;

    /**
     * 根据科目类型查询科目[全部科目]
     * 
     * @param subjectType
     * @return 科目结果列表
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0041
     */
    public List<Subject> getSubjectByType(SubjectTypeParam subjectType) throws CallerException;

    /**
     * 
     * 根据科目ID查询[资金科目] <br>
     * 
     * @param subjectId
     * @return 资金科目结果对象
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0039
     */
    public SubjectFund getSubjectFund(SubjectIdParam subjectId) throws CallerException;

}

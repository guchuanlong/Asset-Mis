package com.myunihome.myxapp.sys.api.sysoper.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperParamsVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperResponseVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperStaffQueryVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperVO;

public interface IGnOperManageSV {
    
    /**
     * 创建操作员服务
     * @param operParamsVO  待添加操作员信息
     * <p/>
     * 参数列表：<br>
     * 租户编码<br>
     * 操作员编码<br>
     * 工号ID<br>
     * 归属组织类型<br>
     * 归属组织编码<br>
     * 状态<br>
     * 创建操作员id<br>
     * 备注<br>
     * <p/>
     * @return  操作员ID
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0027
     */
    Long addOper(GnOperParamsVO operParamsVO) throws CallerException;
    
    /**
     * 修改操作员服务
     * @param operParamsVO  待更新操作员信息
     * <p/>
     * 参数列表：<br>
     * 租户编码<br>
     * 操作员id<br>
     * 操作员编码<br>
     * 工号ID<br>
     * 归属组织类型<br>
     * 归属组织编码<br>
     * 状态<br>
     * 更新操作员id<br>
     * 备注<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0034
     */
    GnOperResponseVO updateOper(GnOperParamsVO operParamsVO) throws CallerException;

    /**
     * 删除操作员服务
     * @param operParamsVO  操作员操作参数类
     * <p/>
     * 参数列表：<br>
     * 操作员id<br>
     * 租户编码<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0028
     */
    GnOperResponseVO delOperByID(GnOperParamsVO operParamsVO) throws CallerException;
    
    /**
     * 根据操作员id获取操作信息服务
     * @param operParamsVO  操作员操作参数类
     * <p/>
     * 参数列表：<br>
     * 操作员id<br>
     * 租户编码<br>
     * <p/>
     * @return  实体类（租户编码、操作员id、操作员编码、工号ID、归属组织类型、归属组织编码、状态、备注）
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0035
     */
    GnOperVO queryOperById(GnOperParamsVO operParamsVO) throws CallerException;
    
    /**
     * 获取操作员分页信息
     * @param operParamsVO
     * @return
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0049
     */
    PageInfo<GnOperVO> queryOperPageInfo(GnOperParamsVO operParamsVO) throws CallerException;
    
    /**
     * 通过员工信息查询所有操作员对象
     * @param staffQueryVO
     * @return
     * @throws CallerException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0066
     */
    List<GnOperVO> queryOperListByStaff(GnOperStaffQueryVO staffQueryVO) throws CallerException;
    
}

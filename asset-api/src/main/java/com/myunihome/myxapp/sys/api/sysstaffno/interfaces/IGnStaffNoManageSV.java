package com.myunihome.myxapp.sys.api.sysstaffno.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoParamsVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoPasswdVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoResponseVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoVO;

public interface IGnStaffNoManageSV {
    
    /**
     * 员工工号创建服务
     * @param staffNoParamsVO  待添加员工工号信息
     * <p/>
     * 参数列表：<br>
     * 租户编码<br>
     * 员工工号<br>
     * 工号密码（MD5）<br>
     * 员工ID<br>
     * 员工姓名<br>
     * 状态<br>
     * 生效时间<br>
     * 失效时间<br>
     * 创建人<br>
     * <p/>
     * @return  员工工号ID
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0009
     */
    Long addStaffNo(GnStaffNoParamsVO staffNoParamsVO) throws CallerException;
    
    /**
     * 员工工号修改服务
     * @param staffNoParamsVO  待更新员工工号信息
     * <p/>
     * 参数列表：<br>
     * 租户编码<br>
     * 工号密码（MD5）<br>
     * 员工ID<br>
     * 员工姓名<br>
     * 状态<br>
     * 生效时间<br>
     * 失效时间<br>
     * 更新人<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0011
     */
    GnStaffNoResponseVO updateStaffNo(GnStaffNoParamsVO staffNoParamsVO) throws CallerException;

    /**
     * 员工工号删除服务
     * @param staffNoParamsVO  员工工号操作参数类
     * <p/>
     * 参数列表：<br>
     * 员工工号id<br>
     * 租户编码<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0012
     */
    GnStaffNoResponseVO delStaffNoByID(GnStaffNoParamsVO staffNoParamsVO) throws CallerException;
    
    /**
     * 根据员工工号id获取员工工号信息服务
     * @param staffNoParamsVO  员工工号操作参数类
     * <p/>
     * 参数列表：<br>
     * 员工工号id<br>
     * 租户编码<br>
     * <p/>
     * @return  实体类（租户编码、员工工号ID、员工工号、对应员工ID、生效时间、失效时间、对应员工名称）
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0013
     */
    GnStaffNoVO queryStaffNoById(GnStaffNoParamsVO staffNoParamsVO) throws CallerException;
    
    /**
     * 根据查询条件获取员工工号列表服务
     * @param staffNoParamsVO  员工工号操作参数类
     * <p/>
     * 参数列表：<br>
     * 租户编码<br>
     * 分页参数<br>
     * 员工工号<br>
     * 生效时间<br>
     * 失效时间<br>
     * <p/>
     * @return  列表（员工工号ID、员工工号、员工ID、员工名称、租户编码、生效时间、失效时间、状态）
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0014
     */
    PageInfo<GnStaffNoVO> queryStaffNo(GnStaffNoParamsVO staffNoParamsVO) throws CallerException;
    
    /**
     * 员工工号唯一性校验
     * @param staffNoParamsVO  员工工号操作参数类
     * <p/>
     * 参数列表：<br>
     * 员工工号<br>
     * 租户编码<br>
     * <p/>
     * @return  TRUE 唯一，FALSE 不唯一
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0033
     */
    Boolean isStaffNoUnique(GnStaffNoParamsVO staffNoParamsVO) throws CallerException;
    
    /**
     * 重置工号密码（密码重置为原始密码：12345）
     * @param staffNoPasswdVO
     * @return
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0064
     */
    GnStaffNoResponseVO resetStaffPassword(GnStaffNoPasswdVO staffNoPasswdVO) throws CallerException;
    
    /**
     * 获得员工工号列表信息
     * @param staffNoParamsVO
     * @return
     * @throws CallerException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0068
     */
    List<GnStaffNoVO> queryStaffNoList(GnStaffNoParamsVO staffNoParamsVO) throws CallerException;
}

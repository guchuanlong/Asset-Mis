package com.myunihome.myxapp.sys.api.sysoperarea.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaParamsVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaResponseVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffAreaPageQueryVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffAreaQueryVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffOperVO;

public interface IGnOperAreaManageSV {
    
    /**
     * 操作员赋予区域权限服务
     * @param GnOperAreaParamsVO  待处理操作员信息
     * @return  响应信息
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0045
     */
    GnOperAreaResponseVO addAreaToOper(GnOperAreaParamsVO operAreaParamsVO) throws CallerException;
    
    /**
     * 操作员拥有区域列表服务
     * @param operAreaParamsVO  操作员拥有区域操作参数
     * <p/>
     * 参数列表：<br>
     * 租户编码<br>
     * 操作员id<br>
     * 分页参数<br>
     * <p/>
     * @return  列表（区域id、区域名称）
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0046
     */
    PageInfo<GnOperAreaVO> queryAreaPageByOperId(GnOperAreaParamsVO operAreaParamsVO) throws CallerException;
    
    /**
     * 通过操作员id获得区域信息列表
     * @param operAreaParamsVO (租户id,操作员id)
     * @return
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0047
     */
    List<GnOperAreaVO> queryAreaListByOperId(GnOperAreaParamsVO operAreaParamsVO) throws CallerException;
    
    /**
     * 删除操作员区域信息
     * @param operAreaParamsVO
     * @return
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0048
     */
    GnOperAreaResponseVO deleteOperArea(GnOperAreaParamsVO operAreaParamsVO) throws CallerException;
   
    /**
     * 根据小区查询人员列表的服务
     * @param staffnoAreaQueryVO
     * @return
     * @throws CallerException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0067
     */
    List<GnStaffOperVO> queryStaffOperListByArea(GnStaffAreaQueryVO staffnoAreaQueryVO) throws CallerException;

    /**
     * 根据小区查询人员分页信息的服务
     * @param staffnoAreaPageQueryVO
     * @return
     * @throws CallerException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0069
     */
    PageInfo<GnStaffOperVO> queryStaffOperPageInfoByArea(GnStaffAreaPageQueryVO staffnoAreaPageQueryVO) throws CallerException;
}

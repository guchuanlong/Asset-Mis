package com.myunihome.myxapp.sso.service;

import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperArea;
import com.myunihome.myxapp.sso.model.operarea.OperAreaQueryParams;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaParamsVO;

public interface IOperAreaService {

	/**
     * 操作员赋予区域权限服务
     * @param gnOperArea  待处理操作员信息
     * @return  响应信息
     * @author jiaxs
     */
    Integer addAreaToOper(GnOperArea gnOperArea);
    
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
     */
    PageInfo<GnOperArea> queryAreaPageByOperId(GnOperAreaParamsVO operAreaParamsVO);
    
    /**
     * 通过操作员id获得区域信息列表
     * @param operAreaParamsVO (租户id,操作员id)
     * @return
     * @author jiaxs
     */
    List<GnOperArea> queryAreaListByOperId(GnOperAreaParamsVO operAreaParamsVO);
    
    /**
     * 删除操作员区域信息
     * @param operAreaParamsVO
     * @return
     * @author jiaxs
     */
    Integer deleteOperArea(GnOperAreaParamsVO operAreaParamsVO);
    
    /**
     * 通过查询条件查询操作员区域List对象
     * @param operAreaQueryParams
     * @return
     * @author jiaxs
     * @ApiDocMethod
     */
    List<GnOperArea> queryAreaListByParams(OperAreaQueryParams operAreaQueryParams);
}

package com.myunihome.myxapp.common.api.cache.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.cache.param.Area;
import com.myunihome.myxapp.common.api.cache.param.CfgProperties;
import com.myunihome.myxapp.common.api.cache.param.Depart;
import com.myunihome.myxapp.common.api.cache.param.SysParam;

/**
 * 公共中心缓存读取服务<br>
 * Date: 2015年7月16日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhangchao
 */
public interface ICacheSV {

    /**
     * 获取字典参数列表
     * 
     * @param tenantId
     *            租户ID
     * @param typeCode
     *            字典类型
     * @param paramCode
     *            字典参数
     * @return 字段参数配置列表 List<SysParam>
     * @throws CallerException
     * @author zhangchao
     * @ApiDocMethod
     * @ApiCode GN_0200
     */
    public List<SysParam> getSysParams(String tenantId, String typeCode, String paramCode)
            throws CallerException;

    /**
     * 
     * 获取单条字典参数
     * 
     * @param tenantId
     *            租户ID
     * @param typeCode
     *            字典类型
     * @param paramCode
     *            字典参数
     * @param columnValue
     *          字典取值
     * @return 单个字典参数配置对象 SysParam
     * @throws CallerException
     * @author zhangchao
     * @ApiDocMethod
     * @ApiCode GN_0201
     */
    public SysParam getSysParam(String tenantId, String typeCode, String paramCode,
            String columnValue) throws CallerException;

    /**
     * 
     * 获取单条系统配置参数
     * 
     * @param tenantId
     *            租户ID
     * @param cfgType
     *            配置类型
     * @param cfgProperty
     *            配置参数
     * @return 单个配置参数配置对象 CfgProperties
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0202
     */
    public CfgProperties getCfgProperties(String tenantId, String cfgType, String cfgProperty) throws CallerException;
    
    /**
     * 获取单条区域名称
     * @param tenantId
     * @param areaCode
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0203
     */
    public String getAreaName(String tenantId, String areaCode) throws CallerException;
    
    /**
     * 获取单条区域信息
     * @param tenantId
     * @param areaCode
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0204
     */
    public Area getArea(String tenantId, String areaCode) throws CallerException;
    
    /**
     * 获取部门ID对应的部门名称
     * @param departId
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0205
     */
    public String getDepartName(String tenantId,String departId) throws CallerException;
    
    /**
     * 获取部门ID对应的部门信息及所属的区域信息
     * @param tenantId
     * @param departId
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0206
     */
    public Depart getDepart(String tenantId,String departId) throws CallerException;

}

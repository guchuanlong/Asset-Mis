package com.myunihome.myxapp.common.api.area.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.area.param.GnAreaCodeCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaPageCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaPageFilterCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaVo;

/**
 * 区域查询服务<br>
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin10
 */
public interface IGnAreaQuerySV {

    /**
     * 根据区域编码获取详细信息.
     * <p/>
     * 根据传入的区域ID来查询详情,如果传入的区域ID为空，则抛出异常.
     *
     * @param condition
     * @return
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0101
     */
    GnAreaVo selectByID(GnAreaCondition condition) throws CallerException;
    
    
    /**
     * 根据地域编码获取地域信息
     * @param areaCode 地域编码
     * @return 地域信息
     * @throws CallerException
     * @author zhangchao
     * @ApiDocMethod
     * @ApiCode GN_0102
     */
    GnAreaVo queryGnArea(String tenantId,String areaCode) throws CallerException;
    
    
    /**
     * 获取所有的省份列表.
     *
     * @return 所有省份列表
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0103
     */
    List<GnAreaVo> getProvinceList() throws CallerException;
    
    /**
     * 根据小区编码获取对应的所有上级区域列表
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0104
     */
    List<GnAreaVo> getParentAreaListByAreaCode(GnAreaCodeCondition condition) throws CallerException;
    
    /**
     * 根据省份code，查找所有的城市列表
     * @param provinceCode 省份code
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0105
     */
    List<GnAreaVo> getCityListByProviceCode(String provinceCode) throws CallerException;
    /**
     * 根据城市code，查找所有的区县列表
     * @param cityCode 城市code
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0106
     */
    List<GnAreaVo> getCountyListByCityCode(String cityCode) throws CallerException;
    /**
     * 根据区县code，查找所有的街道列表
     * @param countyCode 区县code
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0107
     */
    List<GnAreaVo> getStreetListByCountyCode(String countyCode) throws CallerException;
    /**
     * 根据街道code，查找小区列表
     * @param tenantId 租户ID
     * @param streetCode 街道code
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0108
     */
    List<GnAreaVo> getAreaListByStreetCode(String tenantId,String streetCode) throws CallerException;
    
    /**
     * 小区（街道下的小区）分页查询
     * @param areaPage
     * @return
     * @throws CallerException
     * @author gucl
     * @ApiDocMethod
     * @ApiCode GN_0109
     */
    PageInfo<GnAreaVo> getAreaListByPage(GnAreaPageCondition areaPage) throws CallerException;
    
    /**
     * 获取全国列表
     * @return
     * @throws CallerException
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode GN_0110
     */
    List<GnAreaVo> getNationList() throws CallerException;
    
    /**
     * 小区（街道下的小区）分页查询(可过滤指定areacodeList)
     * @param areaPage
     * @return
     * @throws CallerException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode GN_0111
     */
    PageInfo<GnAreaVo> getFilterAreaListByPage(GnAreaPageFilterCondition areaPage) throws CallerException;
    
}

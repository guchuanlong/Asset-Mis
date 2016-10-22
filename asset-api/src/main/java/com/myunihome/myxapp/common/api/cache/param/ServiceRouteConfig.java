package com.myunihome.myxapp.common.api.cache.param;

import java.io.Serializable;

/**
 * 服务路由配置对象.<br>
 * Date: 2015年7月20日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author gucl
 *
 */
public class ServiceRouteConfig  implements Serializable {
	/**
	 * 服务类型
	 */
    private String serviceType;

    /**
     * 路由参数名称
     */
    private String routeParamName;

    /**
     * 路由参数取值
     */
    private String routeParamValue;

    /**
     * 服务信息
     */
    private String routeService;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态-1：有效 0：无效
     */
    private String state;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getRouteParamName() {
        return routeParamName;
    }

    public void setRouteParamName(String routeParamName) {
        this.routeParamName = routeParamName == null ? null : routeParamName.trim();
    }

    public String getRouteParamValue() {
        return routeParamValue;
    }

    public void setRouteParamValue(String routeParamValue) {
        this.routeParamValue = routeParamValue == null ? null : routeParamValue.trim();
    }

    public String getRouteService() {
        return routeService;
    }

    public void setRouteService(String routeService) {
        this.routeService = routeService == null ? null : routeService.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

}
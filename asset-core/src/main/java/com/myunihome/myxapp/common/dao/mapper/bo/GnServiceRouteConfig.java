package com.myunihome.myxapp.common.dao.mapper.bo;

public class GnServiceRouteConfig {
    private Long routeId;

    private String serviceType;

    private String routeParamName;

    private String routeParamValue;

    private String routeService;

    private String remark;

    private String state;

    private String tenantId;

    private String centerCode;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode == null ? null : centerCode.trim();
    }
}
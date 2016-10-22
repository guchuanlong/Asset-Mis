package com.myunihome.myxapp.sso.dao.mapper.bo;

public class GnSystemModeKey {
    private String systemModeId;

    private String tenantId;

    public String getSystemModeId() {
        return systemModeId;
    }

    public void setSystemModeId(String systemModeId) {
        this.systemModeId = systemModeId == null ? null : systemModeId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}
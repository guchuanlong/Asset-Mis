package com.myunihome.myxapp.sso.dao.mapper.bo;

public class GnSystemMode extends GnSystemModeKey {
    private String systemModeName;

    private String systemUrlContext;

    public String getSystemModeName() {
        return systemModeName;
    }

    public void setSystemModeName(String systemModeName) {
        this.systemModeName = systemModeName == null ? null : systemModeName.trim();
    }

    public String getSystemUrlContext() {
        return systemUrlContext;
    }

    public void setSystemUrlContext(String systemUrlContext) {
        this.systemUrlContext = systemUrlContext == null ? null : systemUrlContext.trim();
    }
}
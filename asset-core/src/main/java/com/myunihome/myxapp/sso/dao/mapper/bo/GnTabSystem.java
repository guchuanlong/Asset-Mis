package com.myunihome.myxapp.sso.dao.mapper.bo;

public class GnTabSystem extends GnTabSystemKey {
    private String systemName;

    private String remark;

    private String systemUrlContext;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSystemUrlContext() {
        return systemUrlContext;
    }

    public void setSystemUrlContext(String systemUrlContext) {
        this.systemUrlContext = systemUrlContext == null ? null : systemUrlContext.trim();
    }
}
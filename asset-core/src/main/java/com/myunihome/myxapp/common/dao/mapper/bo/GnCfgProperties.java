package com.myunihome.myxapp.common.dao.mapper.bo;

public class GnCfgProperties {
    private String guidkey;

    private String cfgtype;

    private String property;

    private String value;

    private String cfgdesc;

    private String tenantId;

    private String systemId;

    public String getGuidkey() {
        return guidkey;
    }

    public void setGuidkey(String guidkey) {
        this.guidkey = guidkey == null ? null : guidkey.trim();
    }

    public String getCfgtype() {
        return cfgtype;
    }

    public void setCfgtype(String cfgtype) {
        this.cfgtype = cfgtype == null ? null : cfgtype.trim();
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getCfgdesc() {
        return cfgdesc;
    }

    public void setCfgdesc(String cfgdesc) {
        this.cfgdesc = cfgdesc == null ? null : cfgdesc.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }
}
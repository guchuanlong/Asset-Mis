package com.myunihome.myxapp.sso.dao.mapper.bo;

public class GnTabSysIpMap extends GnTabSysIpMapKey {
    private String mappedId;

    private String remark;

    public String getMappedId() {
        return mappedId;
    }

    public void setMappedId(String mappedId) {
        this.mappedId = mappedId == null ? null : mappedId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
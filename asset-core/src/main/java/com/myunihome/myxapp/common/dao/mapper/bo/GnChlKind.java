package com.myunihome.myxapp.common.dao.mapper.bo;

public class GnChlKind {
    private String kindId;

    private String kindValue;

    private String upKindId;

    private String kindLevel;

    private String provinceCode;

    private String state;

    private String tenantId;

    public String getKindId() {
        return kindId;
    }

    public void setKindId(String kindId) {
        this.kindId = kindId == null ? null : kindId.trim();
    }

    public String getKindValue() {
        return kindValue;
    }

    public void setKindValue(String kindValue) {
        this.kindValue = kindValue == null ? null : kindValue.trim();
    }

    public String getUpKindId() {
        return upKindId;
    }

    public void setUpKindId(String upKindId) {
        this.upKindId = upKindId == null ? null : upKindId.trim();
    }

    public String getKindLevel() {
        return kindLevel;
    }

    public void setKindLevel(String kindLevel) {
        this.kindLevel = kindLevel == null ? null : kindLevel.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
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
}
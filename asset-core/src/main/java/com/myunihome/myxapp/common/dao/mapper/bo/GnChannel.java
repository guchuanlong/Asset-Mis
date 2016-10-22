package com.myunihome.myxapp.common.dao.mapper.bo;

import java.sql.Timestamp;

public class GnChannel {
    private String chnlId;

    private String chnlCode;

    private String chnlName;

    private String chnlDesc;

    private String state;

    private String chnlKindId;

    private String selfFlag;

    private String feeCloseFlag;

    private String departId;

    private String managerStaffId;

    private String provinceCode;

    private String cityCode;

    private String areaCode;

    private String address;

    private String postcode;

    private String longitude;

    private String latitude;

    private String contactTel;

    private String superChnlId;

    private Timestamp createTime;

    private Timestamp updateTime;

    private String remark;

    private String tenantId;

    public String getChnlId() {
        return chnlId;
    }

    public void setChnlId(String chnlId) {
        this.chnlId = chnlId == null ? null : chnlId.trim();
    }

    public String getChnlCode() {
        return chnlCode;
    }

    public void setChnlCode(String chnlCode) {
        this.chnlCode = chnlCode == null ? null : chnlCode.trim();
    }

    public String getChnlName() {
        return chnlName;
    }

    public void setChnlName(String chnlName) {
        this.chnlName = chnlName == null ? null : chnlName.trim();
    }

    public String getChnlDesc() {
        return chnlDesc;
    }

    public void setChnlDesc(String chnlDesc) {
        this.chnlDesc = chnlDesc == null ? null : chnlDesc.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getChnlKindId() {
        return chnlKindId;
    }

    public void setChnlKindId(String chnlKindId) {
        this.chnlKindId = chnlKindId == null ? null : chnlKindId.trim();
    }

    public String getSelfFlag() {
        return selfFlag;
    }

    public void setSelfFlag(String selfFlag) {
        this.selfFlag = selfFlag == null ? null : selfFlag.trim();
    }

    public String getFeeCloseFlag() {
        return feeCloseFlag;
    }

    public void setFeeCloseFlag(String feeCloseFlag) {
        this.feeCloseFlag = feeCloseFlag == null ? null : feeCloseFlag.trim();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public String getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(String managerStaffId) {
        this.managerStaffId = managerStaffId == null ? null : managerStaffId.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getSuperChnlId() {
        return superChnlId;
    }

    public void setSuperChnlId(String superChnlId) {
        this.superChnlId = superChnlId == null ? null : superChnlId.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}
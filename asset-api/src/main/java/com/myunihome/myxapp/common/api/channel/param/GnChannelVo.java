package com.myunihome.myxapp.common.api.channel.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 渠道查询结果类<br>
 * Date: 2015年9月25日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin10
 */
public class GnChannelVo extends BaseInfo {

    /**
     * 渠道ID
     */
    private String chnlId;

    /**
     * 渠道编码
     */
    private String chnlCode;

    /**
     * 渠道名称
     */
    private String chnlName;

    /**
     * 渠道描述
     */
    private String chnlDesc;

    /**
     * 渠道类型ID
     */
    private String chnlKindId;

    /**
     * 是否支持自提
     */
    private String selfFlag;

    /**
     * 扎帐标识
     */
    private String feeCloseFlag;

    /**
     * 渠道管理部门
     */
    private String departId;

    /**
     * 渠道管理员
     */
    private String managerStaffId;

    /**
     * 渠道所属省分
     */
    private String provinceCode;

    /**
     * 渠道所属地市
     */
    private String cityCode;

    /**
     * 渠道归属区域
     */
    private String areaCode;

    /**
     * 渠道地址
     */
    private String address;

    /**
     * 地址邮编
     */
    private String postcode;

    /**
     * 联系电话
     */
    private String contactTel;

    /**
     * 父渠道ID
     */
    private String superChnlId;

    /**
     * 备注
     */
    private String remark;

    public String getChnlId() {
        return chnlId;
    }

    public void setChnlId(String chnlId) {
        this.chnlId = chnlId;
    }

    public String getChnlCode() {
        return chnlCode;
    }

    public void setChnlCode(String chnlCode) {
        this.chnlCode = chnlCode;
    }

    public String getChnlName() {
        return chnlName;
    }

    public void setChnlName(String chnlName) {
        this.chnlName = chnlName;
    }

    public String getChnlDesc() {
        return chnlDesc;
    }

    public void setChnlDesc(String chnlDesc) {
        this.chnlDesc = chnlDesc;
    }

    public String getChnlKindId() {
        return chnlKindId;
    }

    public void setChnlKindId(String chnlKindId) {
        this.chnlKindId = chnlKindId;
    }

    public String getSelfFlag() {
        return selfFlag;
    }

    public void setSelfFlag(String selfFlag) {
        this.selfFlag = selfFlag;
    }

    public String getFeeCloseFlag() {
        return feeCloseFlag;
    }

    public void setFeeCloseFlag(String feeCloseFlag) {
        this.feeCloseFlag = feeCloseFlag;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(String managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getSuperChnlId() {
        return superChnlId;
    }

    public void setSuperChnlId(String superChnlId) {
        this.superChnlId = superChnlId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

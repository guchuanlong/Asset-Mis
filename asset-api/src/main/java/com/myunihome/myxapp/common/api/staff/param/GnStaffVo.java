package com.myunihome.myxapp.common.api.staff.param;

import java.sql.Timestamp;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 人员查询结果类<br>
 * Date: 2015年8月10日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin
 */
public class GnStaffVo extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 员工编码(员工ID)
     */
    private String staffId;

    /**
     * 员工工号
     */
    private String staffNo;

    /**
     * 员工名称
     */
    private String staffName;

    /**
     * 员工类型
     */
    private String staffClass;

    /**
     * 归属部门ID
     */
    private String departId;

    /**
     * 归属部门名称
     */
    private String departName;

    /**
     * 联系电话
     */
    private String contactTel;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 生效时间
     */
    private Timestamp activeTime;

    /**
     * 失效时间
     */
    private Timestamp inactiveTime;
    /**
     * 人员职位
     */
    private String positionCode;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffClass() {
        return staffClass;
    }

    public void setStaffClass(String staffClass) {
        this.staffClass = staffClass;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Timestamp getActiveTime() {
        if (activeTime != null) {
            return new Timestamp(activeTime.getTime());
        }

        return null;
    }

    public void setActiveTime(Timestamp activeTime) {
        if (activeTime != null) {
            this.activeTime = new Timestamp(activeTime.getTime());
        }
    }

    public Timestamp getInactiveTime() {
        if (inactiveTime != null) {
            return new Timestamp(inactiveTime.getTime());
        }

        return null;
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        if (inactiveTime != null) {
            this.inactiveTime = new Timestamp(inactiveTime.getTime());
        }
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }
    
}

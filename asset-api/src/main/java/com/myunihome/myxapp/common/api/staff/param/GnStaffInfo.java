package com.myunihome.myxapp.common.api.staff.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 人员查询结果类<br>
 * Date: 2016年1月5日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public class GnStaffInfo extends BaseInfo {
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

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

}

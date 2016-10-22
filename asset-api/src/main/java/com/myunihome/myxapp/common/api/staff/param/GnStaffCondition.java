package com.myunihome.myxapp.common.api.staff.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 人员查询条件类<br>
 * Date: 2015年8月10日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin
 */
public class GnStaffCondition extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 员工名称
     */
    private String staffName;

    /**
     * 部门编码(部门ID)
     */
    private String departId;

    /**
     * 员工编码(员工ID)
     */
    private String staffId;

    /**
     * 员工工号
     */
    private String staffNo;

    /**
     * 员所属行业
     */
    private String positionCode;

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

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
}

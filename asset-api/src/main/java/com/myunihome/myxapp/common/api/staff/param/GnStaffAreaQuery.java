package com.myunihome.myxapp.common.api.staff.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 人员查询条件类<br>
 * Date: 2016年1月5日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public class GnStaffAreaQuery extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 员工名称
     */
    private String staffName;

    /**
     * 员工工号
     */
    private String staffNo;

    /**
     * 小区
     */
    private String areaCode;

    /**
     * 部门ID
     */
    private String departId;

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

}

package com.myunihome.myxapp.sso.api.staffnoquery.param;

import com.myunihome.myxapp.base.vo.BaseInfo;
/**
 * 员工信息查询<br>
 * Date: 2015年8月17日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhouyy5
 */
public class StaffNoVo extends  BaseInfo{

    private static final long serialVersionUID = 2579255457536164067L;
    /**
     * 员工id
     */
    private String  staffId;
    /**
     * 员工名称
     */
    private String  staffName;
    /**
     * 请求查询页码
     */
    private Integer  pageNumber;
    /**
     * 每页显示条数
     */
    private Integer  pageSize;
    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public Integer getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
 
}

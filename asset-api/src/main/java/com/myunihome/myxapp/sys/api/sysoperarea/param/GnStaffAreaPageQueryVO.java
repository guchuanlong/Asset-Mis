package com.myunihome.myxapp.sys.api.sysoperarea.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 根据小区查询人员的服务查询条件对象
 * Date: 2016年1月6日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author jiaxs
 */
public class GnStaffAreaPageQueryVO extends BaseInfo {

	private static final long serialVersionUID = 1L;

	/**
	 * 区域编码（必填）
	 */
	private String areaCode;
	/**
	 * 员工工号（选填）
	 */
	private String staffNo;
	/**
	 * 员工姓名（选填）
	 */
	private String staffName;
	
	/**
     * 每页显示条数（必填）
     */
    private Integer pageSize;
    
    /**
     * 请求查询的页码（必填）
     */
    private Integer pageNo;
	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

}

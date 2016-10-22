package com.myunihome.myxapp.sys.api.sysoperarea.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class GnStaffOperVO extends BaseInfo {

	private static final long serialVersionUID = 1L;

	/**
	 * 员工id
	 */
	private String staffId;

	/**
	 * 员工工号
	 */
	private String staffNo;

	/**
	 * 员工姓名
	 */
	private String staffName;

	/**
	 * 归属组织类型
	 */
	private String orgType;

	/**
	 * 归属组织
	 */
	private String orgId;

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

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}

package com.myunihome.myxapp.sys.api.sysstaffno.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class GnStaffNoPasswdVO extends BaseInfo {

	private static final long serialVersionUID = 1L;
	
	/**
     * 员工工号 不能为空
     */
    private String staffNo;

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

}

package com.myunihome.myxapp.sys.api.sysoper.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class GnOperStaffQueryVO extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	/**
     * 员工姓名
     */
    private String staffName;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

}

package com.myunihome.myxapp.sso.api.staffnoquery.param;

import java.util.List;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 返回员工信息<br> 
 * Date: 2015年8月17日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhouyy5
 */
public class StaffNoInfoQuery extends BaseInfo {

	private static final long serialVersionUID = 2579255457536164067L;
	/**
	 * 总条数
	 */
	private int count;
	/**
	 * 详细员工信息
	 */
	private List<StaffInfo> staffInfoList;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<StaffInfo> getStaffInfoList() {
		return staffInfoList;
	}
	public void setStaffInfoList(List<StaffInfo> staffInfoList) {
		this.staffInfoList = staffInfoList;
	}
	

}

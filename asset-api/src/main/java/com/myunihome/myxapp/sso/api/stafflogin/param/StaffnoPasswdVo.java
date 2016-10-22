package com.myunihome.myxapp.sso.api.stafflogin.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 查询员工列表信息返回参数
 * 
 * @author Becky
 * 
 */
public class StaffnoPasswdVo extends BaseInfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;


	/**
	 * 员工工号
	 */
	private String staffNo;

	/**
	 * 原密码（MD5加密后的数据）
	 */
	private String oldPassword;
	
	/**
	 * 新密码（MD5加密后的数据）
	 */
	private String newPassword;

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}

package com.myunihome.myxapp.sso.api.stafflogin.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 员工登录返回参数
 * @author gucl
 */
public class StaffLoginVo extends BaseInfo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 工号ID
	 */
    private Long staffnoId;

    /**
	 * 员工ID
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
     * 密码
     */
    private String staffPasswd;
    
    /**
     * 账号状态
     */
    private String state;

    /**
     * 账号生效时间
     */
    private Timestamp activeTime;

    /**
     * 账号失效时间
     */
    private Timestamp inactiveTime;


	public Long getStaffnoId() {
		return staffnoId;
	}

	public void setStaffnoId(Long staffnoId) {
		this.staffnoId = staffnoId;
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

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPasswd() {
		return staffPasswd;
	}

	public void setStaffPasswd(String staffPasswd) {
		this.staffPasswd = staffPasswd;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Timestamp activeTime) {
		this.activeTime = activeTime;
	}

	public Timestamp getInactiveTime() {
		return inactiveTime;
	}

	public void setInactiveTime(Timestamp inactiveTime) {
		this.inactiveTime = inactiveTime;
	}
	
	

}
